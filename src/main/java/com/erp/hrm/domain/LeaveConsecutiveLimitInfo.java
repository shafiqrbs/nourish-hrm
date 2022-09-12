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
@Table( name = "LeaveConsecutiveLimitInfo" )
public class LeaveConsecutiveLimitInfo extends BaseEntity {

    @Size(max = 10)
    @NotNull
    @Column(name = "LeavePolicyID")
    private String LeavePolicyID;

    @NotNull
    @Column(name = "MinLength")
    private double MinLength;

    @NotNull
    @Column(name = "MaxLength")
    private double MaxLength;

    @NotNull
    @Column(name = "Days")
    private double Days;

    public String getLeavePolicyID() {
        return LeavePolicyID;
    }

    public void setLeavePolicyID(String LeavePolicyID) {
        this.LeavePolicyID = LeavePolicyID;
    }

    public double getMinLength() {
        return MinLength;
    }

    public void setMinLength(double MinLength) {
        this.MinLength = MinLength;
    }

    public double getMaxLength() {
        return MaxLength;
    }

    public void setMaxLength(double MaxLength) {
        this.MaxLength = MaxLength;
    }

    public double getDays() {
        return Days;
    }

    public void setDays(double Days) {
        this.Days = Days;
    }
}
