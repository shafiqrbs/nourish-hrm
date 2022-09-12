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
@Table( name = "AllSelectedReportColumns" )
public class AllSelectedReportColumns extends BaseEntity {

    @Column(name = "ColumnId",nullable = false)
    private long columnId;

    @Column(name = "UserId",nullable = false)
    private String userId;

    @NotNull
    @Column(name = "IsActive",nullable = false, columnDefinition = "BIT CONSTRAINT DF_AllSelectedReportColumns_IsActive DEFAULT 0")
    private boolean isActive;

    public long getColumnId() {
        return columnId;
    }

    public void setColumnId(long columnId) {
        this.columnId = columnId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
