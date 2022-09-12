package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "EmployeeRuleTag" )
public class EmployeeRuleTag extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode",columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_EmployeeRuleTag_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @Size(max = 50)
    @Column(name = "OTRule")
    private String otRule;

    @Size(max = 50)
    @Column(name = "AdditionalSalaryRule")
    private String additionalSalaryRule;

    @Size(max = 50)
    @Column(name = "FinalSettlementRule")
    private String finalSettlementRule;

    @Size(max = 50)
    @Column(name = "AttendanceLateDeductionRule")
    private String attendanceLateDeductionRule;

    @Size(max = 50)
    @Column(name = "BonusPolicyCode")
    private String bonusPolicyCode;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getOtRule() {
        return otRule;
    }

    public void setOtRule(String otRule) {
        this.otRule = otRule;
    }

    public String getAdditionalSalaryRule() {
        return additionalSalaryRule;
    }

    public void setAdditionalSalaryRule(String additionalSalaryRule) {
        this.additionalSalaryRule = additionalSalaryRule;
    }

    public String getFinalSettlementRule() {
        return finalSettlementRule;
    }

    public void setFinalSettlementRule(String finalSettlementRule) {
        this.finalSettlementRule = finalSettlementRule;
    }

    public String getAttendanceLateDeductionRule() {
        return attendanceLateDeductionRule;
    }

    public void setAttendanceLateDeductionRule(String attendanceLateDeductionRule) {
        this.attendanceLateDeductionRule = attendanceLateDeductionRule;
    }

    public String getBonusPolicyCode() {
        return bonusPolicyCode;
    }

    public void setBonusPolicyCode(String bonusPolicyCode) {
        this.bonusPolicyCode = bonusPolicyCode;
    }
}
