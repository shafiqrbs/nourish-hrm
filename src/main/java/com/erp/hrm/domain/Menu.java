package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "Menu", uniqueConstraints = { @UniqueConstraint( columnNames = { "MenuKey" } ) } )
public class Menu extends BaseIntEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "MenuName",nullable = false)
    private String menuName;

    @Size(max = 50)
    @NotNull
    @Column(name = "MenuKey",nullable = false)
    private String menuKey;

    @Size(max = 50)
    @NotNull
    @Column(name = "DisplayLabel",nullable = false)
    private String displayLabel;

    @Size(max = 256)
    @NotNull
    @Column(name = "MenuURL",nullable = false)
    private String menuURL;

    @Column(name = "IsActive",nullable = false,columnDefinition = "BIT CONSTRAINT DF_Menu_IsActive DEFAULT 0")
    private boolean isActive;

    @Size(max = 256)
    @Column(name = "Descriptions")
    private String descriptions;

    @Column(name = "SequenceNo",nullable = false)
    private Integer sequenceNo;

    @Column(name = "IsLinkable",nullable = false,columnDefinition = "BIT CONSTRAINT DF_Menu_IsLinkable DEFAULT 0")
    private boolean isLinkable;

    @Column(name = "IsParent",nullable = false,columnDefinition = "BIT CONSTRAINT DF_Menu_IsParent DEFAULT 0")
    private boolean isParent;

    @Column(name = "IsRoot",nullable = false,columnDefinition = "BIT CONSTRAINT DF_Menu_IsRoot DEFAULT 0")
    private boolean isRoot;

    @Column(name = "ParentId",nullable = false)
    private Integer parentId;

    @OneToOne(mappedBy = "menu", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private MenuPermission menuPermission;

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey;
    }

    public String getDisplayLabel() {
        return displayLabel;
    }

    public void setDisplayLabel(String displayLabel) {
        this.displayLabel = displayLabel;
    }

    public String getMenuURL() {
        return menuURL;
    }

    public void setMenuURL(String menuURL) {
        this.menuURL = menuURL;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public Integer getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(Integer sequenceNo) {
        this.sequenceNo = sequenceNo;
    }

    public boolean isLinkable() {
        return isLinkable;
    }

    public void setLinkable(boolean linkable) {
        isLinkable = linkable;
    }

    public boolean isParent() {
        return isParent;
    }

    public void setParent(boolean parent) {
        isParent = parent;
    }

    public boolean isRoot() {
        return isRoot;
    }

    public void setRoot(boolean root) {
        isRoot = root;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public MenuPermission getMenuPermission() {
        return menuPermission;
    }

    public void setMenuPermission(MenuPermission menuPermission) {
        this.menuPermission = menuPermission;
    }
}
