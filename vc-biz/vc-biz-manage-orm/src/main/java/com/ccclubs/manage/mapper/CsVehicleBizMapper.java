package com.ccclubs.manage.mapper;

import com.ccclubs.manage.model.CsVehicleBiz;
import com.ccclubs.manage.model.CsVehicleBizExample;

import java.util.List;

public interface CsVehicleBizMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_vehicle_biz
     *
     * @mbg.generated
     */
    long countByExample(CsVehicleBizExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_vehicle_biz
     *
     * @mbg.generated
     */
    List<CsVehicleBiz> selectByExample(CsVehicleBizExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_vehicle_biz
     *
     * @mbg.generated
     */
    CsVehicleBiz selectByPrimaryKey(Integer csvId);
}