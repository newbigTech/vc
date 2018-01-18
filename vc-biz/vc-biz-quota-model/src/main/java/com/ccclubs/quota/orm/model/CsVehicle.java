package com.ccclubs.quota.orm.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class CsVehicle implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_id
     *
     * @mbg.generated
     */
    private Integer csvId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_access
     *
     * @mbg.generated
     */
    private Integer csvAccess;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_host
     *
     * @mbg.generated
     */
    private Integer csvHost;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_car_no
     *
     * @mbg.generated
     */
    private String csvCarNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_vin
     *
     * @mbg.generated
     */
    private String csvVin;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_engine_no
     *
     * @mbg.generated
     */
    private String csvEngineNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_certific
     *
     * @mbg.generated
     */
    private String csvCertific;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_color
     *
     * @mbg.generated
     */
    private Integer csvColor;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_color_code
     *
     * @mbg.generated
     */
    private Integer csvColorCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_model
     *
     * @mbg.generated
     */
    private Integer csvModel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_bataccu_code
     *
     * @mbg.generated
     */
    private String csvBataccuCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_machine
     *
     * @mbg.generated
     */
    private Integer csvMachine;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_prod_date
     *
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date csvProdDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_machines
     *
     * @mbg.generated
     */
    private String csvMachines;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_update_time
     *
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date csvUpdateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_add_time
     *
     * @mbg.generated
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone="GMT+8")
    private Date csvAddTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column cs_vehicle.csv_status
     *
     * @mbg.generated
     */
    private Integer csvStatus;



//    private  String   csvLandMark;
//
//    private  Integer  csvDomain;
//
//    private  String  csvModelCodeFull;
//
//    private  String  csvModelCodeSimple;
//
//    private  String  csvInteriorColorCode;
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table cs_vehicle
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_id
     *
     * @return the value of cs_vehicle.csv_id
     *
     * @mbg.generated
     */
    public Integer getCsvId() {
        return csvId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_id
     *
     * @param csvId the value for cs_vehicle.csv_id
     *
     * @mbg.generated
     */
    public void setCsvId(Integer csvId) {
        this.csvId = csvId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_access
     *
     * @return the value of cs_vehicle.csv_access
     *
     * @mbg.generated
     */
    public Integer getCsvAccess() {
        return csvAccess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_access
     *
     * @param csvAccess the value for cs_vehicle.csv_access
     *
     * @mbg.generated
     */
    public void setCsvAccess(Integer csvAccess) {
        this.csvAccess = csvAccess;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_host
     *
     * @return the value of cs_vehicle.csv_host
     *
     * @mbg.generated
     */
    public Integer getCsvHost() {
        return csvHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_host
     *
     * @param csvHost the value for cs_vehicle.csv_host
     *
     * @mbg.generated
     */
    public void setCsvHost(Integer csvHost) {
        this.csvHost = csvHost;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_car_no
     *
     * @return the value of cs_vehicle.csv_car_no
     *
     * @mbg.generated
     */
    public String getCsvCarNo() {
        return csvCarNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_car_no
     *
     * @param csvCarNo the value for cs_vehicle.csv_car_no
     *
     * @mbg.generated
     */
    public void setCsvCarNo(String csvCarNo) {
        this.csvCarNo = csvCarNo == null ? null : csvCarNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_vin
     *
     * @return the value of cs_vehicle.csv_vin
     *
     * @mbg.generated
     */
    public String getCsvVin() {
        return csvVin;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_vin
     *
     * @param csvVin the value for cs_vehicle.csv_vin
     *
     * @mbg.generated
     */
    public void setCsvVin(String csvVin) {
        this.csvVin = csvVin == null ? null : csvVin.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_engine_no
     *
     * @return the value of cs_vehicle.csv_engine_no
     *
     * @mbg.generated
     */
    public String getCsvEngineNo() {
        return csvEngineNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_engine_no
     *
     * @param csvEngineNo the value for cs_vehicle.csv_engine_no
     *
     * @mbg.generated
     */
    public void setCsvEngineNo(String csvEngineNo) {
        this.csvEngineNo = csvEngineNo == null ? null : csvEngineNo.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_certific
     *
     * @return the value of cs_vehicle.csv_certific
     *
     * @mbg.generated
     */
    public String getCsvCertific() {
        return csvCertific;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_certific
     *
     * @param csvCertific the value for cs_vehicle.csv_certific
     *
     * @mbg.generated
     */
    public void setCsvCertific(String csvCertific) {
        this.csvCertific = csvCertific == null ? null : csvCertific.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_color
     *
     * @return the value of cs_vehicle.csv_color
     *
     * @mbg.generated
     */
    public Integer getCsvColor() {
        return csvColor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_color
     *
     * @param csvColor the value for cs_vehicle.csv_color
     *
     * @mbg.generated
     */
    public void setCsvColor(Integer csvColor) {
        this.csvColor = csvColor;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_color_code
     *
     * @return the value of cs_vehicle.csv_color_code
     *
     * @mbg.generated
     */
    public Integer getCsvColorCode() {
        return csvColorCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_color_code
     *
     * @param csvColorCode the value for cs_vehicle.csv_color_code
     *
     * @mbg.generated
     */
    public void setCsvColorCode(Integer csvColorCode) {
        this.csvColorCode = csvColorCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_model
     *
     * @return the value of cs_vehicle.csv_model
     *
     * @mbg.generated
     */
    public Integer getCsvModel() {
        return csvModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_model
     *
     * @param csvModel the value for cs_vehicle.csv_model
     *
     * @mbg.generated
     */
    public void setCsvModel(Integer csvModel) {
        this.csvModel = csvModel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_bataccu_code
     *
     * @return the value of cs_vehicle.csv_bataccu_code
     *
     * @mbg.generated
     */
    public String getCsvBataccuCode() {
        return csvBataccuCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_bataccu_code
     *
     * @param csvBataccuCode the value for cs_vehicle.csv_bataccu_code
     *
     * @mbg.generated
     */
    public void setCsvBataccuCode(String csvBataccuCode) {
        this.csvBataccuCode = csvBataccuCode == null ? null : csvBataccuCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_machine
     *
     * @return the value of cs_vehicle.csv_machine
     *
     * @mbg.generated
     */
    public Integer getCsvMachine() {
        return csvMachine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_machine
     *
     * @param csvMachine the value for cs_vehicle.csv_machine
     *
     * @mbg.generated
     */
    public void setCsvMachine(Integer csvMachine) {
        this.csvMachine = csvMachine;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_prod_date
     *
     * @return the value of cs_vehicle.csv_prod_date
     *
     * @mbg.generated
     */
    public Date getCsvProdDate() {
        return csvProdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_prod_date
     *
     * @param csvProdDate the value for cs_vehicle.csv_prod_date
     *
     * @mbg.generated
     */
    public void setCsvProdDate(Date csvProdDate) {
        this.csvProdDate = csvProdDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_machines
     *
     * @return the value of cs_vehicle.csv_machines
     *
     * @mbg.generated
     */
    public String getCsvMachines() {
        return csvMachines;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_machines
     *
     * @param csvMachines the value for cs_vehicle.csv_machines
     *
     * @mbg.generated
     */
    public void setCsvMachines(String csvMachines) {
        this.csvMachines = csvMachines == null ? null : csvMachines.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_update_time
     *
     * @return the value of cs_vehicle.csv_update_time
     *
     * @mbg.generated
     */
    public Date getCsvUpdateTime() {
        return csvUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_update_time
     *
     * @param csvUpdateTime the value for cs_vehicle.csv_update_time
     *
     * @mbg.generated
     */
    public void setCsvUpdateTime(Date csvUpdateTime) {
        this.csvUpdateTime = csvUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_add_time
     *
     * @return the value of cs_vehicle.csv_add_time
     *
     * @mbg.generated
     */
    public Date getCsvAddTime() {
        return csvAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_add_time
     *
     * @param csvAddTime the value for cs_vehicle.csv_add_time
     *
     * @mbg.generated
     */
    public void setCsvAddTime(Date csvAddTime) {
        this.csvAddTime = csvAddTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column cs_vehicle.csv_status
     *
     * @return the value of cs_vehicle.csv_status
     *
     * @mbg.generated
     */
    public Integer getCsvStatus() {
        return csvStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column cs_vehicle.csv_status
     *
     * @param csvStatus the value for cs_vehicle.csv_status
     *
     * @mbg.generated
     */
    public void setCsvStatus(Integer csvStatus) {
        this.csvStatus = csvStatus;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_vehicle
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
        CsVehicle other = (CsVehicle) that;
        return (this.getCsvId() == null ? other.getCsvId() == null : this.getCsvId().equals(other.getCsvId()))
            && (this.getCsvAccess() == null ? other.getCsvAccess() == null : this.getCsvAccess().equals(other.getCsvAccess()))
            && (this.getCsvHost() == null ? other.getCsvHost() == null : this.getCsvHost().equals(other.getCsvHost()))
            && (this.getCsvCarNo() == null ? other.getCsvCarNo() == null : this.getCsvCarNo().equals(other.getCsvCarNo()))
            && (this.getCsvVin() == null ? other.getCsvVin() == null : this.getCsvVin().equals(other.getCsvVin()))
            && (this.getCsvEngineNo() == null ? other.getCsvEngineNo() == null : this.getCsvEngineNo().equals(other.getCsvEngineNo()))
            && (this.getCsvCertific() == null ? other.getCsvCertific() == null : this.getCsvCertific().equals(other.getCsvCertific()))
            && (this.getCsvColor() == null ? other.getCsvColor() == null : this.getCsvColor().equals(other.getCsvColor()))
            && (this.getCsvColorCode() == null ? other.getCsvColorCode() == null : this.getCsvColorCode().equals(other.getCsvColorCode()))
            && (this.getCsvModel() == null ? other.getCsvModel() == null : this.getCsvModel().equals(other.getCsvModel()))
            && (this.getCsvBataccuCode() == null ? other.getCsvBataccuCode() == null : this.getCsvBataccuCode().equals(other.getCsvBataccuCode()))
            && (this.getCsvMachine() == null ? other.getCsvMachine() == null : this.getCsvMachine().equals(other.getCsvMachine()))
            && (this.getCsvProdDate() == null ? other.getCsvProdDate() == null : this.getCsvProdDate().equals(other.getCsvProdDate()))
            && (this.getCsvMachines() == null ? other.getCsvMachines() == null : this.getCsvMachines().equals(other.getCsvMachines()))
            && (this.getCsvUpdateTime() == null ? other.getCsvUpdateTime() == null : this.getCsvUpdateTime().equals(other.getCsvUpdateTime()))
            && (this.getCsvAddTime() == null ? other.getCsvAddTime() == null : this.getCsvAddTime().equals(other.getCsvAddTime()))
            && (this.getCsvStatus() == null ? other.getCsvStatus() == null : this.getCsvStatus().equals(other.getCsvStatus()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_vehicle
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getCsvId() == null) ? 0 : getCsvId().hashCode());
        result = prime * result + ((getCsvAccess() == null) ? 0 : getCsvAccess().hashCode());
        result = prime * result + ((getCsvHost() == null) ? 0 : getCsvHost().hashCode());
        result = prime * result + ((getCsvCarNo() == null) ? 0 : getCsvCarNo().hashCode());
        result = prime * result + ((getCsvVin() == null) ? 0 : getCsvVin().hashCode());
        result = prime * result + ((getCsvEngineNo() == null) ? 0 : getCsvEngineNo().hashCode());
        result = prime * result + ((getCsvCertific() == null) ? 0 : getCsvCertific().hashCode());
        result = prime * result + ((getCsvColor() == null) ? 0 : getCsvColor().hashCode());
        result = prime * result + ((getCsvColorCode() == null) ? 0 : getCsvColorCode().hashCode());
        result = prime * result + ((getCsvModel() == null) ? 0 : getCsvModel().hashCode());
        result = prime * result + ((getCsvBataccuCode() == null) ? 0 : getCsvBataccuCode().hashCode());
        result = prime * result + ((getCsvMachine() == null) ? 0 : getCsvMachine().hashCode());
        result = prime * result + ((getCsvProdDate() == null) ? 0 : getCsvProdDate().hashCode());
        result = prime * result + ((getCsvMachines() == null) ? 0 : getCsvMachines().hashCode());
        result = prime * result + ((getCsvUpdateTime() == null) ? 0 : getCsvUpdateTime().hashCode());
        result = prime * result + ((getCsvAddTime() == null) ? 0 : getCsvAddTime().hashCode());
        result = prime * result + ((getCsvStatus() == null) ? 0 : getCsvStatus().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_vehicle
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", csvId=").append(csvId);
        sb.append(", csvAccess=").append(csvAccess);
        sb.append(", csvHost=").append(csvHost);
        sb.append(", csvCarNo=").append(csvCarNo);
        sb.append(", csvVin=").append(csvVin);
        sb.append(", csvEngineNo=").append(csvEngineNo);
        sb.append(", csvCertific=").append(csvCertific);
        sb.append(", csvColor=").append(csvColor);
        sb.append(", csvColorCode=").append(csvColorCode);
        sb.append(", csvModel=").append(csvModel);
        sb.append(", csvBataccuCode=").append(csvBataccuCode);
        sb.append(", csvMachine=").append(csvMachine);
        sb.append(", csvProdDate=").append(csvProdDate);
        sb.append(", csvMachines=").append(csvMachines);
        sb.append(", csvUpdateTime=").append(csvUpdateTime);
        sb.append(", csvAddTime=").append(csvAddTime);
        sb.append(", csvStatus=").append(csvStatus);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}