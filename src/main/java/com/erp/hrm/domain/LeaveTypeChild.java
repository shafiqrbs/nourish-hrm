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
@Table( name = "LeaveTypeChild" )
public class LeaveTypeChild extends BaseEntity {

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveTypeID")
    private String LeaveTypeID;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveRuleID")
    private String LeaveRuleID;

    @NotNull
    @Column(name = "MinLength")
    private double MinLength;

    @NotNull
    @Column(name = "MaxLength")
    private double MaxLength;

    @Column(name = "Fixed")
    private boolean Fixed;

    @NotNull
    @Column(name = "NoOfDays")
    private Integer NoOfDays;

    @Column(name = "MaxDaysToCarryForward")
    private Integer MaxDaysToCarryForward;

    @Column(name = "MaxDaysAfterCarry")
    private Integer MaxDaysAfterCarry;

    @Size(max = 40)
    @Column(name = "DefinedFor")
    private String DefinedFor;

    public String getLeaveTypeID() {
        return LeaveTypeID;
    }

    public void setLeaveTypeID(String LeaveTypeID) {
        this.LeaveTypeID = LeaveTypeID;
    }

    public String getLeaveRuleID() {
        return LeaveRuleID;
    }

    public void setLeaveRuleID(String LeaveRuleID) {
        this.LeaveRuleID = LeaveRuleID;
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

    public boolean getFixed() {
        return Fixed;
    }

    public void setFixed(boolean Fixed) {
        this.Fixed = Fixed;
    }

    public Integer getNoOfDays(){
        return NoOfDays;
    }

    public void setNoOfDays(Integer NoOfDays){
        this.NoOfDays=NoOfDays;
    }

    public Integer getMaxDaysToCarryForward(){
        return MaxDaysToCarryForward;
    }

    public void setMaxDaysToCarryForward(Integer MaxDaysToCarryForward){
        this.MaxDaysToCarryForward=MaxDaysToCarryForward;
    }

    public Integer getMaxDaysAfterCarry(){
        return MaxDaysAfterCarry;
    }

    public void setMaxDaysAfterCarry(Integer MaxDaysAfterCarry){
        this.MaxDaysAfterCarry=MaxDaysAfterCarry;
    }

    public String getDefinedFor() {
        return DefinedFor;
    }

    public void setDefinedFor(String DefinedFor) {
        this.DefinedFor = DefinedFor;
    }
}
