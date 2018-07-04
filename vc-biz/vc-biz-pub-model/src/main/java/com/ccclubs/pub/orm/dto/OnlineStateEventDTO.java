package com.ccclubs.pub.orm.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 上下线事件及状态数据
 *
 * @author jianghaiyang
 * @create 2018-07-03
 **/
public class OnlineStateEventDTO implements Serializable {
    /**
     * 车辆vin码
     */
    private String vin;

    /**
     * 手机 卡号
     */
    private String simNo;

    /**
     * 车机号
     */
    private String teNumber;

    /**
     * 服务端IP
     */
    private String serverIp;

    /**
     * 客户端IP
     */
    private String clientIp;

    /**
     * 车辆在线状态通知
     * true:    在线
     * false:   下线
     */
    private boolean online;

    /**
     * 发送该通知的时间戳
     */
    private Long timestamp;

    /**
     * 网关类型：808,GB,MQTT
     */
    private String gatewayType;

    /**
     * 车辆下线类型
     * 1: 网关主动断开（网关检测到错误）
     * 2: 超时断开（终端在某时间段内没有和网关交互）
     */
    private Integer offlineType;

    /**
     * access
     */
    private Short access;

    /**
     * 终端序列号
     */
    private String teNo;

    /**
     * 终端批次 XXXX-X
     */
    private String batchNo;

    /**
     * 终端类型
     */
    private Byte teType;

    /**
     * 终端型号
     */
    private String teModelNo;

    /**
     * ICCID
     */
    private String iccid;

    /**
     * 下位机时间
     */
    private Date currentTime;

    /**
     * OBD
     */
    private BigDecimal obdMile;

    /**
     * 总里程
     */
    private BigDecimal mileage;

    /**
     * 车速
     */
    private BigDecimal speed;

    /**
     * 转速
     */
    private Integer rotateSpeed;

    /**
     * 燃油量
     */
    private BigDecimal fuelQuantity;

    /**
     * 小电瓶电量
     */
    private BigDecimal power;

    /**
     * 动力电池电量
     */
    private Byte soc;

    /**
     * 充电状态
     */
    private Byte charging;

    /**
     * 油里程
     */
    private BigDecimal fuelMileage;

    /**
     * 电量程
     */
    private BigDecimal electricMileage;

    /**
     * 续航里程
     */
    private BigDecimal endurance;

    /**
     * 温度
     */
    private BigDecimal temperature;

    /**
     * 信号强度
     */
    private Short csq;

    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 纬度
     */
    private BigDecimal latitude;

    /**
     * GPS有效
     */
    private Byte gpsValid;

    /**
     * GPS CN值
     */
    private Short gpsCn;

    /**
     * GPS 当前卫星数量
     */
    private Short gpsCount;

    /**
     * 方向角度
     */
    private BigDecimal dirAngle;

    /**
     * 循环模式:0:内循环,1:外循环;
     */
    private Byte circular;

    /**
     * PTC启停:0:OFF,1:ON;
     */
    private Byte ptc;

    /**
     * 压缩机:0:OFF,1:ON;
     */
    private Byte compress;

    /**
     * 档风量:0:OFF,1:1档,2:2档,3:3档,4:4档;
     */
    private Byte fan;

    /**
     * 省电模式:0:标准模式,1:最佳省电,2:极度省电;
     */
    private Byte saving;

    /**
     * 车门状态
     */
    private String door;

    /**
     * 发动机状态: 0无效 1未熄火，2已熄火，3ACC
     */
    private Byte engine;

    /**
     * 钥匙状态: 1插入，2拔出，0无效
     */
    private Byte key;

    /**
     * 挡位: 0:空挡;1:1挡;2:2挡...13:倒挡;14:自动D挡;15:停车P挡
     */
    private Byte gear;

    /**
     * 灯状态: 1未关，2全关，0无效
     */
    private Integer light;

    /**
     *  锁状态: 1门已锁，2有门未锁，0无效
     */
    private Integer lock;

    /**
     * 网络类型 0:GSM 1:3G/4G 2:CDMA
     */
    private Byte netType;

    /**
     * 基站LAC
     */
    private Integer baseLac;

    /**
     * 基站CI
     */
    private Integer baseCi;

    /**
     * 当前订单
     */
    private Long order;

    /**
     * 自动驾驶状态
     */
    private Integer autopilot;

    /**
     * 手刹状态
     */
    private Integer handbrake;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getSimNo() {
        return simNo;
    }

    public void setSimNo(String simNo) {
        this.simNo = simNo;
    }

    public String getTeNumber() {
        return teNumber;
    }

    public void setTeNumber(String teNumber) {
        this.teNumber = teNumber;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public boolean isOnline() {
        return online;
    }

    public void setOnline(boolean online) {
        this.online = online;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getGatewayType() {
        return gatewayType;
    }

    public void setGatewayType(String gatewayType) {
        this.gatewayType = gatewayType;
    }

    public Short getAccess() {
        return access;
    }

    public void setAccess(Short access) {
        this.access = access;
    }

    public String getTeNo() {
        return teNo;
    }

    public void setTeNo(String teNo) {
        this.teNo = teNo;
    }

    public Byte getTeType() {
        return teType;
    }

    public void setTeType(Byte teType) {
        this.teType = teType;
    }

    public String getTeModelNo() {
        return teModelNo;
    }

    public void setTeModelNo(String teModelNo) {
        this.teModelNo = teModelNo;
    }

    public String getIccid() {
        return iccid;
    }

    public void setIccid(String iccid) {
        this.iccid = iccid;
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Date currentTime) {
        this.currentTime = currentTime;
    }

    public BigDecimal getObdMile() {
        return obdMile;
    }

    public void setObdMile(BigDecimal obdMile) {
        this.obdMile = obdMile;
    }

    public BigDecimal getMileage() {
        return mileage;
    }

    public void setMileage(BigDecimal mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getSpeed() {
        return speed;
    }

    public void setSpeed(BigDecimal speed) {
        this.speed = speed;
    }

    public Integer getRotateSpeed() {
        return rotateSpeed;
    }

    public void setRotateSpeed(Integer rotateSpeed) {
        this.rotateSpeed = rotateSpeed;
    }

    public BigDecimal getFuelQuantity() {
        return fuelQuantity;
    }

    public void setFuelQuantity(BigDecimal fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public BigDecimal getPower() {
        return power;
    }

    public void setPower(BigDecimal power) {
        this.power = power;
    }

    public Byte getSoc() {
        return soc;
    }

    public void setSoc(Byte soc) {
        this.soc = soc;
    }

    public Byte getCharging() {
        return charging;
    }

    public void setCharging(Byte charging) {
        this.charging = charging;
    }

    public BigDecimal getFuelMileage() {
        return fuelMileage;
    }

    public void setFuelMileage(BigDecimal fuelMileage) {
        this.fuelMileage = fuelMileage;
    }

    public BigDecimal getElectricMileage() {
        return electricMileage;
    }

    public void setElectricMileage(BigDecimal electricMileage) {
        this.electricMileage = electricMileage;
    }

    public BigDecimal getEndurance() {
        return endurance;
    }

    public void setEndurance(BigDecimal endurance) {
        this.endurance = endurance;
    }

    public BigDecimal getTemperature() {
        return temperature;
    }

    public void setTemperature(BigDecimal temperature) {
        this.temperature = temperature;
    }

    public Short getCsq() {
        return csq;
    }

    public void setCsq(Short csq) {
        this.csq = csq;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Byte getGpsValid() {
        return gpsValid;
    }

    public void setGpsValid(Byte gpsValid) {
        this.gpsValid = gpsValid;
    }

    public Short getGpsCn() {
        return gpsCn;
    }

    public void setGpsCn(Short gpsCn) {
        this.gpsCn = gpsCn;
    }

    public Short getGpsCount() {
        return gpsCount;
    }

    public void setGpsCount(Short gpsCount) {
        this.gpsCount = gpsCount;
    }

    public BigDecimal getDirAngle() {
        return dirAngle;
    }

    public void setDirAngle(BigDecimal dirAngle) {
        this.dirAngle = dirAngle;
    }

    public Byte getCircular() {
        return circular;
    }

    public void setCircular(Byte circular) {
        this.circular = circular;
    }

    public Byte getPtc() {
        return ptc;
    }

    public void setPtc(Byte ptc) {
        this.ptc = ptc;
    }

    public Byte getCompress() {
        return compress;
    }

    public void setCompress(Byte compress) {
        this.compress = compress;
    }

    public Byte getFan() {
        return fan;
    }

    public void setFan(Byte fan) {
        this.fan = fan;
    }

    public Byte getSaving() {
        return saving;
    }

    public void setSaving(Byte saving) {
        this.saving = saving;
    }

    public String getDoor() {
        return door;
    }

    public void setDoor(String door) {
        this.door = door;
    }

    public Byte getEngine() {
        return engine;
    }

    public void setEngine(Byte engine) {
        this.engine = engine;
    }

    public Byte getKey() {
        return key;
    }

    public void setKey(Byte key) {
        this.key = key;
    }

    public Byte getGear() {
        return gear;
    }

    public void setGear(Byte gear) {
        this.gear = gear;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getLock() {
        return lock;
    }

    public void setLock(Integer lock) {
        this.lock = lock;
    }

    public Byte getNetType() {
        return netType;
    }

    public void setNetType(Byte netType) {
        this.netType = netType;
    }

    public Integer getBaseLac() {
        return baseLac;
    }

    public void setBaseLac(Integer baseLac) {
        this.baseLac = baseLac;
    }

    public Integer getBaseCi() {
        return baseCi;
    }

    public void setBaseCi(Integer baseCi) {
        this.baseCi = baseCi;
    }

    public Long getOrder() {
        return order;
    }

    public void setOrder(Long order) {
        this.order = order;
    }

    public Integer getAutopilot() {
        return autopilot;
    }

    public void setAutopilot(Integer autopilot) {
        this.autopilot = autopilot;
    }

    public Integer getHandbrake() {
        return handbrake;
    }

    public void setHandbrake(Integer handbrake) {
        this.handbrake = handbrake;
    }

    public Integer getOfflineType() {
        return offlineType;
    }

    public void setOfflineType(Integer offlineType) {
        this.offlineType = offlineType;
    }

    public String getBatchNo() {
        return batchNo;
    }

    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo;
    }
}
