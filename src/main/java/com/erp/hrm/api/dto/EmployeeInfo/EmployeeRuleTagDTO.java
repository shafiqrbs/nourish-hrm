package com.erp.hrm.api.dto.EmployeeInfo;

import java.util.Date;

/**
 * Created by Sohag
 */
public class EmployeeRuleTagDTO {

    private String userId;
    private String ruleName;
    private String ruleCode;
    private String selectedEmployeeCodes;
    private String unitName;
    private String departmentName;
    private String designationName;
    private String staffCategoryName;
    private boolean isUsingFilter;

    public EmployeeRuleTagDTO() {
    }

    public EmployeeRuleTagDTO(String userId, String ruleName, String ruleCode, String selectedEmployeeCodes, String unitName, String departmentName, String designationName, String staffCategoryName, boolean isUsingFilter) {
        this.userId = userId;
        this.ruleName = ruleName;
        this.ruleCode = ruleCode;
        this.selectedEmployeeCodes = selectedEmployeeCodes;
        this.unitName = unitName;
        this.departmentName = departmentName;
        this.designationName = designationName;
        this.staffCategoryName = staffCategoryName;
        this.isUsingFilter = isUsingFilter;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
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
}
