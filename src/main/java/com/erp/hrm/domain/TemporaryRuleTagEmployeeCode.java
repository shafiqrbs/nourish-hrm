package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 19/01/2019.
 */
@Entity
@Table( name = "TemporaryRuleTagEmployeeCode" )
public class TemporaryRuleTagEmployeeCode extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String employeeCode;

    @Size(max = 16)
    @Column(name = "RuleCode")
    private String ruleCode;

    @Size(max = 250)
    @Column(name = "UserId")
    private String userId;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
