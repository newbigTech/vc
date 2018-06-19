package com.ccclubs.gateway.jt808.process.decoder;

import com.ccclubs.gateway.common.bean.track.PacProcessTrack;
import com.ccclubs.gateway.common.config.TcpServerConf;
import com.ccclubs.gateway.common.util.ChannelPacTrackUtil;
import com.ccclubs.gateway.jt808.constant.PackagePart;
import com.ccclubs.gateway.jt808.constant.msg.UpPacType;
import com.ccclubs.gateway.jt808.exception.DecodeExceptionDTO;
import com.ccclubs.gateway.jt808.exception.PackageDecodeException;
import com.ccclubs.gateway.jt808.message.pac.PacContentAttr;
import com.ccclubs.gateway.jt808.message.pac.PacSealInfo;
import com.ccclubs.gateway.jt808.message.pac.Package808;
import com.ccclubs.gateway.jt808.util.PacTranslateUtil;
import com.ccclubs.gateway.jt808.util.PacUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufUtil;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/5/30
 * @Time: 16:42
 * Email:  yeanzhi@ccclubs.com
 * 808消息不定长分隔符解码器
 */
public class PackageBaseDecoder extends DelimiterBasedFrameDecoder {
    public static final Logger LOG = LoggerFactory.getLogger(PackageBaseDecoder.class);

    /**
     * 最小报文长度
     */
    private final Integer minFrameLength;

    private Package808 pac;

    public PackageBaseDecoder(int minFrameLength, int maxFrameLength, ByteBuf delimiter) {
        super(maxFrameLength, delimiter);
        this.minFrameLength = minFrameLength;
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf buffer) throws Exception {
        String sourceHex = ByteBufUtil.hexDump(buffer);
        if (LOG.isDebugEnabled()) {
            LOG.debug("sourceHex={}", sourceHex);
        }
        // TODO 校验最小字节数

        ByteBuf frame = (ByteBuf) super.decode(ctx, buffer);
        if (LOG.isDebugEnabled()) {
            LOG.debug("after decode: frame={}", frame==null?"null":ByteBufUtil.hexDump(frame));
        }

        if (Objects.isNull(frame) || frame.readableBytes() == 0) {
            return null;
        }

        // 消息转义: 还原消息
        PacTranslateUtil.translateUpPac(frame);
        if (TcpServerConf.GATEWAY_PRINT_LOG) {
            LOG.info("-------------------------------------------------------after transltated: \n{}", ByteBufUtil.hexDump(frame));
        }

        PacProcessTrack pacProcessTrack = resetTracks(ctx);
        this.pac = composePac(frame, pacProcessTrack);

        return this.pac;
    }

    public void skipBytesWhenLessThenMinFrameLength(ByteBuf buff) {
        Objects.requireNonNull(buff);

    }

    /**
     * 消息组装
     * @param frame
     * @return
     */
    public Package808 composePac(ByteBuf frame, PacProcessTrack pacProcessTrack) {
        String sourceHexStr = ByteBufUtil.hexDump(frame);
        Package808 pac = Package808.ofNew()
                .setSourceBuff(frame).setSourceHexStr(sourceHexStr);
        pacProcessTrack.setSourceHex(sourceHexStr);
        DecodeExceptionDTO decodeExceptionInfo = new DecodeExceptionDTO(pac.getSourceHexStr());

        // 读取终端手机号
        int mobileByteIndex = PackagePart.PAC_ID.getLen() + PackagePart.PAC_SERIAL_NO.getLen();
        if (frame.readableBytes() < mobileByteIndex) {
            decodeExceptionInfo.fail()
                    .setReason("sim号码字段不满12个")
                    .setExpectedVal("非空的12个字符");
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        } else {
            frame.readerIndex(mobileByteIndex);
            ByteBuf mobileBuf = frame.readSlice(PackagePart.TER_MOBILE.getLen());
            String mobile = ByteBufUtil.hexDump(mobileBuf);

            pac.getHeader().setTerMobile(mobile);
            pacProcessTrack.setUniqueNo(mobile);
            decodeExceptionInfo.setUniqueNo(mobile).next();

            frame.resetReaderIndex();
        }


        // 读取消息ID
        int pacId = frame.readUnsignedShort();
        UpPacType upPacType = UpPacType.getByCode(pacId);
        if (Objects.isNull(upPacType)) {
            decodeExceptionInfo.fail()
                    .setReason("不支持的消息ID")
                    .setExceptionVal(Integer.toHexString(pacId))
                    .setExpectedVal(UpPacType.expectedVals());
            throwWhenDecodeError(decodeExceptionInfo, pacProcessTrack);
        } else {
            decodeExceptionInfo.next();
            pac.getHeader().setPacId(pacId);
        }

        // 读取消息体属性
        PacContentAttr pacAttr = new PacContentAttr();
        Short contentAttr = frame.readShort();
        pacAttr.setContentLen(PacUtil.getContentLen(contentAttr))
                .setEncrypted(PacUtil.isEncrypted(contentAttr))
                .setMultiPac(PacUtil.isMultiPac(contentAttr));

        pac.getHeader().setPacContentAttr(pacAttr);
        decodeExceptionInfo.next();

        // 跳过终端手机号
        frame.skipBytes(PackagePart.TER_MOBILE.getLen());

        // 读取消息流水号
        int pacSerialNo = frame.readUnsignedShort();
        pac.getHeader().setPacSerialNo(pacSerialNo);
        decodeExceptionInfo.next();

        /*
         * 读取消息包封顶项
         *     如果为分包则 消息包封装项有值否则没有值
         */
        if (pac.getHeader().getPacContentAttr().isMultiPac()) {
            // 读取消息总包数
            Integer totalPac = frame.readUnsignedShort();
            Integer pacNo = frame.readUnsignedShort();
            PacSealInfo pacSealInfo = new PacSealInfo().setPacNo(pacNo).setTotalPacCount(totalPac);
            pac.getHeader().setPacSealInfo(pacSealInfo);
        } else {}
        decodeExceptionInfo.next();

        // 读取包体部分
        ByteBuf bodyBuf = frame.readSlice(pac.getHeader().getPacContentAttr().getContentLen());
        pac.getBody().setContent(bodyBuf);
        decodeExceptionInfo.next();

        // 读取校验码
        byte validCode = frame.readByte();
        pac.setValidCode(validCode);
        decodeExceptionInfo.next();

        frame.resetReaderIndex();
        return pac;
    }

    /**
     * 新消息时，重置消息轨迹记录
     * @param ctx
     */
    private PacProcessTrack resetTracks(ChannelHandlerContext ctx) {
        // 处理链处理新消息前，先清除上一个消息的轨迹信息
        ChannelPacTrackUtil.refreshPacTrackForNewMsg(ctx.channel());
        return ChannelPacTrackUtil.getPacTracker(ctx.channel()).next();
    }

    public void throwWhenDecodeError(DecodeExceptionDTO decodeExceptionInfo, PacProcessTrack pacProcessTrack) {
        pacProcessTrack.getCurrentHandlerTracker().setErrorOccur(true);
        pacProcessTrack.getExpMessageDTO()
                .setMsgTime(System.currentTimeMillis());
        pacProcessTrack.getExpMessageDTO()
                .setSourceHex(decodeExceptionInfo.getSource())
                .setVin(decodeExceptionInfo.getUniqueNo())
                .setIndex(decodeExceptionInfo.getDecodeMarkIndex())
                .setReason(decodeExceptionInfo.toLogString())
                .setCode(pacProcessTrack.getStep() + "");
        throw new PackageDecodeException(decodeExceptionInfo.toLogString());
    }
}
