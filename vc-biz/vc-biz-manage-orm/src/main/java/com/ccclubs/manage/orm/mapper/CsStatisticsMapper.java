package com.ccclubs.manage.orm.mapper;

import com.ccclubs.manage.orm.model.CsStatistics;
import com.ccclubs.manage.orm.model.CsStatisticsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CsStatisticsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    long countByExample(CsStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    int deleteByExample(CsStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer cssId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    int insert(CsStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    int insertSelective(CsStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    List<CsStatistics> selectByExample(CsStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    CsStatistics selectByPrimaryKey(Integer cssId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") CsStatistics record, @Param("example") CsStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") CsStatistics record, @Param("example") CsStatisticsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(CsStatistics record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table cs_statistics
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(CsStatistics record);
}