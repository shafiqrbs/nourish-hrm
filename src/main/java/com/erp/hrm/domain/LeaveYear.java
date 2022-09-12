package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveYear")
public class LeaveYear extends BaseEntity {

    @NotNull
    @Column(name = "FromDate",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date fromDate;

    @NotNull
    @Column(name = "ToDate",nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date toDate;

    @Column(name = "IsActive")
    private boolean isActive;

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
