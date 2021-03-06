package com.ccclubs.usr.orm.model;

import java.io.Serializable;

public class VcRoleGroup implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_role_group.role_group_id
     *
     * @mbg.generated
     */
    private String roleGroupId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_role_group.role_id
     *
     * @mbg.generated
     */
    private String roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_role_group.group_id
     *
     * @mbg.generated
     */
    private String groupId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vc_role_group
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_role_group.role_group_id
     *
     * @return the value of vc_role_group.role_group_id
     *
     * @mbg.generated
     */
    public String getRoleGroupId() {
        return roleGroupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_role_group.role_group_id
     *
     * @param roleGroupId the value for vc_role_group.role_group_id
     *
     * @mbg.generated
     */
    public void setRoleGroupId(String roleGroupId) {
        this.roleGroupId = roleGroupId == null ? null : roleGroupId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_role_group.role_id
     *
     * @return the value of vc_role_group.role_id
     *
     * @mbg.generated
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_role_group.role_id
     *
     * @param roleId the value for vc_role_group.role_id
     *
     * @mbg.generated
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_role_group.group_id
     *
     * @return the value of vc_role_group.group_id
     *
     * @mbg.generated
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_role_group.group_id
     *
     * @param groupId the value for vc_role_group.group_id
     *
     * @mbg.generated
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId == null ? null : groupId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_role_group
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
        VcRoleGroup other = (VcRoleGroup) that;
        return (this.getRoleGroupId() == null ? other.getRoleGroupId() == null : this.getRoleGroupId().equals(other.getRoleGroupId()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getGroupId() == null ? other.getGroupId() == null : this.getGroupId().equals(other.getGroupId()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_role_group
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRoleGroupId() == null) ? 0 : getRoleGroupId().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getGroupId() == null) ? 0 : getGroupId().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_role_group
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", roleGroupId=").append(roleGroupId);
        sb.append(", roleId=").append(roleId);
        sb.append(", groupId=").append(groupId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}