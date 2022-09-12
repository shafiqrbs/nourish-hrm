package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "Separation")
public class Separation extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_Separation_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @Size(max = 100)
    @Column(name = "SeparationCause")
    private String SeparationCause;

    @Size(max = 250)
    @Column(name = "Notes")
    private String Notes;

    @Column(name = "EffectiveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date EffectiveDate;

    @Size(max = 10)
    @Column(name = "ApprovedBy")
    private String ApprovedBy;

    @Column(name = "DateApproved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateApproved;

    @Size(max = 50)
    @Column(name = "SepAction")
    private String SepAction;

    @Column(name = "IsEffected")
    private boolean IsEffected;

    @Column(name = "IsBlackListed")
    private boolean IsBlackListed;

    @Size(max = 500)
    @Column(name = "BlackListCause")
    private String BlackListCause;

    @Column(name = "ResignSubmissionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ResignSubmissionDate;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getSeparationCause() {
        return SeparationCause;
    }

    public void setSeparationCause(String separationCause) {
        SeparationCause = separationCause;
    }

    public String getNotes() {
        return Notes;
    }

    public void setNotes(String notes) {
        Notes = notes;
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

    public String getSepAction() {
        return SepAction;
    }

    public void setSepAction(String sepAction) {
        SepAction = sepAction;
    }

    public boolean isEffected() {
        return IsEffected;
    }

    public void setEffected(boolean effected) {
        IsEffected = effected;
    }

    public boolean isBlackListed() {
        return IsBlackListed;
    }

    public void setBlackListed(boolean blackListed) {
        IsBlackListed = blackListed;
    }

    public String getBlackListCause() {
        return BlackListCause;
    }

    public void setBlackListCause(String blackListCause) {
        BlackListCause = blackListCause;
    }

    public Date getResignSubmissionDate() {
        return ResignSubmissionDate;
    }

    public void setResignSubmissionDate(Date resignSubmissionDate) {
        ResignSubmissionDate = resignSubmissionDate;
    }
}
