package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by SA
 */
@Entity
@Table( name = "MaternityPaymentDetails", uniqueConstraints = { @UniqueConstraint( columnNames = { "TranId","SalaryHeadID" } ) })
public class MaternityPaymentDetails extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TranId", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_MaternityPaymentDetails_MaternityPayment"))
    private MaternityPayment maternityPayment;

    @NotNull
    @Size(max = 20)
    @Column(name = "SalaryHeadID")
    private String salaryHeadID;

    @Column(name = "FirstAmount")
    private float firstAmount;

    @Column(name = "SecondAmount")
    private float secondAmount;

    public MaternityPayment getMaternityPayment() {
        return maternityPayment;
    }

    public void setMaternityPayment(MaternityPayment maternityPayment) {
        this.maternityPayment = maternityPayment;
    }

    public String getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public float getFirstAmount() {
        return firstAmount;
    }

    public void setFirstAmount(float firstAmount) {
        this.firstAmount = firstAmount;
    }

    public float getSecondAmount() {
        return secondAmount;
    }

    public void setSecondAmount(float secondAmount) {
        this.secondAmount = secondAmount;
    }
}
