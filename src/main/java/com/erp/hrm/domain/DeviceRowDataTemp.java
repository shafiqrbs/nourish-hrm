package com.erp.hrm.domain;

import com.erp.hrm.util.DateUtils;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.text.ParseException;
import java.util.Date;

/**
 * Created by WS on 04/08/2018.
 */
@Entity
@Table( name = "DeviceRowDataTemp" )
public class DeviceRowDataTemp extends BaseEntity   {

    @Size(max = 20)
    @Column(name = "EmployeeCode", nullable = false)
    private String employeeCode;

    @Column(name = "PTime")
    private Date punchTime;

    @Column(name = "WorkDate")
    private Date workDate;

    @Column(name = "PunchCardNo")
    private String punchCardNo;

    @Column(name = "PunchType")
    private String punchType;

    @Column(name = "DeviceID")
    private String deviceID;

    @Column(name = "IsBCSynchronize",columnDefinition = "BIT CONSTRAINT DF_DeviceRowDataTemp_IsBCSynchronize DEFAULT 0")
    private boolean isBCSynchronize;

    @Column(name = "AttnUploadedFileId")
    private long attnUploadedFileId;

    @Column(name = "IsProcessed" , nullable = false, columnDefinition = "BIT CONSTRAINT DF_DeviceRowDataTemp_IsProcessed  DEFAULT 0")
    private boolean isProcessed;

    @Size(max = 20)
    @NotNull
    @Column(name = "ShiftID",nullable = false)
    private String shiftID;

    @Size(max = 20)
    @NotNull
    @Column(name = "ShiftType",nullable = false)
    private String shiftType;

    @Column(name = "IsLate" , nullable = false, columnDefinition = "BIT CONSTRAINT DF_DeviceRowDataTemp_IsLate  DEFAULT 0")
    private boolean isLate;

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public Date getPunchTime() {
        return punchTime;
    }

    public void setPunchTime(Date punchTime) {
        this.punchTime = punchTime;
    }

    public Date getWorkDate() {
        return workDate;
    }

    public void setWorkDate(Date workDate) {
        this.workDate = workDate;
    }

    public String getPunchCardNo() {
        return punchCardNo;
    }

    public void setPunchCardNo(String punchCardNo) {
        this.punchCardNo = punchCardNo;
    }

    public String getPunchType() {
        return punchType;
    }

    public void setPunchType(String punchType) {
        this.punchType = punchType;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    public boolean isBCSynchronize() {
        return isBCSynchronize;
    }

    public void setBCSynchronize(boolean BCSynchronize) {
        isBCSynchronize = BCSynchronize;
    }

    public long getAttnUploadedFileId() {
        return attnUploadedFileId;
    }

    public void setAttnUploadedFileId(long attnUploadedFileId) {
        this.attnUploadedFileId = attnUploadedFileId;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean processed) {
        isProcessed = processed;
    }

    public boolean isLate() {
        return isLate;
    }

    public void setLate(boolean late) {
        isLate = late;
    }

    @NotNull
    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(@NotNull String shiftID) {
        this.shiftID = shiftID;
    }

    @NotNull
    public String getShiftType() {
        return shiftType;
    }

    public void setShiftType(@NotNull String shiftType) {
        this.shiftType = shiftType;
    }

    public DeviceRowDataTemp() {
    }

    /*public DeviceRowDataTemp(String employeeCode, String punchCardNo,String deviceID,Date workDate,Date punchTime,String shiftType, String shiftID,
                             String inTime,String outTime, String lunchInTime,String lunchOutTime) {
        this.employeeCode = employeeCode;
        this.punchTime = punchTime;
        this.workDate = workDate;
        this.punchCardNo = punchCardNo;
        this.deviceID = deviceID;
        this.shiftType = shiftType;
        this.shiftID = shiftID;

        try {
            Date pInTime = DateUtils.parse(DateUtils.format(workDate, "yyyy-MM-dd") + " " + inTime);
            Date pOutTime = DateUtils.parse(DateUtils.format(workDate, "yyyy-MM-dd") + " " + outTime);
            Date pLunchInTime = DateUtils.parse(DateUtils.format(workDate, "yyyy-MM-dd") + " " + lunchInTime);
            Date pLunchOutTime = DateUtils.parse(DateUtils.format(workDate, "yyyy-MM-dd") + " " + lunchOutTime);

            this.isLate =false;

            if (pOutTime.before(punchTime) || pOutTime.equals(punchTime)) {
                this.punchType = "Out";
            } else if (pLunchInTime.before(punchTime) || pLunchInTime.equals(punchTime)) {
                this.punchType = "LIn";
            } else if (pLunchOutTime.before(punchTime) || pLunchOutTime.equals(punchTime)) {
                this.punchType = "LOut";
            } else if (pInTime.before(punchTime)) {
                this.punchType = "In";
                this.isLate = true;
            } else {
                this.punchType = "In";
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
*/
    public DeviceRowDataTemp(String employeeCode, DeviceRowUploadedData data,ShiftPlan shiftPlan) {
        this.employeeCode = employeeCode;
        this.punchTime = data.getpTime();
        this.workDate = data.getPunchDate();
        this.punchCardNo = data.getUserId();
        this.deviceID = data.getReaderName();
        this.shiftType = shiftPlan.getShiftType();
        this.shiftID = shiftPlan.getShiftID();
        this.attnUploadedFileId = data.getAttFileId();


        Date pInTime = DateUtils.getDateTime(workDate, shiftPlan.getInTime());
        Date pOutTime = DateUtils.getDateTime(workDate, shiftPlan.getOutTime());
        Date pLunchInTime = DateUtils.getDateTime(workDate,shiftPlan.getLunchInTime());
        Date pLunchOutTime = DateUtils.getDateTime(workDate, shiftPlan.getLunchOutTime());

        this.isLate =false;

        if (pOutTime.before(punchTime) || pOutTime.equals(punchTime)) {
            this.punchType = "Out";
        } else if (pLunchInTime.before(punchTime) || pLunchInTime.equals(punchTime)) {
            this.punchType = "LIn";
        } else if (pLunchOutTime.before(punchTime) || pLunchOutTime.equals(punchTime)) {
            this.punchType = "LOut";
        } else if (pInTime.before(punchTime)) {
            this.punchType = "In";
            this.isLate = true;
        } else {
            this.punchType = "In";
        }
    }

}
