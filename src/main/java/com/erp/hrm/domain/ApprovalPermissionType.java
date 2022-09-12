package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "ApprovalPermissionType", uniqueConstraints = { @UniqueConstraint( columnNames = { "PermissionType" } ) } )
public class ApprovalPermissionType extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "PermissionType")
    private String permissionType;

    @Column(name = "IsActive",nullable = false,columnDefinition = "BIT CONSTRAINT DF_ApprovalPermissionType_IsActive DEFAULT 0")
    private boolean isActive;

    @OneToOne(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private MenuPermission menuPermission;

    @OneToOne(mappedBy = "approvalPermissionType", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private ApprovalNodeHierarchy approvalNodeHierarchy;

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public ApprovalNodeHierarchy getApprovalNodeHierarchy() {
        return approvalNodeHierarchy;
    }

    public void setApprovalNodeHierarchy(ApprovalNodeHierarchy approvalNodeHierarchy) {
        this.approvalNodeHierarchy = approvalNodeHierarchy;
    }
}
