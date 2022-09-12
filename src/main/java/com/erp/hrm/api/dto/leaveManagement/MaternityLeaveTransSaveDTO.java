package com.erp.hrm.api.dto.leaveManagement;

import java.util.Date;

/**
 * Created by SA
 */
public class MaternityLeaveTransSaveDTO {
    private long id;
    private String employeeCode;
    private Date fromDate;
    private Date toDate;
    private int totalLeaveDays;
    private Date EDD;
    private Date firstPaymentDate;
    private int firstPaymentPCT;
    private Date secondPaymentDate;
    private int secondPaymentPCT;

    public MaternityLeaveTransSaveDTO() {
    }

    public MaternityLeaveTransSaveDTO(long id,String employeeCode, Date fromDate, Date toDate, int totalLeaveDays, Date EDD, Date firstPaymentDate, int firstPaymentPCT, Date secondPaymentDate, int secondPaymentPCT) {
        this.id = id;
        this.employeeCode = employeeCode;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalLeaveDays = totalLeaveDays;
        this.EDD = EDD;
        this.firstPaymentDate = firstPaymentDate;
        this.firstPaymentPCT = firstPaymentPCT;
        this.secondPaymentDate = secondPaymentDate;
        this.secondPaymentPCT = secondPaymentPCT;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

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

    public int getTotalLeaveDays() {
        return totalLeaveDays;
    }

    public void setTotalLeaveDays(int totalLeaveDays) {
        this.totalLeaveDays = totalLeaveDays;
    }

    public Date getEDD() {
        return EDD;
    }

    public void setEDD(Date EDD) {
        this.EDD = EDD;
    }

    public Date getFirstPaymentDate() {
        return firstPaymentDate;
    }

    public void setFirstPaymentDate(Date firstPaymentDate) {
        this.firstPaymentDate = firstPaymentDate;
    }

    public int getFirstPaymentPCT() {
        return firstPaymentPCT;
    }

    public void setFirstPaymentPCT(int firstPaymentPCT) {
        this.firstPaymentPCT = firstPaymentPCT;
    }

    public Date getSecondPaymentDate() {
        return secondPaymentDate;
    }

    public void setSecondPaymentDate(Date secondPaymentDate) {
        this.secondPaymentDate = secondPaymentDate;
    }

    public int getSecondPaymentPCT() {
        return secondPaymentPCT;
    }

    public void setSecondPaymentPCT(int secondPaymentPCT) {
        this.secondPaymentPCT = secondPaymentPCT;
    }
}
