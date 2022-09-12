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
@Table( name = "ReportFiltersDDL", uniqueConstraints = { @UniqueConstraint( name="UK_ReportFiltersDDL",columnNames = { "dropDownName","reportId" } ) } )
public class ReportFiltersDDL extends BaseEntity {

    @Size(max = 32)
    @Column(name = "DropDownName",nullable = false)
    private String dropDownName;

    @Column(name = "ReportId",nullable = false)
    private long reportId;

    @NotNull
    @Column(name = "IsActive",nullable = false, columnDefinition = "BIT CONSTRAINT DF_ReportFilterDDL_IsActive DEFAULT 0")
    private boolean isActive;

    public String getDropDownName() {
        return dropDownName;
    }

    public void setDropDownName(String dropDownName) {
        this.dropDownName = dropDownName;
    }

    public long getReportId() {
        return reportId;
    }

    public void setReportId(long reportId) {
        this.reportId = reportId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
