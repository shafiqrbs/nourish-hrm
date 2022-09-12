package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by SA
 */
@Entity
@Table( name = "BonusEffectiveDate", uniqueConstraints = { @UniqueConstraint( name = "UK_BonusEffectiveDate",columnNames = { "BonusCode","EffectiveDate"} ) } )
public class BonusEffectiveDate extends BaseEntity {

    @Size(max = 50)
    @Column(name = "BonusCode",nullable = false)
    private String bonusCode;

    @Column(name = "EffectiveDate", nullable = false)
    private Date effectiveDate;

    @Column(name = "IsApproved",nullable = false)
    private boolean isApproved;

    @Size(max = 20)
    @Column(name = "ApprovedBy")
    private String approvedBy;

    @Column(name = "ApprovedDate")
    private Date approvedDate;

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
