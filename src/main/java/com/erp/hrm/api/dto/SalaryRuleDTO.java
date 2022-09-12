package com.erp.hrm.api.dto;
public class SalaryRuleDTO {

    private long id;
    private String salaryRuleCode;
    private String salaryHeadID;
    private String sCriteria;
    private String parentHeadID;
    private float parentHeadValue;
    private boolean isFixed;
    private boolean isHigher;
    private String formula1;
    private String formula2;
    private int sequenceNo;

    public SalaryRuleDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSalaryRuleCode() {
        return salaryRuleCode;
    }

    public void setSalaryRuleCode(String salaryRuleCode) {
        this.salaryRuleCode = salaryRuleCode;
    }

    public String getSalaryHeadID() {
        return salaryHeadID;
    }

    public void setSalaryHeadID(String salaryHeadID) {
        this.salaryHeadID = salaryHeadID;
    }

    public String getsCriteria() {
        return sCriteria;
    }

    public void setsCriteria(String sCriteria) {
        this.sCriteria = sCriteria;
    }

    public String getParentHeadID() {
        return parentHeadID;
    }

    public void setParentHeadID(String parentHeadID) {
        this.parentHeadID = parentHeadID;
    }

    public float getParentHeadValue() {
        return parentHeadValue;
    }

    public void setParentHeadValue(float parentHeadValue) {
        this.parentHeadValue = parentHeadValue;
    }

    public boolean isFixed() {
        return isFixed;
    }

    public void setFixed(boolean fixed) {
        isFixed = fixed;
    }

    public boolean isHigher() {
        return isHigher;
    }

    public void setHigher(boolean higher) {
        isHigher = higher;
    }

    public String getFormula1() {
        return formula1;
    }

    public void setFormula1(String formula1) {
        this.formula1 = formula1;
    }

    public String getFormula2() {
        return formula2;
    }

    public void setFormula2(String formula2) {
        this.formula2 = formula2;
    }

    public int getSequenceNo() {
        return sequenceNo;
    }

    public void setSequenceNo(int sequenceNo) {
        this.sequenceNo = sequenceNo;
    }
}
