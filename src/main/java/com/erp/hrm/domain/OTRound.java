package com.erp.hrm.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by WS on 09/05/2018.
 */
@Entity
@Table( name = "OTRound", uniqueConstraints = { @UniqueConstraint( name = "UK_OTRound",columnNames = { "HKEntryId","MinMinitues","MaxMinutes" } ) } )
public class OTRound extends BaseEntity {

    @Size(max = 50)
    @Column(name = "HKEntryId",nullable = false)
    private String HKEntryId;

    @Size(max = 250)
    @Column(name = "HKEntryName", nullable = false)
    private String HKEntryName;

    @Column(name = "MinMinitues", nullable = false, columnDefinition = "NUMERIC(18,4)")
    private BigDecimal MinMinitues;

    @Column(name = "MaxMinutes", nullable = false, columnDefinition = "NUMERIC(18,4)")
    private BigDecimal MaxMinutes;

    @Column(name = "OTMinutes", nullable = false)
    private int OTMinutes;


    public String getHKEntryId() {
        return HKEntryId;
    }

    public void setHKEntryId(String HKEntryId) {
        this.HKEntryId = HKEntryId;
    }

    public String getHKEntryName() {
        return HKEntryName;
    }

    public void setHKEntryName(String HKEntryName) {
        this.HKEntryName = HKEntryName;
    }

    public BigDecimal getMinMinitues() {
        return MinMinitues;
    }

    public void setMinMinitues(BigDecimal minMinitues) {
        MinMinitues = minMinitues;
    }

    public BigDecimal getMaxMinutes() {
        return MaxMinutes;
    }

    public void setMaxMinutes(BigDecimal maxMinutes) {
        MaxMinutes = maxMinutes;
    }

    public int getOTMinutes() {
        return OTMinutes;
    }

    public void setOTMinutes(int OTMinutes) {
        this.OTMinutes = OTMinutes;
    }
}
