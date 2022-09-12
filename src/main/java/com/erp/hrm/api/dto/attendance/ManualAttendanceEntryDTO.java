package com.erp.hrm.api.dto.attendance;

import java.util.Date;

/**
 * Created by Sohag
 */
public class ManualAttendanceEntryDTO {

    private String userId;
    private String selectedEmployeeCodes;
    private String unitName;
    private String departmentName;
    private String designationName;
    private String staffCategoryName;
    private boolean isUsingFilter;
    private String entryDate;
    private String entryType;

    public ManualAttendanceEntryDTO() {
    }

    public ManualAttendanceEntryDTO(
            String userId, String selectedEmployeeCodes, String unitName, String departmentName,
            String designationName, String staffCategoryName, boolean isUsingFilter,
            String entryDate,String entryType) {
        this.userId = userId;
        this.selectedEmployeeCodes = selectedEmployeeCodes;
        this.unitName = unitName;
        this.departmentName = departmentName;
        this.designationName = designationName;
        this.staffCategoryName = staffCategoryName;
        this.isUsingFilter = isUsingFilter;
        this.entryDate = entryDate;
        this.entryType = entryType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSelectedEmployeeCodes() {
        return selectedEmployeeCodes;
    }

    public void setSelectedEmployeeCodes(String selectedEmployeeCodes) {
        this.selectedEmployeeCodes = selectedEmployeeCodes;
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

    public boolean isUsingFilter() {
        return isUsingFilter;
    }

    public void setUsingFilter(boolean usingFilter) {
        isUsingFilter = usingFilter;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }
}
