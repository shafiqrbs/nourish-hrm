package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by WS on 05/06/2018.
 */
@Entity
@Table( name = "ShiftPlan" )
public class ShiftPlan extends BaseByOnEntity {

    @Id
    @Size(max = 20)
    @Column(name = "ShiftID",nullable = false)
    private String shiftID;

    @Size(max = 20)
    @Column(name = "ShiftType",nullable = false)
    private String shiftType;

    @Size(max = 50)
    @Column(name = "Alais",nullable = false)
    private String alias;

    @Size(max = 50)
    @Column(name = "Descriptions",nullable = false)
    private String descriptions;

    @Column(name = "IsDefaultPlan",nullable = false)
    private boolean isDefaultPlan;

    @Column(name = "IsActive",nullable = false)
    private boolean isActive;

    @Column(name = "RoundAfter",nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private BigDecimal roundAfter;

    @Column(name = "RoundFor",nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private BigDecimal roundFor;

    @Column(name = "MorningOTRoundAfter",nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private BigDecimal morningOTRoundAfter;

    @Column(name = "MorningOTRoundFor",nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private BigDecimal morningOTRoundFor;

    @Column(name = "IgnoreMonringOTInWeekend",nullable = false,columnDefinition = "BIT  CONSTRAINT DF_ShiftPlan_IgnoreMonringOTInWeekend DEFAULT 0")
    private boolean ignoreMonringOTInWeekend;

    @Column(name = "IgnoreMonringOTInHoliday",nullable = false,columnDefinition = "BIT  CONSTRAINT DF_ShiftPlan_IgnoreMonringOTInHoliday DEFAULT 0")
    private boolean ignoreMonringOTInHoliday;

    @Column(name = "InTime", columnDefinition = "VARCHAR(16)")
    private String inTime;

    @Column(name = "InTimeStartMargin", columnDefinition = "VARCHAR(16)")
    private String inTimeStartMargin;

    @Column(name = "OutTime", columnDefinition = "VARCHAR(16)")
    private String outTime;

    @Column(name = "OutTimeEndMargin", columnDefinition = "VARCHAR(16)")
    private String outTimeEndMargin;

    @Column(name = "LunchOutTime", columnDefinition = "VARCHAR(16)")
    private String lunchOutTime;

    @Column(name = "LunchInTime", columnDefinition = "VARCHAR(16)")
    private String lunchInTime;

    @Column(name = "LunchInEndMargin", columnDefinition = "VARCHAR(16)")
    private String lunchInEndMargin;

    @Column(name = "LunchPeriod", columnDefinition = "VARCHAR(16)")
    private String lunchPeriod;

    @Column(name = "AbsentEndMargin")
    private String absentEndMargin;

    @Column(name = "WorkingHour",nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private BigDecimal workingHour;

    @Column(name = "LateMargin",nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private BigDecimal lateMargin;

    @Column(name = "EarlyOutMargin",nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private BigDecimal earlyOutMargin;

    @Column(name = "SpecialLateMargin",nullable = false, columnDefinition = "NUMERIC(18, 4)")
    private BigDecimal specialLateMargin;

    @Column(name = "InputAs")
    private String inputAs;

    @Column(name = "ProcessCheck", columnDefinition = "BIT  CONSTRAINT DF_ShiftPlan_ProcessCheck DEFAULT 0")
    private boolean processCheck;

    @Column(name = "EarlyOutAbsentMargin",nullable = false, columnDefinition = "NUMERIC(18, 4) CONSTRAINT DF_ShiftPlan_EarlyOutAbsentMargin DEFAULT ((0))")
    private BigDecimal earlyOutAbsentMargin;

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(String shiftType) {
        this.shiftType = shiftType;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isDefaultPlan() {
        return isDefaultPlan;
    }

    public void setDefaultPlan(boolean defaultPlan) {
        isDefaultPlan = defaultPlan;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public BigDecimal getRoundAfter() {
        return roundAfter;
    }

    public void setRoundAfter(BigDecimal roundAfter) {
        this.roundAfter = roundAfter;
    }

    public BigDecimal getRoundFor() {
        return roundFor;
    }

    public void setRoundFor(BigDecimal roundFor) {
        this.roundFor = roundFor;
    }

    public BigDecimal getMorningOTRoundAfter() {
        return morningOTRoundAfter;
    }

    public void setMorningOTRoundAfter(BigDecimal morningOTRoundAfter) {
        this.morningOTRoundAfter = morningOTRoundAfter;
    }

    public BigDecimal getMorningOTRoundFor() {
        return morningOTRoundFor;
    }

    public void setMorningOTRoundFor(BigDecimal morningOTRoundFor) {
        this.morningOTRoundFor = morningOTRoundFor;
    }

    public boolean isIgnoreMonringOTInWeekend() {
        return ignoreMonringOTInWeekend;
    }

    public void setIgnoreMonringOTInWeekend(boolean ignoreMonringOTInWeekend) {
        this.ignoreMonringOTInWeekend = ignoreMonringOTInWeekend;
    }

    public boolean isIgnoreMonringOTInHoliday() {
        return ignoreMonringOTInHoliday;
    }

    public void setIgnoreMonringOTInHoliday(boolean ignoreMonringOTInHoliday) {
        this.ignoreMonringOTInHoliday = ignoreMonringOTInHoliday;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getInTimeStartMargin() {
        return inTimeStartMargin;
    }

    public void setInTimeStartMargin(String inTimeStartMargin) {
        this.inTimeStartMargin = inTimeStartMargin;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getOutTimeEndMargin() {
        return outTimeEndMargin;
    }

    public void setOutTimeEndMargin(String outTimeEndMargin) {
        this.outTimeEndMargin = outTimeEndMargin;
    }

    public String getLunchOutTime() {
        return lunchOutTime;
    }

    public void setLunchOutTime(String lunchOutTime) {
        this.lunchOutTime = lunchOutTime;
    }

    public String getLunchInTime() {
        return lunchInTime;
    }

    public void setLunchInTime(String lunchInTime) {
        this.lunchInTime = lunchInTime;
    }

    public String getLunchInEndMargin() {
        return lunchInEndMargin;
    }

    public void setLunchInEndMargin(String lunchInEndMargin) {
        this.lunchInEndMargin = lunchInEndMargin;
    }

    public String getLunchPeriod() {
        return lunchPeriod;
    }

    public void setLunchPeriod(String lunchPeriod) {
        this.lunchPeriod = lunchPeriod;
    }

    public String getAbsentEndMargin() {
        return absentEndMargin;
    }

    public void setAbsentEndMargin(String absentEndMargin) {
        this.absentEndMargin = absentEndMargin;
    }

    public BigDecimal getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(BigDecimal workingHour) {
        this.workingHour = workingHour;
    }

    public BigDecimal getLateMargin() {
        return lateMargin;
    }

    public void setLateMargin(BigDecimal lateMargin) {
        this.lateMargin = lateMargin;
    }

    public BigDecimal getEarlyOutMargin() {
        return earlyOutMargin;
    }

    public void setEarlyOutMargin(BigDecimal earlyOutMargin) {
        this.earlyOutMargin = earlyOutMargin;
    }

    public BigDecimal getSpecialLateMargin() {
        return specialLateMargin;
    }

    public void setSpecialLateMargin(BigDecimal specialLateMargin) {
        this.specialLateMargin = specialLateMargin;
    }

    public String getInputAs() {
        return inputAs;
    }

    public void setInputAs(String inputAs) {
        this.inputAs = inputAs;
    }

    public boolean isProcessCheck() {
        return processCheck;
    }

    public void setProcessCheck(boolean processCheck) {
        this.processCheck = processCheck;
    }

    public BigDecimal getEarlyOutAbsentMargin() {
        return earlyOutAbsentMargin;
    }

    public void setEarlyOutAbsentMargin(BigDecimal earlyOutAbsentMargin) {
        this.earlyOutAbsentMargin = earlyOutAbsentMargin;
    }
}
