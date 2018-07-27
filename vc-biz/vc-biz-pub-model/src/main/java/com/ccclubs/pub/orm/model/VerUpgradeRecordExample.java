package com.ccclubs.pub.orm.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VerUpgradeRecordExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    public VerUpgradeRecordExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_upgrade_record
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
     * This method corresponds to the database table ver_upgrade_record
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
     * This method corresponds to the database table ver_upgrade_record
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_upgrade_record
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
     * This class corresponds to the database table ver_upgrade_record
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andVinIsNull() {
            addCriterion("vin is null");
            return (Criteria) this;
        }

        public Criteria andVinIsNotNull() {
            addCriterion("vin is not null");
            return (Criteria) this;
        }

        public Criteria andVinEqualTo(String value) {
            addCriterion("vin =", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotEqualTo(String value) {
            addCriterion("vin <>", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThan(String value) {
            addCriterion("vin >", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinGreaterThanOrEqualTo(String value) {
            addCriterion("vin >=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThan(String value) {
            addCriterion("vin <", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLessThanOrEqualTo(String value) {
            addCriterion("vin <=", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinLike(String value) {
            addCriterion("vin like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotLike(String value) {
            addCriterion("vin not like", value, "vin");
            return (Criteria) this;
        }

        public Criteria andVinIn(List<String> values) {
            addCriterion("vin in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotIn(List<String> values) {
            addCriterion("vin not in", values, "vin");
            return (Criteria) this;
        }

        public Criteria andVinBetween(String value1, String value2) {
            addCriterion("vin between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andVinNotBetween(String value1, String value2) {
            addCriterion("vin not between", value1, value2, "vin");
            return (Criteria) this;
        }

        public Criteria andCarModelIsNull() {
            addCriterion("car_model is null");
            return (Criteria) this;
        }

        public Criteria andCarModelIsNotNull() {
            addCriterion("car_model is not null");
            return (Criteria) this;
        }

        public Criteria andCarModelEqualTo(Integer value) {
            addCriterion("car_model =", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelNotEqualTo(Integer value) {
            addCriterion("car_model <>", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelGreaterThan(Integer value) {
            addCriterion("car_model >", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelGreaterThanOrEqualTo(Integer value) {
            addCriterion("car_model >=", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelLessThan(Integer value) {
            addCriterion("car_model <", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelLessThanOrEqualTo(Integer value) {
            addCriterion("car_model <=", value, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelIn(List<Integer> values) {
            addCriterion("car_model in", values, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelNotIn(List<Integer> values) {
            addCriterion("car_model not in", values, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelBetween(Integer value1, Integer value2) {
            addCriterion("car_model between", value1, value2, "carModel");
            return (Criteria) this;
        }

        public Criteria andCarModelNotBetween(Integer value1, Integer value2) {
            addCriterion("car_model not between", value1, value2, "carModel");
            return (Criteria) this;
        }

        public Criteria andTeNumberIsNull() {
            addCriterion("te_number is null");
            return (Criteria) this;
        }

        public Criteria andTeNumberIsNotNull() {
            addCriterion("te_number is not null");
            return (Criteria) this;
        }

        public Criteria andTeNumberEqualTo(String value) {
            addCriterion("te_number =", value, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberNotEqualTo(String value) {
            addCriterion("te_number <>", value, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberGreaterThan(String value) {
            addCriterion("te_number >", value, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberGreaterThanOrEqualTo(String value) {
            addCriterion("te_number >=", value, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberLessThan(String value) {
            addCriterion("te_number <", value, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberLessThanOrEqualTo(String value) {
            addCriterion("te_number <=", value, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberLike(String value) {
            addCriterion("te_number like", value, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberNotLike(String value) {
            addCriterion("te_number not like", value, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberIn(List<String> values) {
            addCriterion("te_number in", values, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberNotIn(List<String> values) {
            addCriterion("te_number not in", values, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberBetween(String value1, String value2) {
            addCriterion("te_number between", value1, value2, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeNumberNotBetween(String value1, String value2) {
            addCriterion("te_number not between", value1, value2, "teNumber");
            return (Criteria) this;
        }

        public Criteria andTeTypeIsNull() {
            addCriterion("te_type is null");
            return (Criteria) this;
        }

        public Criteria andTeTypeIsNotNull() {
            addCriterion("te_type is not null");
            return (Criteria) this;
        }

        public Criteria andTeTypeEqualTo(Byte value) {
            addCriterion("te_type =", value, "teType");
            return (Criteria) this;
        }

        public Criteria andTeTypeNotEqualTo(Byte value) {
            addCriterion("te_type <>", value, "teType");
            return (Criteria) this;
        }

        public Criteria andTeTypeGreaterThan(Byte value) {
            addCriterion("te_type >", value, "teType");
            return (Criteria) this;
        }

        public Criteria andTeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("te_type >=", value, "teType");
            return (Criteria) this;
        }

        public Criteria andTeTypeLessThan(Byte value) {
            addCriterion("te_type <", value, "teType");
            return (Criteria) this;
        }

        public Criteria andTeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("te_type <=", value, "teType");
            return (Criteria) this;
        }

        public Criteria andTeTypeIn(List<Byte> values) {
            addCriterion("te_type in", values, "teType");
            return (Criteria) this;
        }

        public Criteria andTeTypeNotIn(List<Byte> values) {
            addCriterion("te_type not in", values, "teType");
            return (Criteria) this;
        }

        public Criteria andTeTypeBetween(Byte value1, Byte value2) {
            addCriterion("te_type between", value1, value2, "teType");
            return (Criteria) this;
        }

        public Criteria andTeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("te_type not between", value1, value2, "teType");
            return (Criteria) this;
        }

        public Criteria andTeModelIsNull() {
            addCriterion("te_model is null");
            return (Criteria) this;
        }

        public Criteria andTeModelIsNotNull() {
            addCriterion("te_model is not null");
            return (Criteria) this;
        }

        public Criteria andTeModelEqualTo(String value) {
            addCriterion("te_model =", value, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelNotEqualTo(String value) {
            addCriterion("te_model <>", value, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelGreaterThan(String value) {
            addCriterion("te_model >", value, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelGreaterThanOrEqualTo(String value) {
            addCriterion("te_model >=", value, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelLessThan(String value) {
            addCriterion("te_model <", value, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelLessThanOrEqualTo(String value) {
            addCriterion("te_model <=", value, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelLike(String value) {
            addCriterion("te_model like", value, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelNotLike(String value) {
            addCriterion("te_model not like", value, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelIn(List<String> values) {
            addCriterion("te_model in", values, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelNotIn(List<String> values) {
            addCriterion("te_model not in", values, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelBetween(String value1, String value2) {
            addCriterion("te_model between", value1, value2, "teModel");
            return (Criteria) this;
        }

        public Criteria andTeModelNotBetween(String value1, String value2) {
            addCriterion("te_model not between", value1, value2, "teModel");
            return (Criteria) this;
        }

        public Criteria andFromVersionIsNull() {
            addCriterion("from_version is null");
            return (Criteria) this;
        }

        public Criteria andFromVersionIsNotNull() {
            addCriterion("from_version is not null");
            return (Criteria) this;
        }

        public Criteria andFromVersionEqualTo(Integer value) {
            addCriterion("from_version =", value, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromVersionNotEqualTo(Integer value) {
            addCriterion("from_version <>", value, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromVersionGreaterThan(Integer value) {
            addCriterion("from_version >", value, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("from_version >=", value, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromVersionLessThan(Integer value) {
            addCriterion("from_version <", value, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromVersionLessThanOrEqualTo(Integer value) {
            addCriterion("from_version <=", value, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromVersionIn(List<Integer> values) {
            addCriterion("from_version in", values, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromVersionNotIn(List<Integer> values) {
            addCriterion("from_version not in", values, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromVersionBetween(Integer value1, Integer value2) {
            addCriterion("from_version between", value1, value2, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("from_version not between", value1, value2, "fromVersion");
            return (Criteria) this;
        }

        public Criteria andFromTypeIsNull() {
            addCriterion("from_type is null");
            return (Criteria) this;
        }

        public Criteria andFromTypeIsNotNull() {
            addCriterion("from_type is not null");
            return (Criteria) this;
        }

        public Criteria andFromTypeEqualTo(Byte value) {
            addCriterion("from_type =", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotEqualTo(Byte value) {
            addCriterion("from_type <>", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThan(Byte value) {
            addCriterion("from_type >", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("from_type >=", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThan(Byte value) {
            addCriterion("from_type <", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeLessThanOrEqualTo(Byte value) {
            addCriterion("from_type <=", value, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeIn(List<Byte> values) {
            addCriterion("from_type in", values, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotIn(List<Byte> values) {
            addCriterion("from_type not in", values, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeBetween(Byte value1, Byte value2) {
            addCriterion("from_type between", value1, value2, "fromType");
            return (Criteria) this;
        }

        public Criteria andFromTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("from_type not between", value1, value2, "fromType");
            return (Criteria) this;
        }

        public Criteria andToVersionIsNull() {
            addCriterion("to_version is null");
            return (Criteria) this;
        }

        public Criteria andToVersionIsNotNull() {
            addCriterion("to_version is not null");
            return (Criteria) this;
        }

        public Criteria andToVersionEqualTo(Integer value) {
            addCriterion("to_version =", value, "toVersion");
            return (Criteria) this;
        }

        public Criteria andToVersionNotEqualTo(Integer value) {
            addCriterion("to_version <>", value, "toVersion");
            return (Criteria) this;
        }

        public Criteria andToVersionGreaterThan(Integer value) {
            addCriterion("to_version >", value, "toVersion");
            return (Criteria) this;
        }

        public Criteria andToVersionGreaterThanOrEqualTo(Integer value) {
            addCriterion("to_version >=", value, "toVersion");
            return (Criteria) this;
        }

        public Criteria andToVersionLessThan(Integer value) {
            addCriterion("to_version <", value, "toVersion");
            return (Criteria) this;
        }

        public Criteria andToVersionLessThanOrEqualTo(Integer value) {
            addCriterion("to_version <=", value, "toVersion");
            return (Criteria) this;
        }

        public Criteria andToVersionIn(List<Integer> values) {
            addCriterion("to_version in", values, "toVersion");
            return (Criteria) this;
        }

        public Criteria andToVersionNotIn(List<Integer> values) {
            addCriterion("to_version not in", values, "toVersion");
            return (Criteria) this;
        }

        public Criteria andToVersionBetween(Integer value1, Integer value2) {
            addCriterion("to_version between", value1, value2, "toVersion");
            return (Criteria) this;
        }

        public Criteria andToVersionNotBetween(Integer value1, Integer value2) {
            addCriterion("to_version not between", value1, value2, "toVersion");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table ver_upgrade_record
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
     * This class corresponds to the database table ver_upgrade_record
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