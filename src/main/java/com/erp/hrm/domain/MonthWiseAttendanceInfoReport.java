package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table( name = "MonthWiseAttendanceInfoReport", uniqueConstraints = { @UniqueConstraint( name="UK_MonthWiseAttendanceInfo",columnNames = { "EmployeeCode", "MonthNo", "YearNo" } ) } )
public class MonthWiseAttendanceInfoReport extends BaseEntity  {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode",nullable = false)
    private String employeeCode;

    @Column(name = "AbsentDay")
    private double absentDay;

    @Column(name = "ORGAbsentDay")
    private double orgAbsentDay;

    @Column(name = "PresentDay")
    private double presentDay;

    @Column(name = "LateDay")
    private double lateDay;

    @Column(name = "ORGWorkOff")
    private double orgWorkOff;

    @Column(name = "ORGCOff")
    private double orgcOff;

    @Column(name = "ORGHoliDay")
    private double orgHoliDay;

    @Column(name = "WorkOff")
    private double workOff;

    @Column(name = "HoliDay")
    private double holiDay;

    @Column(name = "PHoliDay")
    private double pHoliDay;

    @Column(name = "OTMinute")
    private double otMinute;

    @Column(name = "PWorkOff")
    private double pWorkOff;

    @Column(name = "LHoliDay")
    private double lHoliDay;

    @Column(name = "LWorkOff")
    private double lWorkOff;

    @Column(name = "PLeave")
    private double pLeave;

    @Column(name = "Leave")
    private double leave;

    @Column(name = "LWP")
    private double lwp;

    @Column(name = "MLV")
    private double mlv;

    @Column(name = "CalculatedAbsent")
    private double calculatedAbsent;

    @Column(name = "CL")
    private double cl;

    @Column(name = "SL")
    private double sl;

    @Column(name = "EL")
    private double el;

    @Column(name = "SPL")
    private double spl;

    @Column(name = "WorkingDay")
    private double workingDay;

    @Column(name = "HWDay")
    private double hwDay;

    @Column(name = "ORGLate")
    private double orgLate;

    @Column(name = "undefinedDay")
    private double undefinedDay;

    @Column(name = "Slab1")
    private double slab1;

    @Column(name = "Slab2")
    private double slab2;

    @Column(name = "Slab3")
    private double slab3;

    @Column(name = "OT")
    private double ot;

    @Column(name = "EOT")
    private double eot;

    @Column(name = "OOT")
    private double oot;

    @Column(name = "OEOT")
    private double oeot;

    @Column(name = "OTRate")
    private double otRate;

    @Column(name = "EOTRate")
    private double eotRate;

    @Column(name = "OOTRate")
    private double ootRate;

    @Column(name = "OEOTRate")
    private double oeotRate;

    @NotNull
    @Column(name = "MonthNo")
    private int monthNo;

    @NotNull
    @Column(name = "YearNo")
    private int yearNo;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public double getAbsentDay() {
        return absentDay;
    }

    public void setAbsentDay(double absentDay) {
        this.absentDay = absentDay;
    }

    public double getOrgAbsentDay() {
        return orgAbsentDay;
    }

    public void setOrgAbsentDay(double orgAbsentDay) {
        this.orgAbsentDay = orgAbsentDay;
    }

    public double getPresentDay() {
        return presentDay;
    }

    public void setPresentDay(double presentDay) {
        this.presentDay = presentDay;
    }

    public double getLateDay() {
        return lateDay;
    }

    public void setLateDay(double lateDay) {
        this.lateDay = lateDay;
    }

    public double getOrgWorkOff() {
        return orgWorkOff;
    }

    public void setOrgWorkOff(double orgWorkOff) {
        this.orgWorkOff = orgWorkOff;
    }

    public double getOrgcOff() {
        return orgcOff;
    }

    public void setOrgcOff(double orgcOff) {
        this.orgcOff = orgcOff;
    }

    public double getOrgHoliDay() {
        return orgHoliDay;
    }

    public void setOrgHoliDay(double orgHoliDay) {
        this.orgHoliDay = orgHoliDay;
    }

    public double getWorkOff() {
        return workOff;
    }

    public void setWorkOff(double workOff) {
        this.workOff = workOff;
    }

    public double getHoliDay() {
        return holiDay;
    }

    public void setHoliDay(double holiDay) {
        this.holiDay = holiDay;
    }

    public double getpHoliDay() {
        return pHoliDay;
    }

    public void setpHoliDay(double pHoliDay) {
        this.pHoliDay = pHoliDay;
    }

    public double getOtMinute() {
        return otMinute;
    }

    public void setOtMinute(double otMinute) {
        this.otMinute = otMinute;
    }

    public double getpWorkOff() {
        return pWorkOff;
    }

    public void setpWorkOff(double pWorkOff) {
        this.pWorkOff = pWorkOff;
    }

    public double getlHoliDay() {
        return lHoliDay;
    }

    public void setlHoliDay(double lHoliDay) {
        this.lHoliDay = lHoliDay;
    }

    public double getlWorkOff() {
        return lWorkOff;
    }

    public void setlWorkOff(double lWorkOff) {
        this.lWorkOff = lWorkOff;
    }

    public double getpLeave() {
        return pLeave;
    }

    public void setpLeave(double pLeave) {
        this.pLeave = pLeave;
    }

    public double getLeave() {
        return leave;
    }

    public void setLeave(double leave) {
        this.leave = leave;
    }

    public double getLwp() {
        return lwp;
    }

    public void setLwp(double lwp) {
        this.lwp = lwp;
    }

    public double getMlv() {
        return mlv;
    }

    public void setMlv(double mlv) {
        this.mlv = mlv;
    }

    public double getCalculatedAbsent() {
        return calculatedAbsent;
    }

    public void setCalculatedAbsent(double calculatedAbsent) {
        this.calculatedAbsent = calculatedAbsent;
    }

    public double getCl() {
        return cl;
    }

    public void setCl(double cl) {
        this.cl = cl;
    }

    public double getSl() {
        return sl;
    }

    public void setSl(double sl) {
        this.sl = sl;
    }

    public double getEl() {
        return el;
    }

    public void setEl(double el) {
        this.el = el;
    }

    public double getSpl() {
        return spl;
    }

    public void setSpl(double spl) {
        this.spl = spl;
    }

    public double getWorkingDay() {
        return workingDay;
    }

    public void setWorkingDay(double workingDay) {
        this.workingDay = workingDay;
    }

    public double getHwDay() {
        return hwDay;
    }

    public void setHwDay(double hwDay) {
        this.hwDay = hwDay;
    }

    public double getOrgLate() {
        return orgLate;
    }

    public void setOrgLate(double orgLate) {
        this.orgLate = orgLate;
    }

    public double getUndefinedDay() {
        return undefinedDay;
    }

    public void setUndefinedDay(double undefinedDay) {
        this.undefinedDay = undefinedDay;
    }

    public double getSlab1() {
        return slab1;
    }

    public void setSlab1(double slab1) {
        this.slab1 = slab1;
    }

    public double getSlab2() {
        return slab2;
    }

    public void setSlab2(double slab2) {
        this.slab2 = slab2;
    }

    public double getSlab3() {
        return slab3;
    }

    public void setSlab3(double slab3) {
        this.slab3 = slab3;
    }

    public double getOt() {
        return ot;
    }

    public void setOt(double ot) {
        this.ot = ot;
    }

    public double getEot() {
        return eot;
    }

    public void setEot(double eot) {
        this.eot = eot;
    }

    public double getOot() {
        return oot;
    }

    public void setOot(double oot) {
        this.oot = oot;
    }

    public double getOeot() {
        return oeot;
    }

    public void setOeot(double oeot) {
        this.oeot = oeot;
    }

    public double getOtRate() {
        return otRate;
    }

    public void setOtRate(double otRate) {
        this.otRate = otRate;
    }

    public double getEotRate() {
        return eotRate;
    }

    public void setEotRate(double eotRate) {
        this.eotRate = eotRate;
    }

    public double getOotRate() {
        return ootRate;
    }

    public void setOotRate(double ootRate) {
        this.ootRate = ootRate;
    }

    public double getOeotRate() {
        return oeotRate;
    }

    public void setOeotRate(double oeotRate) {
        this.oeotRate = oeotRate;
    }

    public int getMonthNo() {
        return monthNo;
    }

    public void setMonthNo(int monthNo) {
        this.monthNo = monthNo;
    }

    public int getYearNo() {
        return yearNo;
    }

    public void setYearNo(int yearNo) {
        this.yearNo = yearNo;
    }
}

