package com.ccclubs.pub.orm.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * 车辆、tbox所有信息
 *
 * @author jianghaiyang
 * @create 2018-02-07
 **/
public class VehicleMachineVo implements Serializable {
    /**
     * 查询开始时间
     */
    private String startDate;
    /**
     * 查询结束时间
     */
    private String endDate;
    /**
     * [user_id]主机厂用户
     */
    private   Integer userId;
    /**
     * 编号:
     */
    private Integer csvId;

    /**
     * 授权系统,0:无所属者
     */
    private Integer csvAccess;

    /**
     * 子域:
     */
    private Integer csvHost;

    /**
     * 真实车牌:
     */
    private String csvCarNo;

    /**
     * 车架号:
     */
    private String csvVin;

    /**
     * 发动机号
     */
    private String csvEngineNo;

    /**
     * 合格证号
     */
    private String csvCertific;

    /**
     * 颜色
     */
    private Byte csvColor;

    /**
     * 车型:
     */
    private Integer csvModel;

    /**
     * 车机设备:
     */
    private Integer csvMachine;

    /**
     * 历史设备:
     */
    private String csvMachines;

    /**
     * 车颜色代码0: 白套红橙1: 白套玫瑰金2: 白套苹果绿3: 红橙套黑4: 红套黑5: 黄/黑6: 黄套黑7: 蓝白套8: 苹果绿/白9: 深空黑/红橙10: 紫白套
     */
    private Byte csvColorCode;

    /**
     * 可充电储能系统编码
     */
    private String csvBataccuCode;

    /**
     * 出厂日期
     */
    private Date csvProdDate;

    /**
     * 地标类型
     */
    private String csvLandmark;

    /**
     * 车辆领域：0:未知,1:个人领域,2:公共领域
     */
    private Byte csvDomain;

    /**
     * 车型代码
     */
    private String csvModelCodeFull;

    /**
     * 车型备案型号
     */
    private String csvModelCodeSimple;

    /**
     * 内饰颜色
     */
    private String csvInteriorColorCode;

    /**
     * 状态:1:正常,0:无效;
     */
    private Byte csvStatus;

    /**
     * 添加时间:
     */
    private Date csvAddTime;

    /**
     * 修改时间:
     */
    private Date csvUpdateTime;

    /**
     * Database Column Remarks:
     * tbox 主键:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_id
     *
     * @mbg.generated
     */
    private Integer csmId;

    /**
     * Database Column Remarks:
     * 授权系统:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_access
     *
     * @mbg.generated
     */
    private Integer csmAccess;

    /**
     * Database Column Remarks:
     * 子域:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_host
     *
     * @mbg.generated
     */
    private Integer csmHost;

    /**
     * Database Column Remarks:
     * 车机号:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_number
     *
     * @mbg.generated
     */
    private String csmNumber;

    /**
     * Database Column Remarks:
     * 终端编号:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_te_no
     *
     * @mbg.generated
     */
    private String csmTeNo;

    /**
     * Database Column Remarks:
     * 终端类型:0:车厘子,1:中导,2:慧翰,3:通领;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_te_type
     *
     * @mbg.generated
     */
    private Byte csmTeType;

    /**
     * Database Column Remarks:
     * 终端型号:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_te_model
     *
     * @mbg.generated
     */
    private String csmTeModel;

    /**
     * Database Column Remarks:
     * 厂商代码:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_te_code
     *
     * @mbg.generated
     */
    private String csmTeCode;

    /**
     * Database Column Remarks:
     * 终端批号:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_te_lot_no
     *
     * @mbg.generated
     */
    private String csmTeLotNo;

    /**
     * Database Column Remarks:
     * 终端流水
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_te_serial
     *
     * @mbg.generated
     */
    private String csmTeSerial;

    /**
     * Database Column Remarks:
     * 手机号码:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_mobile
     *
     * @mbg.generated
     */
    private String csmMobile;

    /**
     * Database Column Remarks:
     * ICCID
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_iccid
     *
     * @mbg.generated
     */
    private String csmIccid;

    /**
     * Database Column Remarks:
     * 服务密码:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_password
     *
     * @mbg.generated
     */
    private String csmPassword;

    /**
     * Database Column Remarks:
     * 省电模式:0:标准模式,1:最佳省电模式,2:极度省电模式;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_saving
     *
     * @mbg.generated
     */
    private Byte csmSaving;

    /**
     * Database Column Remarks:
     * 下位机版本:0:1.0版,1:2.0版,2:3.0版,3:4.0版;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_device_vesion
     *
     * @mbg.generated
     */
    private Byte csmDeviceVesion;

    /**
     * Database Column Remarks:
     * 协议类型:0:无,1:mqtt,2:jt808,3:mq;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_protocol
     *
     * @mbg.generated
     */
    private Long csmProtocol;

    /**
     * Database Column Remarks:
     * 功能标签
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_functions
     *
     * @mbg.generated
     */
    private String csmFunctions;

    /**
     * Database Column Remarks:
     * 蓝牙版本
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_bluetooth_version
     *
     * @mbg.generated
     */
    private Integer csmBluetoothVersion;

    /**
     * Database Column Remarks:
     * 蓝牙地址
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_bluetooth_mac
     *
     * @mbg.generated
     */
    private String csmBluetoothMac;

    /**
     * Database Column Remarks:
     * 蓝牙密码
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_bluetooth_psd
     *
     * @mbg.generated
     */
    private String csmBluetoothPsd;

    /**
     * Database Column Remarks:
     * 服务器标识:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_mqtt_flag
     *
     * @mbg.generated
     */
    private String csmMqttFlag;

    /**
     * Database Column Remarks:
     * 超级手机号
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_super_sim
     *
     * @mbg.generated
     */
    private String csmSuperSim;

    /**
     * Database Column Remarks:
     * 初次激活:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_ce_first
     *
     * @mbg.generated
     */
    private Date csmCeFirst;

    /**
     * Database Column Remarks:
     * 最后连接:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_ce_last
     *
     * @mbg.generated
     */
    private Date csmCeLast;

    /**
     * Database Column Remarks:
     * 地标类型:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_landmark
     *
     * @mbg.generated
     */
    private String csmLandmark;

    /**
     * Database Column Remarks:
     * 电池容量:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_battery_capacity
     *
     * @mbg.generated
     */
    private Double csmBatteryCapacity;

    /**
     * Database Column Remarks:
     * 实际里程:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_mileage
     *
     * @mbg.generated
     */
    private Double csmMileage;

    /**
     * Database Column Remarks:
     * 充电次数:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_recharge_s
     *
     * @mbg.generated
     */
    private Integer csmRechargeS;

    /**
     * Database Column Remarks:
     * 注册流水号:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_reg_no
     *
     * @mbg.generated
     */
    private String csmRegNo;

    /**
     * Database Column Remarks:
     * 电池类型代码:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_be_no
     *
     * @mbg.generated
     */
    private String csmBeNo;

    /**
     * Database Column Remarks:
     * 电池厂商代码:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_be_code
     *
     * @mbg.generated
     */
    private String csmBeCode;

    /**
     * Database Column Remarks:
     * 电池批号:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_be_lot_no
     *
     * @mbg.generated
     */
    private String csmBeLotNo;

    /**
     * Database Column Remarks:
     * 电池流水号::动力蓄电池编码
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_be_serial
     *
     * @mbg.generated
     */
    private String csmBeSerial;

    /**
     * Database Column Remarks:
     * 动力电池包数:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_ev_cell_n
     *
     * @mbg.generated
     */
    private Integer csmEvCellN;

    /**
     * Database Column Remarks:
     * 动力电池列表:number:index,text:code;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_evs
     *
     * @mbg.generated
     */
    private String csmEvs;

    /**
     * Database Column Remarks:
     * 储能装置种类:0:燃油,1:锂电池,2:超级电容;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_zzzl
     *
     * @mbg.generated
     */
    private Byte csmZzzl;

    /**
     * Database Column Remarks:
     * 驱动电机类型:0:直流电机,1:异步电机,2:同步电机,3:开关磁阻;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_djlx
     *
     * @mbg.generated
     */
    private Byte csmDjlx;

    /**
     * Database Column Remarks:
     * 驱电额定功率:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_edgl
     *
     * @mbg.generated
     */
    private Integer csmEdgl;

    /**
     * Database Column Remarks:
     * 驱电额定转速:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_edzs
     *
     * @mbg.generated
     */
    private Integer csmEdzs;

    /**
     * Database Column Remarks:
     * 驱电额定转矩:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_edlj
     *
     * @mbg.generated
     */
    private Integer csmEdlj;

    /**
     * Database Column Remarks:
     * 驱电安装数量:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_azsl
     *
     * @mbg.generated
     */
    private Integer csmAzsl;

    /**
     * Database Column Remarks:
     * 驱电布置型式:1:前置横式,2:前置纵式,3:后置横式,4:后置纵式,5:中置横式,6:中置纵式;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_bzlx
     *
     * @mbg.generated
     */
    private Short csmBzlx;

    /**
     * Database Column Remarks:
     * 驱电冷却方式:1:液冷,2:风冷;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_lqfs
     *
     * @mbg.generated
     */
    private Short csmLqfs;

    /**
     * Database Column Remarks:
     * 车辆续航里程:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_xhlc
     *
     * @mbg.generated
     */
    private Integer csmXhlc;

    /**
     * Database Column Remarks:
     * 车辆最高车速:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_zgcs
     *
     * @mbg.generated
     */
    private Integer csmZgcs;

    /**
     * Database Column Remarks:
     * 软件版本:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_v1
     *
     * @mbg.generated
     */
    private String csmV1;

    /**
     * Database Column Remarks:
     * 硬件版本:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_v2
     *
     * @mbg.generated
     */
    private String csmV2;

    /**
     * Database Column Remarks:
     * DVD当前版本
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_v3
     *
     * @mbg.generated
     */
    private String csmV3;

    /**
     * Database Column Remarks:
     * DVD升级版本
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_v3_to
     *
     * @mbg.generated
     */
    private String csmV3To;

    /**
     * Database Column Remarks:
     * 适配车型
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_suit
     *
     * @mbg.generated
     */
    private Integer csmSuit;

    /**
     * Database Column Remarks:
     * 通领系统版本
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_tl_v1
     *
     * @mbg.generated
     */
    private String csmTlV1;

    /**
     * Database Column Remarks:
     * 通领插件版本
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_tl_v2
     *
     * @mbg.generated
     */
    private Integer csmTlV2;

    /**
     * Database Column Remarks:
     * 网络类型
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_net_type
     *
     * @mbg.generated
     */
    private Byte csmNetType;

    /**
     * Database Column Remarks:
     * 终端协议 1:mqtt 2:808
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_pro_type
     *
     * @mbg.generated
     */
    private Byte csmProType;

    /**
     * Database Column Remarks:
     * 波特率
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_baud_rate
     *
     * @mbg.generated
     */
    private Integer csmBaudRate;

    /**
     * Database Column Remarks:
     * 备注信息:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_remark
     *
     * @mbg.generated
     */
    private String csmRemark;

    /**
     * Database Column Remarks:
     * 修改时间:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_update_time
     *
     * @mbg.generated
     */
    private Date csmUpdateTime;

    /**
     * Database Column Remarks:
     * 添加时间:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_add_time
     *
     * @mbg.generated
     */
    private Date csmAddTime;

    /**
     * Database Column Remarks:
     * 程序标记:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_mark
     *
     * @mbg.generated
     */
    private String csmMark;

    /**
     * Database Column Remarks:
     * 程序掩码:0:默认,2:已注册;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_mask
     *
     * @mbg.generated
     */
    private Integer csmMask;

    /**
     * Database Column Remarks:
     * 状态:1:正常,0:无效;
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_status
     *
     * @mbg.generated
     */
    private Byte csmStatus;

    public Integer getCsvId() {
        return csvId;
    }

    public void setCsvId(Integer csvId) {
        this.csvId = csvId;
    }

    public Integer getCsvAccess() {
        return csvAccess;
    }

    public void setCsvAccess(Integer csvAccess) {
        this.csvAccess = csvAccess;
    }

    public Integer getCsvHost() {
        return csvHost;
    }

    public void setCsvHost(Integer csvHost) {
        this.csvHost = csvHost;
    }

    public String getCsvCarNo() {
        return csvCarNo;
    }

    public void setCsvCarNo(String csvCarNo) {
        this.csvCarNo = csvCarNo;
    }

    public String getCsvVin() {
        return csvVin;
    }

    public void setCsvVin(String csvVin) {
        this.csvVin = csvVin;
    }

    public String getCsvEngineNo() {
        return csvEngineNo;
    }

    public void setCsvEngineNo(String csvEngineNo) {
        this.csvEngineNo = csvEngineNo;
    }

    public String getCsvCertific() {
        return csvCertific;
    }

    public void setCsvCertific(String csvCertific) {
        this.csvCertific = csvCertific;
    }

    public Byte getCsvColor() {
        return csvColor;
    }

    public void setCsvColor(Byte csvColor) {
        this.csvColor = csvColor;
    }

    public Integer getCsvModel() {
        return csvModel;
    }

    public void setCsvModel(Integer csvModel) {
        this.csvModel = csvModel;
    }

    public Integer getCsvMachine() {
        return csvMachine;
    }

    public void setCsvMachine(Integer csvMachine) {
        this.csvMachine = csvMachine;
    }

    public String getCsvMachines() {
        return csvMachines;
    }

    public void setCsvMachines(String csvMachines) {
        this.csvMachines = csvMachines;
    }

    public Byte getCsvColorCode() {
        return csvColorCode;
    }

    public void setCsvColorCode(Byte csvColorCode) {
        this.csvColorCode = csvColorCode;
    }

    public String getCsvBataccuCode() {
        return csvBataccuCode;
    }

    public void setCsvBataccuCode(String csvBataccuCode) {
        this.csvBataccuCode = csvBataccuCode;
    }

    public Date getCsvProdDate() {
        return csvProdDate;
    }

    public void setCsvProdDate(Date csvProdDate) {
        this.csvProdDate = csvProdDate;
    }

    public String getCsvLandmark() {
        return csvLandmark;
    }

    public void setCsvLandmark(String csvLandmark) {
        this.csvLandmark = csvLandmark;
    }

    public Byte getCsvDomain() {
        return csvDomain;
    }

    public void setCsvDomain(Byte csvDomain) {
        this.csvDomain = csvDomain;
    }

    public String getCsvModelCodeFull() {
        return csvModelCodeFull;
    }

    public void setCsvModelCodeFull(String csvModelCodeFull) {
        this.csvModelCodeFull = csvModelCodeFull;
    }

    public String getCsvModelCodeSimple() {
        return csvModelCodeSimple;
    }

    public void setCsvModelCodeSimple(String csvModelCodeSimple) {
        this.csvModelCodeSimple = csvModelCodeSimple;
    }

    public String getCsvInteriorColorCode() {
        return csvInteriorColorCode;
    }

    public void setCsvInteriorColorCode(String csvInteriorColorCode) {
        this.csvInteriorColorCode = csvInteriorColorCode;
    }

    public Byte getCsvStatus() {
        return csvStatus;
    }

    public void setCsvStatus(Byte csvStatus) {
        this.csvStatus = csvStatus;
    }

    public Date getCsvAddTime() {
        return csvAddTime;
    }

    public void setCsvAddTime(Date csvAddTime) {
        this.csvAddTime = csvAddTime;
    }

    public Date getCsvUpdateTime() {
        return csvUpdateTime;
    }

    public void setCsvUpdateTime(Date csvUpdateTime) {
        this.csvUpdateTime = csvUpdateTime;
    }

    public Integer getCsmId() {
        return csmId;
    }

    public void setCsmId(Integer csmId) {
        this.csmId = csmId;
    }

    public Integer getCsmAccess() {
        return csmAccess;
    }

    public void setCsmAccess(Integer csmAccess) {
        this.csmAccess = csmAccess;
    }

    public Integer getCsmHost() {
        return csmHost;
    }

    public void setCsmHost(Integer csmHost) {
        this.csmHost = csmHost;
    }

    public String getCsmNumber() {
        return csmNumber;
    }

    public void setCsmNumber(String csmNumber) {
        this.csmNumber = csmNumber;
    }

    public String getCsmTeNo() {
        return csmTeNo;
    }

    public void setCsmTeNo(String csmTeNo) {
        this.csmTeNo = csmTeNo;
    }

    public Byte getCsmTeType() {
        return csmTeType;
    }

    public void setCsmTeType(Byte csmTeType) {
        this.csmTeType = csmTeType;
    }

    public String getCsmTeModel() {
        return csmTeModel;
    }

    public void setCsmTeModel(String csmTeModel) {
        this.csmTeModel = csmTeModel;
    }

    public String getCsmTeCode() {
        return csmTeCode;
    }

    public void setCsmTeCode(String csmTeCode) {
        this.csmTeCode = csmTeCode;
    }

    public String getCsmTeLotNo() {
        return csmTeLotNo;
    }

    public void setCsmTeLotNo(String csmTeLotNo) {
        this.csmTeLotNo = csmTeLotNo;
    }

    public String getCsmTeSerial() {
        return csmTeSerial;
    }

    public void setCsmTeSerial(String csmTeSerial) {
        this.csmTeSerial = csmTeSerial;
    }

    public String getCsmMobile() {
        return csmMobile;
    }

    public void setCsmMobile(String csmMobile) {
        this.csmMobile = csmMobile;
    }

    public String getCsmIccid() {
        return csmIccid;
    }

    public void setCsmIccid(String csmIccid) {
        this.csmIccid = csmIccid;
    }

    public String getCsmPassword() {
        return csmPassword;
    }

    public void setCsmPassword(String csmPassword) {
        this.csmPassword = csmPassword;
    }

    public Byte getCsmSaving() {
        return csmSaving;
    }

    public void setCsmSaving(Byte csmSaving) {
        this.csmSaving = csmSaving;
    }

    public Byte getCsmDeviceVesion() {
        return csmDeviceVesion;
    }

    public void setCsmDeviceVesion(Byte csmDeviceVesion) {
        this.csmDeviceVesion = csmDeviceVesion;
    }

    public Long getCsmProtocol() {
        return csmProtocol;
    }

    public void setCsmProtocol(Long csmProtocol) {
        this.csmProtocol = csmProtocol;
    }

    public String getCsmFunctions() {
        return csmFunctions;
    }

    public void setCsmFunctions(String csmFunctions) {
        this.csmFunctions = csmFunctions;
    }

    public Integer getCsmBluetoothVersion() {
        return csmBluetoothVersion;
    }

    public void setCsmBluetoothVersion(Integer csmBluetoothVersion) {
        this.csmBluetoothVersion = csmBluetoothVersion;
    }

    public String getCsmBluetoothMac() {
        return csmBluetoothMac;
    }

    public void setCsmBluetoothMac(String csmBluetoothMac) {
        this.csmBluetoothMac = csmBluetoothMac;
    }

    public String getCsmBluetoothPsd() {
        return csmBluetoothPsd;
    }

    public void setCsmBluetoothPsd(String csmBluetoothPsd) {
        this.csmBluetoothPsd = csmBluetoothPsd;
    }

    public String getCsmMqttFlag() {
        return csmMqttFlag;
    }

    public void setCsmMqttFlag(String csmMqttFlag) {
        this.csmMqttFlag = csmMqttFlag;
    }

    public String getCsmSuperSim() {
        return csmSuperSim;
    }

    public void setCsmSuperSim(String csmSuperSim) {
        this.csmSuperSim = csmSuperSim;
    }

    public Date getCsmCeFirst() {
        return csmCeFirst;
    }

    public void setCsmCeFirst(Date csmCeFirst) {
        this.csmCeFirst = csmCeFirst;
    }

    public Date getCsmCeLast() {
        return csmCeLast;
    }

    public void setCsmCeLast(Date csmCeLast) {
        this.csmCeLast = csmCeLast;
    }

    public String getCsmLandmark() {
        return csmLandmark;
    }

    public void setCsmLandmark(String csmLandmark) {
        this.csmLandmark = csmLandmark;
    }

    public Double getCsmBatteryCapacity() {
        return csmBatteryCapacity;
    }

    public void setCsmBatteryCapacity(Double csmBatteryCapacity) {
        this.csmBatteryCapacity = csmBatteryCapacity;
    }

    public Double getCsmMileage() {
        return csmMileage;
    }

    public void setCsmMileage(Double csmMileage) {
        this.csmMileage = csmMileage;
    }

    public Integer getCsmRechargeS() {
        return csmRechargeS;
    }

    public void setCsmRechargeS(Integer csmRechargeS) {
        this.csmRechargeS = csmRechargeS;
    }

    public String getCsmRegNo() {
        return csmRegNo;
    }

    public void setCsmRegNo(String csmRegNo) {
        this.csmRegNo = csmRegNo;
    }

    public String getCsmBeNo() {
        return csmBeNo;
    }

    public void setCsmBeNo(String csmBeNo) {
        this.csmBeNo = csmBeNo;
    }

    public String getCsmBeCode() {
        return csmBeCode;
    }

    public void setCsmBeCode(String csmBeCode) {
        this.csmBeCode = csmBeCode;
    }

    public String getCsmBeLotNo() {
        return csmBeLotNo;
    }

    public void setCsmBeLotNo(String csmBeLotNo) {
        this.csmBeLotNo = csmBeLotNo;
    }

    public String getCsmBeSerial() {
        return csmBeSerial;
    }

    public void setCsmBeSerial(String csmBeSerial) {
        this.csmBeSerial = csmBeSerial;
    }

    public Integer getCsmEvCellN() {
        return csmEvCellN;
    }

    public void setCsmEvCellN(Integer csmEvCellN) {
        this.csmEvCellN = csmEvCellN;
    }

    public String getCsmEvs() {
        return csmEvs;
    }

    public void setCsmEvs(String csmEvs) {
        this.csmEvs = csmEvs;
    }

    public Byte getCsmZzzl() {
        return csmZzzl;
    }

    public void setCsmZzzl(Byte csmZzzl) {
        this.csmZzzl = csmZzzl;
    }

    public Byte getCsmDjlx() {
        return csmDjlx;
    }

    public void setCsmDjlx(Byte csmDjlx) {
        this.csmDjlx = csmDjlx;
    }

    public Integer getCsmEdgl() {
        return csmEdgl;
    }

    public void setCsmEdgl(Integer csmEdgl) {
        this.csmEdgl = csmEdgl;
    }

    public Integer getCsmEdzs() {
        return csmEdzs;
    }

    public void setCsmEdzs(Integer csmEdzs) {
        this.csmEdzs = csmEdzs;
    }

    public Integer getCsmEdlj() {
        return csmEdlj;
    }

    public void setCsmEdlj(Integer csmEdlj) {
        this.csmEdlj = csmEdlj;
    }

    public Integer getCsmAzsl() {
        return csmAzsl;
    }

    public void setCsmAzsl(Integer csmAzsl) {
        this.csmAzsl = csmAzsl;
    }

    public Short getCsmBzlx() {
        return csmBzlx;
    }

    public void setCsmBzlx(Short csmBzlx) {
        this.csmBzlx = csmBzlx;
    }

    public Short getCsmLqfs() {
        return csmLqfs;
    }

    public void setCsmLqfs(Short csmLqfs) {
        this.csmLqfs = csmLqfs;
    }

    public Integer getCsmXhlc() {
        return csmXhlc;
    }

    public void setCsmXhlc(Integer csmXhlc) {
        this.csmXhlc = csmXhlc;
    }

    public Integer getCsmZgcs() {
        return csmZgcs;
    }

    public void setCsmZgcs(Integer csmZgcs) {
        this.csmZgcs = csmZgcs;
    }

    public String getCsmV1() {
        return csmV1;
    }

    public void setCsmV1(String csmV1) {
        this.csmV1 = csmV1;
    }

    public String getCsmV2() {
        return csmV2;
    }

    public void setCsmV2(String csmV2) {
        this.csmV2 = csmV2;
    }

    public String getCsmV3() {
        return csmV3;
    }

    public void setCsmV3(String csmV3) {
        this.csmV3 = csmV3;
    }

    public String getCsmV3To() {
        return csmV3To;
    }

    public void setCsmV3To(String csmV3To) {
        this.csmV3To = csmV3To;
    }

    public Integer getCsmSuit() {
        return csmSuit;
    }

    public void setCsmSuit(Integer csmSuit) {
        this.csmSuit = csmSuit;
    }

    public String getCsmTlV1() {
        return csmTlV1;
    }

    public void setCsmTlV1(String csmTlV1) {
        this.csmTlV1 = csmTlV1;
    }

    public Integer getCsmTlV2() {
        return csmTlV2;
    }

    public void setCsmTlV2(Integer csmTlV2) {
        this.csmTlV2 = csmTlV2;
    }

    public Byte getCsmNetType() {
        return csmNetType;
    }

    public void setCsmNetType(Byte csmNetType) {
        this.csmNetType = csmNetType;
    }

    public Byte getCsmProType() {
        return csmProType;
    }

    public void setCsmProType(Byte csmProType) {
        this.csmProType = csmProType;
    }

    public Integer getCsmBaudRate() {
        return csmBaudRate;
    }

    public void setCsmBaudRate(Integer csmBaudRate) {
        this.csmBaudRate = csmBaudRate;
    }

    public String getCsmRemark() {
        return csmRemark;
    }

    public void setCsmRemark(String csmRemark) {
        this.csmRemark = csmRemark;
    }

    public Date getCsmUpdateTime() {
        return csmUpdateTime;
    }

    public void setCsmUpdateTime(Date csmUpdateTime) {
        this.csmUpdateTime = csmUpdateTime;
    }

    public Date getCsmAddTime() {
        return csmAddTime;
    }

    public void setCsmAddTime(Date csmAddTime) {
        this.csmAddTime = csmAddTime;
    }

    public String getCsmMark() {
        return csmMark;
    }

    public void setCsmMark(String csmMark) {
        this.csmMark = csmMark;
    }

    public Integer getCsmMask() {
        return csmMask;
    }

    public void setCsmMask(Integer csmMask) {
        this.csmMask = csmMask;
    }

    public Byte getCsmStatus() {
        return csmStatus;
    }

    public void setCsmStatus(Byte csmStatus) {
        this.csmStatus = csmStatus;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
