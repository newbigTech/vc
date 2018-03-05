package com.ccclubs.mongo.orm.model.history;

import cn.afterturn.easypoi.excel.annotation.Excel;
import com.ccclubs.frm.spring.annotation.AutomaticSequence;
import com.ccclubs.frm.spring.resolver.Resolver;
import com.ccclubs.mongo.orm.model.AbstractDocumentOld;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 异常车辆数据
 *
 * @author jianghaiyang
 * @create 2018-03-02
 **/
@Document(collection = "CsVehicleExp")
public class CsVehicleExp extends AbstractDocumentOld implements Serializable {
    //编号
    //@AutomaticSequence
    private Long csvExpId;

    /**
     * 车架号:
     */
    @Excel(name = "车架号", width = 20)
    private String csvVin;

    /**
     * Database Column Remarks:
     * 终端编号:
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_te_no
     *
     * @mbg.generated
     */
    @Excel(name = "终端编号", width = 20)
    private String csmTeNo;

    /**
     * Database Column Remarks:
     * ICCID
     * <p>
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_machine.csm_iccid
     *
     * @mbg.generated
     */
    @Excel(name = "ICCID", width = 25)
    private String csmIccid;

    /**
     * 发动机号
     */
    @Excel(name = "发动机号", width = 20)
    private String csvEngineNo;

    /**
     * 可充电储能系统编码
     */
    @Excel(name = "可充电储能系统编码", width = 25)
    private String csvBataccuCode;

    /**
     * 车型备案型号
     */
    @Excel(name = "车型备案型号", width = 15)
    private String csvModelCodeSimple;

    /**
     * 车牌号
     */
    @Excel(name = "车牌号", width = 15)
    private String csvCarNo;

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
     * 出厂日期
     */
    @Excel(name = "出厂日期", format = "yyyy-MM-dd", width = 20)
    private Date csvProdDate;

    /**
     * 车辆添加时间:
     */
    @Excel(name = "车辆添加时间", format = "yyyy-MM-dd HH:mm:ss", width = 20)
    private Date csvAddTime;

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
     * 车型代码
     */
    private String csvModelCodeFull;

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

    public Long getCsvExpId() {
        return csvExpId;
    }

    public void setCsvExpId(Long csvExpId) {
        this.csvExpId = csvExpId;
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

    public Date getCsvAddTime() {
        return csvAddTime;
    }

    public void setCsvAddTime(Date csvAddTime) {
        this.csvAddTime = csvAddTime;
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

    //默认构造函数
    public CsVehicleExp(){

    }

    //主键构造函数
    public CsVehicleExp(Long id){
        this.csvExpId = id;
    }

    //设置非空字段
    public CsVehicleExp setNotNull(Long csvExpId){
        this.csvExpId=csvExpId;
        return this;
    }

    public Object getCsmTeTypeText(){
        return resolve("csmTeTypeText");
    }

    @Transient
    Map<String, Resolver<CsVehicleExp>> resolvers = new HashMap<String, Resolver<CsVehicleExp>>();

    public void registResolver(Resolver<CsVehicleExp> resolver){
        this.resolvers.put(resolver.getName(), resolver);
    }

    public Object resolve(String key){
        if(resolvers.get(key)!=null){
            return resolvers.get(key).execute(this);
        }
        return null;
    }
}
