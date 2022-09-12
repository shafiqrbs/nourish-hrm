package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by WS
 */
@Entity
@Table( name = "LeaveRuleInfo" ,uniqueConstraints = { @UniqueConstraint( name = "UK_LeaveRuleInfo",columnNames = { "LeaveRuleID","LeavePolicyID"} ) } )
public class LeaveRuleInfo extends BaseEntity {

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveRuleID")
    private String leaveRuleID;

    @Size(max = 50)
    @NotNull
    @Column(name = "LeavePolicyID")
    private String leavePolicyID;

    @Size(max = 250)
    @Column(name = "Description")
    private String description;

    public String getLeaveRuleID() {
        return leaveRuleID;
    }

    public void setLeaveRuleID(String leaveRuleID) {
        this.leaveRuleID = leaveRuleID;
    }

    public String getLeavePolicyID() {
        return leavePolicyID;
    }

    public void setLeavePolicyID(String leavePolicyID) {
        this.leavePolicyID = leavePolicyID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
