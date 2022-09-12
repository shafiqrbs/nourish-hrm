package com.erp.hrm.repository.reports;

import com.erp.hrm.domain.DailyAttendanceReport;
import com.erp.hrm.domain.LeaveReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Sohag on 10/03/2019.
 */
public interface LeaveReportRepository extends JpaRepository<LeaveReport, Long>{

    @Query("SELECT LR FROM LeaveReport LR " +
            "WHERE LR.leaveFromDate >= :pFromDateFilter AND LR.leaveToDate <= :pToDateFilter " +
                "AND (:pEmpCodeFilter='All' OR LOWER(LR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(LR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(LR.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(LR.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(LR.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(LR.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(LR.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(LR.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(LR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "ORDER BY LR.department ASC"
        )
    List<LeaveReport> findAllMonthlyLeaveTransaction(
            @Param("pFromDateFilter") Date pFromDateFilter,
            @Param("pToDateFilter") Date pToDateFilter,
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

    @Query("SELECT LR FROM LeaveReport LR " +
            "WHERE LR.leaveFromDate >= :pFromDateFilter AND LR.leaveToDate <= :pToDateFilter " +
            "AND (:pEmpCodeFilter='All' OR LOWER(LR.employeeCode) = LOWER(:pEmpCodeFilter)) " +
            "AND (:pPunchCardFilter='All' OR LOWER(LR.punchCardNo) = LOWER(:pPunchCardFilter)) " +
            "AND (:pUnitFilter='All' OR LOWER(LR.unit) = LOWER(:pUnitFilter)) " +
            "AND (:pFloorFilter='All' OR LOWER(LR.floor) = LOWER(:pFloorFilter)) " +
            "AND (:pLineFilter='All' OR LOWER(LR.line) = LOWER(:pLineFilter)) " +
            "AND (:pDepartmentFilter='All' OR LOWER(LR.department) = LOWER(:pDepartmentFilter)) " +
            "AND (:pSectionFilter='All' OR LOWER(LR.section) = LOWER(:pSectionFilter)) " +
            "AND (:pDesignationFilter='All' OR LOWER(LR.designation) = LOWER(:pDesignationFilter)) " +
            "AND (:pStaffCategoryFilter='All' OR LOWER(LR.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "ORDER BY LR.employeeName ASC,LR.designation ASC,LR.employeeCode ASC,LR.punchCardNo,LR.unit," +
            "LR.department ASC,LR.section ASC,LR.line ASC,LR.serviceLength ASC"
    )
    List<LeaveReport> findEmployeeAllLeaveTransaction(
            @Param("pFromDateFilter") Date pFromDateFilter,
            @Param("pToDateFilter") Date pToDateFilter,
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
}
