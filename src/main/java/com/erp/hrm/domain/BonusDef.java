package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "BonusDef" )
public class BonusDef extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "BonusCode")
    private String BonusCode;

    @Size(max = 20)
    @Column(name = "BonusType")
    private String BonusType;

    @Size(max = 50)
    @Column(name = "Description")
    private String Description;

    @Column(name = "EffectiveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date EffectiveDate;

    @Size(max = 20)
    @Column(name = "AvailFrom")
    private String AvailFrom;

    @Column(name = "DayAfter")
    private double DayAfter;

    @NotNull
    @Column(name = "IsFixed")
    private boolean IsFixed;

    @Size(max = 30)
    @Column(name = "Religion")
    private String Religion;

    @Size(max = 10)
    @Column(name = "EmpType")
    private String EmpType;

    @Size(max = 15)
    @Column(name = "EmployeeState")
    private String EmployeeState;

    @NotNull
    @Column(name = "IsActive")
    private boolean IsActive;

    @Column(name = "PSLPercentage")
    private double PSLPercentage;

    @Column(name = "DateApproved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateApproved;

    @Size(max = 10)
    @Column(name = "ApprovedBy")
    private String ApprovedBy;

    public String getBonusCode() {
        return BonusCode;
    }

    public void setBonusCode(String BonusCode) {
        this.BonusCode = BonusCode;
    }

    public String getBonusType() {
        return BonusType;
    }

    public void setBonusType(String BonusType) {
        this.BonusType = BonusType;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public Date getEffectiveDate() {
        return EffectiveDate;
    }

    public void setEffectiveDate(Date EffectiveDate) {
        this.EffectiveDate = EffectiveDate;
    }

    public String getAvailFrom() {
        return AvailFrom;
    }

    public void setAvailFrom(String AvailFrom) {
        this.AvailFrom = AvailFrom;
    }

    public double getDayAfter() {
        return DayAfter;
    }

    public void setDayAfter(double DayAfter) {
        this.DayAfter = DayAfter;
    }

    public boolean getIsFixed() {
        return IsFixed;
    }

    public void setIsFixed(boolean IsFixed) {
        this.IsFixed = IsFixed;
    }

    public String getReligion() {
        return Religion;
    }

    public void setReligion(String Religion) {
        this.Religion = Religion;
    }

    public String getEmpType() {
        return EmpType;
    }

    public void setEmpType(String EmpType) {
        this.EmpType = EmpType;
    }

    public String getEmployeeState() {
        return EmployeeState;
    }

    public void setEmployeeState(String EmployeeState) {
        this.EmployeeState = EmployeeState;
    }

    public boolean getIsActive() {
        return IsActive;
    }

    public void setIsActive(boolean IsActive) {
        this.IsActive = IsActive;
    }

    public double getPSLPercentage() {
        return PSLPercentage;
    }

    public void setPSLPercentage(double PSLPercentage) {
        this.PSLPercentage = PSLPercentage;
    }

    public Date getDateApproved() {
        return DateApproved;
    }

    public void setDateApproved(Date DateApproved) {
        this.DateApproved = DateApproved;
    }

    public String getApprovedBy() {
        return ApprovedBy;
    }

    public void setApprovedBy(String ApprovedBy) {
        this.ApprovedBy = ApprovedBy;
    }
}
