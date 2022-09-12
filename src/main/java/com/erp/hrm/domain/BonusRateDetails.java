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
@Table( name = "BonusRateDetails" )
public class BonusRateDetails extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "RuleCode")
    private String RuleCode;

    @Size(max = 40)
    @NotNull
    @Column(name = "Condition")
    private String Condition;

    @Column(name = "FromAmt")
    private double FromAmt;

    @Column(name = "ToAmt")
    private double ToAmt;

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryHeadID")
    private String SalaryHeadID;

    @Size(max = 10)
    @Column(name = "sCriteria")
    private String sCriteria;

    @Column(name = "Amount")
    private double Amount;

    @Size(max = 20)
    @Column(name = "HeadToDeduct")
    private String HeadToDeduct;

    public String getRuleCode() {
        return RuleCode;
    }

    public void setRuleCode(String RuleCode) {
        this.RuleCode = RuleCode;
    }

    public String getCondition() {
        return Condition;
    }

    public void setCondition(String Condition) {
        this.Condition = Condition;
    }

    public double getFromAmt() {
        return FromAmt;
    }

    public void setFromAmt(double FromAmt) {
        this.FromAmt = FromAmt;
    }

    public double getToAmt() {
        return ToAmt;
    }

    public void setToAmt(double ToAmt) {
        this.ToAmt = ToAmt;
    }

    public String getSalaryHeadID() {
        return SalaryHeadID;
    }

    public void setSalaryHeadID(String SalaryHeadID) {
        this.SalaryHeadID = SalaryHeadID;
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

    public String getHeadToDeduct(){
        return HeadToDeduct;
    }

    public void setHeadToDeduct(String HeadToDeduct){
        this.HeadToDeduct=HeadToDeduct;
    }
}
