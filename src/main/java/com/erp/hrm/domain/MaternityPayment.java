package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Set;

/**
 * Created by SA
 */
@Entity(name = "MaternityPayment")
@Table( name = "MaternityPayment", uniqueConstraints = { @UniqueConstraint( columnNames = { "TranId" } ) })
public class MaternityPayment extends BaseByOnEntity {

    @Id
    @Size(max = 20)
    @NotNull
    @Column(name = "TranId")
    private String tranId;

    @Column(name = "FirstPaymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date firstPaymentDate;

    @Column(name = "SecondPaymentDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date secondPaymentDate;

    @Column(name = "FirstPercent")
    private float firstPercent;

    @Size(max = 50)
    @Column(name = "Status")
    private String status;

    @Column(name = "Others")
    private float others;

    @Size(max = 50)
    @Column(name = "MaternityDeduction")
    private String maternityDeduction;

    @OneToMany(mappedBy = "maternityPayment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MaternityPaymentDetails> maternityPaymentDetails;

    @OneToMany(mappedBy = "maternityPayment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MaternityLeavePayment> maternityLeavePayments;

    @OneToMany(mappedBy = "maternityPayment", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<MaternityLeaveTransInfo> maternityLeaveTransInfos;

    public String getTranId() {
        return tranId;
    }

    public void setTranId(String tranId) {
        this.tranId = tranId;
    }

    public Date getFirstPaymentDate() {
        return firstPaymentDate;
    }

    public void setFirstPaymentDate(Date firstPaymentDate) {
        this.firstPaymentDate = firstPaymentDate;
    }

    public Date getSecondPaymentDate() {
        return secondPaymentDate;
    }

    public void setSecondPaymentDate(Date secondPaymentDate) {
        this.secondPaymentDate = secondPaymentDate;
    }

    public float getFirstPercent() {
        return firstPercent;
    }

    public void setFirstPercent(float firstPercent) {
        this.firstPercent = firstPercent;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getOthers() {
        return others;
    }

    public void setOthers(float others) {
        this.others = others;
    }

    public String getMaternityDeduction() {
        return maternityDeduction;
    }

    public void setMaternityDeduction(String maternityDeduction) {
        this.maternityDeduction = maternityDeduction;
    }

    public Set<MaternityPaymentDetails> getMaternityPaymentDetails() {
        return maternityPaymentDetails;
    }

    public void setMaternityPaymentDetails(Set<MaternityPaymentDetails> maternityPaymentDetails) {
        this.maternityPaymentDetails = maternityPaymentDetails;
    }

    public Set<MaternityLeavePayment> getMaternityLeavePayments() {
        return maternityLeavePayments;
    }

    public void setMaternityLeavePayments(Set<MaternityLeavePayment> maternityLeavePayments) {
        this.maternityLeavePayments = maternityLeavePayments;
    }
}
