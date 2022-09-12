package com.erp.hrm.repository.reports;

import com.erp.hrm.domain.DailyAttendanceReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Sohag on 10/03/2019.
 */
public interface DailyAttendanceReportRepository extends JpaRepository<DailyAttendanceReport, Long>{

    @Query("SELECT DAR FROM DailyAttendanceReport DAR " +
            "WHERE DAR.workDate = :pWorkDateFilter " +
                "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "ORDER BY DAR.department,DAR.section ASC"
        )
    List<DailyAttendanceReport> findAllAttendanceInfoByDate(
            @Param("pWorkDateFilter") Date pWorkDateFilter,
            @Param("pEmpCodeFilter") String pEmpCodeFilter,
            @Param("pPunchCardFilter") String pPunchCardFilter,
            @Param("pUnitFilter") String pUnitFilter,
            @Param("pFloorFilter") String pFloorFilter,
            @Param("pLineFilter") String pLineFilter,
            @Param("pDepartmentFilter") String pDepartmentFilter,
            @Param("pSectionFilter") String pSectionFilter,
            @Param("pDesignationFilter") String pDesignationFilter,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter
    );

    @Query("SELECT DAR FROM DailyAttendanceReport DAR " +
            "WHERE DAR.workDate BETWEEN :pWorkFromDateFilter AND :pWorkToDateFilter " +
                "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "ORDER BY DAR.department,DAR.section ASC"
    )
    List<DailyAttendanceReport> findAllAttendanceInfoByDateRange(
            @Param("pWorkFromDateFilter") Date pWorkFromDateFilter,
            @Param("pWorkToDateFilter") Date pWorkToDateFilter,
            @Param("pEmpCodeFilter") String pEmpCodeFilter,
            @Param("pPunchCardFilter") String pPunchCardFilter,
            @Param("pUnitFilter") String pUnitFilter,
            @Param("pFloorFilter") String pFloorFilter,
            @Param("pLineFilter") String pLineFilter,
            @Param("pDepartmentFilter") String pDepartmentFilter,
            @Param("pSectionFilter") String pSectionFilter,
            @Param("pDesignationFilter") String pDesignationFilter,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter
    );

    @Query("SELECT DAR FROM DailyAttendanceReport DAR " +
            "WHERE DAR.workDate = :pWorkDateFilter " +
                "AND LOWER(DAR.dayStatus)=LOWER(:pDayStatus) " +
                "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "ORDER BY DAR.department,DAR.section ASC"
    )
    List<DailyAttendanceReport> findAllAttendanceInfoByDateByDayStatus(
            @Param("pWorkDateFilter") Date pWorkDateFilter,
            @Param("pEmpCodeFilter") String pEmpCodeFilter,
            @Param("pPunchCardFilter") String pPunchCardFilter,
            @Param("pUnitFilter") String pUnitFilter,
            @Param("pFloorFilter") String pFloorFilter,
            @Param("pLineFilter") String pLineFilter,
            @Param("pDepartmentFilter") String pDepartmentFilter,
            @Param("pSectionFilter") String pSectionFilter,
            @Param("pDesignationFilter") String pDesignationFilter,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter,
            @Param("pDayStatus") String pDayStatus
    );

    @Query("SELECT DAR FROM DailyAttendanceReport DAR " +
            "WHERE DAR.workDate = :pWorkDateFilter " +
                "AND LOWER(DAR.dayStatus)='p' " +
                "AND LOWER(DAR.late)=LOWER(:pLateStatus) " +
                "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "ORDER BY DAR.department,DAR.section ASC"
    )
    List<DailyAttendanceReport> findAllLateAttendanceInfoByDate(
            @Param("pWorkDateFilter") Date pWorkDateFilter,
            @Param("pEmpCodeFilter") String pEmpCodeFilter,
            @Param("pPunchCardFilter") String pPunchCardFilter,
            @Param("pUnitFilter") String pUnitFilter,
            @Param("pFloorFilter") String pFloorFilter,
            @Param("pLineFilter") String pLineFilter,
            @Param("pDepartmentFilter") String pDepartmentFilter,
            @Param("pSectionFilter") String pSectionFilter,
            @Param("pDesignationFilter") String pDesignationFilter,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter,
            @Param("pLateStatus") String pLateStatus
    );

    @Query("SELECT DAR FROM DailyAttendanceReport DAR " +
            "WHERE DAR.dayStatus=(:pDayStatus) " +
                "AND DAR.workDate BETWEEN :pWorkFromDateFilter AND :pWorkToDateFilter " +
                "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "ORDER BY DAR.department,DAR.section ASC"
    )
    List<DailyAttendanceReport> findAllAttendanceInfoByDateRangeByDayStatus(
            @Param("pWorkFromDateFilter") Date pWorkFromDateFilter,
            @Param("pWorkToDateFilter") Date pWorkToDateFilter,
            @Param("pEmpCodeFilter") String pEmpCodeFilter,
            @Param("pPunchCardFilter") String pPunchCardFilter,
            @Param("pUnitFilter") String pUnitFilter,
            @Param("pFloorFilter") String pFloorFilter,
            @Param("pLineFilter") String pLineFilter,
            @Param("pDepartmentFilter") String pDepartmentFilter,
            @Param("pSectionFilter") String pSectionFilter,
            @Param("pDesignationFilter") String pDesignationFilter,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter,
            @Param("pDayStatus") String pDayStatus
    );

    @Query("SELECT DAR FROM DailyAttendanceReport DAR " +
            "WHERE DAR.workDate = :pWorkDateFilter " +
                "AND DAR.punchInTime IS NULL " +
                "AND DAR.punchOutTime IS NOT NULL " +
                "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "ORDER BY DAR.department,DAR.section ASC"
    )
    List<DailyAttendanceReport> findAllInPunchMissingAttnInfoByDate(
            @Param("pWorkDateFilter") Date pWorkDateFilter,
            @Param("pEmpCodeFilter") String pEmpCodeFilter,
            @Param("pPunchCardFilter") String pPunchCardFilter,
            @Param("pUnitFilter") String pUnitFilter,
            @Param("pFloorFilter") String pFloorFilter,
            @Param("pLineFilter") String pLineFilter,
            @Param("pDepartmentFilter") String pDepartmentFilter,
            @Param("pSectionFilter") String pSectionFilter,
            @Param("pDesignationFilter") String pDesignationFilter,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter
    );

    @Query("SELECT DAR FROM DailyAttendanceReport DAR " +
            "WHERE DAR.workDate = :pWorkDateFilter " +
                "AND DAR.punchInTime IS NOT NULL " +
                "AND DAR.punchOutTime IS NULL " +
                "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "ORDER BY DAR.department,DAR.section ASC"
    )
    List<DailyAttendanceReport> findAllOutPunchMissingAttnInfoByDate(
            @Param("pWorkDateFilter") Date pWorkDateFilter,
            @Param("pEmpCodeFilter") String pEmpCodeFilter,
            @Param("pPunchCardFilter") String pPunchCardFilter,
            @Param("pUnitFilter") String pUnitFilter,
            @Param("pFloorFilter") String pFloorFilter,
            @Param("pLineFilter") String pLineFilter,
            @Param("pDepartmentFilter") String pDepartmentFilter,
            @Param("pSectionFilter") String pSectionFilter,
            @Param("pDesignationFilter") String pDesignationFilter,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter
    );

    @Query("SELECT DAR.unit,DAR.line,DAR.designation,COUNT(DAR.employeeCode) AS activeEmployee, " +
                "COUNT(PEMP.employeeCode) AS presentEmployee,COUNT(AEMP.employeeCode) AS absentEmployee, " +
                "COUNT(LEMP.employeeCode) AS lateEmployee,COUNT(LVEMP.employeeCode) AS leaveEmployee, " +
                "0 AS newEmployee,0 AS separatedEmployee "+
            "FROM DailyAttendanceReport DAR " +
            "INNER JOIN EmployeeReport EPR ON DAR.employeeCode = EPR.employeeCode " +
                "AND DAR.workDate=:pWorkDateFilter " +
                "AND DAR.employeeStatus='Active' " +
            "LEFT OUTER JOIN DailyAttendanceReport PEMP ON DAR.employeeCode = PEMP.employeeCode " +
                "AND PEMP.dayStatus='P' " +
                "AND PEMP.workDate=:pWorkDateFilter " +
            "LEFT OUTER JOIN DailyAttendanceReport AEMP ON DAR.employeeCode = AEMP.employeeCode " +
                "AND AEMP.dayStatus='A' " +
                "AND AEMP.workDate=:pWorkDateFilter " +
            "LEFT OUTER JOIN DailyAttendanceReport LEMP ON DAR.employeeCode = LEMP.employeeCode " +
                "AND LEMP.dayStatus='P' " +
                "AND LEMP.late='L' " +
                "AND LEMP.workDate=:pWorkDateFilter " +
            "LEFT OUTER JOIN DailyAttendanceReport LVEMP ON DAR.employeeCode = LVEMP.employeeCode " +
                "AND LVEMP.dayStatus='LV' " +
                "AND LVEMP.workDate=:pWorkDateFilter " +
            "WHERE DAR.workDate = :pWorkDateFilter " +
                "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "GROUP BY DAR.unit,DAR.line,DAR.designation " +
            "ORDER BY DAR.unit,DAR.line,DAR.designation"
    )
    List<Object[]> findAllLineWiseAttendanceReport(
            @Param("pWorkDateFilter") Date pWorkDateFilter,
            @Param("pEmpCodeFilter") String pEmpCodeFilter,
            @Param("pPunchCardFilter") String pPunchCardFilter,
            @Param("pUnitFilter") String pUnitFilter,
            @Param("pFloorFilter") String pFloorFilter,
            @Param("pLineFilter") String pLineFilter,
            @Param("pDepartmentFilter") String pDepartmentFilter,
            @Param("pSectionFilter") String pSectionFilter,
            @Param("pDesignationFilter") String pDesignationFilter,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter
    );

    @Query( "SELECT DAR.unit,DAR.department ,DAR.designation " +
                ",COUNT( DAR.employeeCode ) AS totalEmployee " +
                ",SUM( CASE WHEN DAR.dayStatus = 'P' THEN 1 ELSE 0 END) AS present " +
                ",SUM( CASE WHEN DAR.dayStatus = 'A' THEN 1 ELSE 0 END) AS absent " +
                ",SUM( CASE WHEN DAR.dayStatus = 'LV' THEN 1 ELSE 0 END) AS leave " +
                ",SUM( CASE WHEN DAR.late = 'L' THEN 1 ELSE 0 END) AS late " +
                ",0 AS newEmployee " +
                ",0 AS leftEmployee " +
                ",'' AS remarks " +
            "FROM DailyAttendanceReport AS DAR " +
            "WHERE DAR.workDate = :pWorkDateFilter " +
                "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
                "AND DAR.employeeStatus = 'Active' " +
            "GROUP BY DAR.unit, DAR.department, DAR.designation " +
            "ORDER BY DAR.unit, DAR.department, DAR.designation ASC " )
    List<Object[]> findAllWorkDateWiseAttendanceReport(
            @Param("pWorkDateFilter") Date pWorkDateFilter,
            @Param("pUnitFilter") String pUnitFilter,
            @Param("pDepartmentFilter") String pDepartmentFilter,
            @Param("pDesignationFilter") String pDesignationFilter
    );
//
//    @Query("SELECT SWE.unit, SWE.designation, SWE.line, DAR.employeeCode, DAR.employeeName, DAR.punchCardNo " +
//            "FROM DailyAttendanceReport DAR " +
//            "LEFT JOIN SalaryWiseEmployeeInfoReport AS SWE ON DAR.employeeCode = SWE.employeeCode " +
//            "LEFT JOIN MonthWiseSalaryReport AS MWS ON DAR.EmployeeCode = MWS.EmployeeCode " +
//                "WHERE DAR.WorkDate BETWEEN '2016-01-01' AND '2016-01-31'" +
//            "AND DAR.workDate = :pWorkDateFilter " +
//            "AND DAR.punchInTime IS NOT NULL " +
//            "AND DAR.punchOutTime IS NULL " +
//            "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
//            "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
//            "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
//            "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
//            "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
//            "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
//            "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
//            "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
//            "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
//            "ORDER BY DAR.department,DAR.section ASC"
//    )
//    List<DailyAttendanceReport> findAllEmployeeAttendanceHistoryforBuyerReport(
//            @Param("pWorkDateFilter") Date pWorkDateFilter,
//            @Param("pEmpCodeFilter") String pEmpCodeFilter,
//            @Param("pPunchCardFilter") String pPunchCardFilter,
//            @Param("pUnitFilter") String pUnitFilter,
//            @Param("pFloorFilter") String pFloorFilter,
//            @Param("pLineFilter") String pLineFilter,
//            @Param("pDepartmentFilter") String pDepartmentFilter,
//            @Param("pSectionFilter") String pSectionFilter,
//            @Param("pDesignationFilter") String pDesignationFilter,
//            @Param("pStaffCategoryFilter") String pStaffCategoryFilter
//    );

//
//    @Query("SELECT LR FROM LeaveReport LR " +
//            "LEFT JOIN EmployeeOfficeInfo EOI ON LR.employeeCode = EOI.EmployeeCode " +
//            "WHERE DAR.workDate BETWEEN :pWorkFromDateFilter AND :pWorkToDateFilter " +
//            "AND (:pEmpCodeFilter='All' OR LOWER(DAR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
//            "AND (:pPunchCardFilter='All' OR LOWER(DAR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
//            "AND (:pUnitFilter='All' OR LOWER(DAR.unit) = LOWER(:pUnitFilter)) " +
//            "AND (:pFloorFilter='All' OR LOWER(DAR.floor) = LOWER(:pFloorFilter)) " +
//            "AND (:pLineFilter='All' OR LOWER(DAR.line) = LOWER(:pLineFilter)) " +
//            "AND (:pDepartmentFilter='All' OR LOWER(DAR.department) = LOWER(:pDepartmentFilter)) " +
//            "AND (:pSectionFilter='All' OR LOWER(DAR.section) = LOWER(:pSectionFilter)) " +
//            "AND (:pDesignationFilter='All' OR LOWER(DAR.designation) = LOWER(:pDesignationFilter)) " +
//            "AND (:pStaffCategoryFilter='All' OR LOWER(DAR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
//            "ORDER BY DAR.department,DAR.section ASC"
//    )
//    List<DailyAttendanceReport> findAllContinuousAbsentReport(
//            @Param("pWorkFromDateFilter") Date pWorkFromDateFilter,
//            @Param("pWorkToDateFilter") Date pWorkToDateFilter,
//            @Param("pEmpCodeFilter") String pEmpCodeFilter,
//            @Param("pPunchCardFilter") String pPunchCardFilter,
//            @Param("pUnitFilter") String pUnitFilter,
//            @Param("pFloorFilter") String pFloorFilter,
//            @Param("pLineFilter") String pLineFilter,
//            @Param("pDepartmentFilter") String pDepartmentFilter,
//            @Param("pSectionFilter") String pSectionFilter,
//            @Param("pDesignationFilter") String pDesignationFilter,
//            @Param("pStaffCategoryFilter") String pStaffCategoryFilter
//    );
}
