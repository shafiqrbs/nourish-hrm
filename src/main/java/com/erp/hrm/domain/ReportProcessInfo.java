package com.erp.hrm.domain;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Sohag on 09/05/2018.
 */
@Entity
@Table( name = "ReportProcessInfo" )
public class ReportProcessInfo extends BaseIntEntity {

    @Size(max = 64)
    @Column(name = "ProcessName")
    private String processName;

    @Column(name = "ProcessDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date processDate;

    @Size(max = 16)
    @Column(name = "ProcessStatus",nullable = false)
    private String processStatus;

    @Size(max = 16)
    @Column(name = "ProcessBy",nullable = false)
    private String processBy;

    public String getProcessName() {
        return processName;
    }

    public void setProcessName(String processName) {
        this.processName = processName;
    }

    public Date getProcessDate() {
        return processDate;
    }

    public void setProcessDate(Date processDate) {
        this.processDate = processDate;
    }

    public String getProcessStatus() {
        return processStatus;
    }

    public void setProcessStatus(String processStatus) {
        this.processStatus = processStatus;
    }

    public String getProcessBy() {
        return processBy;
    }

    public void setProcessBy(String processBy) {
        this.processBy = processBy;
    }
}
