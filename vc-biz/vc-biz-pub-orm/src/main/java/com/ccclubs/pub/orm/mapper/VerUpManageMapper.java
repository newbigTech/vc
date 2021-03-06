package com.ccclubs.pub.orm.mapper;

import com.ccclubs.pub.orm.model.VerUpManage;
import com.ccclubs.pub.orm.model.VerUpManageExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface VerUpManageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    long countByExample(VerUpManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    int deleteByExample(VerUpManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    int insert(VerUpManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    int insertSelective(VerUpManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    List<VerUpManage> selectByExample(VerUpManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    VerUpManage selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") VerUpManage record, @Param("example") VerUpManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") VerUpManage record, @Param("example") VerUpManageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(VerUpManage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ver_up_manage
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(VerUpManage record);
}