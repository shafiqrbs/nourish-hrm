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
@Table( name = "OTSlot", uniqueConstraints = { @UniqueConstraint( name = "UK_OTSlot",columnNames = { "SlotID" } ) } )
public class OTSlot extends BaseEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "SlotID",nullable = false)
    private String SlotID;

    @Size(max = 250)
    @Column(name = "SlotDescription")
    private String SlotDescription;

    @Column(name = "StartTime", nullable = false)
    private Date StartTime;

    @Column(name = "EndTime", nullable = false)
    private Date EndTime;

    @Column(name = "Rate", columnDefinition = "NUMERIC(18,2)")
    private BigDecimal Rate;

    @Size(max = 50)
    @Column(name = "ReportingHead")
    private String ReportingHead;

    public String getSlotID() {
        return SlotID;
    }

    public void setSlotID(String slotID) {
        SlotID = slotID;
    }

    public String getSlotDescription() {
        return SlotDescription;
    }

    public void setSlotDescription(String slotDescription) {
        SlotDescription = slotDescription;
    }

    public Date getStartTime() {
        return StartTime;
    }

    public void setStartTime(Date startTime) {
        StartTime = startTime;
    }

    public Date getEndTime() {
        return EndTime;
    }

    public void setEndTime(Date endTime) {
        EndTime = endTime;
    }

    public BigDecimal getRate() {
        return Rate;
    }

    public void setRate(BigDecimal rate) {
        Rate = rate;
    }

    public String getReportingHead() {
        return ReportingHead;
    }

    public void setReportingHead(String reportingHead) {
        ReportingHead = reportingHead;
    }
}
