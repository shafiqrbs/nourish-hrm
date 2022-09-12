package com.erp.hrm.api.dto.leaveManagement;

import java.math.BigDecimal;

public class LeaveDeductionEncashmentDTO {
    private String PolicyID;
    private String LeaveType;
    private String Description;
    private String sCriteria; // Fixed, Percentage, Partial
    private String Head;
    private BigDecimal Amount;
    private int DaysInMonthCalculateDeduction;
    private boolean IsDeductionForPerDayLeave;

    private String sCriteriaEncashment; // Fixed, Percentage, Partial
    private String FirstHead;
    private BigDecimal FirstAmount;
    private String SecondHead;
    private BigDecimal SecondAmount;

    private boolean IsHigher; // Higher OR Lower

    public LeaveDeductionEncashmentDTO() {
    }

    public LeaveDeductionEncashmentDTO(String policyID, String leaveType, String description, String sCriteria, String head, BigDecimal amount, int daysInMonthCalculateDeduction, boolean isDeductionForPerDayLeave, String sCriteriaEncashment, String firstHead, BigDecimal firstAmount, String secondHead, BigDecimal secondAmount, boolean isHigher) {
        PolicyID = policyID;
        LeaveType = leaveType;
        Description = description;
        this.sCriteria = sCriteria;
        Head = head;
        Amount = amount;
        DaysInMonthCalculateDeduction = daysInMonthCalculateDeduction;
        IsDeductionForPerDayLeave = isDeductionForPerDayLeave;
        this.sCriteriaEncashment = sCriteriaEncashment;
        FirstHead = firstHead;
        FirstAmount = firstAmount;
        SecondHead = secondHead;
        SecondAmount = secondAmount;
        IsHigher = isHigher;
    }

    public String getPolicyID() {
        return PolicyID;
    }

    public void setPolicyID(String policyID) {
        PolicyID = policyID;
    }

    public String getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(String leaveType) {
        LeaveType = leaveType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getsCriteria() {
        return sCriteria;
    }

    public void setsCriteria(String sCriteria) {
        this.sCriteria = sCriteria;
    }

    public String getHead() {
        return Head;
    }

    public void setHead(String head) {
        Head = head;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        Amount = amount;
    }

    public int getDaysInMonthCalculateDeduction() {
        return DaysInMonthCalculateDeduction;
    }

    public void setDaysInMonthCalculateDeduction(int daysInMonthCalculateDeduction) {
        DaysInMonthCalculateDeduction = daysInMonthCalculateDeduction;
    }

    public boolean isDeductionForPerDayLeave() {
        return IsDeductionForPerDayLeave;
    }

    public void setDeductionForPerDayLeave(boolean deductionForPerDayLeave) {
        IsDeductionForPerDayLeave = deductionForPerDayLeave;
    }

    public String getsCriteriaEncashment() {
        return sCriteriaEncashment;
    }

    public void setsCriteriaEncashment(String sCriteriaEncashment) {
        this.sCriteriaEncashment = sCriteriaEncashment;
    }

    public String getFirstHead() {
        return FirstHead;
    }

    public void setFirstHead(String firstHead) {
        FirstHead = firstHead;
    }

    public BigDecimal getFirstAmount() {
        return FirstAmount;
    }

    public void setFirstAmount(BigDecimal firstAmount) {
        FirstAmount = firstAmount;
    }

    public String getSecondHead() {
        return SecondHead;
    }

    public void setSecondHead(String secondHead) {
        SecondHead = secondHead;
    }

    public BigDecimal getSecondAmount() {
        return SecondAmount;
    }

    public void setSecondAmount(BigDecimal secondAmount) {
        SecondAmount = secondAmount;
    }

    public boolean isHigher() {
        return IsHigher;
    }

    public void setHigher(boolean higher) {
        IsHigher = higher;
    }
}
