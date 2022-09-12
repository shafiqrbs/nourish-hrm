package com.erp.hrm.api.dto;

import java.util.Date;

public class TransferDTO {
    private long TransferId;
    private String EmployeeCode;
    private String TransferType;
    private String TransferLocation;
    private Date EffectiveDate;
    private String ApprovedBy;
    private Date DateApproved;
    private String PreTransferLocation;

    public TransferDTO(){
    }

    public TransferDTO(long transferId,String employeeCode, String transferType, String transferLocation, Date effectiveDate, String approvedBy,
                       Date dateApproved, String preTransferLocation) {
        TransferId = transferId;
        EmployeeCode = employeeCode;
        TransferType = transferType;
        TransferLocation = transferLocation;
        EffectiveDate = effectiveDate;
        ApprovedBy = approvedBy;
        DateApproved = dateApproved;
        PreTransferLocation = preTransferLocation;
    }

    public long getTransferId() {
        return TransferId;
    }

    public void setTransferId(long transferId) {
        TransferId = transferId;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
    }

    public String getTransferType() {
        return TransferType;
    }

    public void setTransferType(String transferType) {
        TransferType = transferType;
    }

    public String getTransferLocation() {
        return TransferLocation;
    }

    public void setTransferLocation(String transferLocation) {
        TransferLocation = transferLocation;
    }

    public Date getEffectiveDate() {
        return EffectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        EffectiveDate = effectiveDate;
    }

    public String getApprovedBy() {
        return ApprovedBy;
    }

    public void setApprovedBy(String approvedBy) {
        ApprovedBy = approvedBy;
    }

    public Date getDateApproved() {
        return DateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        DateApproved = dateApproved;
    }

    public String getPreTransferLocation() {
        return PreTransferLocation;
    }

    public void setPreTransferLocation(String preTransferLocation) {
        PreTransferLocation = preTransferLocation;
    }
}
