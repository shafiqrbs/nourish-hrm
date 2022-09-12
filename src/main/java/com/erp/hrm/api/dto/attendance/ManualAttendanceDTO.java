package com.erp.hrm.api.dto.attendance;

import java.util.Date;

public class ManualAttendanceDTO {

    private String employeeCode;
    private String workDate;
    private String shiftID;
    private boolean isCheckInTime;
    private String checkInTime;
    private String checkInRemarks;
    private boolean isLunchOutTime;
    private String lunchOutTime;
    private String lunchOutRemarks;
    private boolean isLunchInTime;
    private String lunchInTime;
    private String lunchInRemarks;
    private boolean isCheckOutTime;
    private String checkOutTime;
    private String checkOutRemarks;

    public ManualAttendanceDTO() {
    }

    public ManualAttendanceDTO(String employeeCode, String workDate, String shiftID,
                               boolean isCheckInTime, String checkInTime, String checkInRemarks,
                               boolean isLunchOutTime, String lunchOutTime, String lunchOutRemarks,
                               boolean isLunchInTime, String lunchInTime, String lunchInRemarks,
                               boolean isCheckOutTime, String checkOutTime, String checkOutRemarks, String remarks) {
        this.employeeCode = employeeCode;
        this.workDate = workDate;
        this.shiftID = shiftID;
        this.isCheckInTime = isCheckInTime;
        this.checkInTime = checkInTime;
        this.checkInRemarks = checkInRemarks;
        this.isLunchOutTime = isLunchOutTime;
        this.lunchOutTime = lunchOutTime;
        this.lunchOutRemarks = lunchOutRemarks;
        this.isLunchInTime = isLunchInTime;
        this.lunchInTime = lunchInTime;
        this.lunchInRemarks = lunchInRemarks;
        this.isCheckOutTime = isCheckOutTime;
        this.checkOutTime = checkOutTime;
        this.checkOutRemarks = checkOutRemarks;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getWorkDate() {
        return workDate;
    }

    public void setWorkDate(String workDate) {
        this.workDate = workDate;
    }

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public boolean getIsCheckInTime() {
        return isCheckInTime;
    }

    public void setIsCheckInTime(boolean isCheckInTime) {
        this.isCheckInTime = isCheckInTime;
    }

    public String getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(String checkInTime) {
        this.checkInTime = checkInTime;
    }

    public String getCheckInRemarks() {
        return checkInRemarks;
    }

    public void setCheckInRemarks(String checkInRemarks) {
        this.checkInRemarks = checkInRemarks;
    }

    public boolean getIsLunchOutTime() {
        return isLunchOutTime;
    }

    public void setIsLunchOutTime(boolean IsLunchOutTime) {
        this.isLunchOutTime = IsLunchOutTime;
    }

    public String getLunchOutTime() {
        return lunchOutTime;
    }

    public void setLunchOutTime(String lunchOutTime) {
        this.lunchOutTime = lunchOutTime;
    }

    public String getLunchOutRemarks() {
        return lunchOutRemarks;
    }

    public void setLunchOutRemarks(String lunchOutRemarks) {
        this.lunchOutRemarks = lunchOutRemarks;
    }

    public boolean getIsLunchInTime() {
        return isLunchInTime;
    }

    public void setIsLunchInTime(boolean isLunchInTime) {
        this.isLunchInTime = isLunchInTime;
    }

    public String getLunchInTime() {
        return lunchInTime;
    }

    public String getLunchInRemarks() {
        return lunchInRemarks;
    }

    public void setLunchInRemarks(String lunchInRemarks) {
        this.lunchInRemarks = lunchInRemarks;
    }

    public void setLunchInTime(String lunchInTime) {
        this.lunchInTime = lunchInTime;
    }

    public boolean getIsCheckOutTime() {
        return isCheckOutTime;
    }

    public void setIsCheckOutTime(boolean isCheckOutTime) {
        this.isCheckOutTime = isCheckOutTime;
    }

    public String getCheckOutTime() {
        return checkOutTime;
    }

    public void setCheckOutTime(String checkOutTime) {
        this.checkOutTime = checkOutTime;
    }

    public String getCheckOutRemarks() {
        return checkOutRemarks;
    }

    public void setCheckOutRemarks(String checkOutRemarks) {
        this.checkOutRemarks = checkOutRemarks;
    }
}
