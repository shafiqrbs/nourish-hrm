package com.erp.hrm.repository.reports;

import com.erp.hrm.domain.DailyAttendanceReport;
import com.erp.hrm.domain.EmployeeReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by Sohag on 10/03/2019.
 */
public interface EmployeeReportRepository extends JpaRepository<EmployeeReport, Long>{

    @Query("SELECT ER.department,ER.unit,COUNT(ER.gender) AS noOfStaff,COUNT(MG.gender) AS maleCount,COUNT(FG.gender) AS femaleCount " +
            "FROM EmployeeReport ER " +
            "LEFT OUTER JOIN EmployeeReport MG ON ER.employeeCode = MG.employeeCode " +
                "AND MG.gender = 'M' " +
                "AND ER.gender = 'M' " +
            "LEFT OUTER JOIN EmployeeReport FG ON ER.employeeCode = FG.employeeCode " +
                "AND FG.gender = 'F' " +
                "AND ER.gender = 'F' " +
            "WHERE (:pEmpCodeFilter='All' OR LOWER(ER.employeeCode) = LOWER(:pEmpCodeFilter))" +
                "AND (:pPunchCardFilter='All' OR LOWER(ER.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(ER.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(ER.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(ER.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(ER.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(ER.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(ER.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(ER.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "GROUP BY ER.department,ER.unit " +
            "ORDER BY ER.department ASC"
    )
    List<Object[]> findAllDepartmentWiseEmployee(
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

    @Query("SELECT ER.designation,ER.unit,COUNT(ER.gender) AS noOfStaff,COUNT(MG.gender) AS maleCount,COUNT(FG.gender) AS femaleCount " +
            "FROM EmployeeReport ER " +
            "LEFT OUTER JOIN EmployeeReport MG ON ER.employeeCode = MG.employeeCode " +
                "AND MG.gender = 'M' " +
                "AND ER.gender = 'M' " +
            "LEFT OUTER JOIN EmployeeReport FG ON ER.employeeCode = FG.employeeCode " +
                "AND FG.gender = 'F' " +
                "AND ER.gender = 'F' " +
            "WHERE (:pEmpCodeFilter='All' OR LOWER(ER.employeeCode) = LOWER(:pEmpCodeFilter))" +
                "AND (:pPunchCardFilter='All' OR LOWER(ER.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(ER.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(ER.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(ER.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(ER.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(ER.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(ER.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(ER.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "GROUP BY ER.designation,ER.unit " +
            "ORDER BY ER.designation ASC"
    )
    List<Object[]> findAllDesignationWiseEmployee(
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

    @Query("SELECT ER.staffCategory,ER.unit,COUNT(ER.gender) AS noOfStaff,COUNT(ER.gender) AS noOfStaff,COUNT(MG.gender) AS maleCount,COUNT(FG.gender) AS femaleCount " +
            "FROM EmployeeReport ER " +
            "LEFT OUTER JOIN EmployeeReport MG ON ER.employeeCode = MG.employeeCode " +
                "AND MG.gender = 'M' " +
                "AND ER.gender = 'M' " +
            "LEFT OUTER JOIN EmployeeReport FG ON ER.employeeCode = FG.employeeCode " +
                "AND FG.gender = 'F' " +
                "AND ER.gender = 'F' " +
            "WHERE (:pEmpCodeFilter='All' OR LOWER(ER.employeeCode) = LOWER(:pEmpCodeFilter))" +
                "AND (:pPunchCardFilter='All' OR LOWER(ER.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(ER.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(ER.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(ER.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(ER.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(ER.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(ER.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(ER.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "GROUP BY ER.staffCategory,ER.unit " +
            "ORDER BY ER.staffCategory ASC"
        )
    List<Object[]> findAllGenderWiseEmployee(
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

    @Query("SELECT ER.grade,COUNT(ER.gender) AS noOfStaff,COUNT(MG.gender) AS maleCount,COUNT(FG.gender) AS femaleCount " +
            "FROM EmployeeReport ER " +
            "LEFT OUTER JOIN EmployeeReport MG ON ER.employeeCode = MG.employeeCode " +
                "AND MG.gender = 'M' " +
                "AND ER.gender = 'M' " +
            "LEFT OUTER JOIN EmployeeReport FG ON ER.employeeCode = FG.employeeCode " +
                "AND FG.gender = 'F' " +
                "AND ER.gender = 'F' " +
            "WHERE (:pEmpCodeFilter='All' OR LOWER(ER.employeeCode) = LOWER(:pEmpCodeFilter))" +
                "AND (:pPunchCardFilter='All' OR LOWER(ER.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(ER.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(ER.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(ER.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(ER.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(ER.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(ER.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(ER.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "GROUP BY ER.grade " +
            "ORDER BY ER.grade ASC"
        )
    List<Object[]> findAllGradeWiseEmployee(
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

    @Query("SELECT ER FROM EmployeeReport ER " +
            "WHERE ER.doj BETWEEN :pWorkFromDateFilter AND :pWorkToDateFilter " +
                "AND (:pEmpCodeFilter='All' OR LOWER(ER.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(ER.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(ER.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(ER.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(ER.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(ER.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(ER.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(ER.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(ER.staffCategory) = LOWER(:pStaffCategoryFilter)) "+
            "ORDER BY ER.unit,ER.department,ER.section,ER.line ASC"
        )
    List<EmployeeReport> findAllNewJoiningEmployee(
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

    @Query("SELECT ER FROM EmployeeReport ER " +
            "WHERE ER.doj BETWEEN :pWorkFromDateFilter AND :pWorkToDateFilter " +
                "AND (:pEmpCodeFilter='All' OR LOWER(ER.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(ER.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(ER.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(ER.floor) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(ER.line) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(ER.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(ER.section) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(ER.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(ER.staffCategory) = LOWER(:pStaffCategoryFilter)) "+
            "ORDER BY ER.unit,ER.section,ER.line ASC"
    )
    List<EmployeeReport> findAllSeparatedEmployee(
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
}
