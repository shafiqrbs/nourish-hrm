package com.erp.hrm.api.dto;

import java.util.Date;

public class DisciplinaryActionDTO {
    private long disciplinaryActionId;
    private String employeeCode;
    private String disciplinaryActionType;
    private String description;
    private Date effectiveDate;
    private String disAction;
    private boolean isEffected;
    private Date activationDate;
    private String approvedBy;
    private Date dateApproved;

    public DisciplinaryActionDTO(){
    }

    public DisciplinaryActionDTO(long disciplinaryActionId, String employeeCode, String disciplinaryActionType, String description, Date effectiveDate, String disAction, boolean isEffected, Date activationDate, String approvedBy, Date dateApproved) {
        this.disciplinaryActionId = disciplinaryActionId;
        this.employeeCode = employeeCode;
        this.disciplinaryActionType = disciplinaryActionType;
        this.description = description;
        this.effectiveDate = effectiveDate;
        this.disAction = disAction;
        this.isEffected = isEffected;
        this.activationDate = activationDate;
        this.approvedBy = approvedBy;
        this.dateApproved = dateApproved;
    }

    public long getDisciplinaryActionId() {
        return disciplinaryActionId;
    }

    public void setDisciplinaryActionId(long disciplinaryActionId) {
        this.disciplinaryActionId = disciplinaryActionId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
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
