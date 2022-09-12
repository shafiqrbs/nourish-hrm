package com.erp.hrm.api.dto.shift;

import java.util.Date;
import java.util.List;

public class ShiftRosteringDTO {
    private List<String> employeeCodes;
    private boolean allEmployees;
    private Date fromDate;
    private Date toDate;
    private String userId;

    public ShiftRosteringDTO() {
    }

    public ShiftRosteringDTO(List<String> employeeCodes, boolean allEmployees, Date fromDate, Date toDate, String userId) {
        this.employeeCodes = employeeCodes;
        this.allEmployees = allEmployees;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.userId = userId;
    }

    public List<String> getEmployeeCodes() {
        return employeeCodes;
    }

    public void setEmployeeCodes(List<String> employeeCodes) {
        this.employeeCodes = employeeCodes;
    }

    public boolean isAllEmployees() {
        return allEmployees;
    }

    public void setAllEmployees(boolean allEmployees) {
        this.allEmployees = allEmployees;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
