package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by SA
 */
@Entity
@Table( name = "MaternityLeavePayment", uniqueConstraints = { @UniqueConstraint( columnNames = { "EmployeeCode","TranID" } ) })
public class MaternityLeavePayment extends BaseEntity {

    @NotNull
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_MaternityLeavePayment_EmployeeInfo"), nullable = false)
    private EmployeeInfo employeeInfo;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TranID", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_MaternityLeavePayment_MaternityPayment"))
    private MaternityPayment maternityPayment;

    @Column(name = "PreNatalFromDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preNatalFromDate;

    @Column(name = "PreNatalToDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date preNatalToDate;

    @Column(name = "PostNatalFromDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postNatalFromDate;

    @Column(name = "PostNatalToDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date postNatalToDate;

    @Column(name = "PreNatalTotalDays")
    private int preNatalTotalDays;

    @Column(name = "PostNatalTotalDays")
    private int postNatalTotalDays;

    @Column(name = "PreNatalPayment")
    private float preNatalPayment;

    @Column(name = "PostNatalPayment")
    private float postNatalPayment;

    @Column(name = "OtherAddition")
    private float otherAddition;

    @Column(name = "OtherDeduction")
    private float otherDeduction;

    @Column(name = "NetPayment")
    private float netPayment;

    @Column(name = "ActualPaymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date actualPaymentDate;

    @Column(name = "PaymentReleaseDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentReleaseDate;

    @Column(name = "IsIncrementEffected",columnDefinition = "BIT DEFAULT 0")
    private boolean isIncrementEffected;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public MaternityPayment getMaternityPayment() {
        return maternityPayment;
    }

    public void setMaternityPayment(MaternityPayment maternityPayment) {
        this.maternityPayment = maternityPayment;
    }

    public Date getPreNatalFromDate() {
        return preNatalFromDate;
    }

    public void setPreNatalFromDate(Date preNatalFromDate) {
        this.preNatalFromDate = preNatalFromDate;
    }

    public Date getPreNatalToDate() {
        return preNatalToDate;
    }

    public void setPreNatalToDate(Date preNatalToDate) {
        this.preNatalToDate = preNatalToDate;
    }

    public Date getPostNatalFromDate() {
        return postNatalFromDate;
    }

    public void setPostNatalFromDate(Date postNatalFromDate) {
        this.postNatalFromDate = postNatalFromDate;
    }

    public Date getPostNatalToDate() {
        return postNatalToDate;
    }

    public void setPostNatalToDate(Date postNatalToDate) {
        this.postNatalToDate = postNatalToDate;
    }

    public int getPreNatalTotalDays() {
        return preNatalTotalDays;
    }

    public void setPreNatalTotalDays(int preNatalTotalDays) {
        this.preNatalTotalDays = preNatalTotalDays;
    }

    public int getPostNatalTotalDays() {
        return postNatalTotalDays;
    }

    public void setPostNatalTotalDays(int postNatalTotalDays) {
        this.postNatalTotalDays = postNatalTotalDays;
    }

    public float getPreNatalPayment() {
        return preNatalPayment;
    }

    public void setPreNatalPayment(float preNatalPayment) {
        this.preNatalPayment = preNatalPayment;
    }

    public float getPostNatalPayment() {
        return postNatalPayment;
    }

    public void setPostNatalPayment(float postNatalPayment) {
        this.postNatalPayment = postNatalPayment;
    }

    public float getOtherAddition() {
        return otherAddition;
    }

    public void setOtherAddition(float otherAddition) {
        this.otherAddition = otherAddition;
    }

    public float getOtherDeduction() {
        return otherDeduction;
    }

    public void setOtherDeduction(float otherDeduction) {
        this.otherDeduction = otherDeduction;
    }

    public float getNetPayment() {
        return netPayment;
    }

    public void setNetPayment(float netPayment) {
        this.netPayment = netPayment;
    }

    public Date getActualPaymentDate() {
        return actualPaymentDate;
    }

    public void setActualPaymentDate(Date actualPaymentDate) {
        this.actualPaymentDate = actualPaymentDate;
    }

    public Date getPaymentReleaseDate() {
        return paymentReleaseDate;
    }

    public void setPaymentReleaseDate(Date paymentReleaseDate) {
        this.paymentReleaseDate = paymentReleaseDate;
    }

    public boolean isIncrementEffected() {
        return isIncrementEffected;
    }

    public void setIncrementEffected(boolean incrementEffected) {
        this.isIncrementEffected = incrementEffected;
    }
}
