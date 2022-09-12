package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by SA
 */
@Entity
@Table( name = "MaternityPaymentHead", uniqueConstraints = { @UniqueConstraint( columnNames = { "MaternityLeaveRuleID","SalaryHeadID" } ) })
public class MaternityPaymentHead extends BaseEntity {

    @NotNull
    @Size(max = 50)
    @Column(name = "MaternityLeaveRuleID")
    private String maternityLeaveRuleID;

    @NotNull
    @Size(max = 50)
    @Column(name = "SalaryHeadID")
    private String salaryHeadID;

    @Size(max = 100)
    @Column(name = "Description")
    private String description;

    @Size(max = 1)
    @Column(name = "HeadType")
    private String headType;

    public String getMaternityLeaveRuleID() {
        return maternityLeaveRuleID;
    }

    public void setMaternityLeaveRuleID(String maternityLeaveRuleID) {
        this.maternityLeaveRuleID = maternityLeaveRuleID;
    }

    public String getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHeadType() {
        return headType;
    }

    public void setHeadType(String headType) {
        this.headType = headType;
    }
}
