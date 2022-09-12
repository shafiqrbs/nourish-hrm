package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "EmployeeSalary" )
public class EmployeeSalary extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmployeeSalary_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SalaryRuleId", columnDefinition="BIGINT", foreignKey = @ForeignKey(name = "FK_EmployeeSalary_SalaryRule"))
    private SalaryRule salaryRule;

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryHeadID",nullable = false)
    private String salaryHeadID;

    @Column(name = "IsFixed" ,nullable = false, columnDefinition = "BIT CONSTRAINT DF_EmployeeSalary_IsFixed DEFAULT 0")
    private boolean isFixed;

    @Column(name = "Amount", columnDefinition = "NUMERIC(18,4)")
    private float amount;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public SalaryRule getSalaryRule() {
        return salaryRule;
    }

    public void setSalaryRule(SalaryRule salaryRule) {
        this.salaryRule = salaryRule;
    }

    public String getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }
}
