package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveEncashmentPolicyInfo" )
public class LeaveEncashmentPolicyInfo extends BaseEntity {

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

    @Column(name = "Amount")
    private BigDecimal Amount;

    @Column(name = "IsPerDay")
    private boolean IsPerDay;

    @Size(max = 20)
    @Column(name = "PartialHead")
    private String PartialHead;

    @Column(name = "PartialAmount")
    private BigDecimal PartialAmount;

    @Column(name = "IsHigher")
    private boolean IsHigher;

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

    public BigDecimal getPartialAmount(){
        return PartialAmount;
    }

    public void setPartialAmount(BigDecimal PartialAmount){
        this.PartialAmount=PartialAmount;
    }

    public boolean getIsHigher() {
        return IsHigher;
    }

    public void setIsHigher(boolean IsHigher) {
        this.IsHigher = IsHigher;
    }
}
