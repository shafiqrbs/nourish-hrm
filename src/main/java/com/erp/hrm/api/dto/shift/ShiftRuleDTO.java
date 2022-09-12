package com.erp.hrm.api.dto.shift;

public class ShiftRuleDTO {

    private String ShiftRuleCode;
    private String Descriptions;
    private boolean IsDefault;

    public ShiftRuleDTO() {
    }

    public String getShiftRuleCode() {
        return ShiftRuleCode;
    }

    public void setShiftRuleCode(String shiftRuleCode) {
        ShiftRuleCode = shiftRuleCode;
    }

    public String getDescriptions() {
        return Descriptions;
    }

    public void setDescriptions(String descriptions) {
        Descriptions = descriptions;
    }

    public boolean isDefault() {
        return IsDefault;
    }

    public void setDefault(boolean aDefault) {
        IsDefault = aDefault;
    }
}
