package com.erp.hrm.repository.reports;

import com.erp.hrm.domain.MonthWiseSalaryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by Sohag on 10/03/2019.
 */
public interface PaymentReportRepository extends JpaRepository<MonthWiseSalaryReport, Long> {

    @Query("SELECT SWE.sectionInfo,SWE.lineInfo,MWS.employeeCode,coalesce(SWE.punchCardNo,'') AS punchCardNo,SWE.employeeName," +
                "SWE.doj,SWE.designation,coalesce(SWE.gradeInfo,0) AS grade,MWA.presentDay,MWA.workingDay,MWA.absentDay,MWA.cl," +
                "MWA.sl,MWA.el,MWA.spl,MWS.basic,MWS.houseRent,MWS.medicalAllowance,MWS.lunchBill," +
                "MWS.conveyance,MWS.advance,MWS.stamp,MWS.attendanceBonus,MWA.ot,MWA.otRate,MWS.ot " +
            "FROM SalaryWiseEmployeeInfoReport SWE " +
            "INNER JOIN MonthWiseSalaryReport MWS ON SWE.employeeCode = MWS.employeeCode " +
                "AND SWE.salaryProcID = MWS.salaryProcID "+
                "AND MWS.yearNo = :pYearNo " +
                "AND MWS.monthNo = :pMonthNo " +
                "AND (:pEmpCodeFilter='All' OR LOWER(SWE.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(SWE.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(SWE.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(SWE.floorInfo) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(SWE.lineInfo) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(SWE.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(SWE.sectionInfo) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(SWE.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(SWE.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "INNER JOIN MonthWiseAttendanceInfoReport MWA ON SWE.employeeCode = MWA.employeeCode " +
                "AND MWS.yearNo = MWA.yearNo " +
                "AND MWS.monthNo = MWA.monthNo " +
            "ORDER BY SWE.sectionInfo ASC, SWE.lineInfo ASC")
    List<Object[]> findAllSalaryAndOverTime(
            @Param("pYearNo") Integer pYearNo,
            @Param("pMonthNo") Integer pMonthNo,
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

    @Query("SELECT SWE.sectionInfo, SWE.lineInfo,MWS.employeeCode,coalesce(SWE.punchCardNo,'') AS punchCardNo,SWE.employeeName," +
                "SWE.doj,SWE.designation,coalesce(SWE.gradeInfo,0) AS grade,MWA.presentDay,MWA.workingDay,MWA.absentDay," +
                "SWE.tinNumber,SWE.bankName,SWE.bankAccNo,MWA.cl,MWA.sl,MWA.el,MWA.spl,MWS.basic,MWS.houseRent,MWS.medicalAllowance," +
                "MWS.lunchBill,MWS.conveyance,MWS.advance,MWS.stamp,MWS.attendanceBonus,MWA.ot,MWA.otRate,MWS.ot " +
            "FROM SalaryWiseEmployeeInfoReport SWE " +
            "INNER JOIN MonthWiseSalaryReport MWS ON SWE.employeeCode = MWS.employeeCode " +
                "AND SWE.salaryProcID = MWS.salaryProcID "+
                "AND MWS.yearNo = :pYearNo " +
                "AND MWS.monthNo = :pMonthNo " +
                "AND (:pEmpCodeFilter='All' OR LOWER(SWE.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(SWE.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(SWE.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(SWE.floorInfo) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(SWE.lineInfo) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(SWE.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(SWE.sectionInfo) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(SWE.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(SWE.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "INNER JOIN MonthWiseAttendanceInfoReport MWA ON SWE.employeeCode = MWA.employeeCode " +
                "AND MWS.yearNo = MWA.yearNo " +
                "AND MWS.monthNo = MWA.monthNo " +
            "ORDER BY SWE.sectionInfo ASC, SWE.lineInfo ASC")
    List<Object[]> findAllSalaryAndOverTimeForBuyer(
            @Param("pYearNo") Integer pYearNo,
            @Param("pMonthNo") Integer pMonthNo,
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

    @Query("SELECT SWE.sectionInfo AS section,SWE.designation AS designation,COUNT(SWE.employeeCode) AS totalManPower," +
                "SUM(MWS.basic) AS basic,SUM(MWS.houseRent) AS houseRent,SUM(MWS.medicalAllowance) AS medicalAllowance," +
                "SUM(MWS.lunchBill) AS lunchBill,SUM(MWS.conveyance) AS conveyance,SUM(MWS.absenteeism) AS absent," +
                "SUM(MWS.advance) AS advance,SUM(MWS.stamp) AS stamp,SUM(MWS.attendanceBonus) AS attendanceBonus," +
                "SUM(0.00) AS otHour,SUM(MWS.ot) AS ot " +
            "FROM SalaryWiseEmployeeInfoReport SWE " +
            "INNER JOIN MonthWiseSalaryReport MWS ON SWE.employeeCode = MWS.employeeCode " +
                "AND SWE.salaryProcID = MWS.salaryProcID "+
                "AND MWS.yearNo = :pYearNo " +
                "AND MWS.monthNo = :pMonthNo " +
                "AND (:pEmpCodeFilter='All' OR LOWER(SWE.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(SWE.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(SWE.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(SWE.floorInfo) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(SWE.lineInfo) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(SWE.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(SWE.sectionInfo) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(SWE.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(SWE.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "GROUP BY SWE.sectionInfo, SWE.designation " +
            "ORDER BY SWE.sectionInfo ASC, SWE.designation ASC")
    List<Object[]> findAllSalaryAndOTTopSheetForBuyer(
            @Param("pYearNo") Integer pYearNo,
            @Param("pMonthNo") Integer pMonthNo,
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

    @Query("SELECT SWE.lineInfo AS line,MWS.employeeCode,coalesce(SWE.punchCardNo,'') AS punchCardNo,SWE.employeeName," +
                "SWE.doj,SWE.designation,coalesce(SWE.gradeInfo,0) AS grade,MWA.presentDay AS present,MWA.workingDay," +
                "MWS.gross AS totalSalary,MWS.basic,MWA.ot As otHour,MWA.otRate,MWA.eot AS eotHour, " +
                "MWS.ot AS salaryWithOt " +
            "FROM SalaryWiseEmployeeInfoReport SWE " +
            "INNER JOIN MonthWiseSalaryReport MWS ON SWE.employeeCode = MWS.employeeCode " +
                "AND SWE.salaryProcID = MWS.salaryProcID "+
                "AND MWS.yearNo = :pYearNo " +
                "AND MWS.monthNo = :pMonthNo " +
                "AND (:pEmpCodeFilter='All' OR LOWER(SWE.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(SWE.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(SWE.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(SWE.floorInfo) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(SWE.lineInfo) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(SWE.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(SWE.sectionInfo) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(SWE.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(SWE.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "INNER JOIN MonthWiseAttendanceInfoReport MWA ON SWE.employeeCode = MWA.employeeCode " +
                "AND MWS.yearNo = MWA.yearNo " +
                "AND MWS.monthNo = MWA.monthNo " +
            "ORDER BY SWE.lineInfo ASC")
    List<Object[]> findAllExtraOverTimeSheet(
            @Param("pYearNo") Integer pYearNo,
            @Param("pMonthNo") Integer pMonthNo,
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

    @Query("SELECT MWS.employeeCode,coalesce(SWE.punchCardNo,'') AS punchCardNo,MWA.yearNo AS yearNo,MWA.monthNo AS monthNo,SWE.employeeName," +
                "SWE.designation,SWE.sectionInfo,SWE.lineInfo,coalesce(SWE.gradeInfo,0) AS grade,SWE.doj,MWA.workingDay,MWA.presentDay,MWA.absentDay," +
                "MWA.cl,MWA.sl,MWA.el,MWA.spl,MWS.gross,MWS.basic,MWS.houseRent,MWS.medicalAllowance,MWS.lunchBill," +
                "MWS.conveyance,MWS.absenteeism,MWS.advance,MWS.stamp,MWS.attendanceBonus,MWA.ot,MWA.otRate,MWS.ot " +
            "FROM SalaryWiseEmployeeInfoReport SWE " +
            "INNER JOIN MonthWiseSalaryReport MWS ON SWE.employeeCode = MWS.employeeCode " +
                "AND SWE.salaryProcID = MWS.salaryProcID "+
                "AND MWS.yearNo = :pYearNo " +
                "AND MWS.monthNo = :pMonthNo " +
                "AND (:pEmpCodeFilter='All' OR LOWER(SWE.employeeCode) = LOWER(:pEmpCodeFilter)) " +
                "AND (:pPunchCardFilter='All' OR LOWER(SWE.punchCardNo) = LOWER(:pPunchCardFilter)) " +
                "AND (:pUnitFilter='All' OR LOWER(SWE.unit) = LOWER(:pUnitFilter)) " +
                "AND (:pFloorFilter='All' OR LOWER(SWE.floorInfo) = LOWER(:pFloorFilter)) " +
                "AND (:pLineFilter='All' OR LOWER(SWE.lineInfo) = LOWER(:pLineFilter)) " +
                "AND (:pDepartmentFilter='All' OR LOWER(SWE.department) = LOWER(:pDepartmentFilter)) " +
                "AND (:pSectionFilter='All' OR LOWER(SWE.sectionInfo) = LOWER(:pSectionFilter)) " +
                "AND (:pDesignationFilter='All' OR LOWER(SWE.designation) = LOWER(:pDesignationFilter)) " +
                "AND (:pStaffCategoryFilter='All' OR LOWER(SWE.staffCategory) = LOWER(:pStaffCategoryFilter)) " +
            "INNER JOIN MonthWiseAttendanceInfoReport MWA ON SWE.employeeCode = MWA.employeeCode " +
                "AND MWS.yearNo = MWA.yearNo " +
                "AND MWS.monthNo = MWA.monthNo " +
            "ORDER BY SWE.sectionInfo ASC, SWE.lineInfo ASC")
    List<Object[]> findAllEmployeePaySlip(
            @Param("pYearNo") Integer pYearNo,
            @Param("pMonthNo") Integer pMonthNo,
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
