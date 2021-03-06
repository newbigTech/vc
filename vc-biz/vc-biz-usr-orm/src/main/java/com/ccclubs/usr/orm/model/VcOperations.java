package com.ccclubs.usr.orm.model;

import java.io.Serializable;

public class VcOperations implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_operations.operation_id
     *
     * @mbg.generated
     */
    private String operationId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column vc_operations.operation_name
     *
     * @mbg.generated
     */
    private String operationName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table vc_operations
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_operations.operation_id
     *
     * @return the value of vc_operations.operation_id
     *
     * @mbg.generated
     */
    public String getOperationId() {
        return operationId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_operations.operation_id
     *
     * @param operationId the value for vc_operations.operation_id
     *
     * @mbg.generated
     */
    public void setOperationId(String operationId) {
        this.operationId = operationId == null ? null : operationId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column vc_operations.operation_name
     *
     * @return the value of vc_operations.operation_name
     *
     * @mbg.generated
     */
    public String getOperationName() {
        return operationName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column vc_operations.operation_name
     *
     * @param operationName the value for vc_operations.operation_name
     *
     * @mbg.generated
     */
    public void setOperationName(String operationName) {
        this.operationName = operationName == null ? null : operationName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_operations
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
        VcOperations other = (VcOperations) that;
        return (this.getOperationId() == null ? other.getOperationId() == null : this.getOperationId().equals(other.getOperationId()))
            && (this.getOperationName() == null ? other.getOperationName() == null : this.getOperationName().equals(other.getOperationName()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_operations
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getOperationId() == null) ? 0 : getOperationId().hashCode());
        result = prime * result + ((getOperationName() == null) ? 0 : getOperationName().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table vc_operations
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", operationId=").append(operationId);
        sb.append(", operationName=").append(operationName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}