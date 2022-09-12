package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "ApprovalNodeHierarchy", uniqueConstraints = { @UniqueConstraint( columnNames = { "PermissionTypeId","NodeName" } ) } )
public class ApprovalNodeHierarchy extends BaseIntEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "PermissionTypeId", columnDefinition="INT", foreignKey = @ForeignKey(name = "FK_ApprovalNodeHierarchy_ApprovalNodeHierarchy"), nullable = false)
    private ApprovalPermissionType approvalPermissionType;

    @Size(max = 64)
    @NotNull
    @Column(name = "NodeName",nullable = false)
    private String nodeName;

    @Column(name = "ApprovalStatus")
    private int approvalStatus;

    @Size(max = 100)
    @Column(name = "ApprovedStatusLabel")
    private String approvedStatusLabel;

    @Size(max = 100)
    @Column(name = "RejectedStatusLabel")
    private String rejectedStatusLabel;

    @Size(max = 256)
    @Column(name = "Notes")
    private String notes;

    @OneToOne(mappedBy = "approvalNodeHierarchy", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private ApprovalAssignUserRole approvalAssignUserRole;


    public ApprovalPermissionType getApprovalPermissionType() {
        return approvalPermissionType;
    }

    public void setApprovalPermissionType(ApprovalPermissionType approvalPermissionType) {
        this.approvalPermissionType = approvalPermissionType;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public int getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(int approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getApprovedStatusLabel() {
        return approvedStatusLabel;
    }

    public void setApprovedStatusLabel(String approvedStatusLabel) {
        this.approvedStatusLabel = approvedStatusLabel;
    }

    public String getRejectedStatusLabel() {
        return rejectedStatusLabel;
    }

    public void setRejectedStatusLabel(String rejectedStatusLabel) {
        this.rejectedStatusLabel = rejectedStatusLabel;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public ApprovalAssignUserRole getApprovalAssignUserRole() {
        return approvalAssignUserRole;
    }

    public void setApprovalAssignUserRole(ApprovalAssignUserRole approvalAssignUserRole) {
        this.approvalAssignUserRole = approvalAssignUserRole;
    }
}
