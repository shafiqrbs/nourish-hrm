package com.erp.hrm.api.dto.leaveManagement;

import java.math.BigDecimal;
import java.util.Date;

public class LeaveHourlyTransactionDTO {
    private String LeaveType;
    private Date FromDate;
    private Date ToDate;
    private BigDecimal TotalDays;
    private String LeaveReason;
    private String AddressWhenOnLeave;
    private boolean IsPreApproved;
    private boolean IsPostApproved;

    public LeaveHourlyTransactionDTO() {
    }

    public LeaveHourlyTransactionDTO(String leaveType, Date fromDate, Date toDate, BigDecimal totalDays, String leaveReason,
                                     String addressWhenOnLeave, boolean isPreApproved, boolean isPostApproved) {
        LeaveType = leaveType;
        FromDate = fromDate;
        ToDate = toDate;
        TotalDays = totalDays;
        LeaveReason = leaveReason;
        AddressWhenOnLeave = addressWhenOnLeave;
        IsPreApproved = isPreApproved;
        IsPostApproved = isPostApproved;
    }

    public String getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(String leaveType) {
        LeaveType = leaveType;
    }

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date fromDate) {
        FromDate = fromDate;
    }

    public Date getToDate() {
        return ToDate;
    }

    public void setToDate(Date toDate) {
        ToDate = toDate;
    }

    public BigDecimal getTotalDays() {
        return TotalDays;
    }

    public void setTotalDays(BigDecimal totalDays) {
        TotalDays = totalDays;
    }

    public String getLeaveReason() {
        return LeaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        LeaveReason = leaveReason;
    }

    public String getAddressWhenOnLeave() {
        return AddressWhenOnLeave;
    }

    public void setAddressWhenOnLeave(String addressWhenOnLeave) {
        AddressWhenOnLeave = addressWhenOnLeave;
    }

    public boolean isPreApproved() {
        return IsPreApproved;
    }

    public void setPreApproved(boolean preApproved) {
        IsPreApproved = preApproved;
    }

    public boolean isPostApproved() {
        return IsPostApproved;
    }

    public void setPostApproved(boolean postApproved) {
        IsPostApproved = postApproved;
    }
}
