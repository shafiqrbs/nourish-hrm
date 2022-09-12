package com.erp.hrm.api.dto.shift;

import java.util.Date;

public class ShiftAssignmentDTO {
    private boolean IsFixedShift; // FixedShift OR Roster Shift

    private String ShiftType; // Daily OR Temporary OR Permanent
    private Date CurrentDate;

    private String ShiftID;

    public ShiftAssignmentDTO() {
    }

    public boolean isFixedShift() {
        return IsFixedShift;
    }

    public void setFixedShift(boolean fixedShift) {
        IsFixedShift = fixedShift;
    }

    public String getShiftType() {
        return ShiftType;
    }

    public void setShiftType(String shiftType) {
        ShiftType = shiftType;
    }

    public Date getCurrentDate() {
        return CurrentDate;
    }

    public void setCurrentDate(Date currentDate) {
        CurrentDate = currentDate;
    }

    public String getShiftID() {
        return ShiftID;
    }

    public void setShiftID(String shiftID) {
        ShiftID = shiftID;
    }
}
