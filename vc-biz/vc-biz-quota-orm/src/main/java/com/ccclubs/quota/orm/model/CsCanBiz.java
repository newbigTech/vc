package com.ccclubs.quota.orm.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class CsCanBiz implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_id
     *
     * @mbg.generated
     */
    private Long cscId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_access
     *
     * @mbg.generated
     */
    private Integer cscAccess;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.sh_name
     *
     * @mbg.generated
     */
    private String shName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_host
     *
     * @mbg.generated
     */
    private Integer cscHost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_number
     *
     * @mbg.generated
     */
    private String cscNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.cs_vin
     *
     * @mbg.generated
     */
    private String csVin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_car
     *
     * @mbg.generated
     */
    private Integer cscCar;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_model
     *
     * @mbg.generated
     */
    private Integer cscModel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_type
     *
     * @mbg.generated
     */
    private Integer cscType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_order
     *
     * @mbg.generated
     */
    private Long cscOrder;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_data
     *
     * @mbg.generated
     */
    private String cscData;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_fault
     *
     * @mbg.generated
     */
    private String cscFault;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_upload_time
     *
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date cscUploadTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_add_time
     *
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date cscAddTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_larum
     *
     * @mbg.generated
     */
    private String cscLarum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_prompt
     *
     * @mbg.generated
     */
    private String cscPrompt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_deal_desc
     *
     * @mbg.generated
     */
    private String cscDealDesc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_deal_time
     *
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date cscDealTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_can_biz.csc_status
     *
     * @mbg.generated
     */
    private Integer cscStatus;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_can_biz
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_id
     *
     * @return the value of cs_can_biz.csc_id
     *
     * @mbg.generated
     */
    public Long getCscId() {
        return cscId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_id
     *
     * @param cscId the value for cs_can_biz.csc_id
     *
     * @mbg.generated
     */
    public void setCscId(Long cscId) {
        this.cscId = cscId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_access
     *
     * @return the value of cs_can_biz.csc_access
     *
     * @mbg.generated
     */
    public Integer getCscAccess() {
        return cscAccess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_access
     *
     * @param cscAccess the value for cs_can_biz.csc_access
     *
     * @mbg.generated
     */
    public void setCscAccess(Integer cscAccess) {
        this.cscAccess = cscAccess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.sh_name
     *
     * @return the value of cs_can_biz.sh_name
     *
     * @mbg.generated
     */
    public String getShName() {
        return shName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.sh_name
     *
     * @param shName the value for cs_can_biz.sh_name
     *
     * @mbg.generated
     */
    public void setShName(String shName) {
        this.shName = shName == null ? null : shName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_host
     *
     * @return the value of cs_can_biz.csc_host
     *
     * @mbg.generated
     */
    public Integer getCscHost() {
        return cscHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_host
     *
     * @param cscHost the value for cs_can_biz.csc_host
     *
     * @mbg.generated
     */
    public void setCscHost(Integer cscHost) {
        this.cscHost = cscHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_number
     *
     * @return the value of cs_can_biz.csc_number
     *
     * @mbg.generated
     */
    public String getCscNumber() {
        return cscNumber;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_number
     *
     * @param cscNumber the value for cs_can_biz.csc_number
     *
     * @mbg.generated
     */
    public void setCscNumber(String cscNumber) {
        this.cscNumber = cscNumber == null ? null : cscNumber.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.cs_vin
     *
     * @return the value of cs_can_biz.cs_vin
     *
     * @mbg.generated
     */
    public String getCsVin() {
        return csVin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.cs_vin
     *
     * @param csVin the value for cs_can_biz.cs_vin
     *
     * @mbg.generated
     */
    public void setCsVin(String csVin) {
        this.csVin = csVin == null ? null : csVin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_car
     *
     * @return the value of cs_can_biz.csc_car
     *
     * @mbg.generated
     */
    public Integer getCscCar() {
        return cscCar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_car
     *
     * @param cscCar the value for cs_can_biz.csc_car
     *
     * @mbg.generated
     */
    public void setCscCar(Integer cscCar) {
        this.cscCar = cscCar;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_model
     *
     * @return the value of cs_can_biz.csc_model
     *
     * @mbg.generated
     */
    public Integer getCscModel() {
        return cscModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_model
     *
     * @param cscModel the value for cs_can_biz.csc_model
     *
     * @mbg.generated
     */
    public void setCscModel(Integer cscModel) {
        this.cscModel = cscModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_type
     *
     * @return the value of cs_can_biz.csc_type
     *
     * @mbg.generated
     */
    public Integer getCscType() {
        return cscType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_type
     *
     * @param cscType the value for cs_can_biz.csc_type
     *
     * @mbg.generated
     */
    public void setCscType(Integer cscType) {
        this.cscType = cscType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_order
     *
     * @return the value of cs_can_biz.csc_order
     *
     * @mbg.generated
     */
    public Long getCscOrder() {
        return cscOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_order
     *
     * @param cscOrder the value for cs_can_biz.csc_order
     *
     * @mbg.generated
     */
    public void setCscOrder(Long cscOrder) {
        this.cscOrder = cscOrder;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_data
     *
     * @return the value of cs_can_biz.csc_data
     *
     * @mbg.generated
     */
    public String getCscData() {
        return cscData;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_data
     *
     * @param cscData the value for cs_can_biz.csc_data
     *
     * @mbg.generated
     */
    public void setCscData(String cscData) {
        this.cscData = cscData == null ? null : cscData.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_fault
     *
     * @return the value of cs_can_biz.csc_fault
     *
     * @mbg.generated
     */
    public String getCscFault() {
        return cscFault;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_fault
     *
     * @param cscFault the value for cs_can_biz.csc_fault
     *
     * @mbg.generated
     */
    public void setCscFault(String cscFault) {
        this.cscFault = cscFault == null ? null : cscFault.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_upload_time
     *
     * @return the value of cs_can_biz.csc_upload_time
     *
     * @mbg.generated
     */
    public Date getCscUploadTime() {
        return cscUploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_upload_time
     *
     * @param cscUploadTime the value for cs_can_biz.csc_upload_time
     *
     * @mbg.generated
     */
    public void setCscUploadTime(Date cscUploadTime) {
        this.cscUploadTime = cscUploadTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_add_time
     *
     * @return the value of cs_can_biz.csc_add_time
     *
     * @mbg.generated
     */
    public Date getCscAddTime() {
        return cscAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_add_time
     *
     * @param cscAddTime the value for cs_can_biz.csc_add_time
     *
     * @mbg.generated
     */
    public void setCscAddTime(Date cscAddTime) {
        this.cscAddTime = cscAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_larum
     *
     * @return the value of cs_can_biz.csc_larum
     *
     * @mbg.generated
     */
    public String getCscLarum() {
        return cscLarum;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_larum
     *
     * @param cscLarum the value for cs_can_biz.csc_larum
     *
     * @mbg.generated
     */
    public void setCscLarum(String cscLarum) {
        this.cscLarum = cscLarum == null ? null : cscLarum.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_prompt
     *
     * @return the value of cs_can_biz.csc_prompt
     *
     * @mbg.generated
     */
    public String getCscPrompt() {
        return cscPrompt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_prompt
     *
     * @param cscPrompt the value for cs_can_biz.csc_prompt
     *
     * @mbg.generated
     */
    public void setCscPrompt(String cscPrompt) {
        this.cscPrompt = cscPrompt == null ? null : cscPrompt.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_deal_desc
     *
     * @return the value of cs_can_biz.csc_deal_desc
     *
     * @mbg.generated
     */
    public String getCscDealDesc() {
        return cscDealDesc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_deal_desc
     *
     * @param cscDealDesc the value for cs_can_biz.csc_deal_desc
     *
     * @mbg.generated
     */
    public void setCscDealDesc(String cscDealDesc) {
        this.cscDealDesc = cscDealDesc == null ? null : cscDealDesc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_deal_time
     *
     * @return the value of cs_can_biz.csc_deal_time
     *
     * @mbg.generated
     */
    public Date getCscDealTime() {
        return cscDealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_deal_time
     *
     * @param cscDealTime the value for cs_can_biz.csc_deal_time
     *
     * @mbg.generated
     */
    public void setCscDealTime(Date cscDealTime) {
        this.cscDealTime = cscDealTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_can_biz.csc_status
     *
     * @return the value of cs_can_biz.csc_status
     *
     * @mbg.generated
     */
    public Integer getCscStatus() {
        return cscStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_can_biz.csc_status
     *
     * @param cscStatus the value for cs_can_biz.csc_status
     *
     * @mbg.generated
     */
    public void setCscStatus(Integer cscStatus) {
        this.cscStatus = cscStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can_biz
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        CsCanBiz other = (CsCanBiz) that;
        return (this.getCscId() == null ? other.getCscId() == null : this.getCscId().equals(other.getCscId()))
            && (this.getCscAccess() == null ? other.getCscAccess() == null : this.getCscAccess().equals(other.getCscAccess()))
            && (this.getShName() == null ? other.getShName() == null : this.getShName().equals(other.getShName()))
            && (this.getCscHost() == null ? other.getCscHost() == null : this.getCscHost().equals(other.getCscHost()))
            && (this.getCscNumber() == null ? other.getCscNumber() == null : this.getCscNumber().equals(other.getCscNumber()))
            && (this.getCsVin() == null ? other.getCsVin() == null : this.getCsVin().equals(other.getCsVin()))
            && (this.getCscCar() == null ? other.getCscCar() == null : this.getCscCar().equals(other.getCscCar()))
            && (this.getCscModel() == null ? other.getCscModel() == null : this.getCscModel().equals(other.getCscModel()))
            && (this.getCscType() == null ? other.getCscType() == null : this.getCscType().equals(other.getCscType()))
            && (this.getCscOrder() == null ? other.getCscOrder() == null : this.getCscOrder().equals(other.getCscOrder()))
            && (this.getCscData() == null ? other.getCscData() == null : this.getCscData().equals(other.getCscData()))
            && (this.getCscFault() == null ? other.getCscFault() == null : this.getCscFault().equals(other.getCscFault()))
            && (this.getCscUploadTime() == null ? other.getCscUploadTime() == null : this.getCscUploadTime().equals(other.getCscUploadTime()))
            && (this.getCscAddTime() == null ? other.getCscAddTime() == null : this.getCscAddTime().equals(other.getCscAddTime()))
            && (this.getCscLarum() == null ? other.getCscLarum() == null : this.getCscLarum().equals(other.getCscLarum()))
            && (this.getCscPrompt() == null ? other.getCscPrompt() == null : this.getCscPrompt().equals(other.getCscPrompt()))
            && (this.getCscDealDesc() == null ? other.getCscDealDesc() == null : this.getCscDealDesc().equals(other.getCscDealDesc()))
            && (this.getCscDealTime() == null ? other.getCscDealTime() == null : this.getCscDealTime().equals(other.getCscDealTime()))
            && (this.getCscStatus() == null ? other.getCscStatus() == null : this.getCscStatus().equals(other.getCscStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can_biz
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCscId() == null) ? 0 : getCscId().hashCode());
        result = prime * result + ((getCscAccess() == null) ? 0 : getCscAccess().hashCode());
        result = prime * result + ((getShName() == null) ? 0 : getShName().hashCode());
        result = prime * result + ((getCscHost() == null) ? 0 : getCscHost().hashCode());
        result = prime * result + ((getCscNumber() == null) ? 0 : getCscNumber().hashCode());
        result = prime * result + ((getCsVin() == null) ? 0 : getCsVin().hashCode());
        result = prime * result + ((getCscCar() == null) ? 0 : getCscCar().hashCode());
        result = prime * result + ((getCscModel() == null) ? 0 : getCscModel().hashCode());
        result = prime * result + ((getCscType() == null) ? 0 : getCscType().hashCode());
        result = prime * result + ((getCscOrder() == null) ? 0 : getCscOrder().hashCode());
        result = prime * result + ((getCscData() == null) ? 0 : getCscData().hashCode());
        result = prime * result + ((getCscFault() == null) ? 0 : getCscFault().hashCode());
        result = prime * result + ((getCscUploadTime() == null) ? 0 : getCscUploadTime().hashCode());
        result = prime * result + ((getCscAddTime() == null) ? 0 : getCscAddTime().hashCode());
        result = prime * result + ((getCscLarum() == null) ? 0 : getCscLarum().hashCode());
        result = prime * result + ((getCscPrompt() == null) ? 0 : getCscPrompt().hashCode());
        result = prime * result + ((getCscDealDesc() == null) ? 0 : getCscDealDesc().hashCode());
        result = prime * result + ((getCscDealTime() == null) ? 0 : getCscDealTime().hashCode());
        result = prime * result + ((getCscStatus() == null) ? 0 : getCscStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_can_biz
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", cscId=").append(cscId);
        sb.append(", cscAccess=").append(cscAccess);
        sb.append(", shName=").append(shName);
        sb.append(", cscHost=").append(cscHost);
        sb.append(", cscNumber=").append(cscNumber);
        sb.append(", csVin=").append(csVin);
        sb.append(", cscCar=").append(cscCar);
        sb.append(", cscModel=").append(cscModel);
        sb.append(", cscType=").append(cscType);
        sb.append(", cscOrder=").append(cscOrder);
        sb.append(", cscData=").append(cscData);
        sb.append(", cscFault=").append(cscFault);
        sb.append(", cscUploadTime=").append(cscUploadTime);
        sb.append(", cscAddTime=").append(cscAddTime);
        sb.append(", cscLarum=").append(cscLarum);
        sb.append(", cscPrompt=").append(cscPrompt);
        sb.append(", cscDealDesc=").append(cscDealDesc);
        sb.append(", cscDealTime=").append(cscDealTime);
        sb.append(", cscStatus=").append(cscStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}