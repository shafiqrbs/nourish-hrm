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
@Table( name = "AllAvailableReportColumns" )
public class AllAvailableReportColumns extends BaseEntity {

    @Size(max = 32)
    @Column(name = "ColumnName",nullable = false)
    private String columnName;

    @Column(name = "ReportId",nullable = false)
    private long reportId;

    @NotNull
    @Column(name = "IsActive",nullable = false, columnDefinition = "BIT CONSTRAINT DF_AllAvailableReportColumns_IsActive DEFAULT 0")
    private boolean isActive;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
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
