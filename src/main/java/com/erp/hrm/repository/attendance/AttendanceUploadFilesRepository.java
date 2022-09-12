package com.erp.hrm.repository.attendance;

import com.erp.hrm.domain.AttendanceUploadedFiles;
import com.erp.hrm.domain.DailyAttendance;
import com.erp.hrm.domain.DeviceRowDataTemp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 28/11/2018.
 */

@Repository
public interface AttendanceUploadFilesRepository extends JpaRepository<AttendanceUploadedFiles, Long>{
    @Query("SELECT auf FROM AttendanceUploadedFiles auf WHERE auf.uploadedStatus <> 'success' ORDER BY auf.fileName ASC")
    List<AttendanceUploadedFiles> getAllUploadFiles();

    @Query("SELECT auf FROM AttendanceUploadedFiles auf WHERE auf.uploadedStatus='initial' ORDER BY auf.fileName ASC")
    List<AttendanceUploadedFiles> getAllUploadingInitialFiles();

    @Query("SELECT auf FROM AttendanceUploadedFiles auf WHERE auf.uploadedStatus='pending' ORDER BY auf.fileName ASC")
    List<AttendanceUploadedFiles> getAllPendingFiles();

    @Query("SELECT auf FROM AttendanceUploadedFiles auf WHERE auf.uploadedStatus='process pending' ORDER BY auf.fileName ASC")
    List<AttendanceUploadedFiles> getProcessableFiles();

    @Query("SELECT auf FROM AttendanceUploadedFiles auf WHERE auf.fileName= :pFileName AND auf.fileType= :pFileType")
    AttendanceUploadedFiles getAttendanceFilesIfExists(@Param("pFileName")String pFileName, @Param("pFileType")String pFileType);

    @Query("SELECT DTD FROM DeviceRowDataTemp DTD WHERE DTD.attnUploadedFileId= :pAttnUploadedFileId AND DTD.isProcessed = 0  ORDER BY employeeCode,punchTime")
    List<DeviceRowDataTemp> getAllDeviceTempDataByFileId(@Param("pAttnUploadedFileId")long pAttnUploadedFileId);

    @Query("SELECT DTD.employeeCode,DTD.workDate,DTD.shiftID,DTD.shiftType,DTD.punchType,MAX(DTD.punchTime) " +
            " FROM DeviceRowDataTemp DTD " +
            " LEFT OUTER JOIN DailyAttendance DA ON DTD.employeeCode = DA.employeeCode " +
                " AND DTD.workDate = DA.workDate "+
                " AND DTD.shiftID = DA.shiftID "+
                " AND DTD.shiftType = DA.shiftType "+
                " AND DTD.punchType = DA.punchType "+
            " WHERE DTD.attnUploadedFileId= :pAttnUploadedFileId AND DTD.isProcessed = 0 AND DA.id IS NULL" +
            " GROUP BY DTD.employeeCode,DTD.workDate,DTD.shiftID,DTD.shiftType,DTD.punchType" +
            " ORDER BY DTD.employeeCode")
    List<Object[]> getProcessableAttendanceDataWithObject(@Param("pAttnUploadedFileId")long pAttnUploadedFileId);


    @Query("SELECT new com.erp.hrm.domain.DailyAttendance( DTD.employeeCode,DTD.workDate,DTD.shiftID,DTD.shiftType,DTD.punchType," +
            " MAX(DTD.punchTime))" +
            " FROM DeviceRowDataTemp DTD " +
            " WHERE DTD.isProcessed = 0 " +
            " GROUP BY DTD.employeeCode,DTD.workDate,DTD.shiftID,DTD.shiftType,DTD.punchType" +
            " ORDER BY DTD.employeeCode")
    List<DeviceRowDataTemp> getAllProcessableAttendanceData();
}
