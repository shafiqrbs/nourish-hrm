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
public interface BonusReportRepository extends JpaRepository<DailyAttendanceReport, Long>{

    /*
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
    */
}
