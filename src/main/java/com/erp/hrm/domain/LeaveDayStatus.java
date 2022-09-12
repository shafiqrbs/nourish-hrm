package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveDayStatus" )
public class LeaveDayStatus extends BaseEntity {

    @Size(max = 15)
    @NotNull
    @Column(name = "DayStatus")
    private String DayStatus;

    @Size(max = 50)
    @Column(name = "DayStatusDesc")
    private String DayStatusDesc;

    public String getDayStatus() {
        return DayStatus;
    }

    public void setDayStatus(String DayStatus) {
        this.DayStatus = DayStatus;
    }

    public String getDayStatusDesc() {
        return DayStatusDesc;
    }

    public void setDayStatusDesc(String DayStatusDesc) {
        this.DayStatusDesc = DayStatusDesc;
    }
}
