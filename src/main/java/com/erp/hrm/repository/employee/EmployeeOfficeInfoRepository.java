package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.EmployeeOfficeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EmployeeOfficeInfoRepository extends JpaRepository<EmployeeOfficeInfo, Long> {

    // Return employee office info based on employee code
    @Query("SELECT EO FROM EmployeeOfficeInfo EO WHERE EO.employeeInfo.employeeCode= :pEmployeeCode")
    public EmployeeOfficeInfo get(@Param("pEmployeeCode") String pEmployeeCode);

    // Return all employee office info
    @Query("SELECT EO FROM EmployeeOfficeInfo EO")
    public EmployeeOfficeInfo getAll();

    @Query("SELECT DISTINCT EO.employeeInfo.employeeCode " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo EO " +
            "LEFT OUTER JOIN EmployeeRuleTag ERT ON emp.employeeCode = ERT.employeeInfo.employeeCode " +
                "AND (" +
                    "(LOWER(:pRuleName)='Bonus Rule' AND LOWER(ERT.bonusPolicyCode)=LOWER(:pRuleCode)) " +
                    "OR (LOWER(:pRuleName)='OT Rule' AND LOWER(ERT.otRule)=LOWER(:pRuleCode)) " +
                    "OR (LOWER(:pRuleName)='ALD Rule' AND LOWER(ERT.attendanceLateDeductionRule)=LOWER(:pRuleCode)) " +
                    "OR (LOWER(:pRuleName)='Final Settlement Rule' AND LOWER(ERT.finalSettlementRule)=LOWER(:pRuleCode)) " +
                    "OR (LOWER(:pRuleName)='Additional Salary Rule' AND LOWER(ERT.additionalSalaryRule)=LOWER(:pRuleCode)) " +
                ")"+
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
                "AND (LOWER(:pUnitName)='all' OR EO.unit=LOWER(:pUnitName)) " +
                "AND (LOWER(:pDepartmentName)='all' OR EO.department=LOWER(:pDepartmentName)) " +
                "AND (LOWER(:pDesignationName)='all' OR EO.designation=LOWER(:pDesignationName)) " +
                "AND (LOWER(:pStaffCategoryName)='all' OR EO.staffCategory=LOWER(:pStaffCategoryName)) " +
                "AND ERT.employeeInfo.employeeCode IS NULL")
    List<Object[]> getAllEmployeeCodesByFilters(
            @Param("pRuleName") String pRuleName,
            @Param("pRuleCode") String pRuleCode,
            @Param("pUnitName") String pUnitName,
            @Param("pDepartmentName") String pDepartmentName,
            @Param("pDesignationName") String pDesignationName,
            @Param("pStaffCategoryName") String pStaffCategoryName
    );

    @Query("SELECT DISTINCT emp.employeeCode,SP.inTime,SP.absentEndMargin,SP.outTime,SP.outTimeEndMargin," +
            "SP.shiftID,SP.shiftType " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo EO " +
            "INNER JOIN ShiftRoster SR ON emp.employeeCode=SR.EmployeeCode AND SR.ShiftDate=:pEntryDate " +
            "INNER JOIN ShiftPlan SP ON SR.ShiftID=SP.shiftID " +
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
            "AND (LOWER(:pUnitName)='all' OR EO.unit=LOWER(:pUnitName)) " +
            "AND (LOWER(:pDepartmentName)='all' OR EO.department=LOWER(:pDepartmentName)) " +
            "AND (LOWER(:pDesignationName)='all' OR EO.designation=LOWER(:pDesignationName)) " +
            "AND (LOWER(:pStaffCategoryName)='all' OR EO.staffCategory=LOWER(:pStaffCategoryName))")
    List<Object[]> getAllActiveEmployeeForManualAttendanceByFilters(
            @Param("pUnitName") String pUnitName,
            @Param("pDepartmentName") String pDepartmentName,
            @Param("pDesignationName") String pDesignationName,
            @Param("pStaffCategoryName") String pStaffCategoryName,
            @Param("pEntryDate") Date pEntryDate
    );

    @Query("SELECT DISTINCT emp.employeeCode,SP.inTime,SP.absentEndMargin,SP.outTime,SP.outTimeEndMargin " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN ShiftRoster SR ON emp.employeeCode=SR.EmployeeCode AND SR.ShiftDate=:pEntryDate " +
            "INNER JOIN ShiftPlan SP ON SR.ShiftID=SP.shiftID " +
            "WHERE emp.employeeCode IN (:vEmployeeCodeObj)")
    List<Object[]> getAllActiveEmployeeForManualAttByEmpCodes(@Param("vEmployeeCodeObj") List<String> vEmployeeCodeObj);
}
