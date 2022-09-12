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
@Table( name = "LeaveEncashmentDeduction" )
public class LeaveEncashmentDeduction extends BaseEntity {

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveTypeID")
    private String LeaveTypeID;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveRuleID")
    private String LeaveRuleID;

    @Size(max = 20)
    @NotNull
    @Column(name = "HeadToDeduct")
    private String HeadToDeduct;

    @Size(max = 10)
    @NotNull
    @Column(name = "sCriteria")
    private String sCriteria;

    @Column(name = "Amount")
    private double Amount;

    @Column(name = "IsPerDay")
    private boolean IsPerDay;

    @Size(max = 20)
    @Column(name = "PartialHead")
    private String PartialHead;

    @Column(name = "PartialAmount")
    private double PartialAmount;

    @Column(name = "IsHigher")
    private boolean IsHigher;

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

    public String getHeadToDeduct() {
        return HeadToDeduct;
    }

    public void setHeadToDeduct(String HeadToDeduct) {
        this.HeadToDeduct = HeadToDeduct;
    }

    public String getsCriteria() {
        return sCriteria;
    }

    public void setsCriteria(String sCriteria) {
        this.sCriteria = sCriteria;
    }

    public double getAmount() {
        return Amount;
    }

    public void setAmount(double Amount) {
        this.Amount = Amount;
    }

    public boolean getIsPerDay() {
        return IsPerDay;
    }

    public void setIsPerDay(boolean IsPerDay) {
        this.IsPerDay = IsPerDay;
    }

    public String getPartialHead() {
        return PartialHead;
    }

    public void setPartialHead(String PartialHead) {
        this.PartialHead = PartialHead;
    }

    public double getPartialAmount() {
        return PartialAmount;
    }

    public void setPartialAmount(double PartialAmount) {
        this.PartialAmount = PartialAmount;
    }

    public boolean getIsHigher() {
        return IsHigher;
    }

    public void setIsHigher(boolean IsHigher) {
        this.IsHigher = IsHigher;
    }
}
