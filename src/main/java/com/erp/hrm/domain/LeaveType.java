package com.erp.hrm.domain;

import org.hibernate.type.descriptor.sql.TinyIntTypeDescriptor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveType", uniqueConstraints = { @UniqueConstraint( name = "UK_LeaveType",columnNames = { "LeaveTypeID","LeaveRuleID"} ) })
public class LeaveType extends BaseEntity {

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveTypeID")
    private String LeaveTypeID;

    @Size(max = 10)
    @NotNull
    @Column(name = "LeaveRuleID")
    private String LeaveRuleID;

    @Size(max = 50)
    @Column(name = "Alias")
    private String Alias;

    @Size(max = 50)
    @Column(name = "Description")
    private String Description;

    @Column(name = "NoOfDays")
    private int NoOfDays;

    @Column(name = "MaxConsecutiveDays")
    private int MaxConsecutiveDays;

    @Column(name = "FixedDays")
    private byte FixedDays;

    @Column(name = "CanCarryForward")
    private byte CanCarryForward;

    @Column(name = "MaxDaysToCarryForward")
    private int MaxDaysToCarryForward;

    @Column(name = "MaxDaysAfterCarry")
    private int MaxDaysAfterCarry;

    @Size(max = 5)
    @Column(name = "AvailFrom")
    private String AvailFrom;

    @Size(max = 5)
    @Column(name = "BasedOn")
    private String BasedOn;

    @Column(name = "CLY", columnDefinition = "NUMERIC(10, 2)")
    private BigDecimal CLY;

    @Size(max = 5)
    @Column(name = "AvailingCriteria")
    private String AvailingCriteria;

    @Size(max = 5)
    @Column(name = "CalendarType")
    private String CalendarType;

    @NotNull
    @Column(name = "AvailYear",columnDefinition = "NUMERIC(10, 2) CONSTRAINT DF_LeaveType_AvailYear DEFAULT 0")
    private BigDecimal AvailYear;

    @Column(name = "CarryCriteria")
    private byte CarryCriteria;

    @NotNull
    @Column(name = "LVDependson", nullable = false, columnDefinition = " BIT CONSTRAINT DF_LeaveType_LVDependson  DEFAULT 0")
    private boolean LVDependson;

    @NotNull
    @Column(name = "DependsOnSL", nullable = false, columnDefinition = " BIT CONSTRAINT DF_LeaveType_DependsOnSL DEFAULT 0")
    private boolean DependsOnSL;

    @NotNull
    @Column(name = "AdvanceLeave", nullable = false, columnDefinition = " BIT CONSTRAINT DF_LeaveType_AdvanceLeave DEFAULT 0")
    private boolean AdvanceLeave;

    @NotNull
    @Column(name = "IsAlways", nullable = false, columnDefinition = " BIT CONSTRAINT DF_LeaveType_IsAlways  DEFAULT 0")
    private boolean IsAlways;

    @NotNull
    @Column(name = "DeductAdvanceLeave", nullable = false, columnDefinition = " BIT CONSTRAINT DF_LeaveType_DeductAdvanceLeave DEFAULT 0")
    private boolean DeductAdvanceLeave;

    public String getLeaveTypeID() {
        return LeaveTypeID;
    }

    public void setLeaveTypeID(String LeaveTypeID) {
        this.LeaveTypeID = LeaveTypeID;
    }

    public String getLeaveRuleID() {
        return LeaveRuleID;
    }

    public void setLeaveRuleID(String LeaveRuleID) {
        this.LeaveRuleID = LeaveRuleID;
    }

    public String getAlias() {
        return Alias;
    }

    public void setAlias(String Alias) {
        this.Alias = Alias;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public int getNoOfDays() {
        return NoOfDays;
    }

    public void setNoOfDays(int NoOfDays) {
        this.NoOfDays = NoOfDays;
    }

    public int getMaxConsecutiveDays() {
        return MaxConsecutiveDays;
    }

    public void setMaxConsecutiveDays(int MaxConsecutiveDays) {
        this.MaxConsecutiveDays = MaxConsecutiveDays;
    }

    public byte getFixedDays() {
        return FixedDays;
    }

    public void setFixedDays(byte FixedDays) {
        this.FixedDays = FixedDays;
    }

    public byte getCanCarryForward() {
        return CanCarryForward;
    }

    public void setCanCarryForward(byte CanCarryForward) {
        this.CanCarryForward = CanCarryForward;
    }

    public int getMaxDaysToCarryForward() {
        return MaxDaysToCarryForward;
    }

    public void setMaxDaysToCarryForward(int MaxDaysToCarryForward) {
        this.MaxDaysToCarryForward = MaxDaysToCarryForward;
    }

    public int getMaxDaysAfterCarry() {
        return MaxDaysAfterCarry;
    }

    public void setMaxDaysAfterCarry(int MaxDaysAfterCarry) {
        this.MaxDaysAfterCarry = MaxDaysAfterCarry;
    }

    public String getAvailFrom() {
        return AvailFrom;
    }

    public void setAvailFrom(String AvailFrom) {
        this.AvailFrom = AvailFrom;
    }

    public String getBasedOn() {
        return BasedOn;
    }

    public void setBasedOn(String BasedOn) {
        this.BasedOn = BasedOn;
    }

    public BigDecimal getCLY() {
        return CLY;
    }

    public void setCLY(BigDecimal CLY) {
        this.CLY = CLY;
    }

    public String getAvailingCriteria() {
        return AvailingCriteria;
    }

    public void setAvailingCriteria(String AvailingCriteria) {
        this.AvailingCriteria = AvailingCriteria;
    }

    public String getCalendarType() {
        return CalendarType;
    }

    public void setCalendarType(String CalendarType) {
        this.CalendarType = CalendarType;
    }

    public BigDecimal getAvailYear() {
        return AvailYear;
    }

    public void setAvailYear(BigDecimal AvailYear) {
        this.AvailYear = AvailYear;
    }

    public byte getCarryCriteria() {
        return CarryCriteria;
    }

    public void setCarryCriteria(byte CarryCriteria) {
        this.CarryCriteria = CarryCriteria;
    }

    public boolean getLVDependson() {
        return LVDependson;
    }

    public void setLVDependson(boolean LVDependson) {
        this.LVDependson = LVDependson;
    }

    public boolean getDependsOnSL() {
        return DependsOnSL;
    }

    public void setDependsOnSL(boolean DependsOnSL) {
        this.DependsOnSL = DependsOnSL;
    }

    public boolean getAdvanceLeave() {
        return AdvanceLeave;
    }

    public void setAdvanceLeave(boolean AdvanceLeave) {
        this.AdvanceLeave = AdvanceLeave;
    }

    public boolean getIsAlways() {
        return IsAlways;
    }

    public void setIsAlways(boolean IsAlways) {
        this.IsAlways = IsAlways;
    }

    public boolean getDeductAdvanceLeave() {
        return DeductAdvanceLeave;
    }

    public void setDeductAdvanceLeave(boolean DeductAdvanceLeave) {
        this.DeductAdvanceLeave = DeductAdvanceLeave;
    }
}
