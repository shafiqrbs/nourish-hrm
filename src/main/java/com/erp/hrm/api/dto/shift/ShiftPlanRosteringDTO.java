package com.erp.hrm.api.dto.shift;

public class ShiftPlanRosteringDTO {

    private String ShiftRuleCode;
    private String ShiftID;
    private String ShiftType;
    private String Alias;
    private int Days;
    private int SequenceNo;

    public String getShiftRuleCode() {
        return ShiftRuleCode;
    }

    public void setShiftRuleCode(String ShiftRuleCode) {
        this.ShiftRuleCode = ShiftRuleCode;
    }

    public String getShiftID() {
        return ShiftID;
    }

    public void setShiftID(String shiftID) {
        this.ShiftID = shiftID;
    }

    public String getShiftType() {
        return ShiftType;
    }

    public void setShiftType(String shiftType) {
        this.ShiftType = shiftType;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String alias) {
        this.Alias = alias;
    }

    public int getDays() {
        return Days;
    }

    public void setDays(int days) {
        this.Days = days;
    }

    public int getSequenceNo() {
        return SequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.SequenceNo = sequenceNo;
    }
}
