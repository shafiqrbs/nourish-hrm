package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "ApprovalAssignUserRole", uniqueConstraints = { @UniqueConstraint( columnNames = { "ApprovalNodeId","UserRole" } ) } )
public class ApprovalAssignUserRole extends BaseIntEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "ApprovalNodeId", columnDefinition="INT", foreignKey = @ForeignKey(name = "FK_ApprovalAssignUserRole_ApprovalNodeHierarchy"), nullable = false)
    private ApprovalNodeHierarchy approvalNodeHierarchy;

    @Size(max = 50)
    @NotNull
    @Column(name = "UserRole",nullable = false)
    private String userRole;

    public ApprovalNodeHierarchy getApprovalNodeHierarchy() {
        return approvalNodeHierarchy;
    }

    public void setApprovalNodeHierarchy(ApprovalNodeHierarchy approvalNodeHierarchy) {
        this.approvalNodeHierarchy = approvalNodeHierarchy;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }
}
