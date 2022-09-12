package com.erp.hrm.api.dto.shift;

public class WorkOffCalendarDTO {

    private String shiftNature;     // FixedShift OR Roster Shift
    private String shiftIds;        // All or shiftIds separated by comma
    private String employeeCodes;        // All or EmployeeCode separated by comma
    private String dayOffDates;     // dates separated by comma
    private String dayType;         // W (Weekend) or H (Holiday)
    private String unitName;
    private String departmentName;
    private String designationName;
    private String staffCategoryName;
    private String remarks;
    private String userId;

    public String getShiftNature() {
        return shiftNature;
    }

    public void setShiftNature(String shiftNature) {
        this.shiftNature = shiftNature;
    }

    public String getShiftIds() {
        return shiftIds;
    }

    public void setShiftIds(String shiftIds) {
        this.shiftIds = shiftIds;
    }

    public String getEmployeeCodes() {
        return employeeCodes;
    }

    public void setEmployeeCodes(String employeeCodes) {
        this.employeeCodes = employeeCodes;
    }

    public String getDayOffDates() {
        return dayOffDates;
    }

    public void setDayOffDates(String dayOffDates) {
        this.dayOffDates = dayOffDates;
    }

    public String getDayType() {
        return dayType;
    }

    public void setDayType(String dayType) {
        this.dayType = dayType;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getStaffCategoryName() {
        return staffCategoryName;
    }

    public void setStaffCategoryName(String staffCategoryName) {
        this.staffCategoryName = staffCategoryName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
