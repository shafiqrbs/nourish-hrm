package com.erp.hrm.api.dto.shift;

import java.util.Date;
import java.util.List;

public class ManualShiftAssignmentDTO {
    private List<String> employeeCodes;
    private boolean allEmployeeCode;
    private boolean isFixedShift;
    private String shiftTransferType; // Daily Or Temporary Or Permanent
    private Date currentDate;
    private Date toDate;
    private String shiftID;
    private String shiftRule;
    private String userId;

    public ManualShiftAssignmentDTO() {
    }

    public ManualShiftAssignmentDTO(List<String> employeeCodes, boolean allEmployeeCode, boolean isFixedShift, String shiftTransferType, Date currentDate, Date toDate, String shiftID, String shiftRule, String userId) {
        this.employeeCodes = employeeCodes;
        this.allEmployeeCode = allEmployeeCode;
        this.isFixedShift = isFixedShift;
        this.shiftTransferType = shiftTransferType;
        this.currentDate = currentDate;
        this.toDate = toDate;
        this.shiftID = shiftID;
        this.shiftRule = shiftRule;
        this.userId = userId;
    }

    public List<String> getEmployeeCodes() {
        return employeeCodes;
    }

    public void setEmployeeCodes(List<String> employeeCodes) {
        this.employeeCodes = employeeCodes;
    }

    public boolean isAllEmployeeCode() {
        return allEmployeeCode;
    }

    public void setAllEmployeeCode(boolean allEmployeeCode) {
        this.allEmployeeCode = allEmployeeCode;
    }

    public boolean isFixedShift() {
        return isFixedShift;
    }

    public void setFixedShift(boolean fixedShift) {
        isFixedShift = fixedShift;
    }

    public String getShiftTransferType() {
        return shiftTransferType;
    }

    public void setShiftTransferType(String shiftTransferType) {
        this.shiftTransferType = shiftTransferType;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public String getShiftRule() {
        return shiftRule;
    }

    public void setShiftRule(String shiftRule) {
        this.shiftRule = shiftRule;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
