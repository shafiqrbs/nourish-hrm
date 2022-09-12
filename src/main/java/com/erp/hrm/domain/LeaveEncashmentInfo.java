package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "LeaveEncashmentInfo" )
public class LeaveEncashmentInfo extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode")
    private String EmployeeCode;

    @Size(max = 50)
    @NotNull
    @Column(name = "LeavePolicyID")
    private String LeavePolicyID;

    @NotNull
    @Column(name = "YearNo")
    private Integer YearNo;

    @Column(name = "ProcessDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ProcessDate;

    @Column(name = "DevideFactor")
    private Integer DevideFactor;

    @Size(max = 50)
    @Column(name = "DayType")
    private String DayType;

    @Size(max = 10)
    @Column(name = "DCriteria")
    private String DCriteria;

    @Column(name = "EncashedDays")
    private Integer EncashedDays;

    @Column(name = "EncashedAmount")
    private double EncashedAmount;

    @Size(max = 20)
    @Column(name = "SalaryProcID")
    private String SalaryProcID;

    @Column(name = "TotalEarnedDays")
    private Integer TotalEarnedDays;

    @Column(name = "TotalEnjoyed")
    private Integer TotalEnjoyed;

    @Size(max = 20)
    @Column(name = "ApprovedBy")
    private String ApprovedBy;

    @Column(name = "ApprovedDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ApprovedDate;

    @Column(name = "ProcessFrom")
    private Integer ProcessFrom;

    @Column(name = "HasDisburse")
    private boolean HasDisburse;

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String EmployeeCode) {
        this.EmployeeCode = EmployeeCode;
    }

    public String getLeavePolicyID() {
        return LeavePolicyID;
    }

    public void setLeavePolicyID(String LeavePolicyID) {
        this.LeavePolicyID = LeavePolicyID;
    }

    public Integer getYearNo() {
        return YearNo;
    }

    public void setYearNo(Integer YearNo) {
        this.YearNo = YearNo;
    }

    public Date getProcessDate() {
        return ProcessDate;
    }

    public void setProcessDate(Date ProcessDate) {
        this.ProcessDate = ProcessDate;
    }

    public Integer getDevideFactor() {
        return DevideFactor;
    }

    public void setDevideFactor(Integer DevideFactor) {
        this.DevideFactor = DevideFactor;
    }

    public String getDayType() {
        return DayType;
    }

    public void setDayType(String DayType) {
        this.DayType = DayType;
    }

    public String getDCriteria() {
        return DCriteria;
    }

    public void setDCriteria(String DCriteria) {
        this.DCriteria = DCriteria;
    }

    public Integer getEncashedDays() {
        return EncashedDays;
    }

    public void setEncashedDays(Integer EncashedDays) {
        this.EncashedDays = EncashedDays;
    }

    public double getEncashedAmount() {
        return EncashedAmount;
    }

    public void setEncashedAmount(double EncashedAmount) {
        this.EncashedAmount = EncashedAmount;
    }

    public String getSalaryProcID() {
        return SalaryProcID;
    }

    public void setSalaryProcID(String SalaryProcID) {
        this.SalaryProcID = SalaryProcID;
    }

    public Integer getTotalEarnedDays() {
        return TotalEarnedDays;
    }

    public void setTotalEarnedDays(Integer TotalEarnedDays) {
        this.TotalEarnedDays = TotalEarnedDays;
    }

    public Integer getTotalEnjoyed(){
        return TotalEnjoyed;
    }

    public void setTotalEnjoyed(Integer TotalEnjoyed){
        this.TotalEnjoyed=TotalEnjoyed;
    }

    public String getApprovedBy() {
        return ApprovedBy;
    }

    public void setApprovedBy(String ApprovedBy) {
        this.ApprovedBy = ApprovedBy;
    }

    public Date getApprovedDate() {
        return ApprovedDate;
    }

    public void setApprovedDate(Date ApprovedDate) {
        this.ApprovedDate = ApprovedDate;
    }

    public Integer getProcessFrom(){
        return ProcessFrom;
    }

    public void setProcessFrom(Integer ProcessFrom){
        this.ProcessFrom=ProcessFrom;
    }

    public boolean getHasDisburse(){
        return HasDisburse;
    }

    public void setHasDisburse(boolean HasDisburse){
        this.HasDisburse=HasDisburse;
    }
}
