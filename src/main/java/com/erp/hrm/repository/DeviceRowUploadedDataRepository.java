package com.erp.hrm.repository;

import com.erp.hrm.domain.DeviceRowDataTemp;
import com.erp.hrm.domain.DeviceRowUploadedData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by WS on 04/08/2018.
 */
@Repository
public interface DeviceRowUploadedDataRepository extends JpaRepository<DeviceRowUploadedData, Long>{

  /*  @Query("SELECT new com.erp.hrm.domain.DeviceRowDataTemp( EMP.employeeCode,DRUD.userId,DRUD.readerName,DRUD.punchDate,DRUD.pTime," +
            " SP.shiftID,SP.shiftType, SP.inTime,SP.outTime,SP.lunchInTime, SP.lunchOutTime)" +
            " FROM DeviceRowUploadedData DRUD " +
            " INNER JOIN EmployeeInfo EMP ON DRUD.userId = EMP.punchCardNo " +
            " INNER JOIN ShiftRoster SR ON EMP.employeeCode = SR.EmployeeCode AND DRUD.punchDate = SR.ShiftDate " +
            " INNER JOIN ShiftPlan SP ON  SR.ShiftID = SP.shiftID " +
            " LEFT OUTER JOIN DeviceRowDataTemp DRDT ON DRUD.userId = DRDT.punchCardNo AND " +
            " DRUD.pTime = DRDT.punchTime " +
            " WHERE DRDT.workDate IS NULL"
    )
    List<DeviceRowDataTemp> getUploadedDevice();*/

    @Query("SELECT new com.erp.hrm.domain.DeviceRowDataTemp( EMP.employeeCode,DRUD,SP)" +
            " FROM DeviceRowUploadedData DRUD " +
            " INNER JOIN EmployeeInfo EMP ON DRUD.userId = EMP.punchCardNo " +
            " INNER JOIN ShiftRoster SR ON EMP.employeeCode = SR.EmployeeCode AND DRUD.punchDate = SR.ShiftDate " +
            " INNER JOIN ShiftPlan SP ON  SR.ShiftID = SP.shiftID " +
            " LEFT OUTER JOIN DeviceRowDataTemp DRDT ON DRUD.userId = DRDT.punchCardNo AND " +
            " DRUD.pTime = DRDT.punchTime " +
            " WHERE DRDT.workDate IS NULL"
    )
    List<DeviceRowDataTemp> getUploadedDeviceTest();

    @Query("SELECT EMP.employeeCode,DRUD.pTime,DRUD.punchDate,DRUD.userId,DRUD.readerName,DRUD.attFileId," +
            "SP.shiftType,SP.shiftID,SP.inTime,SP.outTime,SP.lunchInTime,SP.lunchOutTime " +
            " FROM DeviceRowUploadedData DRUD " +
            " INNER JOIN EmployeeInfo EMP ON DRUD.userId = EMP.punchCardNo " +
            " INNER JOIN ShiftRoster SR ON EMP.employeeCode = SR.EmployeeCode AND DRUD.punchDate = SR.ShiftDate " +
            " INNER JOIN ShiftPlan SP ON  SR.ShiftID = SP.shiftID " +
            " LEFT OUTER JOIN DeviceRowDataTemp DRDT ON DRUD.userId = DRDT.punchCardNo AND " +
                " DRUD.pTime = DRDT.punchTime AND DRUD.punchDate = DRDT.workDate " +
            " WHERE DRDT.workDate IS NULL"
    )
    List<Object[]> getUploadedDevice();
}




