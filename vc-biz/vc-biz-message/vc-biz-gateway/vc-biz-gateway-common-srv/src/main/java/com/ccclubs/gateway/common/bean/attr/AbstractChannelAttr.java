package com.ccclubs.gateway.common.bean.attr;

import com.ccclubs.gateway.common.constant.GatewayType;
import com.ccclubs.gateway.common.inf.ChannelAttr;

/**
 * @author Andaren
 * email   603822061@qq.com
 * @date 2018/9/9 下午3:51
 * description: TODO
 * version : v1.0
 * update_log:
 * date[更新日期] time[更新时间] updater[更新人]     for[原因]
 */
public class AbstractChannelAttr implements ChannelAttr {
    /**
     * 渠道唯一标志
     */
    private String uniqueNo;
    /**
     * 网关类型
     */
    private GatewayType gatewayType;

    public String getUniqueNo() {
        return uniqueNo;
    }

    public AbstractChannelAttr setUniqueNo(String uniqueNo) {
        this.uniqueNo = uniqueNo;
        return this;
    }

    public GatewayType getGatewayType() {
        return gatewayType;
    }

    public AbstractChannelAttr setGatewayType(GatewayType gatewayType) {
        this.gatewayType = gatewayType;
        return this;
    }
}
