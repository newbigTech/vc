package com.ccclubs.quota.orm.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class VcDistrictGps implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_district_gps.district_id
     *
     * @mbg.generated
     */
    private String districtId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_district_gps.district_name
     *
     * @mbg.generated
     */
    private String districtName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_district_gps.max_longitude
     *
     * @mbg.generated
     */
    private BigDecimal maxLongitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_district_gps.min_longitude
     *
     * @mbg.generated
     */
    private BigDecimal minLongitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_district_gps.max_latitude
     *
     * @mbg.generated
     */
    private BigDecimal maxLatitude;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_district_gps.min_latitude
     *
     * @mbg.generated
     */
    private BigDecimal minLatitude;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vc_district_gps
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_district_gps.district_id
     *
     * @return the value of vc_district_gps.district_id
     *
     * @mbg.generated
     */
    public String getDistrictId() {
        return districtId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_district_gps.district_id
     *
     * @param districtId the value for vc_district_gps.district_id
     *
     * @mbg.generated
     */
    public void setDistrictId(String districtId) {
        this.districtId = districtId == null ? null : districtId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_district_gps.district_name
     *
     * @return the value of vc_district_gps.district_name
     *
     * @mbg.generated
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_district_gps.district_name
     *
     * @param districtName the value for vc_district_gps.district_name
     *
     * @mbg.generated
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_district_gps.max_longitude
     *
     * @return the value of vc_district_gps.max_longitude
     *
     * @mbg.generated
     */
    public BigDecimal getMaxLongitude() {
        return maxLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_district_gps.max_longitude
     *
     * @param maxLongitude the value for vc_district_gps.max_longitude
     *
     * @mbg.generated
     */
    public void setMaxLongitude(BigDecimal maxLongitude) {
        this.maxLongitude = maxLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_district_gps.min_longitude
     *
     * @return the value of vc_district_gps.min_longitude
     *
     * @mbg.generated
     */
    public BigDecimal getMinLongitude() {
        return minLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_district_gps.min_longitude
     *
     * @param minLongitude the value for vc_district_gps.min_longitude
     *
     * @mbg.generated
     */
    public void setMinLongitude(BigDecimal minLongitude) {
        this.minLongitude = minLongitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_district_gps.max_latitude
     *
     * @return the value of vc_district_gps.max_latitude
     *
     * @mbg.generated
     */
    public BigDecimal getMaxLatitude() {
        return maxLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_district_gps.max_latitude
     *
     * @param maxLatitude the value for vc_district_gps.max_latitude
     *
     * @mbg.generated
     */
    public void setMaxLatitude(BigDecimal maxLatitude) {
        this.maxLatitude = maxLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_district_gps.min_latitude
     *
     * @return the value of vc_district_gps.min_latitude
     *
     * @mbg.generated
     */
    public BigDecimal getMinLatitude() {
        return minLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_district_gps.min_latitude
     *
     * @param minLatitude the value for vc_district_gps.min_latitude
     *
     * @mbg.generated
     */
    public void setMinLatitude(BigDecimal minLatitude) {
        this.minLatitude = minLatitude;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_gps
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
        VcDistrictGps other = (VcDistrictGps) that;
        return (this.getDistrictId() == null ? other.getDistrictId() == null : this.getDistrictId().equals(other.getDistrictId()))
            && (this.getDistrictName() == null ? other.getDistrictName() == null : this.getDistrictName().equals(other.getDistrictName()))
            && (this.getMaxLongitude() == null ? other.getMaxLongitude() == null : this.getMaxLongitude().equals(other.getMaxLongitude()))
            && (this.getMinLongitude() == null ? other.getMinLongitude() == null : this.getMinLongitude().equals(other.getMinLongitude()))
            && (this.getMaxLatitude() == null ? other.getMaxLatitude() == null : this.getMaxLatitude().equals(other.getMaxLatitude()))
            && (this.getMinLatitude() == null ? other.getMinLatitude() == null : this.getMinLatitude().equals(other.getMinLatitude()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_gps
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getDistrictId() == null) ? 0 : getDistrictId().hashCode());
        result = prime * result + ((getDistrictName() == null) ? 0 : getDistrictName().hashCode());
        result = prime * result + ((getMaxLongitude() == null) ? 0 : getMaxLongitude().hashCode());
        result = prime * result + ((getMinLongitude() == null) ? 0 : getMinLongitude().hashCode());
        result = prime * result + ((getMaxLatitude() == null) ? 0 : getMaxLatitude().hashCode());
        result = prime * result + ((getMinLatitude() == null) ? 0 : getMinLatitude().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_gps
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", districtId=").append(districtId);
        sb.append(", districtName=").append(districtName);
        sb.append(", maxLongitude=").append(maxLongitude);
        sb.append(", minLongitude=").append(minLongitude);
        sb.append(", maxLatitude=").append(maxLatitude);
        sb.append(", minLatitude=").append(minLatitude);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}