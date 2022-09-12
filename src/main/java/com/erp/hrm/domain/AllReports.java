package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "AllReports", uniqueConstraints = { @UniqueConstraint( name="UK_AllReports",columnNames = { "ModuleName","subModuleName","ReportName" } ) } )
public class AllReports extends BaseEntity {

    @Size(max = 64)
    @Column(name = "ModuleName",nullable = false)
    private String moduleName;

    @Size(max = 64)
    @Column(name = "SubModuleName",nullable = false)
    private String subModuleName;

    @Size(max = 64)
    @Column(name = "ReportName",nullable = false)
    private String reportName;

    @Size(max = 64)
    @Column(name = "ReportLabel")
    private String reportLabel;

    @Size(max = 256)
    @Column(name = "TemplateName",nullable = false)
    private String templateName;

    @Size(max = 64)
    @Column(name = "MenuIcon")
    private String menuIcon;

    @Size(max = 64)
    @Column(name = "ItemIcon")
    private String itemIcon;

    @Column(name = "CompanyId")
    private int companyId;

    @NotNull
    @Column(name = "IsActive",nullable = false, columnDefinition = "BIT CONSTRAINT DF_AllReports_IsActive DEFAULT 0")
    private boolean isActive;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public String getReportLabel() {
        return reportLabel;
    }

    public void setReportLabel(String reportLabel) {
        this.reportLabel = reportLabel;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getMenuIcon() {
        return menuIcon;
    }

    public void setMenuIcon(String menuIcon) {
        this.menuIcon = menuIcon;
    }

    public String getItemIcon() {
        return itemIcon;
    }

    public void setItemIcon(String itemIcon) {
        this.itemIcon = itemIcon;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
