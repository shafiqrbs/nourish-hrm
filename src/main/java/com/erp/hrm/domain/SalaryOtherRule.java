package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "SalaryOtherRule", uniqueConstraints = { @UniqueConstraint(name="UK_SalaryOtherRule", columnNames = { "OtherSalaryRuleName" } ) } )
public class SalaryOtherRule extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "OtherSalaryRuleName",nullable = false)
    private String OtherSalaryRuleName;

    @Size(max = 20)
    @NotNull
    @Column(name = "EffectedSalaryHeadID",nullable = false)
    private String EffectedSalaryHeadID;

    @Column(name = "RuleType",nullable = false)
    private int RuleType;

    @Size(max = 20)
    @Column(name = "SalaryHeadID")
    private String SalaryHeadID;

    @Column(name = "Amount", columnDefinition = "NUMERIC(18,4)")
    private BigDecimal Amount;

    @Size(max = 225)
    @Column(name = "Status")
    private String Status;

    @Column(name = "IsOverWrite", columnDefinition = "BIT CONSTRAINT DF_SalaryOtherRule_IsOverWrite  DEFAULT 0")
    private boolean IsOverWrite;

    @Column(name = "DateApproved")
    private Date DateApproved;

    @Size(max = 10)
    @Column(name = "ApprovedBy")
    private String ApprovedBy;

    @Size(max = 100)
    @Column(name = "LeaveType")
    private String LeaveType;

    @Column(name = "ExcludeWorkoff", columnDefinition = "BIT CONSTRAINT DF_SalaryOtherRule_ExcludeWorkoff  DEFAULT 0")
    private boolean ExcludeWorkoff;

    public String getOtherSalaryRuleName() {
        return OtherSalaryRuleName;
    }

    public void setOtherSalaryRuleName(String otherSalaryRuleName) {
        this.OtherSalaryRuleName = otherSalaryRuleName;
    }

    public String getEffectedSalaryHeadID() {
        return EffectedSalaryHeadID;
    }

    public void setEffectedSalaryHeadID(String effectedSalaryHeadID) {
        this.EffectedSalaryHeadID = effectedSalaryHeadID;
    }

    public int getRuleType() {
        return RuleType;
    }

    public void setRuleType(int ruleType) {
        this.RuleType = ruleType;
    }

    public String getSalaryHeadID() {
        return SalaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.SalaryHeadID = salaryHeadID;
    }

    public BigDecimal getAmount() {
        return Amount;
    }

    public void setAmount(BigDecimal amount) {
        this.Amount = amount;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public boolean isOverWrite() {
        return IsOverWrite;
    }

    public void setOverWrite(boolean overWrite) {
        this.IsOverWrite = overWrite;
    }

    public Date getDateApproved() {
        return DateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.DateApproved = dateApproved;
    }

    public String getApprovedBy() {
        return ApprovedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.ApprovedBy = approvedBy;
    }

    public String getLeaveType() {
        return LeaveType;
    }

    public void setLeaveType(String leaveType) {
        this.LeaveType = leaveType;
    }

    public boolean isExcludeWorkoff() {
        return ExcludeWorkoff;
    }

    public void setExcludeWorkoff(boolean excludeWorkoff) {
        this.ExcludeWorkoff = excludeWorkoff;
    }
}
