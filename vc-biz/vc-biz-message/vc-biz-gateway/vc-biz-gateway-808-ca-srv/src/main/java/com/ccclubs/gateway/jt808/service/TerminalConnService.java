package com.ccclubs.gateway.jt808.service;

import com.ccclubs.gateway.common.bean.event.ConnLiveEvent;
import com.ccclubs.gateway.common.connection.ChannelMappingCollection;
import com.ccclubs.gateway.common.connection.ClientSocketCollection;
import com.ccclubs.gateway.common.constant.ChannelLiveStatus;
import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.constant.KafkaSendTopicType;
import com.ccclubs.gateway.common.dto.KafkaTask;
import com.ccclubs.gateway.common.dto.event.ConnOnlineStatusEvent;
import com.ccclubs.gateway.common.service.KafkaService;
import com.ccclubs.gateway.common.util.ChannelAttrbuteUtil;
import com.ccclubs.gateway.common.util.ClientEventFactory;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.channel.socket.SocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;
import java.util.Optional;

/**
 * @Author: yeanzi
 * @Date: 2018/6/28
 * @Time: 19:11
 * Email:  yeanzhi@ccclubs.com
 * 终端服务
 */
@Service
public class TerminalConnService {
    public static final Logger LOG = LoggerFactory.getLogger(TerminalConnService.class);

    /**
     * redis中的客户端信息
     */
    @Autowired
    private RedisConnService redisConnService;

    /**
     * 本地缓存的channId->uniqueNo映射信息
     */
    @Resource
    private ChannelMappingCollection channelMappingCollection;

    /**
     * 本地缓存的
     */
    @Resource
    private ClientSocketCollection clientSocketCollection;

    /**
     * kafka发送服务
     */
    @Autowired
    private KafkaService kafkaService;

    /**
     * 终端第一次注册
     * @param uniqueNo
     * @param newChannel
     * @param gatewayType
     */
    public TerminalConnService register(String uniqueNo, SocketChannel newChannel, GatewayType gatewayType) {
        Objects.requireNonNull(uniqueNo);
        Objects.requireNonNull(newChannel);
        Objects.requireNonNull(gatewayType);

        // 检验连接状态
        if (ClientSocketCollection.channelInActive(newChannel)) {
            throw new IllegalStateException("创建新客户端缓存时发现：连接通道状态异常");
        }

        // TODO 终端注册成功后，应该发送一段包含 终端ID、手机号、终端IP信息的数据给规则引擎

        boolean existedInReids = redisConnService.isExisted(uniqueNo, gatewayType);
        if (existedInReids) {
            // 已存在：
            boolean socketExisted = clientSocketCollection.existed(uniqueNo);
            boolean channelIdMappingExisted = channelMappingCollection.existed(newChannel.id().asLongText());
            LOG.error("终端({})注册时发现redis中已存在该客户端信息; 本地缓存信息：对应socket存在={}，对应channelIdMapping存在={}",
                    uniqueNo, socketExisted, channelIdMappingExisted);
        } else {
            // 不存在：新建一个连接

            // 1. 本地缓存socket
            clientSocketCollection.add(uniqueNo, newChannel);
            // 2. 本地缓存channelId -> uniqueNo的映射
            channelMappingCollection.add(uniqueNo, newChannel.id());
            // 3. redis缓存客户端信息
            redisConnService.clientRegister(uniqueNo, newChannel, gatewayType);
            LOG.info("client ({}) register success!", uniqueNo);
        }
        return this;
    }

    /**
     * 终端下线
     *          1. 清除本地连接缓存
     *          2. 更新redis在线状态
     *          3. 发送离线事件
     *          4. 发送离线轨迹信息用于统计
     * @param channel
     * @param gatewayType
     */
    public String offline(SocketChannel channel, GatewayType gatewayType) {
        Objects.requireNonNull(channel);
        Objects.requireNonNull(gatewayType);
        ChannelLiveStatus liveStatus = ChannelAttrbuteUtil.getLifeTrack(channel).getLiveStatus();

        Optional<String> uniqueNoOpt = channelMappingCollection.getUniqueNoByChannelIdLongText(channel.id().asLongText());
        String uniqueNo = null;
        if (uniqueNoOpt.isPresent()) {
            uniqueNo = uniqueNoOpt.get();
        } else {
            LOG.error("this channelId ({}) can not mapping to uniquNo when offline!", channel.id().asLongText());
            throw new RuntimeException();
        }
        // 1. 清除本地连接缓存
        clientSocketCollection.offline(uniqueNo, channel);
        channelMappingCollection.offline(uniqueNo, channel.id().asLongText());

        /**
         * 由于读写超时导致的连接断开，如果当前的channel的IP 与 redis 中在线事件中的IP不同，则认为已经上线，不发下线事件，不更新redis中的状态
         */
        boolean needSend2RedisAndUpdateStatu = true;
        if (ChannelLiveStatus.OFFLINE_IDLE.equals(liveStatus)) {
            com.ccclubs.frm.spring.gateway.ConnOnlineStatusEvent event = redisConnService.getOnlineEvent(uniqueNo, GatewayType.GATEWAY_808);
            // 由于读写超时导致的连接断开，如果当前的channel的IP 与 redis 中在线事件中的IP不同，则认为已经上线，不发下线事件
            if (Objects.nonNull(event) && !channel.localAddress().getHostString().equals(event.getServerIp())) {
                needSend2RedisAndUpdateStatu = false;
            }
        }

        if (needSend2RedisAndUpdateStatu) {
            // 下发下线事件
            ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOffline(uniqueNo, channel, gatewayType);
            // 增加下线类型（后面添加掉线原因）
            int offlineType = 0;
            switch (liveStatus) {
                case OFFLINE_IDLE:
                    offlineType = 2;
                    break;
                case OFFLINE_SERVER_CUT:
                    offlineType = 1;
                    break;
                case OFFLINE_CLIENT_CUT:
                    offlineType = 3;
                    break;
                    default:
                        break;
            }
            connOnlineStatusEvent.setOfflineType(offlineType);
            KafkaTask task = new KafkaTask(KafkaSendTopicType.CONN, uniqueNo, connOnlineStatusEvent.toJson());
            kafkaService.send(task);

            // 2. 更新redis在线状态
            redisConnService.offline(uniqueNo, channel, gatewayType);
        }

        // 4. 发送离线轨迹信息用于统计
        String exceptionHex = ChannelAttrbuteUtil.getPacTracker(channel).getSourceHex();
        ConnLiveEvent offlineEvent = new ConnLiveEvent()
                .uniqueNo(uniqueNo)
                .channel(channel)
                .online(false)
                .gatewayType(gatewayType);
        if (ChannelLiveStatus.OFFLINE_SERVER_CUT.equals(liveStatus)) {
            // 只有服务端异常时才发送异常报文
            offlineEvent.exceptionHex(exceptionHex);
        }
        offlineEvent.build();

        redisConnService.addTcpStatusTraceEvent(uniqueNo, gatewayType, offlineEvent);
        LOG.info("client ({}) offline success!", uniqueNo);
        return uniqueNo;
    }

    /**
     * 终端上线
     *      1. 判断是否已经在Redis中注册，未注册则先执行注册
     *      2. 更新本地缓存
     *      3. 更新redis中在线状态
     *      4. 发送上线事件
     *      5. 发送上线轨迹事件
     * @param uniqueNo
     * @param channel
     * @param gatewayType
     */
    public void online(String uniqueNo, SocketChannel channel, GatewayType gatewayType) {
        // 1. 判断是否已经在Redis中注册，未注册则先执行注册
        boolean isRegisted = redisConnService.isExisted(uniqueNo, gatewayType);
        if (!isRegisted) {
            LOG.info("client ({}) info not existed when deal online event, do register begin---", uniqueNo);
            boolean socketExisted = clientSocketCollection.existed(uniqueNo);
            boolean channelIdMappingExisted = channelMappingCollection.existed(channel.id().asLongText());
            if (socketExisted) {
                LOG.error("socket already existed but not register in redis: uniqueNo={}", uniqueNo);
                SocketChannel existedChannel = clientSocketCollection.getByUniqueNo(uniqueNo).get();
                // 执行下线
                clientSocketCollection.offline(uniqueNo, existedChannel);
            }
            if (channelIdMappingExisted) {
                LOG.error("channelMapping already existed but not register in redis: uniqueNo={}", uniqueNo);
                SocketChannel existedChannel = clientSocketCollection.getByUniqueNo(uniqueNo).get();
                // 执行下线
                clientSocketCollection.offline(uniqueNo, existedChannel);
            }
            // 未注册: 重新注册
            register(uniqueNo, channel, gatewayType);
            LOG.info("client ({}) info not existed when deal online event, do register end---", uniqueNo);
        } else {
            // 已注册
            if (redisConnService.isOnline(uniqueNo, gatewayType)) {
                LOG.error("client ({}) already online when deal online event!", uniqueNo);
            } else {
                /**
                 * 2. 更新本地缓存
                 *      这里先处理 channelIdMapping映射
                 */
                channelMappingCollection.online(uniqueNo, channel.id());
                clientSocketCollection.online(uniqueNo, channel);
                // 3. 更新redis中在线状态
                redisConnService.online(uniqueNo, channel, gatewayType);
            }
        }
        /**
         * 对于终端上线，如果终端第一次上线也需要发上线事件，但是终端注册不需要，因为终端注册后会发送鉴权（判定为上线）
         */
        // 4. 发送上线事件
        ConnOnlineStatusEvent connOnlineStatusEvent = ClientEventFactory.ofOnline(uniqueNo, channel, gatewayType);
        KafkaTask task = new KafkaTask(KafkaSendTopicType.CONN, uniqueNo, connOnlineStatusEvent.toJson());
        kafkaService.send(task);

        // 5. 发送上线轨迹事件
        ConnLiveEvent onlineEvent = new ConnLiveEvent()
                .uniqueNo(uniqueNo)
                .channel(channel)
                .online(true)
                .gatewayType(gatewayType)
                .build();
        redisConnService.addTcpStatusTraceEvent(uniqueNo, gatewayType, onlineEvent);
        LOG.info("client ({}) online success!", uniqueNo);
    }

    /**
     * 终端注销 (终端注销以后，后面会断开连接，仍会发送离线事件)
     *      1. 判断redis中是否注册了该客户端信息
     *      2. 本地缓存注销
     *      3. 清除redis缓存
     *      4. 发送注销事件
     *      5. 发送注销轨迹事件
     * @param uniqueNo
     * @param gatewayType
     */
    public void logout(String uniqueNo, SocketChannel channel, GatewayType gatewayType) {
        // 1. 判断是否已经在Redis中注册
        boolean isRegisted = redisConnService.isExisted(uniqueNo, gatewayType);
        if (!isRegisted) {
            LOG.error("client info not existed when deal logout event: uniqueNo={}", uniqueNo);
        } else {
            // 3. 清除redis缓存
            redisConnService.logout(uniqueNo, gatewayType);
        }

        // 2. 本地缓存注销
        channelMappingCollection.logout(uniqueNo, channel.id().asLongText());
        clientSocketCollection.logout(uniqueNo, channel);

        // 4. 发送注销事件 TODO

        LOG.info("client ({}) logout success!", uniqueNo);
    }


}