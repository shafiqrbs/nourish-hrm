package com.erp.hrm.api.dto.bonus;

import java.util.Date;

public class BonusEffectiveDateDTO {

    private String bonusCode;
    private Date effectiveDate;
    private boolean isApproved;
    private String approvedBy;
    private Date approvedDate;

    public BonusEffectiveDateDTO() {
    }

    public BonusEffectiveDateDTO(String bonusCode, Date effectiveDate, boolean isApproved, String approvedBy, Date approvedDate) {
        this.bonusCode = bonusCode;
        this.effectiveDate = effectiveDate;
        this.isApproved = isApproved;
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
    }

    public String getBonusCode() {
        return bonusCode;
    }

    public void setBonusCode(String bonusCode) {
        this.bonusCode = bonusCode;
    }

    public Date getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public Date getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(Date approvedDate) {
        this.approvedDate = approvedDate;
    }
}
