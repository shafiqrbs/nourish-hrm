package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "DisciplinaryAction")
public class DisciplinaryAction extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_DisciplinaryAction_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @Size(max = 100)
    @Column(name = "DisciplinaryActionType")
    private String disciplinaryActionType;

    @Size(max = 100)
    @Column(name = "Description")
    private String description;

    @Column(name = "EffectiveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date effectiveDate;

    @Column(name = "DisAction")
    private String disAction;

    @Column(name = "IsEffected")
    private boolean isEffected;

    @Column(name = "ActivationDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date activationDate;

    @Size(max = 50)
    @Column(name = "ApprovedBy")
    private String approvedBy;

    @Column(name = "DateApproved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateApproved;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getDisciplinaryActionType() {
        return disciplinaryActionType;
    }

    public void setDisciplinaryActionType(String disciplinaryActionType) {
        this.disciplinaryActionType = disciplinaryActionType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public String getDisAction() {
        return disAction;
    }

    public void setDisAction(String disAction) {
        this.disAction = disAction;
    }

    public boolean isEffected() {
        return isEffected;
    }

    public void setEffected(boolean effected) {
        isEffected = effected;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getDateApproved() {
        return dateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        this.dateApproved = dateApproved;
    }
}
