package com.ccclubs.quota.orm.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VcDistrictPolylineExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public VcDistrictPolylineExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPolylineIdIsNull() {
            addCriterion("polyline_id is null");
            return (Criteria) this;
        }

        public Criteria andPolylineIdIsNotNull() {
            addCriterion("polyline_id is not null");
            return (Criteria) this;
        }

        public Criteria andPolylineIdEqualTo(String value) {
            addCriterion("polyline_id =", value, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdNotEqualTo(String value) {
            addCriterion("polyline_id <>", value, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdGreaterThan(String value) {
            addCriterion("polyline_id >", value, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdGreaterThanOrEqualTo(String value) {
            addCriterion("polyline_id >=", value, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdLessThan(String value) {
            addCriterion("polyline_id <", value, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdLessThanOrEqualTo(String value) {
            addCriterion("polyline_id <=", value, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdLike(String value) {
            addCriterion("polyline_id like", value, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdNotLike(String value) {
            addCriterion("polyline_id not like", value, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdIn(List<String> values) {
            addCriterion("polyline_id in", values, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdNotIn(List<String> values) {
            addCriterion("polyline_id not in", values, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdBetween(String value1, String value2) {
            addCriterion("polyline_id between", value1, value2, "polylineId");
            return (Criteria) this;
        }

        public Criteria andPolylineIdNotBetween(String value1, String value2) {
            addCriterion("polyline_id not between", value1, value2, "polylineId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNull() {
            addCriterion("district_id is null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIsNotNull() {
            addCriterion("district_id is not null");
            return (Criteria) this;
        }

        public Criteria andDistrictIdEqualTo(String value) {
            addCriterion("district_id =", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotEqualTo(String value) {
            addCriterion("district_id <>", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThan(String value) {
            addCriterion("district_id >", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdGreaterThanOrEqualTo(String value) {
            addCriterion("district_id >=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThan(String value) {
            addCriterion("district_id <", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLessThanOrEqualTo(String value) {
            addCriterion("district_id <=", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdLike(String value) {
            addCriterion("district_id like", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotLike(String value) {
            addCriterion("district_id not like", value, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdIn(List<String> values) {
            addCriterion("district_id in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotIn(List<String> values) {
            addCriterion("district_id not in", values, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdBetween(String value1, String value2) {
            addCriterion("district_id between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andDistrictIdNotBetween(String value1, String value2) {
            addCriterion("district_id not between", value1, value2, "districtId");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeIsNull() {
            addCriterion("polyline_longitude is null");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeIsNotNull() {
            addCriterion("polyline_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeEqualTo(BigDecimal value) {
            addCriterion("polyline_longitude =", value, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("polyline_longitude <>", value, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeGreaterThan(BigDecimal value) {
            addCriterion("polyline_longitude >", value, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("polyline_longitude >=", value, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeLessThan(BigDecimal value) {
            addCriterion("polyline_longitude <", value, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("polyline_longitude <=", value, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeIn(List<BigDecimal> values) {
            addCriterion("polyline_longitude in", values, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("polyline_longitude not in", values, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("polyline_longitude between", value1, value2, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("polyline_longitude not between", value1, value2, "polylineLongitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeIsNull() {
            addCriterion("polyline_latitude is null");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeIsNotNull() {
            addCriterion("polyline_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeEqualTo(BigDecimal value) {
            addCriterion("polyline_latitude =", value, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("polyline_latitude <>", value, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeGreaterThan(BigDecimal value) {
            addCriterion("polyline_latitude >", value, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("polyline_latitude >=", value, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeLessThan(BigDecimal value) {
            addCriterion("polyline_latitude <", value, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("polyline_latitude <=", value, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeIn(List<BigDecimal> values) {
            addCriterion("polyline_latitude in", values, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("polyline_latitude not in", values, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("polyline_latitude between", value1, value2, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andPolylineLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("polyline_latitude not between", value1, value2, "polylineLatitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeIsNull() {
            addCriterion("gps84_longitude is null");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeIsNotNull() {
            addCriterion("gps84_longitude is not null");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeEqualTo(BigDecimal value) {
            addCriterion("gps84_longitude =", value, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeNotEqualTo(BigDecimal value) {
            addCriterion("gps84_longitude <>", value, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeGreaterThan(BigDecimal value) {
            addCriterion("gps84_longitude >", value, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gps84_longitude >=", value, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeLessThan(BigDecimal value) {
            addCriterion("gps84_longitude <", value, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gps84_longitude <=", value, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeIn(List<BigDecimal> values) {
            addCriterion("gps84_longitude in", values, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeNotIn(List<BigDecimal> values) {
            addCriterion("gps84_longitude not in", values, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gps84_longitude between", value1, value2, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gps84_longitude not between", value1, value2, "gps84Longitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeIsNull() {
            addCriterion("gps84_latitude is null");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeIsNotNull() {
            addCriterion("gps84_latitude is not null");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeEqualTo(BigDecimal value) {
            addCriterion("gps84_latitude =", value, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeNotEqualTo(BigDecimal value) {
            addCriterion("gps84_latitude <>", value, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeGreaterThan(BigDecimal value) {
            addCriterion("gps84_latitude >", value, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("gps84_latitude >=", value, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeLessThan(BigDecimal value) {
            addCriterion("gps84_latitude <", value, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("gps84_latitude <=", value, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeIn(List<BigDecimal> values) {
            addCriterion("gps84_latitude in", values, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeNotIn(List<BigDecimal> values) {
            addCriterion("gps84_latitude not in", values, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gps84_latitude between", value1, value2, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andGps84LatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("gps84_latitude not between", value1, value2, "gps84Latitude");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneIsNull() {
            addCriterion("polyline_zone is null");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneIsNotNull() {
            addCriterion("polyline_zone is not null");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneEqualTo(Integer value) {
            addCriterion("polyline_zone =", value, "polylineZone");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneNotEqualTo(Integer value) {
            addCriterion("polyline_zone <>", value, "polylineZone");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneGreaterThan(Integer value) {
            addCriterion("polyline_zone >", value, "polylineZone");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneGreaterThanOrEqualTo(Integer value) {
            addCriterion("polyline_zone >=", value, "polylineZone");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneLessThan(Integer value) {
            addCriterion("polyline_zone <", value, "polylineZone");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneLessThanOrEqualTo(Integer value) {
            addCriterion("polyline_zone <=", value, "polylineZone");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneIn(List<Integer> values) {
            addCriterion("polyline_zone in", values, "polylineZone");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneNotIn(List<Integer> values) {
            addCriterion("polyline_zone not in", values, "polylineZone");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneBetween(Integer value1, Integer value2) {
            addCriterion("polyline_zone between", value1, value2, "polylineZone");
            return (Criteria) this;
        }

        public Criteria andPolylineZoneNotBetween(Integer value1, Integer value2) {
            addCriterion("polyline_zone not between", value1, value2, "polylineZone");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table vc_district_polyline
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table vc_district_polyline
     *
     * @mbg.generated
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}