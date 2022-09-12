package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "ShiftRule", uniqueConstraints = { @UniqueConstraint( name ="UK_ShiftRule",columnNames = { "ShiftRuleCode" } ) } )
public class ShiftRule extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "ShiftRuleCode")
    private String ShiftRuleCode;

    @Column(name = "Descriptions")
    private String Descriptions;

    @Column(name = "IsDefaultRule", nullable = false, columnDefinition = "BIT CONSTRAINT DF_ShiftRule_IsDefault DEFAULT 0")
    private boolean IsDefaultRule;

    public String getShiftRuleCode() {
        return ShiftRuleCode;
    }

    public void setShiftRuleCode(String ShiftRuleCode) {
        this.ShiftRuleCode = ShiftRuleCode;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String Descriptions) {
        this.Descriptions = Descriptions;
    }

    public boolean getIsDefaultRule() {
        return IsDefaultRule;
    }

    public void setIsDefaultRule(boolean IsDefault) {
        this.IsDefaultRule = IsDefaultRule;
    }
}
