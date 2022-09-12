package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "SalaryRule", uniqueConstraints = { @UniqueConstraint( name = "UK_SalaryRule",columnNames = { "salaryRuleCode","salaryHeadID" } ) } )
public class SalaryRule extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryRuleCode",nullable = false)
    private String salaryRuleCode;

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryHeadID",nullable = false)
    private String salaryHeadID;

    @Size(max = 10)
    @Column(name = "sCriteria")
    private String sCriteria;

    @Size(max = 20)
    @Column(name = "ParentHeadID")
    private String parentHeadID;

    @Column(name = "ParentHeadValue")
    private float parentHeadValue;

    @Column(name = "IsFixed" ,nullable = false, columnDefinition = "BIT CONSTRAINT DF_SalaryRule_IsFixed DEFAULT 0")
    private boolean isFixed;

    @Column(name = "IsHigher", nullable = false, columnDefinition = "BIT CONSTRAINT DF_SalaryRule_IsHigher DEFAULT 0")
    private boolean isHigher;

    @Size(max = 8000)
    @Column(name = "Formula1")
    private String formula1;

    @Size(max = 8000)
    @Column(name = "Formula2")
    private String formula2;

    @Column(name = "SequenceNo", nullable = false, columnDefinition = "INT CONSTRAINT DF_SalaryRule_SequenceNo DEFAULT 0")
    private int sequenceNo;

    @OneToMany(mappedBy = "salaryRule", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<EmployeeSalary> employeeSalaries;

    public String getSalaryRuleCode() {
        return salaryRuleCode;
    }

    public void setSalaryRuleCode(String salaryRuleCode) {
        this.salaryRuleCode = salaryRuleCode;
    }

    public String getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public String getsCriteria() {
        return sCriteria;
    }

    public void setsCriteria(String sCriteria) {
        this.sCriteria = sCriteria;
    }

    public String getParentHeadID() {
        return parentHeadID;
    }

    public void setParentHeadID(String parentHeadID) {
        this.parentHeadID = parentHeadID;
    }

    public float getParentHeadValue() {
        return parentHeadValue;
    }

    public void setParentHeadValue(float parentHeadValue) {
        this.parentHeadValue = parentHeadValue;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public boolean isHigher() {
        return isHigher;
    }

    public void setHigher(boolean higher) {
        isHigher = higher;
    }

    public String getFormula1() {
        return formula1;
    }

    public void setFormula1(String formula1) {
        this.formula1 = formula1;
    }

    public String getFormula2() {
        return formula2;
    }

    public void setFormula2(String formula2) {
        this.formula2 = formula2;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public Set<EmployeeSalary> getEmployeeSalaries() {
        return employeeSalaries;
    }

    public void setEmployeeSalaries(Set<EmployeeSalary> employeeSalaries) {
        this.employeeSalaries = employeeSalaries;
    }
}
