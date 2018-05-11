package com.ccclubs.phoenix.orm.consts;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Module Desc:
 * User: taosm
 * DateTime: 2017/11/28 0028
 */
public class PhoenixFieldsConsts {
    //车辆状态分页查询默认字段列表
    public static final List<String> carStatePageDefaultFields = ImmutableList.of("cs_number", "current_time", "add_time", "obd_miles", "speed", "ev_battery", "saving_mode", "cur_order");
    //车辆状态所有字段列表
    public static final List<String> carStateAllFields = ImmutableList.of("cs_number", "current_time", "cs_access", "add_time", "rent_flg",
            "warn_code", "rfid", "user_rfid", "obd_miles", "engine_tempe", "total_miles", "speed", "motor_speed",
            "oil_cost", "power_reserve", "ev_battery", "charging_status", "fuel_miles", "elec_miles", "endur_miles",
            "tempe", "gps_num", "gps_strength", "gps_valid", "net_strength", "longitude", "latitude", "direction_angle",
            "circular_mode", "ptc_status", "compre_status", "fan_mode", "saving_mode", "door_status", "engine_status",
            "key_status", "light_status", "lock_status", "net_type", "base_lac", "base_ci", "cur_order", "gear", "autopilot_status", "handbrake_status"
    );
    //车辆阶段数据默认字段列表
    public static final List<String> carPaceFields = ImmutableList.of(
            "cs_number", "current_time", "engine_status",
            "add_time", "obd_miles", "speed", "ev_battery", "saving_mode",
            "cur_order", "speed", "longitude",
            "latitude", "charging_status");

    //车辆CAN分页查询默认字段列表
    public static final List<String> carCanPageDefaultFields = ImmutableList.of(
            "cs_number", "current_time", "add_time", "can_data");
    //车辆CAN所有字段列表
    public static final List<String> carCanAllFields = ImmutableList.of(
            "cs_number", "current_time", "add_time", "can_data");

    //车辆GB分页查询默认字段列表
    public static final List<String> carGbPageDefaultFields = ImmutableList.of(
            "cs_vin", "add_time", "current_time", "gb_data");
    //车辆GB所有字段列表
    public static final List<String> carGbAllFields = ImmutableList.of(
            "cs_vin", "add_time", "current_time", "gb_data", "cs_access",
            "cs_protocol", "gb_type", "cs_verify");



}