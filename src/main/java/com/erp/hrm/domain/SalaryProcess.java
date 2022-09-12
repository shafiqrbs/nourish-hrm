package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "SalaryProcess", uniqueConstraints = { @UniqueConstraint(name="UK_SalaryProcess", columnNames = { "SalaryProcID","EmployeeCode","SalaryHeadID" } ) } )
public class SalaryProcess extends BaseEntity {

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryProcID",nullable = false)
    private String SalaryProcID;

    @Size(max = 20)
    @NotNull
    @Column(name = "EmployeeCode",nullable = false)
    private String EmployeeCode;

    @Size(max = 20)
    @NotNull
    @Column(name = "SalaryHeadID",nullable = false)
    private String SalaryHeadID;

    @Size(max = 15)
    @Column(name = "TranID")
    private String TranID;

    @Column(name = "MonthNo")
    private int MonthNo;

    @Column(name = "YearNo")
    private int YearNo;

    @NotNull
    @Column(name = "FromDate",nullable = false)
    private Date FromDate;

    @NotNull
    @Column(name = "ToDate",nullable = false)
    private Date ToDate;

    @NotNull
    @Column(name = "ProcDate",nullable = false)
    private Date ProcDate;

    @Size(max = 50)
    @Column(name = "Currency")
    private String Currency;

    @Column(name = "CurrencyValue", nullable = false,columnDefinition = "NUMERIC(18, 4) CONSTRAINT DF_SalaryProcess_CurrencyValue  DEFAULT 0")
    private BigDecimal CurrencyValue;

    @Size(max = 50)
    @Column(name = "PayCurrency")
    private String PayCurrency;

    @Column(name = "PayCurrencyValue", nullable = false,columnDefinition = "NUMERIC(18, 4) CONSTRAINT DF_SalaryProcess_DF_SalaryProcess_PayCurrencyValue  DEFAULT 0")
    private BigDecimal PayCurrencyValue;

    @Size(max = 50)
    @Column(name = "NetCurrency")
    private String NetCurrency;

    @Column(name = "NetCurrencyValue", nullable = false,columnDefinition = "NUMERIC(18, 4) CONSTRAINT DF_SalaryProcess_DF_SalaryProcess_NetCurrencyValue DEFAULT 0")
    private BigDecimal NetCurrencyValue;

    @Column(name = "OrgPayCurrencyValue")
    private BigDecimal OrgPayCurrencyValue;

    @Size(max = 50)
    @Column(name = "ExchangeCurrency")
    private String ExchangeCurrency;

    @Column(name = "ExchangeCurrencyValue")
    private BigDecimal ExchangeCurrencyValue;

    @Column(name = "ExchangeDiff")
    private BigDecimal ExchangeDiff;

    @Column(name = "CurrencyRate")
    private BigDecimal CurrencyRate;

    @Size(max = 10)
    @Column(name = "ApprovedBy")
    private String ApprovedBy;

    @Column(name = "DateApproved", nullable = false ,columnDefinition = "DATETIME CONSTRAINT DF_SalaryProcessed_DateAdded  DEFAULT (GETDATE())")
    private Date DateApproved;

    @Column(name = "IsProcessed", nullable = false ,columnDefinition = "BIT CONSTRAINT DF_SalaryProcessed_IsProcessed DEFAULT 0")
    private boolean isProcessed;

    @Column(name = "IsProcessSalaryWiseEmployeeReport", nullable = false ,columnDefinition = "BIT CONSTRAINT DF_SalaryProcessed_IsProcessableSalaryWiseEmployeeReport DEFAULT 0")
    private boolean isProcessSalaryWiseEmployeeReport;

    @Column(name = "IsMonthlyAttendanceReportProcess", nullable = false ,columnDefinition = "BIT CONSTRAINT DF_SalaryProcessed_IsMonthlyAttendanceReportProcess DEFAULT 0")
    private boolean isMonthlyAttendanceReportProcess;


    public String getSalaryProcID() {
        return SalaryProcID;
    }

    public void setSalaryProcID(String salaryProcID) {
        this.SalaryProcID = salaryProcID;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.EmployeeCode = employeeCode;
    }

    public String getSalaryHeadID() {
        return SalaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.SalaryHeadID = salaryHeadID;
    }

    public String getTranID() {
        return TranID;
    }

    public void setTranID(String tranID) {
        this.TranID = tranID;
    }

    public int getMonthNo() {
        return MonthNo;
    }

    public void setMonthNo(int monthNo) {
        this.MonthNo = monthNo;
    }

    public int getYearNo() {
        return YearNo;
    }

    public void setYearNo(int yearNo) {
        this.YearNo = yearNo;
    }

    public Date getFromDate() {
        return FromDate;
    }

    public void setFromDate(Date fromDate) {
        this.FromDate = fromDate;
    }

    public Date getToDate() {
        return ToDate;
    }

    public void setToDate(Date toDate) {
        this.ToDate = toDate;
    }

    public Date getProcDate() {
        return ProcDate;
    }

    public void setProcDate(Date procDate) {
        this.ProcDate = procDate;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        this.Currency = currency;
    }

    public BigDecimal getCurrencyValue() {
        return CurrencyValue;
    }

    public void setCurrencyValue(BigDecimal currencyValue) {
        this.CurrencyValue = currencyValue;
    }

    public String getPayCurrency() {
        return PayCurrency;
    }

    public void setPayCurrency(String payCurrency) {
        this.PayCurrency = payCurrency;
    }

    public BigDecimal getPayCurrencyValue() {
        return PayCurrencyValue;
    }

    public void setPayCurrencyValue(BigDecimal payCurrencyValue) {
        this.PayCurrencyValue = payCurrencyValue;
    }

    public String getNetCurrency() {
        return NetCurrency;
    }

    public void setNetCurrency(String netCurrency) {
        this.NetCurrency = netCurrency;
    }

    public BigDecimal getNetCurrencyValue() {
        return NetCurrencyValue;
    }

    public void setNetCurrencyValue(BigDecimal netCurrencyValue) {
        this.NetCurrencyValue = netCurrencyValue;
    }

    public BigDecimal getOrgPayCurrencyValue() {
        return OrgPayCurrencyValue;
    }

    public void setOrgPayCurrencyValue(BigDecimal orgPayCurrencyValue) {
        this.OrgPayCurrencyValue = orgPayCurrencyValue;
    }

    public String getExchangeCurrency() {
        return ExchangeCurrency;
    }

    public void setExchangeCurrency(String exchangeCurrency) {
        this.ExchangeCurrency = exchangeCurrency;
    }

    public BigDecimal getExchangeCurrencyValue() {
        return ExchangeCurrencyValue;
    }

    public void setExchangeCurrencyValue(BigDecimal exchangeCurrencyValue) {
        this.ExchangeCurrencyValue = exchangeCurrencyValue;
    }

    public BigDecimal getExchangeDiff() {
        return ExchangeDiff;
    }

    public void setExchangeDiff(BigDecimal exchangeDiff) {
        this.ExchangeDiff = exchangeDiff;
    }

    public BigDecimal getCurrencyRate() {
        return CurrencyRate;
    }

    public void setCurrencyRate(BigDecimal currencyRate) {
        this.CurrencyRate = currencyRate;
    }

    public String getApprovedBy() {
        return ApprovedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.ApprovedBy = approvedBy;
    }

    public Date getDateApproved() {
        return DateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.DateApproved = dateApproved;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    public boolean isProcessSalaryWiseEmployeeReport() {
        return isProcessSalaryWiseEmployeeReport;
    }

    public void setProcessSalaryWiseEmployeeReport(boolean processSalaryWiseEmployeeReport) {
        isProcessSalaryWiseEmployeeReport = processSalaryWiseEmployeeReport;
    }

    public boolean isMonthlyAttendanceReportProcess() {
        return isMonthlyAttendanceReportProcess;
    }

    public void setMonthlyAttendanceReportProcess(boolean monthlyAttendanceReportProcess) {
        isMonthlyAttendanceReportProcess = monthlyAttendanceReportProcess;
    }
}
