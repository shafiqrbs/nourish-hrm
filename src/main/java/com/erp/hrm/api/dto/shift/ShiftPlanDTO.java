package com.erp.hrm.api.dto.shift;

import java.math.BigDecimal;

public class ShiftPlanDTO {

    private String shiftID;
    private String shiftType;
    private String alais;
    private String descriptions;
    private boolean Default;
    private boolean active;

    private BigDecimal roundAfter;
    private BigDecimal roundFor;
    private BigDecimal morningOTRoundAfter;
    private BigDecimal morningOTRoundFor;
    private boolean ignoreMorningOTInWeekend;
    private boolean ignoreMorningOTInHoliday;

    private String inTime;
    private String inTimeStartMargin;

    private String absentEndMargin;
    private String outTime;
    private String outTimeEndMargin;

    private  String breakOutTime;
    private  String breakInTime;
    private  String breakInEndMargin;
    private  String breakPeriod;

    private BigDecimal workingHour;
    private BigDecimal lateMargin;
    private BigDecimal earlyOutMargin;
    private BigDecimal specialLateMargin;
    private BigDecimal earlyOutAbsentEndMargin;
    private boolean processInSameDay;


    public ShiftPlanDTO() {
    }

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

    public String getAlais() {
        return alais;
    }

    public void setAlais(String alais) {
        this.alais = alais;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public boolean isDefault() {
        return Default;
    }

    public void setDefault(boolean aDefault) {
        Default = aDefault;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

    public boolean isIgnoreMorningOTInWeekend() {
        return ignoreMorningOTInWeekend;
    }

    public void setIgnoreMorningOTInWeekend(boolean ignoreMorningOTInWeekend) {
        this.ignoreMorningOTInWeekend = ignoreMorningOTInWeekend;
    }

    public boolean isIgnoreMorningOTInHoliday() {
        return ignoreMorningOTInHoliday;
    }

    public void setIgnoreMorningOTInHoliday(boolean ignoreMorningOTInHoliday) {
        this.ignoreMorningOTInHoliday = ignoreMorningOTInHoliday;
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

    public String getAbsentEndMargin() {
        return absentEndMargin;
    }

    public void setAbsentEndMargin(String absentEndMargin) {
        this.absentEndMargin = absentEndMargin;
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

    public String getBreakOutTime() {
        return breakOutTime;
    }

    public void setBreakOutTime(String breakOutTime) {
        this.breakOutTime = breakOutTime;
    }

    public String getBreakInTime() {
        return breakInTime;
    }

    public void setBreakInTime(String breakInTime) {
        this.breakInTime = breakInTime;
    }

    public String getBreakInEndMargin() {
        return breakInEndMargin;
    }

    public void setBreakInEndMargin(String breakInEndMargin) {
        this.breakInEndMargin = breakInEndMargin;
    }

    public String getBreakPeriod() {
        return breakPeriod;
    }

    public void setBreakPeriod(String breakPeriod) {
        this.breakPeriod = breakPeriod;
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

    public BigDecimal getEarlyOutAbsentEndMargin() {
        return earlyOutAbsentEndMargin;
    }

    public void setEarlyOutAbsentEndMargin(BigDecimal earlyOutAbsentEndMargin) {
        this.earlyOutAbsentEndMargin = earlyOutAbsentEndMargin;
    }

    public boolean isProcessInSameDay() {
        return processInSameDay;
    }

    public void setProcessInSameDay(boolean processInSameDay) {
        this.processInSameDay = processInSameDay;
    }
}
