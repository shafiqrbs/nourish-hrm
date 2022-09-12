package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Navid on 29/04/2018.
 */
@Entity
@Table( name = "Promotion")
public class Promotion extends BaseEntity {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EmployeeCode", columnDefinition="VARCHAR(20)", foreignKey = @ForeignKey(name = "FK_Promotion_EmployeeInfo"))
    private EmployeeInfo employeeInfo;

    @Size(max = 100)
    @Column(name = "PromotionType")
    private String PromotionType;

    @Column(name = "EffectiveDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date EffectiveDate;

    @Column(name = "DateApproved")
    @Temporal(TemporalType.TIMESTAMP)
    private Date DateApproved;

    @Size(max = 50)
    @Column(name = "Approved")
    private String Approved;

    @Column(name = "IsEffected")
    private boolean IsEffected;

    @Column(name="PostStatus", columnDefinition = "INT")
    private int PostStatus;

    @Size(max = 100)
    @Column(name="PromotedPosition")
    private String PromotedPosition;

    @Column(name="PreStatus", columnDefinition = "INT")
    private int PreStatus;

    @Size(max = 100)
    @Column(name = "PromotionCriteria")
    private String PromotionCriteria;

    @Column(name="ServiceLen", columnDefinition = "INT")
    private int ServiceLen;

    @Column(name = "NextPromotionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date NextPromotionDate;

    @Size(max = 100)
    @Column(name = "PromotionSource")
    private String PromotionSource;

    @Size(max = 100)
    @Column(name = "PrePosition")
    private String PrePosition;

    public EmployeeInfo getEmployeeInfo() {
        return employeeInfo;
    }

    public void setEmployeeInfo(EmployeeInfo employeeInfo) {
        this.employeeInfo = employeeInfo;
    }

    public String getPromotionType() {
        return PromotionType;
    }

    public void setPromotionType(String promotionType) {
        PromotionType = promotionType;
    }

    public Date getEffectiveDate() {
        return EffectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate) {
        EffectiveDate = effectiveDate;
    }

    public Date getDateApproved() {
        return DateApproved;
    }

    public void setDateApproved(Date dateApproved) {
        DateApproved = dateApproved;
    }

    public String getApproved() {
        return Approved;
    }

    public void setApproved(String approved) {
        Approved = approved;
    }

    public boolean isEffected() {
        return IsEffected;
    }

    public void setEffected(boolean effected) {
        IsEffected = effected;
    }

    public int getPostStatus() {
        return PostStatus;
    }

    public void setPostStatus(int postStatus) {
        PostStatus = postStatus;
    }

    public String getPromotedPosition() {
        return PromotedPosition;
    }

    public void setPromotedPosition(String PromotedPosition) {
        this.PromotedPosition = PromotedPosition;
    }

    public int getPreStatus() {
        return PreStatus;
    }

    public void setPreStatus(int preStatus) {
        PreStatus = preStatus;
    }

    public String getPromotionCriteria() {
        return PromotionCriteria;
    }

    public void setPromotionCriteria(String promotionCriteria) {
        PromotionCriteria = promotionCriteria;
    }

    public int getServiceLen() {
        return ServiceLen;
    }

    public void setServiceLen(int serviceLen) {
        ServiceLen = serviceLen;
    }

    public Date getNextPromotionDate() {
        return NextPromotionDate;
    }

    public void setNextPromotionDate(Date nextPromotionDate) {
        NextPromotionDate = nextPromotionDate;
    }

    public String getPromotionSource() {
        return PromotionSource;
    }

    public void setPromotionSource(String promotionSource) {
        PromotionSource = promotionSource;
    }

    public String getPrePosition() {
        return PrePosition;
    }

    public void setPrePosition(String prePosition) {
        PrePosition = prePosition;
    }
}
