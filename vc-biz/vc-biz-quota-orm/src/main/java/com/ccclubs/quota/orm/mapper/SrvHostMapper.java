package com.ccclubs.quota.orm.mapper;

import com.ccclubs.quota.orm.model.SrvHost;
import com.ccclubs.quota.orm.model.SrvHostExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SrvHostMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    long countByExample(SrvHostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    int deleteByExample(SrvHostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer shId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    int insert(SrvHost record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    int insertSelective(SrvHost record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    List<SrvHost> selectByExample(SrvHostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    SrvHost selectByPrimaryKey(Integer shId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SrvHost record,
        @Param("example") SrvHostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SrvHost record, @Param("example") SrvHostExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(SrvHost record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table srv_host
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(SrvHost record);
}