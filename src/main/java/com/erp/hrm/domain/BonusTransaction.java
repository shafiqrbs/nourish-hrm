package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by SA
 */
@Entity
@Table( name = "BonusTransaction", uniqueConstraints = { @UniqueConstraint( name = "UK_BonusTransaction",columnNames = { "BonusCode","EffectiveDate","EmployeeCode"} ) } )
public class BonusTransaction extends BaseEntity {

    @Size(max = 50)
    @Column(name = "BonusCode",nullable = false)
    private String bonusCode;

    @Column(name = "EffectiveDate", nullable = false)
    private Date effectiveDate;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_BonusTransaction_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @Size(max = 50)
    @Column(name = "BonusCriteria",nullable = false)
    private String bonusCriteria;

    @Size(max = 50)
    @Column(name = "BonusCriteriaValue",nullable = false)
    private String bonusCriteriaValue;

    @Column(name = "MinServiceLen",nullable = false, columnDefinition = "INT CONSTRAINT DF_BonusTransaction_MinServiceLen  DEFAULT 0")
    private int minServiceLen;

    @Column(name = "MaxServiceLen",nullable = false, columnDefinition = "INT CONSTRAINT DF_BonusTransaction_MaxServiceLen  DEFAULT 0")
    private int maxServiceLen;

    @Column(name = "EmployeeServiceLen",nullable = false, columnDefinition = "INT CONSTRAINT DF_BonusTransaction_EmployeeServiceLen DEFAULT 0")
    private int employeeServiceLen;

    @Column(name = "Amount",nullable = false, columnDefinition = "NUMERIC(18, 4) CONSTRAINT DF_BonusTransaction_Amount  DEFAULT 0")
    private float amount;

    @Size(max = 20)
    @Column(name = "ApprovedBy",nullable = false)
    private String approvedBy;

    @Column(name = "DateApproved")
    private Date dateApproved;

    @Size(max = 20)
    @Column(name = "SalaryProcID",nullable = false)
    private String salaryProcID;

    public String getBonusCode() {
        return bonusCode;
    }

    public void setBonusCode(String bonusCode) {
        this.bonusCode = bonusCode;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
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

    public int getEmployeeServiceLen() {
        return employeeServiceLen;
    }

    public void setEmployeeServiceLen(int employeeServiceLen) {
        this.employeeServiceLen = employeeServiceLen;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }

    public String getSalaryProcID() {
        return salaryProcID;
    }

    public void setSalaryProcID(String salaryProcID) {
        this.salaryProcID = salaryProcID;
    }
}
