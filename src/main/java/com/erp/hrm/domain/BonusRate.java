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
@Table( name = "BonusRate" )
public class BonusRate extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "RuleCode")
    private String RuleCode;

    @Size(max = 100)
    @Column(name = "Description")
    private String Description;

    @NotNull
    @Column(name = "IsActive")
    private boolean IsActive;

    public String getRuleCode() {
        return RuleCode;
    }

    public void setRuleCode(String RuleCode) {
        this.RuleCode = RuleCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }
}
