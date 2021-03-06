package com.ccclubs.gateway.gb.constant;

import com.ccclubs.gateway.gb.inf.ICodedStatus;

import java.util.Objects;

/**
 * @Author: yeanzi
 * @Date: 2018/3/26
 * @Time: 12:35
 * Email:  yeanzhi@ccclubs.com
 */
public enum AckType implements ICodedStatus {
    /**
     * 接收到的信息正确
     */
    ACK_SUCCESS(0x01),
    /**
     * 设置不成功
     */
    ACK_FAIL(0x02),
    /**
     * VIN码重复
     */
    ACK_DUPLICATE(0x03),
    /**
     * 命令包
     */
    ACK_COMMAND(0xFE);

    private static String EXCEPTED_VALUES;
    private int code;
    AckType(int code) {
        this.code = code;
    }

    @Override
    public int getCode() {
        return code;
    }

    public static AckType getByCode(int code) {
        for (AckType a :
                AckType.values()) {
            if (a.getCode() == code) {
                return a;
            }
        }
        return null;
    }

    /**
     * 预期的期望值，逗号分隔
     * @return
     */
    public static String expectedVals() {
        if (Objects.isNull(EXCEPTED_VALUES)) {
            StringBuilder valSb = new StringBuilder();
            for (AckType c :
                    AckType.values()) {
                valSb.append(c.getCode()).append(",");
            }
            // 删除最后一个逗号
            valSb.deleteCharAt(valSb.length() - 1);
            EXCEPTED_VALUES = valSb.toString();
        }
        return EXCEPTED_VALUES;
    }

}
