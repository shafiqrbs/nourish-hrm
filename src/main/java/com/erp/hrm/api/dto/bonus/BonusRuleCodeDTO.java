package com.erp.hrm.api.dto.bonus;

/**
 * Created by SA
 */
public class BonusRuleCodeDTO {

    private String bonusRuleCode;

    public BonusRuleCodeDTO() {
    }

    public BonusRuleCodeDTO(String bonusRuleCode) {
        this.bonusRuleCode = bonusRuleCode;
    }

    public String getBonusRuleCode() {
        return bonusRuleCode;
    }

    public void setBonusRuleCode(String bonusRuleCode) {
        this.bonusRuleCode = bonusRuleCode;
    }
}
