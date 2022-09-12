package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by SA
 */
@Entity
@Table( name = "BonusPolicyDetail", uniqueConstraints = { @UniqueConstraint( name = "UK_BonusPolicyDetail",columnNames = { "BonusCode","BonusCriteriaValue","MinServiceLen","CalOnPaidSalaryForProdEmployee" } ) } )
public class BonusPolicyDetail extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "BonusCode",nullable = false)
    private String bonusCode;

    @Size(max = 50)
    @Column(name = "BonusCriteria")
    private String bonusCriteria;

    @Size(max = 50)
    @Column(name = "BonusCriteriaValue")
    private String bonusCriteriaValue;

    @Column(name = "MinServiceLen", nullable = false)
    private int minServiceLen;

    @Column(name = "MaxServiceLen", nullable = false)
    private int maxServiceLen;

    @Column(name = "CalOnPaidSalaryForProdEmployee", nullable = false)
    private int calOnPaidSalaryForProdEmployee;

    @Column(name = "NoOfMonthForAvrSalCal", nullable = false)
    private int noOfMonthForAvrSalCal;

    @Size(max = 10)
    @Column(name = "sCriteria", nullable = false)
    private String sCriteria;

    @Size(max = 50)
    @Column(name = "SalaryHeadID")
    private String salaryHeadID;

    @Column(name = "Amount", nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private float amount;

    @Column(name = "IsFixedCalculation",nullable = false,columnDefinition = "BIT DEFAULT 0")
    private boolean isFixedCalculation;

    public String getBonusCode() {
        return bonusCode;
    }

    public void setBonusCode(String bonusCode) {
        this.bonusCode = bonusCode;
    }

    public String getBonusCriteria() {
        return bonusCriteria;
    }

    public void setBonusCriteria(String bonusCriteria) {
        this.bonusCriteria = bonusCriteria;
    }

    public String getBonusCriteriaValue() {
        return bonusCriteriaValue;
    }

    public void setBonusCriteriaValue(String bonusCriteriaValue) {
        this.bonusCriteriaValue = bonusCriteriaValue;
    }

    public int getMinServiceLen() {
        return minServiceLen;
    }

    public void setMinServiceLen(int minServiceLen) {
        this.minServiceLen = minServiceLen;
    }

    public int getMaxServiceLen() {
        return maxServiceLen;
    }

    public void setMaxServiceLen(int maxServiceLen) {
        this.maxServiceLen = maxServiceLen;
    }

    public int getCalOnPaidSalaryForProdEmployee() {
        return calOnPaidSalaryForProdEmployee;
    }

    public void setCalOnPaidSalaryForProdEmployee(int calOnPaidSalaryForProdEmployee) {
        this.calOnPaidSalaryForProdEmployee = calOnPaidSalaryForProdEmployee;
    }

    public int getNoOfMonthForAvrSalCal() {
        return noOfMonthForAvrSalCal;
    }

    public void setNoOfMonthForAvrSalCal(int noOfMonthForAvrSalCal) {
        this.noOfMonthForAvrSalCal = noOfMonthForAvrSalCal;
    }

    public String getsCriteria() {
        return sCriteria;
    }

    public void setsCriteria(String sCriteria) {
        this.sCriteria = sCriteria;
    }

    public String getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public boolean isFixedCalculation() {
        return isFixedCalculation;
    }

    public void setFixedCalculation(boolean fixedCalculation) {
        this.isFixedCalculation = fixedCalculation;
    }
}
