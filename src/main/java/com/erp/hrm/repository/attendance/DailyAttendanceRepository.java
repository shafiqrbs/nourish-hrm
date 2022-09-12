package com.erp.hrm.repository.attendance;

import com.erp.hrm.domain.DailyAttendance;
//import com.erp.hrm.domain.DailyAttendanceReport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Sohag on 26/09/2018.
 */

@Repository
public interface DailyAttendanceRepository extends JpaRepository<DailyAttendance, Long>{

    @Query("SELECT DA.workDate,emp.employeeCode,emp.salutation,emp.firstName,emp.middleName,emp.lastName,emp.punchCardNo," +
           "DA.shiftID,DA.shiftType,DA.pTime,DA.punchType,DA.isManual,DA.isLate,DA.dateApproved,DA.approvedBy,DA.remarks " +
           "FROM DailyAttendance DA " +
           "INNER JOIN EmployeeInfo emp ON DA.employeeCode = emp.employeeCode " +
           "WHERE (DA.workDate BETWEEN :pFromDate AND :pToDate) AND " +
            "(" +
                "LOWER(:pEmpCodeFilter)='all' OR (" +
                "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pFirstNameFilter)='all' OR (" +
                "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
                "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
                "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pPunchCardFilter)='all' OR (" +
                "(LOWER(:pPunchCardOpt) = 'eq' AND LOWER(emp.punchCardNo) = LOWER(:pPunchCardFilter)) OR " +
                "(LOWER(:pPunchCardOpt) = 'neq' AND LOWER(emp.punchCardNo) != LOWER(:pPunchCardFilter)) OR " +
                "(LOWER(:pPunchCardOpt) = 'startswith' AND LOWER(emp.punchCardNo) LIKE CONCAT('', LOWER(:pPunchCardFilter), '%')) OR " +
                "(LOWER(:pPunchCardOpt) = 'endswith' AND LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pPunchCardFilter), '')) OR " +
                "(LOWER(:pPunchCardOpt) = 'contains' AND LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pPunchCardFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pShiftIdFilter)='all' OR (" +
                "(LOWER(:pShiftIdFilterOpt) = 'eq' AND LOWER(DA.shiftID) = LOWER(:pShiftIdFilter)) OR " +
                "(LOWER(:pShiftIdFilterOpt) = 'neq' AND LOWER(DA.shiftID) != LOWER(:pShiftIdFilter)) OR " +
                "(LOWER(:pShiftIdFilterOpt) = 'startswith' AND LOWER(DA.shiftID) LIKE CONCAT('', LOWER(:pShiftIdFilter), '%')) OR " +
                "(LOWER(:pShiftIdFilterOpt) = 'endswith' AND LOWER(DA.shiftID) LIKE CONCAT('%', LOWER(:pShiftIdFilter), '')) OR " +
                "(LOWER(:pShiftIdFilterOpt) = 'contains' AND LOWER(DA.shiftID) LIKE CONCAT('%', LOWER(:pShiftIdFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pShiftTypeFilter)='all' OR (" +
                "(LOWER(:pShiftTypeOpt) = 'eq' AND LOWER(DA.shiftType) = LOWER(:pShiftTypeFilter)) OR " +
                "(LOWER(:pShiftTypeOpt) = 'neq' AND LOWER(DA.shiftType) != LOWER(:pShiftTypeFilter)) OR " +
                "(LOWER(:pShiftTypeOpt) = 'startswith' AND LOWER(DA.shiftType) LIKE CONCAT('', LOWER(:pShiftTypeFilter), '%')) OR " +
                "(LOWER(:pShiftTypeOpt) = 'endswith' AND LOWER(DA.shiftType) LIKE CONCAT('%', LOWER(:pShiftTypeFilter), '')) OR " +
                "(LOWER(:pShiftTypeOpt) = 'contains' AND LOWER(DA.shiftType) LIKE CONCAT('%', LOWER(:pShiftTypeFilter), '%')))" +
            ")"
    )
    Page<Object[]> getAllDailyAttendanceByFilters(
            @Param("pFromDate") Date pFromDate,@Param("pToDate") Date pToDate,
            @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
            @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
            @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
            @Param("pShiftIdFilter") String pShiftIdFilter, @Param("pShiftIdFilterOpt") String pShiftIdFilterOpt,
            @Param("pShiftTypeFilter") String pShiftTypeFilter, @Param("pShiftTypeOpt") String pShiftTypeOpt,
            Pageable pageable
    );

    @Query("SELECT DA.workDate,emp.employeeCode,emp.salutation,emp.firstName,emp.middleName,emp.lastName,emp.punchCardNo," +
            "DA.shiftID,DA.shiftType,DA.pTime,DA.punchType,DA.isManual,DA.isLate,DA.dateApproved,DA.approvedBy,DA.remarks " +
            "FROM DailyAttendance DA " +
            "INNER JOIN EmployeeInfo emp ON DA.employeeCode = emp.employeeCode " +
            "WHERE DA.workDate >= :pFromDate AND DA.workDate <= :pToDate AND DA.punchType IN('In', 'Out') AND " +
            "(" +
            "LOWER(:pEmpCodeFilter)='all' OR (" +
            "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
            "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
            "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
            "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
            "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pFirstNameFilter)='all' OR (" +
            "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
            "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
            "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
            "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
            "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pPunchCardFilter)='all' OR (" +
            "(LOWER(:pPunchCardOpt) = 'eq' AND LOWER(emp.punchCardNo) = LOWER(:pPunchCardFilter)) OR " +
            "(LOWER(:pPunchCardOpt) = 'neq' AND LOWER(emp.punchCardNo) != LOWER(:pPunchCardFilter)) OR " +
            "(LOWER(:pPunchCardOpt) = 'startswith' AND LOWER(emp.punchCardNo) LIKE CONCAT('', LOWER(:pPunchCardFilter), '%')) OR " +
            "(LOWER(:pPunchCardOpt) = 'endswith' AND LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pPunchCardFilter), '')) OR " +
            "(LOWER(:pPunchCardOpt) = 'contains' AND LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pPunchCardFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pShiftIdFilter)='all' OR (" +
            "(LOWER(:pShiftIdFilterOpt) = 'eq' AND LOWER(DA.shiftID) = LOWER(:pShiftIdFilter)) OR " +
            "(LOWER(:pShiftIdFilterOpt) = 'neq' AND LOWER(DA.shiftID) != LOWER(:pShiftIdFilter)) OR " +
            "(LOWER(:pShiftIdFilterOpt) = 'startswith' AND LOWER(DA.shiftID) LIKE CONCAT('', LOWER(:pShiftIdFilter), '%')) OR " +
            "(LOWER(:pShiftIdFilterOpt) = 'endswith' AND LOWER(DA.shiftID) LIKE CONCAT('%', LOWER(:pShiftIdFilter), '')) OR " +
            "(LOWER(:pShiftIdFilterOpt) = 'contains' AND LOWER(DA.shiftID) LIKE CONCAT('%', LOWER(:pShiftIdFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pShiftTypeFilter)='all' OR (" +
            "(LOWER(:pShiftTypeOpt) = 'eq' AND LOWER(DA.shiftType) = LOWER(:pShiftTypeFilter)) OR " +
            "(LOWER(:pShiftTypeOpt) = 'neq' AND LOWER(DA.shiftType) != LOWER(:pShiftTypeFilter)) OR " +
            "(LOWER(:pShiftTypeOpt) = 'startswith' AND LOWER(DA.shiftType) LIKE CONCAT('', LOWER(:pShiftTypeFilter), '%')) OR " +
            "(LOWER(:pShiftTypeOpt) = 'endswith' AND LOWER(DA.shiftType) LIKE CONCAT('%', LOWER(:pShiftTypeFilter), '')) OR " +
            "(LOWER(:pShiftTypeOpt) = 'contains' AND LOWER(DA.shiftType) LIKE CONCAT('%', LOWER(:pShiftTypeFilter), '%')))" +
            ") " +
            "ORDER BY DA.workDate ASC"

    )
    Page<Object[]> getAllHistoryByFiltersWithDate(
            @Param("pFromDate") Date pFromDate,@Param("pToDate") Date pToDate,
            @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
            @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
            @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
            @Param("pShiftIdFilter") String pShiftIdFilter, @Param("pShiftIdFilterOpt") String pShiftIdFilterOpt,
            @Param("pShiftTypeFilter") String pShiftTypeFilter, @Param("pShiftTypeOpt") String pShiftTypeOpt,
            Pageable pageable
    );

    @Query(value = "SELECT DA.workDate,emp.employeeCode,emp.salutation,emp.firstName,emp.middleName,emp.lastName,emp.punchCardNo," +
            "DA.shiftID,DA.shiftType,DA.pTime,DA.punchType,DA.isManual,DA.isLate,DA.dateApproved,DA.approvedBy,DA.remarks " +
            "FROM DailyAttendance DA " +
            "INNER JOIN EmployeeInfo emp ON DA.employeeCode = emp.employeeCode " +
            "WHERE DA.punchType in('In', 'Out') AND " +
            "(" +
            "LOWER(:pEmpCodeFilter)='all' OR (" +
            "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
            "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
            "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
            "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
            "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pFirstNameFilter)='all' OR (" +
            "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
            "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
            "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
            "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
            "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pPunchCardFilter)='all' OR (" +
            "(LOWER(:pPunchCardOpt) = 'eq' AND LOWER(emp.punchCardNo) = LOWER(:pPunchCardFilter)) OR " +
            "(LOWER(:pPunchCardOpt) = 'neq' AND LOWER(emp.punchCardNo) != LOWER(:pPunchCardFilter)) OR " +
            "(LOWER(:pPunchCardOpt) = 'startswith' AND LOWER(emp.punchCardNo) LIKE CONCAT('', LOWER(:pPunchCardFilter), '%')) OR " +
            "(LOWER(:pPunchCardOpt) = 'endswith' AND LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pPunchCardFilter), '')) OR " +
            "(LOWER(:pPunchCardOpt) = 'contains' AND LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pPunchCardFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pShiftIdFilter)='all' OR (" +
            "(LOWER(:pShiftIdFilterOpt) = 'eq' AND LOWER(DA.shiftID) = LOWER(:pShiftIdFilter)) OR " +
            "(LOWER(:pShiftIdFilterOpt) = 'neq' AND LOWER(DA.shiftID) != LOWER(:pShiftIdFilter)) OR " +
            "(LOWER(:pShiftIdFilterOpt) = 'startswith' AND LOWER(DA.shiftID) LIKE CONCAT('', LOWER(:pShiftIdFilter), '%')) OR " +
            "(LOWER(:pShiftIdFilterOpt) = 'endswith' AND LOWER(DA.shiftID) LIKE CONCAT('%', LOWER(:pShiftIdFilter), '')) OR " +
            "(LOWER(:pShiftIdFilterOpt) = 'contains' AND LOWER(DA.shiftID) LIKE CONCAT('%', LOWER(:pShiftIdFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pShiftTypeFilter)='all' OR (" +
            "(LOWER(:pShiftTypeOpt) = 'eq' AND LOWER(DA.shiftType) = LOWER(:pShiftTypeFilter)) OR " +
            "(LOWER(:pShiftTypeOpt) = 'neq' AND LOWER(DA.shiftType) != LOWER(:pShiftTypeFilter)) OR " +
            "(LOWER(:pShiftTypeOpt) = 'startswith' AND LOWER(DA.shiftType) LIKE CONCAT('', LOWER(:pShiftTypeFilter), '%')) OR " +
            "(LOWER(:pShiftTypeOpt) = 'endswith' AND LOWER(DA.shiftType) LIKE CONCAT('%', LOWER(:pShiftTypeFilter), '')) OR " +
            "(LOWER(:pShiftTypeOpt) = 'contains' AND LOWER(DA.shiftType) LIKE CONCAT('%', LOWER(:pShiftTypeFilter), '%')))" +
            ")" +
            "ORDER BY DA.workDate ASC"
    )
    Page<Object[]> getAllHistoryByFiltersWithOutDate(
            @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
            @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
            @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
            @Param("pShiftIdFilter") String pShiftIdFilter, @Param("pShiftIdFilterOpt") String pShiftIdFilterOpt,
            @Param("pShiftTypeFilter") String pShiftTypeFilter, @Param("pShiftTypeOpt") String pShiftTypeOpt,
            Pageable pageable
    );



    @Query("SELECT COUNT(DA.id) FROM DailyAttendance DA WHERE DA.employeeCode= :pEmployeeCode")
    int getAllDailyAttendanceCountByEmployeeCode(@Param("pEmployeeCode") String pEmployeeCode);

    @Query("SELECT COUNT(DA.id) FROM DailyAttendance DA WHERE DA.employeeCode= :pEmployeeCode AND DA.workDate= :pWorkingDate")
    int getAttendanceCountByEmployeeCodeAndDate(@Param("pEmployeeCode") String pEmployeeCode, @Param("pWorkingDate") Date pWorkingDate);

    @Query("SELECT DISTINCT EPR.employeeCode,coalesce(EPR.punchCardNo,''),EPR.employeeName,EPR.doj,EPR.department,EPR.section," +
                "EPR.designation,coalesce(EPR.unit,''),coalesce(EPR.floor,''),coalesce(EPR.line,'')," +
                "coalesce(EPR.staffCategory,''),coalesce(EPR.shiftID,''),SR.ShiftDate,coalesce(Da.pTime,SR.ShiftDate)," +
                "coalesce(Da2.pTime,SR.ShiftDate),SP.inTime,SP.outTime,SP.outTimeEndMargin,SP.workingHour," +
                "coalesce(WOC.dayType,''),coalesce(ELTA.transactionID,0),coalesce(DAR.id,0) " +
            " FROM EmployeeReport EPR " +
            " INNER JOIN ShiftRoster SR ON EPR.employeeCode = SR.EmployeeCode " +
                " AND SR.ShiftDate = :pWorkDate" +
            " INNER JOIN ShiftPlan SP ON SR.ShiftID = SP.shiftID " +
            " LEFT OUTER JOIN WorkOffCalendar WOC ON EPR.employeeCode = WOC.employeeCode " +
                " AND SR.ShiftDate = WOC.workOffDate AND WOC.workOffDate = :pWorkDate "+
            " LEFT OUTER JOIN DailyAttendance Da ON EPR.employeeCode = Da.employeeCode " +
                " AND Da.punchType='In'" +
                " AND Da.workDate = :pWorkDate" +
                " AND Da.isReportProcessed = false " +
            " LEFT OUTER JOIN DailyAttendance Da2 ON EPR.employeeCode = Da2.employeeCode" +
                " AND Da2.punchType = 'Out' " +
                " AND Da2.workDate = :pWorkDate" +
                " AND Da2.isReportProcessed = false " +
            " LEFT OUTER JOIN EmpLeaveTransactionApplied ELTA ON EPR.employeeCode = ELTA.employeeInfo.employeeCode" +
                " AND SR.ShiftDate BETWEEN ELTA.fromDate AND  ELTA.toDate " +
            " LEFT OUTER JOIN DailyAttendanceReport DAR ON EPR.employeeCode = DAR.employeeCode AND DAR.workDate = :pWorkDate" +
            " WHERE EPR.employeeStatus='Active'" )
    List<Object[]> getProcessableAttendance(@Param("pWorkDate") Date pWorkDate);

    @Query("SELECT DISTINCT DA.workDate " +
            " FROM DailyAttendance DA " +
            " WHERE DA.isReportProcessed = false " +
            " ORDER BY DA.workDate ASC" )
    List<Date> getProcessableDates();

    @Transactional
    @Modifying
    @Query("UPDATE DailyAttendance SET isReportProcessed = true " +
            " WHERE isReportProcessed = false AND workDate IN(:dates)" )
    int updateAttendanceProcessStatus(@Param("dates") List<Date> dates);
}
