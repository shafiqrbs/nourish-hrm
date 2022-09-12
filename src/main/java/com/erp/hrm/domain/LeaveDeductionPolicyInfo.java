package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by WS
 */
@Entity
@Table( name = "LeaveDeductionPolicyInfo" ,uniqueConstraints = { @UniqueConstraint( name = "UK_LeaveDeductionInfo",columnNames = { "LeavePolicyID","HeadToDeduct","sCriteria"} ) }   )
public class LeaveDeductionPolicyInfo extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "LeavePolicyID")
    private String LeavePolicyID;

    @Size(max = 20)
    @NotNull
    @Column(name = "HeadToDeduct")
    private String HeadToDeduct;

    @Size(max = 10)
    @NotNull
    @Column(name = "sCriteria")
    private String sCriteria;

    @Column(name = "Amount", columnDefinition = "NUMERIC(18, 2)")
    private BigDecimal Amount;

    @Column(name = "IsPerDay")
    private boolean IsPerDay;

    @Size(max = 20)
    @Column(name = "PartialHead")
    private String PartialHead;

    @Column(name = "PartialAmount", columnDefinition = "NUMERIC(18, 2)")
    private BigDecimal PartialAmount;

    @Column(name = "IsHigher")
    private boolean IsHigher;

    @Column(name = "DaysInMonth")
    private Integer DaysInMonth;

    public String getLeavePolicyID() {
        return LeavePolicyID;
    }

    public void setLeavePolicyID(String LeavePolicyID) {
        this.LeavePolicyID = LeavePolicyID;
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

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal Amount) {
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

    public BigDecimal getPartialAmount() {
        return PartialAmount;
    }

    public void setPartialAmount(BigDecimal PartialAmount) {
        this.PartialAmount = PartialAmount;
    }

    public boolean getIsHigher() {
        return IsHigher;
    }

    public void setIsHigher(boolean IsHigher) {
        this.IsHigher = IsHigher;
    }

    public Integer getDaysInMonth(){
        return DaysInMonth;
    }

    public void setDaysInMonth(Integer DaysInMonth){
        this.DaysInMonth=DaysInMonth;
    }
}
