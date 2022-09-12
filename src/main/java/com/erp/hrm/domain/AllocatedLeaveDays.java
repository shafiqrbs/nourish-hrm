package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "AllocatedLeaveDays" )
public class AllocatedLeaveDays extends BaseEntity {

    @Size(max = 20)
    @Column(name = "EmployeeCode")
    private String EmployeeCode;

    @Size(max = 20)
    @Column(name = "LeavePolicyID")
    private String LeavePolicyID;

    @Column(name = "LeaveDays")
    private Integer LeaveDays;

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public String getLeavePolicyID() {
        return LeavePolicyID;
    }

    public void setLeavePolicyID(String LeavePolicyID) {
        this.LeavePolicyID = LeavePolicyID;
    }

    public Integer getLeaveDays() {
        return LeaveDays;
    }

    public void setLeaveDays(Integer LeaveDays) {
        this.LeaveDays = LeaveDays;
    }
}
