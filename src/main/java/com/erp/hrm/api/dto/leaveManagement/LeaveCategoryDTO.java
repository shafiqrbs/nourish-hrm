package com.erp.hrm.api.dto.leaveManagement;

public class LeaveCategoryDTO {
    private String leaveCategory;

    public LeaveCategoryDTO() {
    }

    public LeaveCategoryDTO(String leaveCategory) {
        this.leaveCategory = leaveCategory;
    }

    public String getLeaveCategory() {
        return leaveCategory;
    }

    public void setLeaveCategory(String leaveCategory) {
        this.leaveCategory = leaveCategory;
    }

}
