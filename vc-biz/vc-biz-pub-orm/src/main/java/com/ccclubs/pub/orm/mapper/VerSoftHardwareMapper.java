package com.ccclubs.pub.orm.mapper;

import com.ccclubs.pub.orm.model.VerSoftHardware;
import com.ccclubs.pub.orm.model.VerSoftHardwareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface VerSoftHardwareMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    long countByExample(VerSoftHardwareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    int deleteByExample(VerSoftHardwareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    int insert(VerSoftHardware record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    int insertSelective(VerSoftHardware record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    List<VerSoftHardware> selectByExample(VerSoftHardwareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    VerSoftHardware selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") VerSoftHardware record, @Param("example") VerSoftHardwareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") VerSoftHardware record, @Param("example") VerSoftHardwareExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(VerSoftHardware record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_soft_hardware
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VerSoftHardware record);
}