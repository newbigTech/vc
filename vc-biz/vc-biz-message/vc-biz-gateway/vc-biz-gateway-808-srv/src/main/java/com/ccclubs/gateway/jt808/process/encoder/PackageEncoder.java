package com.ccclubs.gateway.jt808.process.encoder;

import com.ccclubs.gateway.common.connection.ClientConnCollection;
import com.ccclubs.gateway.common.util.PacValidUtil;
import com.ccclubs.gateway.jt808.constant.EncryptType;
import com.ccclubs.gateway.jt808.constant.PackageCons;
import com.ccclubs.gateway.jt808.message.pac.PacHeader;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.process.conn.JTClientConn;
import com.ccclubs.gateway.jt808.util.PacTranslateUtil;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/31
 * @Time: 16:43
 * Email:  yeanzhi@ccclubs.com
 * 报文编码器（Package808->ByteBuf）
 */
public class PackageEncoder extends MessageToByteEncoder<Package808> {
    private static final Logger LOG = LoggerFactory.getLogger(PackageEncoder.class);

    public PackageEncoder() {
        super();
    }

    public PackageEncoder(boolean preferDirect) {
        super(preferDirect);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);

        LOG.error("消息编码器接收到一个异常：{}", cause.getMessage());
    }

    /**
     * 转码消息：类->ByteBuf
     *      TODO 错误校验
     * @param ctx
     * @param pac
     * @param out
     * @throws Exception
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, Package808 pac, ByteBuf out) throws Exception {
        ByteBuf sendoutBuf = Unpooled.buffer();
        // 消息体
        ByteBuf bodyBuf = pac.getBody().getContent();

        // 起始符
        sendoutBuf.writeByte(PackageCons.PAC_START_SYMBOL_BYTE);

        /*
         *消息头部
         */
        PacHeader header = pac.getHeader();
        // 消息ID
        sendoutBuf.writeShort(header.getPacId())
                // 消息体属性
                .writeShort(createAttrFromPac(null==bodyBuf?0:bodyBuf.readableBytes(), EncryptType.NO))
                // 终端手机号
                .writeBytes(PacUtil.mobile2Buf(header.getTerMobile()));

        // 消息流水号
        if (Objects.nonNull(header.getPacSerialNo())) {
            // 消息流水号
            sendoutBuf.writeShort(header.getPacSerialNo());
        } else {
            // 获取连接中的消息序列号
            JTClientConn conn = (JTClientConn)ClientConnCollection.getByUniqueNo(header.getTerMobile());
            if (Objects.nonNull(conn)) {
                sendoutBuf.writeShort(conn.getAndIncreaseSerialNo());
            } else {
                // 提供一个默认的序列号
                sendoutBuf.writeShort(0);
            }
        }

        // 消息包封装项: 一般下行报文不需要分包发送
        if (Objects.nonNull(header.getPacSealInfo())) {
            // TODO 加入分包的实现
        }

        // 消息体部分
        if (Objects.nonNull(bodyBuf) && bodyBuf.readableBytes() > 0) {
            sendoutBuf.writeBytes(bodyBuf);
        }

        // 校验码
        byte validCode = PacValidUtil.caculateValidByteFromBuff(sendoutBuf, 1, 0);
        sendoutBuf.writeByte(validCode);

        // 消息转义
        PacTranslateUtil.translateDownPac(sendoutBuf);

        // 结束符
        sendoutBuf.writeByte(PackageCons.PAC_START_SYMBOL_BYTE);

        LOG.info("send: {}", ByteBufUtil.hexDump(sendoutBuf));
        // 最后写入：防止写入退出时造成部分写入
        out.writeBytes(sendoutBuf);
    }

    /**
     * 构建消息体属性
     * @param contentLen
     * @param encryptType
     * @return
     */
    private Short createAttrFromPac(Integer contentLen, EncryptType encryptType) {
        int destInt = 0;
        // 加入长度
        destInt |= contentLen;
        // 加入加密方式
        destInt |= encryptType.getCode();

        return (short) destInt;
    }
}
