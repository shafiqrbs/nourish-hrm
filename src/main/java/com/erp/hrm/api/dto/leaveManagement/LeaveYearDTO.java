package com.erp.hrm.api.dto.leaveManagement;

import java.util.Date;

public class LeaveYearDTO {
    private String fromMonth;
    private String toMonth;

    public LeaveYearDTO() {
    }

    public LeaveYearDTO(String fromMonth, String toMonth) {
        this.fromMonth = fromMonth;
        this.toMonth = toMonth;
    }

    public String getFromMonth() {
        return fromMonth;
    }

    public void setFromMonth(String fromMonth) {
        this.fromMonth = fromMonth;
    }

    public String getToMonth() {
        return toMonth;
    }

    public void setToMonth(String toMonth) {
        this.toMonth = toMonth;
    }

}
