package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by WS on 05/06/2018.
 */
@Entity
@Table( name = "CompanyWorkOffCalendar", uniqueConstraints = { @UniqueConstraint( name ="UK_CompanyWorkOffCalendar",columnNames = { "CompanyWorkOffdate","ShiftID","HKEntryID" } ) } )

public class CompanyWorkOffCalendar extends BaseEntity {

    @Column(name = "CompanyWorkOffdate", nullable = false)
    private Date CompanyWorkOffdate;

    @Size(max = 20)
    @Column(name = "ShiftID",nullable = false)
    private String ShiftID;

    @Size(max = 50)
    @Column(name = "ShiftType")
    private String ShiftType;

    @Size(max = 10)
    @Column(name = "DayType")
    private String DayType;

    @Column(name = "HKEntryID",nullable = false)
    private int HKEntryID;

    @Column(name = "IsConsiderLate")
    private boolean IsConsiderLate;

    @Column(name = "IsBreakTimeConsider")
    private boolean IsBreakTimeConsider;

    @Column(name = "MinPayHour",nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private BigDecimal MinPayHour;

    public Date getCompanyWorkOffdate() {
        return CompanyWorkOffdate;
    }

    public void setCompanyWorkOffdate(Date companyWorkOffdate) {
        CompanyWorkOffdate = companyWorkOffdate;
    }

    public String getShiftID() {
        return ShiftID;
    }

    public void setShiftID(String shiftID) {
        ShiftID = shiftID;
    }

    public String getShiftType() {
        return ShiftType;
    }

    public void setShiftType(String shiftType) {
        ShiftType = shiftType;
    }

    public String getDayType() {
        return DayType;
    }

    public void setDayType(String dayType) {
        DayType = dayType;
    }

    public int getHKEntryID() {
        return HKEntryID;
    }

    public void setHKEntryID(int HKEntryID) {
        this.HKEntryID = HKEntryID;
    }

    public boolean isConsiderLate() {
        return IsConsiderLate;
    }

    public void setConsiderLate(boolean considerLate) {
        IsConsiderLate = considerLate;
    }

    public boolean isBreakTimeConsider() {
        return IsBreakTimeConsider;
    }

    public void setBreakTimeConsider(boolean breakTimeConsider) {
        IsBreakTimeConsider = breakTimeConsider;
    }

    public BigDecimal getMinPayHour() {
        return MinPayHour;
    }

    public void setMinPayHour(BigDecimal minPayHour) {
        MinPayHour = minPayHour;
    }
}
