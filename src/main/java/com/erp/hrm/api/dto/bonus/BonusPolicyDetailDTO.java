package com.erp.hrm.api.dto.bonus;

/**
 * Created by SA
 */
public class BonusPolicyDetailDTO {

    private long bonusPaymentPolicyId;
    private String bonusCode;
    private String staffCategory;
    private int minServiceLen;
    private int maxServiceLen;
    private String remarks;

    public BonusPolicyDetailDTO() {
    }

    public BonusPolicyDetailDTO(long bonusPaymentPolicyId, String bonusCode, String staffCategory, int minServiceLen, int maxServiceLen, String remarks) {
        this.bonusPaymentPolicyId = bonusPaymentPolicyId;
        this.bonusCode = bonusCode;
        this.staffCategory = staffCategory;
        this.minServiceLen = minServiceLen;
        this.maxServiceLen = maxServiceLen;
        this.remarks = remarks;
    }

    public long getBonusPaymentPolicyId() {
        return bonusPaymentPolicyId;
    }

    public void setBonusPaymentPolicyId(long bonusPaymentPolicyId) {
        this.bonusPaymentPolicyId = bonusPaymentPolicyId;
    }

    public String getBonusCode() {
        return bonusCode;
    }

    public void setBonusCode(String bonusCode) {
        this.bonusCode = bonusCode;
    }

    public String getStaffCategory() {
        return staffCategory;
    }

    public void setStaffCategory(String staffCategory) {
        this.staffCategory = staffCategory;
    }

    public int getMinServiceLen() {
        return minServiceLen;
    }

    public void setMinServiceLen(int minServiceLen) {
        this.minServiceLen = minServiceLen;
    }

    public int getMaxServiceLen() {
        return maxServiceLen;
    }

    public void setMaxServiceLen(int maxServiceLen) {
        this.maxServiceLen = maxServiceLen;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
