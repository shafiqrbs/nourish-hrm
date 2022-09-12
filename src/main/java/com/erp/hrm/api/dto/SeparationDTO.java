package com.erp.hrm.api.dto;

import java.util.Date;

public class SeparationDTO {
    private long SeparationId;
    private String EmployeeCode;
    private String SeparationCause;
    private String Notes;
    private Date EffectiveDate;
    private String ApprovedBy;
    private Date DateApproved;
    private String SepAction;
    private boolean IsEffected;
    private boolean IsBlackListed;
    private String BlackListCause;
    private Date ResignSubmissionDate;

    public SeparationDTO(){
    }

    public SeparationDTO(long separationId,String employeeCode, String separationCause, String notes, Date effectiveDate, String approvedBy, Date dateApproved, String sepAction, boolean isEffected, boolean isBlackListed, String blackListCause, Date resignSubmissionDate) {
        SeparationId = separationId;
        EmployeeCode = employeeCode;
        SeparationCause = separationCause;
        Notes = notes;
        EffectiveDate = effectiveDate;
        ApprovedBy = approvedBy;
        DateApproved = dateApproved;
        SepAction = sepAction;
        IsEffected = isEffected;
        IsBlackListed = isBlackListed;
        BlackListCause = blackListCause;
        ResignSubmissionDate = resignSubmissionDate;
    }

    public long getSeparationId() {
        return SeparationId;
    }

    public void setSeparationId(long separationId) {
        SeparationId = separationId;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
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
