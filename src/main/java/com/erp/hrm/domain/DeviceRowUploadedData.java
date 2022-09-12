package com.erp.hrm.domain;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by WS on 04/08/2018.
 */
@Entity
@Table( name = "DeviceRowUploadedData" )
public class DeviceRowUploadedData extends BaseEntity {

    @Column(name = "readerName")
    private String readerName;

    @Column(name = "UserId")
    private String userId;

    @Column(name = "PunchDate")
    private Date punchDate;

    @Column(name = "PunchTime")
    private String punchTime;

    @Column(name = "UserActivityStatus")
    private String userActivityStatus;

    @Column(name = "PunchType")
    private String punchType;

    @Column(name = "PTime")
    private Date pTime;

    @Column(name = "AttFileId",nullable = false, columnDefinition = "BIGINT CONSTRAINT DF_DeviceRowUploadedData_AttFileId  DEFAULT 0")
    private long attFileId;

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getPunchDate() {
        return punchDate;
    }

    public void setPunchDate(Date punchDate) {
        this.punchDate = punchDate;
    }

    public String getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(String punchTime) {
        this.punchTime = punchTime;
    }

    public String getUserActivityStatus() {
        return userActivityStatus;
    }

    public void setUserActivityStatus(String userActivityStatus) {
        this.userActivityStatus = userActivityStatus;
    }

    public String getPunchType() {
        return punchType;
    }

    public void setPunchType(String punchType) {
        this.punchType = punchType;
    }

    public Date getpTime() {
        return pTime;
    }

    public void setpTime(Date pTime) {
        this.pTime = pTime;
    }

    public long getAttFileId() {
        return attFileId;
    }

    public void setAttFileId(long attFileId) {
        this.attFileId = attFileId;
    }
}
