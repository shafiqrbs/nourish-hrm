package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "MenuPermission", uniqueConstraints = { @UniqueConstraint( columnNames = { "MenuId","UserRole" } ) } )
public class MenuPermission extends BaseIntEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "MenuId", columnDefinition="INT", foreignKey = @ForeignKey(name = "FK_Menu_MenuPermission"), nullable = false)
    private Menu menu;

    @Size(max = 50)
    @NotNull
    @Column(name = "UserRole",nullable = false)
    private String userRole;

    @Column(name = "IsView",nullable = false,columnDefinition = "BIT  CONSTRAINT DF_MenuPermission_IsView DEFAULT 0")
    private boolean isView;

    @Column(name = "IsCreate",nullable = false,columnDefinition = "BIT  CONSTRAINT DF_MenuPermission_IsCreate DEFAULT 0")
    private boolean isCreate;

    @Column(name = "IsEdit",nullable = false,columnDefinition = "BIT  CONSTRAINT DF_MenuPermission_IsEdit DEFAULT 0")
    private boolean isEdit;

    @Column(name = "IsDelete",nullable = false,columnDefinition = "BIT  CONSTRAINT DF_MenuPermission_IsDelete DEFAULT 0")
    private boolean isDelete;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public boolean isView() {
        return isView;
    }

    public void setView(boolean view) {
        isView = view;
    }

    public boolean isCreate() {
        return isCreate;
    }

    public void setCreate(boolean create) {
        isCreate = create;
    }

    public boolean isEdit() {
        return isEdit;
    }

    public void setEdit(boolean edit) {
        isEdit = edit;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }
}
