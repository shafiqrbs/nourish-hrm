package com.erp.hrm.api.dto.leaveManagement;

import java.util.List;

public class LeaveProcessDTO {
    private boolean allEmployee;
    private List<String> employeeCodes;

    public boolean isAllEmployee() {
        return allEmployee;
    }

    public void setAllEmployee(boolean allEmployee) {
        this.allEmployee = allEmployee;
    }

    public List<String> getEmployeeCodes() {
        return employeeCodes;
    }

    public void setEmployeeCodes(List<String> employeeCodes) {
        this.employeeCodes = employeeCodes;
    }
}
