package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "UserRole", uniqueConstraints = { @UniqueConstraint( columnNames = { "UserRoleName" } ) } )
public class UserRole extends BaseEntity {

    private static final long serialVersionUID = 1L;

	@Size(max = 50)
    @NotNull
    @Column(name = "UserRoleName")
    private String userRoleName;

    @Size(max = 256)
    @Column(name = "Notes")
    private String notes;

    @Column(name = "IsActive",nullable = false,columnDefinition = "BIT  CONSTRAINT DF_UserRole_IsActive DEFAULT 0")
    private boolean isActive;

    public UserRole() {
		super();
	}
    

	public UserRole(String userRoleName, String notes, boolean isActive) {
//		super();
//		this.setId(getId());
		this.userRoleName = userRoleName;
		this.notes = notes;
		this.isActive = isActive;
	}



	public String getUserRoleName() {
        return userRoleName;
    }

    public void setUserRoleName(String userRoleName) {
        this.userRoleName = userRoleName;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
