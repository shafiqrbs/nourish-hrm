package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

/**
 * Created by WS on 09/05/2018.
 */
@Entity
@Table( name = "OTSlab", uniqueConstraints = { @UniqueConstraint( name = "UK_OTSlab",columnNames = { "RuleCode","SlabType" } ) } )
public class OTSlab extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "RuleCode",nullable = false)
    private String ruleCode;

    @Size(max = 20)
    @Column(name = "SlabType",nullable = false)
    private String slabType;

    @Size(max = 50)
    @Column(name = "Description")
    private String description;

    @Column(name = "Rate", columnDefinition = "NUMERIC(18,4) CONSTRAINT DF_OTSlab_Rate  DEFAULT 0")
    private BigDecimal rate;

    @Column(name = "Duration", columnDefinition = "NUMERIC(18,2)")
    private BigDecimal duration;

    @Column(name = "Sequence")
    private int sequence;

    @Size(max = 50)
    @Column(name = "SalaryHead")
    private String salaryHead;

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getSlabType() {
        return slabType;
    }

    public void setSlabType(String slabType) {
        this.slabType = slabType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getDuration() {
        return duration;
    }

    public void setDuration(BigDecimal duration) {
        this.duration = duration;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public String getSalaryHead() {
        return salaryHead;
    }

    public void setSalaryHead(String salaryHead) {
        this.salaryHead = salaryHead;
    }
}
