package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "Transfer")
public class Transfer extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_Transfer_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @Size(max = 100)
    @Column(name = "TransferType")
    private String TransferType;

    @Size(max = 100)
    @Column(name = "TransferLocation")
    private String TransferLocation;

    @Column(name = "EffectiveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date EffectiveDate;

    @Size(max = 50)
    @Column(name = "ApprovedBy")
    private String ApprovedBy;

    @Column(name = "DateApproved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateApproved;

    @Size(max = 100)
    @Column(name = "PreTransferLocation")
    private String PreTransferLocation;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
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
