package com.erp.hrm.api.dto;
import java.util.Date;

public class ReportFilterDTO {
    private String fromDate;
    private String toDate;
    private String employeeCode;
    private String punchCardNo;
    private String unit;
    private String section;
    private String floor;
    private String line;
    private String department;
    private String designation;
    private String staffCategory;

    public ReportFilterDTO() {
    }

    public ReportFilterDTO(String fromDate, String toDate, String employeeCode, String punchCardNo, String unit, String section, String floor, String line, String department, String designation, String staffCategory) {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.employeeCode = employeeCode;
        this.punchCardNo = punchCardNo;
        this.unit = unit;
        this.section = section;
        this.floor = floor;
        this.line = line;
        this.department = department;
        this.designation = designation;
        this.staffCategory = staffCategory;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getPunchCardNo() {
        return punchCardNo;
    }

    public void setPunchCardNo(String punchCardNo) {
        this.punchCardNo = punchCardNo;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }
}
