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
@Table( name = "LeaveDaysInfo" )
public class LeaveDaysInfo extends BaseEntity {

    @Size(max = 10)
    @NotNull
    @Column(name = "LeavePolicyID")
    private String leavePolicyID;

    @NotNull
    @Column(name = "MinLength")
    private double minLength;

    @NotNull
    @Column(name = "MaxLength")
    private double maxLength;

    @NotNull
    @Column(name = "WorkingDays")
    private double workingDays;

    @NotNull
    @Column(name = "Days")
    private double days;

    @Column(name = "MaxAllocatedLimit")
    private double maxAllocatedLimit;

    public String getLeavePolicyID() {
        return leavePolicyID;
    }

    public void setLeavePolicyID(String leavePolicyID) {
        this.leavePolicyID = leavePolicyID;
    }

    public double getMinLength() {
        return minLength;
    }

    public void setMinLength(double minLength) {
        this.minLength = minLength;
    }

    public double getMaxLength() {
        return maxLength;
    }

    public void setMaxLength(double maxLength) {
        this.maxLength = maxLength;
    }

    public double getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(double workingDays) {
        this.workingDays = workingDays;
    }

    public double getDays() {
        return days;
    }

    public void setDays(double days) {
        this.days = days;
    }

    public double getMaxAllocatedLimit() {
        return maxAllocatedLimit;
    }

    public void setMaxAllocatedLimit(double maxAllocatedLimit) {
        this.maxAllocatedLimit = maxAllocatedLimit;
    }
}
