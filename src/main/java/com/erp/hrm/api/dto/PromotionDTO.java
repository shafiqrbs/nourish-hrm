package com.erp.hrm.api.dto;

import java.util.Date;

public class PromotionDTO {
    private long PromotionId;
    private String EmployeeCode;
    private String PromotionType;
    private Date EffectiveDate;
    private Date DateApproved;
    private String Approved;
    private boolean IsEffected;
    private int PostStatus;
    private String PromotedPosition;;
    private int PreStatus;
    private String PromotionCriteria;
    private int ServiceLen;
    private Date NextPromotionDate;
    private String PromotionSource;
    private String PrePosition;

    public PromotionDTO(){
    }

    public PromotionDTO(long promotionId,String employeeCode, String promotionType, Date effectiveDate, Date dateApproved, String approved,
                        boolean isEffected, int postStatus, String promotedPosition, int preStatus, String promotionCriteria,
                        int serviceLen, Date nextPromotionDate, String promotionSource, String prePosition) {
        PromotionId = promotionId;
        EmployeeCode = employeeCode;
        PromotionType = promotionType;
        EffectiveDate = effectiveDate;
        DateApproved = dateApproved;
        Approved = approved;
        IsEffected = isEffected;
        PostStatus = postStatus;
        PromotedPosition = promotedPosition;
        PreStatus = preStatus;
        PromotionCriteria = promotionCriteria;
        ServiceLen = serviceLen;
        NextPromotionDate = nextPromotionDate;
        PromotionSource = promotionSource;
        PrePosition = prePosition;
    }

    public long getPromotionId() {
        return PromotionId;
    }

    public void setPromotionId(long promotionId) {
        PromotionId = promotionId;
    }

    public String getEmployeeCode() {
        return EmployeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        EmployeeCode = employeeCode;
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

    public void setPromotedPosition(String promotedPosition) {
        PromotedPosition = promotedPosition;
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
