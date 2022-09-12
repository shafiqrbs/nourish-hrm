package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.EmployeeReport;
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

@Repository
public interface EmployeeInfoRepository extends JpaRepository<EmployeeInfo, Long> {


    @Query("SELECT emp " +
            "FROM EmployeeInfo emp " +
            "WHERE emp.employeeCode= :pEmployeeCode ")
    EmployeeInfo findOne(@Param("pEmployeeCode")String pEmployeeCode);


    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false")
    Page<Object[]> getAllActiveEmployeeInfo(Pageable pageable);

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.employeeStatus='Active' AND emp.gender='F' AND emp.maritalStatus='Married' AND emp.isCandidate = false")
    Page<Object[]> getAllActiveMLApplicableEmployeeInfo(Pageable pageable);

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.isCandidate = false AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:filterString), '%')")
    Page<Object[]> getAllEmployeeInfoFilterByEmployeeCode(@Param("filterString") String filterString, Pageable pageable);

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.isCandidate = false AND (LOWER(:pEmployeeStatus)='all' OR emp.employeeStatus = LOWER(:pEmployeeStatus)) AND " +
            "(" +
                "LOWER(:pEmpCodeFilter)='all' OR (" +
                "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
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
            "LOWER(:pFirstNameFilter)='all' OR (" +
                "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
                "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
                "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pUnitFilter)='all' OR (" +
                "(LOWER(:pUnitFilterOpt) = 'eq' AND LOWER(eof.unit) = LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'neq' AND LOWER(eof.unit) != LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'startswith' AND LOWER(eof.unit) LIKE CONCAT('', LOWER(:pUnitFilter), '%')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'endswith' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'contains' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pDepartmentFilter)='all' OR (" +
                "(LOWER(:pDepartmentOpt) = 'eq' AND LOWER(eof.department) = LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'neq' AND LOWER(eof.department) != LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'startswith' AND LOWER(eof.department) LIKE CONCAT('', LOWER(:pDepartmentFilter), '%')) OR " +
                "(LOWER(:pDepartmentOpt) = 'endswith' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '')) OR " +
                "(LOWER(:pDepartmentOpt) = 'contains' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pDesignationFilter)='all' OR (" +
                "(LOWER(:pDesignationOpt) = 'eq' AND LOWER(eof.designation) = LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'neq' AND LOWER(eof.designation) != LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'startswith' AND LOWER(eof.designation) LIKE CONCAT('', LOWER(:pDesignationFilter), '%')) OR " +
                "(LOWER(:pDesignationOpt) = 'endswith' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '')) OR " +
                "(LOWER(:pDesignationOpt) = 'contains' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pStaffCategoryFilter)='all' OR (" +
                "(LOWER(:pStaffCategoryOpt) = 'eq' AND LOWER(eof.staffCategory) = LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'neq' AND LOWER(eof.staffCategory) != LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'startswith' AND LOWER(eof.staffCategory) LIKE CONCAT('', LOWER(:pStaffCategoryFilter), '%')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'endswith' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'contains' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '%')))" +
            ")"
        )
    Page<Object[]> getAllEmployeeByFilters(
            @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
            @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
            @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
            @Param("pUnitFilter") String pUnitFilter, @Param("pUnitFilterOpt") String pUnitFilterOpt,
            @Param("pDepartmentFilter") String pDepartmentFilter, @Param("pDepartmentOpt") String pDepartmentOpt,
            @Param("pDesignationFilter") String pDesignationFilter, @Param("pDesignationOpt") String pDesignationOpt,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter, @Param("pStaffCategoryOpt") String pStaffCategoryOpt,
            @Param("pEmployeeStatus") String pEmployeeStatus,
            Pageable pageable
    );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.employeeStatus='Active' AND emp.gender='F' AND emp.maritalStatus='Married' AND emp.isCandidate = false AND" +
            "(" +
                "LOWER(:pEmpCodeFilter)='all' OR (" +
                "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
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
                "LOWER(:pFirstNameFilter)='all' OR (" +
                "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
                "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
                "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pUnitFilter)='all' OR (" +
                "(LOWER(:pUnitFilterOpt) = 'eq' AND LOWER(eof.unit) = LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'neq' AND LOWER(eof.unit) != LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'startswith' AND LOWER(eof.unit) LIKE CONCAT('', LOWER(:pUnitFilter), '%')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'endswith' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'contains' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pDepartmentFilter)='all' OR (" +
                "(LOWER(:pDepartmentOpt) = 'eq' AND LOWER(eof.department) = LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'neq' AND LOWER(eof.department) != LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'startswith' AND LOWER(eof.department) LIKE CONCAT('', LOWER(:pDepartmentFilter), '%')) OR " +
                "(LOWER(:pDepartmentOpt) = 'endswith' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '')) OR " +
                "(LOWER(:pDepartmentOpt) = 'contains' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pDesignationFilter)='all' OR (" +
                "(LOWER(:pDesignationOpt) = 'eq' AND LOWER(eof.designation) = LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'neq' AND LOWER(eof.designation) != LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'startswith' AND LOWER(eof.designation) LIKE CONCAT('', LOWER(:pDesignationFilter), '%')) OR " +
                "(LOWER(:pDesignationOpt) = 'endswith' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '')) OR " +
                "(LOWER(:pDesignationOpt) = 'contains' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pStaffCategoryFilter)='all' OR (" +
                "(LOWER(:pStaffCategoryOpt) = 'eq' AND LOWER(eof.staffCategory) = LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'neq' AND LOWER(eof.staffCategory) != LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'startswith' AND LOWER(eof.staffCategory) LIKE CONCAT('', LOWER(:pStaffCategoryFilter), '%')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'endswith' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'contains' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '%')))" +
            ")"
    )
    Page<Object[]> getAllActiveMLEmployeeByFilters(
            @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
            @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
            @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
            @Param("pUnitFilter") String pUnitFilter, @Param("pUnitFilterOpt") String pUnitFilterOpt,
            @Param("pDepartmentFilter") String pDepartmentFilter, @Param("pDepartmentOpt") String pDepartmentOpt,
            @Param("pDesignationFilter") String pDesignationFilter, @Param("pDesignationOpt") String pDesignationOpt,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter, @Param("pStaffCategoryOpt") String pStaffCategoryOpt,
            Pageable pageable
    );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE (LOWER(:pEmployeeStatus)='all' OR emp.employeeStatus = LOWER(:pEmployeeStatus)) AND " +
            "emp.isCandidate = false AND (" +
                "LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR "+
                "LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.department) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%')" +
            ")"
    )
    Page<Object[]> getAllEmployeeAdvanceSearchByFilters(
            @Param("pAdvanceSearchFilter") String pAdvanceSearchFilter,
            @Param("pEmployeeStatus") String pEmployeeStatus,Pageable pageable
    );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.employeeStatus='Active' AND emp.gender='F' AND emp.maritalStatus='Married' AND " +
            "emp.isCandidate = false AND (" +
                "LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR "+
                "LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.department) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%')" +
            ")"
    )
    Page<Object[]> getAllActiveMLEmployeeAdvanceSearchByFilters(
            @Param("pAdvanceSearchFilter") String pAdvanceSearchFilter,Pageable pageable
    );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:filterString), '%') AND emp.isCandidate = false")
    Page<Object[]> getAllEmployeeInfoFilterByFirstName(@Param("filterString") String filterString, Pageable pageable);

    /*
    @Query("select emp from EmployeeInfo emp left outer join emp.employeeOfficeInfo")
    List<EmployeeInfo> getAllEmployeeInfo();
    */

    @Query("SELECT emp FROM EmployeeInfo emp WHERE emp.employeeCode= :pEmployeeCode")
    EmployeeInfo getEmployeeInfo(@Param("pEmployeeCode")String pEmployeeCode);

    @Query("SELECT emp.employeeCode FROM EmployeeInfo emp WHERE emp.punchCardNo= :pPunchCardNo")
    String getEmployeeCode(@Param("pPunchCardNo")String pPunchCardNo);

    @Query("SELECT DISTINCT emp.employeeCode,sp.shiftID, sp.shiftType, sp.inTime,sp.outTime,sp.lunchInTime, sp.lunchOutTime " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN ShiftRoster sr ON emp.employeeCode = sr.EmployeeCode "+
            "INNER JOIN ShiftPlan sp ON sr.ShiftID = sp.shiftID "+
            "WHERE emp.employeeCode= :pEmployeeCode AND sr.ShiftDate = :workDate")
    Object[] getEmpShiftInfoByEmployeeCodeAndDate(@Param("pEmployeeCode")String pEmployeeCode, @Param("workDate")Date workDate);

    @Query("SELECT COUNT(EMP.employeeCode) FROM EmployeeInfo EMP")
    public int getNumberOfEmployee();

    @Query("SELECT emp.employeeCode FROM EmployeeInfo emp")
    List<String> getAllEmployeeCode();

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeRuleInfo er " +
            "INNER JOIN ShiftRuleDetail srd ON (er.shiftRuleCode = srd.ShiftRuleCode) " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.employeeStatus='Active' " +
            "AND (" +
                "(LOWER(:pShiftVolume)='all' AND er.shiftID IS NULL) " +
                "OR (LOWER(:pShiftVolume)='' AND srd.ShiftID IN (:pShiftIds))" +
            ") " +
            "AND (" +
                "LOWER(:pEmpCodeFilter)='all' OR (" +
                "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
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
                "LOWER(:pFirstNameFilter)='all' OR (" +
                "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
                "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
                "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pUnitFilter)='all' OR (" +
                "(LOWER(:pUnitFilterOpt) = 'eq' AND LOWER(eof.unit) = LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'neq' AND LOWER(eof.unit) != LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'startswith' AND LOWER(eof.unit) LIKE CONCAT('', LOWER(:pUnitFilter), '%')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'endswith' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'contains' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pDepartmentFilter)='all' OR (" +
                "(LOWER(:pDepartmentOpt) = 'eq' AND LOWER(eof.department) = LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'neq' AND LOWER(eof.department) != LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'startswith' AND LOWER(eof.department) LIKE CONCAT('', LOWER(:pDepartmentFilter), '%')) OR " +
                "(LOWER(:pDepartmentOpt) = 'endswith' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '')) OR " +
                "(LOWER(:pDepartmentOpt) = 'contains' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pDesignationFilter)='all' OR (" +
                "(LOWER(:pDesignationOpt) = 'eq' AND LOWER(eof.designation) = LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'neq' AND LOWER(eof.designation) != LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'startswith' AND LOWER(eof.designation) LIKE CONCAT('', LOWER(:pDesignationFilter), '%')) OR " +
                "(LOWER(:pDesignationOpt) = 'endswith' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '')) OR " +
                "(LOWER(:pDesignationOpt) = 'contains' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pStaffCategoryFilter)='all' OR (" +
                "(LOWER(:pStaffCategoryOpt) = 'eq' AND LOWER(eof.staffCategory) = LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'neq' AND LOWER(eof.staffCategory) != LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'startswith' AND LOWER(eof.staffCategory) LIKE CONCAT('', LOWER(:pStaffCategoryFilter), '%')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'endswith' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'contains' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '%')))" +
            ")"
    )
    Page<Object[]> getAllShiftRosterEmployeeByFilters(
            @Param("pShiftIds") List<String> pShiftIds,@Param("pShiftVolume") String pShiftVolume,
            @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
            @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
            @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
            @Param("pUnitFilter") String pUnitFilter, @Param("pUnitFilterOpt") String pUnitFilterOpt,
            @Param("pDepartmentFilter") String pDepartmentFilter, @Param("pDepartmentOpt") String pDepartmentOpt,
            @Param("pDesignationFilter") String pDesignationFilter, @Param("pDesignationOpt") String pDesignationOpt,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter, @Param("pStaffCategoryOpt") String pStaffCategoryOpt,
            Pageable pageable
    );

    @Query("SELECT DISTINCT er.employeeInfo.employeeCode, er.employeeInfo.punchCardNo," +
            " er.employeeInfo.salutation, er.employeeInfo.firstName, " +
            " er.employeeInfo.middleName, er.employeeInfo.lastName," +
            " er.employeeInfo.employeeOfficeInfo.department, er.employeeInfo.employeeOfficeInfo.designation" +
            " FROM ShiftRuleDetail srd " +
            " INNER JOIN EmployeeRuleInfo er ON (srd.ShiftRuleCode = er.shiftRuleCode ) " +
            " WHERE srd.ShiftID IN (:pShiftIds)")
    Page<Object[]> getListOfEmployeeJoinByRuleCode(@Param("pShiftIds")List<String> pShiftIds, Pageable pageable);

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeRuleInfo er " +
            "INNER JOIN ShiftRuleDetail srd ON (er.shiftRuleCode = srd.ShiftRuleCode) " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.employeeStatus='Active' " +
                "AND (" +
                    "(LOWER(:pShiftVolume)='all' AND er.shiftID IS NULL) " +
                    "OR (LOWER(:pShiftVolume)='' AND srd.ShiftID IN (:pShiftIds))" +
                ") " +
                "AND (" +
                    "LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR "+
                    "LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                    "LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                    "LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                    "LOWER(eof.department) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                    "LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                    "LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%')" +
                ")"
    )
    Page<Object[]> getAlldShiftRosterEmployeeByFiltersAdvanceSearch(
            @Param("pShiftIds") List<String> pShiftIds,@Param("pShiftVolume") String pShiftVolume,
            @Param("pAdvanceSearchFilter") String pAdvanceSearchFilter,
            Pageable pageable
    );

    @Query("SELECT DISTINCT er.employeeInfo.employeeCode, er.employeeInfo.punchCardNo," +
            " er.employeeInfo.salutation, er.employeeInfo.firstName, " +
            " er.employeeInfo.middleName, er.employeeInfo.lastName," +
            " er.employeeInfo.employeeOfficeInfo.department, er.employeeInfo.employeeOfficeInfo.designation" +
            " FROM ShiftRuleDetail srd " +
            " INNER JOIN EmployeeRuleInfo er ON (srd.ShiftRuleCode = er.shiftRuleCode ) " +
            " WHERE er.shiftID IS NULL ")
    Page<Object[]> getAllJoinByRuleCode( Pageable pageable);

    @Query("SELECT DISTINCT er.employeeInfo.employeeCode" +
            " FROM ShiftRuleDetail srd " +
            " INNER JOIN EmployeeRuleInfo er ON (srd.ShiftRuleCode = er.shiftRuleCode ) " +
            " WHERE er.shiftID IS NULL ")
    List<String> getAllJoinByRuleCode();

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeRuleInfo er " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.employeeStatus='Active' AND (LOWER(:pShiftVolume)='all' OR er.shiftID IN (:pShiftIds)) AND " +
            "(" +
                "LOWER(:pEmpCodeFilter)='all' OR (" +
                "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
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
                "LOWER(:pFirstNameFilter)='all' OR (" +
                "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
                "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
                "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pUnitFilter)='all' OR (" +
                "(LOWER(:pUnitFilterOpt) = 'eq' AND LOWER(eof.unit) = LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'neq' AND LOWER(eof.unit) != LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'startswith' AND LOWER(eof.unit) LIKE CONCAT('', LOWER(:pUnitFilter), '%')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'endswith' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'contains' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pDepartmentFilter)='all' OR (" +
                "(LOWER(:pDepartmentOpt) = 'eq' AND LOWER(eof.department) = LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'neq' AND LOWER(eof.department) != LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'startswith' AND LOWER(eof.department) LIKE CONCAT('', LOWER(:pDepartmentFilter), '%')) OR " +
                "(LOWER(:pDepartmentOpt) = 'endswith' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '')) OR " +
                "(LOWER(:pDepartmentOpt) = 'contains' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pDesignationFilter)='all' OR (" +
                "(LOWER(:pDesignationOpt) = 'eq' AND LOWER(eof.designation) = LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'neq' AND LOWER(eof.designation) != LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'startswith' AND LOWER(eof.designation) LIKE CONCAT('', LOWER(:pDesignationFilter), '%')) OR " +
                "(LOWER(:pDesignationOpt) = 'endswith' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '')) OR " +
                "(LOWER(:pDesignationOpt) = 'contains' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '%')))" +
            ") AND " +
            "(" +
                "LOWER(:pStaffCategoryFilter)='all' OR (" +
                "(LOWER(:pStaffCategoryOpt) = 'eq' AND LOWER(eof.staffCategory) = LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'neq' AND LOWER(eof.staffCategory) != LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'startswith' AND LOWER(eof.staffCategory) LIKE CONCAT('', LOWER(:pStaffCategoryFilter), '%')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'endswith' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'contains' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '%')))" +
            ")"
    )
    Page<Object[]> getAllEmployeeByShifts(
            @Param("pShiftIds") List<String> pShiftIds,@Param("pShiftVolume") String pShiftVolume,
            @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
            @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
            @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
            @Param("pUnitFilter") String pUnitFilter, @Param("pUnitFilterOpt") String pUnitFilterOpt,
            @Param("pDepartmentFilter") String pDepartmentFilter, @Param("pDepartmentOpt") String pDepartmentOpt,
            @Param("pDesignationFilter") String pDesignationFilter, @Param("pDesignationOpt") String pDesignationOpt,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter, @Param("pStaffCategoryOpt") String pStaffCategoryOpt,
            Pageable pageable
    );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeRuleInfo er " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.employeeStatus='Active' AND (LOWER(:pShiftVolume)='all' OR er.shiftID IN (:pShiftIds)) AND (" +
                "LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR "+
                "LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.department) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%')" +
            ")"
    )
    Page<Object[]> getAllEmployeeByShiftsAdvanceSearch(
            @Param("pShiftIds") List<String> pShiftIds,@Param("pShiftVolume") String pShiftVolume,
            @Param("pAdvanceSearchFilter") String pAdvanceSearchFilter,
            Pageable pageable
    );


    @Query("SELECT DISTINCT er.employeeInfo.employeeCode, er.employeeInfo.punchCardNo," +
            " er.employeeInfo.salutation, er.employeeInfo.firstName, " +
            " er.employeeInfo.middleName, er.employeeInfo.lastName," +
            " er.employeeInfo.employeeOfficeInfo.department, er.employeeInfo.employeeOfficeInfo.designation" +
            " FROM EmployeeRuleInfo er" +
            " WHERE er.shiftID IN (:pShiftIds)")
    Page<Object[]> getListByShiftId(@Param("pShiftIds")List<String> pShiftIds, Pageable pageable);

    @Query("SELECT DISTINCT er.employeeInfo.employeeCode, er.employeeInfo.punchCardNo," +
            " er.employeeInfo.salutation, er.employeeInfo.firstName, " +
            " er.employeeInfo.middleName, er.employeeInfo.lastName," +
            " er.employeeInfo.employeeOfficeInfo.department, er.employeeInfo.employeeOfficeInfo.designation" +
            " FROM EmployeeRuleInfo er" +
            " WHERE er.shiftRuleCode IS NULL")
    Page<Object[]> getAllByShiftId( Pageable pageable);

    @Query("SELECT DISTINCT er.employeeInfo.employeeCode" +
            " FROM EmployeeRuleInfo er" +
            " WHERE er.shiftRuleCode IS NULL")
    List<String> getAllByShiftId();

    @Query("SELECT DISTINCT eo.employeeInfo.employeeCode " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eo " +
            "INNER JOIN emp.employeeRuleInfo er " +
            "WHERE emp.employeeStatus='Active' AND " +
            "(LOWER(:pShiftIds)='All' OR LOWER(er.shiftID) IN (:pShiftIds)) AND " +
            "(LOWER(:pUnitName)='All' OR LOWER(eo.unit)=LOWER(:pUnitName)) AND " +
            "(LOWER(:pDepartmentName)='All' OR LOWER(eo.department)=LOWER(:pDepartmentName)) AND " +
            "(LOWER(:pDesignationName)='All' OR LOWER(eo.designation)=LOWER(:pDesignationName)) AND " +
            "(LOWER(:pStaffCategoryName)='All' OR LOWER(eo.staffCategory)=LOWER(:pStaffCategoryName))"
        )
    List<String> getEmployeeBy(
            @Param("pShiftIds") List<String> pShiftIds,
            @Param("pUnitName") String pUnitName,
            @Param("pDepartmentName") String pDepartmentName,
            @Param("pDesignationName") String pDesignationName,
            @Param("pStaffCategoryName") String pStaffCategoryName
    );

    @Query("SELECT er.employeeInfo.employeeCode,sp.shiftID, sp.shiftType" +
            " FROM EmployeeRuleInfo er " +
            " INNER JOIN ShiftPlan sp ON er.shiftID = sp.shiftID" +
            " WHERE (er.employeeInfo.employeeCode = :pEmployeeCode OR :pEmployeeCode= 'All' )")
    List<Object[]> getShiftIdAndShiftTypeFromShiftPlan(@Param("pEmployeeCode")String pEmployeeCode);

    @Query("SELECT er.employeeInfo.employeeCode, srd.ShiftID, srd.ShiftType, srd.Days " +
            " FROM EmployeeRuleInfo er " +
            " INNER JOIN ShiftRuleDetail srd ON srd.ShiftRuleCode = er.shiftRuleCode " +
            " WHERE (er.employeeInfo.employeeCode = :pEmployeeCode OR :pEmployeeCode= 'All')" +
            " ORDER BY er.employeeInfo.employeeCode , srd.SequenceNo")
    List<Object[]> getShiftIdAndShiftTypeFromShiftRule(@Param("pEmployeeCode")String pEmployeeCode);

    /*Rule Tag Assigned Employee list*/
    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof ON emp.employeeCode = eof.employeeInfo.employeeCode " +
            "INNER JOIN EmployeeRuleTag ert ON emp.employeeCode = ert.employeeInfo.employeeCode " +
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
            " AND (" +
                "(LOWER(:pRuleName)='Bonus Rule' AND LOWER(ert.bonusPolicyCode)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='OT Rule' AND LOWER(ert.otRule)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='ALD Rule' AND LOWER(ert.attendanceLateDeductionRule)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='Final Settlement Rule' AND LOWER(ert.finalSettlementRule)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='Additional Salary Rule' AND LOWER(ert.additionalSalaryRule)=LOWER(:pRuleCode)) " +
            ")")
    Page<Object[]> getAllRuleTaggedEmployeeByRuleCode(
            @Param("pRuleName") String pRuleName,
            @Param("pRuleCode") String pRuleCode,
            Pageable pageable
    );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof ON emp.employeeCode = eof.employeeInfo.employeeCode " +
            "INNER JOIN EmployeeRuleTag ert ON emp.employeeCode = ert.employeeInfo.employeeCode " +
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
            " AND (" +
            "(LOWER(:pRuleName)='Bonus Rule' AND LOWER(ert.bonusPolicyCode)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='OT Rule' AND LOWER(ert.otRule)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='ALD Rule' AND LOWER(ert.attendanceLateDeductionRule)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='Final Settlement Rule' AND LOWER(ert.finalSettlementRule)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='Additional Salary Rule' AND LOWER(ert.additionalSalaryRule)=LOWER(:pRuleCode)) " +
            ") " +
            "AND (" +
            "LOWER(:pEmpCodeFilter)='all' OR (" +
            "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
            "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
            "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
            "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
            "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
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
            "LOWER(:pFirstNameFilter)='all' OR (" +
            "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
            "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
            "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
            "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
            "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pUnitFilter)='all' OR (" +
            "(LOWER(:pUnitFilterOpt) = 'eq' AND LOWER(eof.unit) = LOWER(:pUnitFilter)) OR " +
            "(LOWER(:pUnitFilterOpt) = 'neq' AND LOWER(eof.unit) != LOWER(:pUnitFilter)) OR " +
            "(LOWER(:pUnitFilterOpt) = 'startswith' AND LOWER(eof.unit) LIKE CONCAT('', LOWER(:pUnitFilter), '%')) OR " +
            "(LOWER(:pUnitFilterOpt) = 'endswith' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '')) OR " +
            "(LOWER(:pUnitFilterOpt) = 'contains' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pDepartmentFilter)='all' OR (" +
            "(LOWER(:pDepartmentOpt) = 'eq' AND LOWER(eof.department) = LOWER(:pDepartmentFilter)) OR " +
            "(LOWER(:pDepartmentOpt) = 'neq' AND LOWER(eof.department) != LOWER(:pDepartmentFilter)) OR " +
            "(LOWER(:pDepartmentOpt) = 'startswith' AND LOWER(eof.department) LIKE CONCAT('', LOWER(:pDepartmentFilter), '%')) OR " +
            "(LOWER(:pDepartmentOpt) = 'endswith' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '')) OR " +
            "(LOWER(:pDepartmentOpt) = 'contains' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pDesignationFilter)='all' OR (" +
            "(LOWER(:pDesignationOpt) = 'eq' AND LOWER(eof.designation) = LOWER(:pDesignationFilter)) OR " +
            "(LOWER(:pDesignationOpt) = 'neq' AND LOWER(eof.designation) != LOWER(:pDesignationFilter)) OR " +
            "(LOWER(:pDesignationOpt) = 'startswith' AND LOWER(eof.designation) LIKE CONCAT('', LOWER(:pDesignationFilter), '%')) OR " +
            "(LOWER(:pDesignationOpt) = 'endswith' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '')) OR " +
            "(LOWER(:pDesignationOpt) = 'contains' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pStaffCategoryFilter)='all' OR (" +
            "(LOWER(:pStaffCategoryOpt) = 'eq' AND LOWER(eof.staffCategory) = LOWER(:pStaffCategoryFilter)) OR " +
            "(LOWER(:pStaffCategoryOpt) = 'neq' AND LOWER(eof.staffCategory) != LOWER(:pStaffCategoryFilter)) OR " +
            "(LOWER(:pStaffCategoryOpt) = 'startswith' AND LOWER(eof.staffCategory) LIKE CONCAT('', LOWER(:pStaffCategoryFilter), '%')) OR " +
            "(LOWER(:pStaffCategoryOpt) = 'endswith' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '')) OR " +
            "(LOWER(:pStaffCategoryOpt) = 'contains' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '%')))" +
            ")"
    )
    Page<Object[]> getAllRuleTaggedEmployeeByRuleCodeByFilters(
                    @Param("pRuleName") String pRuleName,
                    @Param("pRuleCode") String pRuleCode,
                    @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
                    @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
                    @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
                    @Param("pUnitFilter") String pUnitFilter, @Param("pUnitFilterOpt") String pUnitFilterOpt,
                    @Param("pDepartmentFilter") String pDepartmentFilter, @Param("pDepartmentOpt") String pDepartmentOpt,
                    @Param("pDesignationFilter") String pDesignationFilter, @Param("pDesignationOpt") String pDesignationOpt,
                    @Param("pStaffCategoryFilter") String pStaffCategoryFilter, @Param("pStaffCategoryOpt") String pStaffCategoryOpt,
                    Pageable pageable
            );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof ON emp.employeeCode = eof.employeeInfo.employeeCode " +
            "INNER JOIN EmployeeRuleTag ert ON emp.employeeCode = ert.employeeInfo.employeeCode " +
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
            " AND (" +
                "(LOWER(:pRuleName)='Bonus Rule' AND LOWER(ert.bonusPolicyCode)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='OT Rule' AND LOWER(ert.otRule)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='ALD Rule' AND LOWER(ert.attendanceLateDeductionRule)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='Final Settlement Rule' AND LOWER(ert.finalSettlementRule)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='Additional Salary Rule' AND LOWER(ert.additionalSalaryRule)=LOWER(:pRuleCode)) " +
            ") " +
            " AND (" +
                "LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR "+
                "LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.department) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%')" +
            ")"
    )
    Page<Object[]> getAllRuleTaggedEmployeeAdvanceSearchByFilters(
        @Param("pRuleName") String pRuleName,
        @Param("pRuleCode") String pRuleCode,
        @Param("pAdvanceSearchFilter") String pAdvanceSearchFilter,
        Pageable pageable
    );
    /*End*/

    /*Rule Tag Unassigned Employee list*/
    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof ON emp.employeeCode = eof.employeeInfo.employeeCode " +
            "LEFT OUTER JOIN EmployeeRuleTag ert ON emp.employeeCode = ert.employeeInfo.employeeCode " +
                " AND (" +
                    "(LOWER(:pRuleName)='Bonus Rule' AND LOWER(ert.bonusPolicyCode)=LOWER(:pRuleCode)) " +
                    "OR (LOWER(:pRuleName)='OT Rule' AND LOWER(ert.otRule)=LOWER(:pRuleCode)) " +
                    "OR (LOWER(:pRuleName)='ALD Rule' AND LOWER(ert.attendanceLateDeductionRule)=LOWER(:pRuleCode)) " +
                    "OR (LOWER(:pRuleName)='Final Settlement Rule' AND LOWER(ert.finalSettlementRule)=LOWER(:pRuleCode)) " +
                    "OR (LOWER(:pRuleName)='Additional Salary Rule' AND LOWER(ert.additionalSalaryRule)=LOWER(:pRuleCode)) " +
                ") "+
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
                "AND ert.employeeInfo.employeeCode IS NULL"
            )
    Page<Object[]> getAllRuleUnTaggedEmployeeByRuleCode(
            @Param("pRuleName") String pRuleName,
            @Param("pRuleCode") String pRuleCode,
            Pageable pageable
    );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof ON emp.employeeCode = eof.employeeInfo.employeeCode " +
            "LEFT OUTER JOIN EmployeeRuleTag ert ON emp.employeeCode = ert.employeeInfo.employeeCode " +
            " AND (" +
            "(LOWER(:pRuleName)='Bonus Rule' AND LOWER(ert.bonusPolicyCode)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='OT Rule' AND LOWER(ert.otRule)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='ALD Rule' AND LOWER(ert.attendanceLateDeductionRule)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='Final Settlement Rule' AND LOWER(ert.finalSettlementRule)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='Additional Salary Rule' AND LOWER(ert.additionalSalaryRule)=LOWER(:pRuleCode)) " +
            ") "+
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
            "AND (" +
            "LOWER(:pEmpCodeFilter)='all' OR (" +
            "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
            "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
            "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
            "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
            "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
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
            "LOWER(:pFirstNameFilter)='all' OR (" +
            "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
            "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
            "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
            "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
            "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pUnitFilter)='all' OR (" +
            "(LOWER(:pUnitFilterOpt) = 'eq' AND LOWER(eof.unit) = LOWER(:pUnitFilter)) OR " +
            "(LOWER(:pUnitFilterOpt) = 'neq' AND LOWER(eof.unit) != LOWER(:pUnitFilter)) OR " +
            "(LOWER(:pUnitFilterOpt) = 'startswith' AND LOWER(eof.unit) LIKE CONCAT('', LOWER(:pUnitFilter), '%')) OR " +
            "(LOWER(:pUnitFilterOpt) = 'endswith' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '')) OR " +
            "(LOWER(:pUnitFilterOpt) = 'contains' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pDepartmentFilter)='all' OR (" +
            "(LOWER(:pDepartmentOpt) = 'eq' AND LOWER(eof.department) = LOWER(:pDepartmentFilter)) OR " +
            "(LOWER(:pDepartmentOpt) = 'neq' AND LOWER(eof.department) != LOWER(:pDepartmentFilter)) OR " +
            "(LOWER(:pDepartmentOpt) = 'startswith' AND LOWER(eof.department) LIKE CONCAT('', LOWER(:pDepartmentFilter), '%')) OR " +
            "(LOWER(:pDepartmentOpt) = 'endswith' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '')) OR " +
            "(LOWER(:pDepartmentOpt) = 'contains' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pDesignationFilter)='all' OR (" +
            "(LOWER(:pDesignationOpt) = 'eq' AND LOWER(eof.designation) = LOWER(:pDesignationFilter)) OR " +
            "(LOWER(:pDesignationOpt) = 'neq' AND LOWER(eof.designation) != LOWER(:pDesignationFilter)) OR " +
            "(LOWER(:pDesignationOpt) = 'startswith' AND LOWER(eof.designation) LIKE CONCAT('', LOWER(:pDesignationFilter), '%')) OR " +
            "(LOWER(:pDesignationOpt) = 'endswith' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '')) OR " +
            "(LOWER(:pDesignationOpt) = 'contains' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pStaffCategoryFilter)='all' OR (" +
            "(LOWER(:pStaffCategoryOpt) = 'eq' AND LOWER(eof.staffCategory) = LOWER(:pStaffCategoryFilter)) OR " +
            "(LOWER(:pStaffCategoryOpt) = 'neq' AND LOWER(eof.staffCategory) != LOWER(:pStaffCategoryFilter)) OR " +
            "(LOWER(:pStaffCategoryOpt) = 'startswith' AND LOWER(eof.staffCategory) LIKE CONCAT('', LOWER(:pStaffCategoryFilter), '%')) OR " +
            "(LOWER(:pStaffCategoryOpt) = 'endswith' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '')) OR " +
            "(LOWER(:pStaffCategoryOpt) = 'contains' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '%')))" +
            ") AND ert.employeeInfo.employeeCode IS NULL"
    )
    Page<Object[]> getAllRuleUnTaggedEmployeeByRuleCodeByFilters(
            @Param("pRuleName") String pRuleName,
            @Param("pRuleCode") String pRuleCode,
            @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
            @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
            @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
            @Param("pUnitFilter") String pUnitFilter, @Param("pUnitFilterOpt") String pUnitFilterOpt,
            @Param("pDepartmentFilter") String pDepartmentFilter, @Param("pDepartmentOpt") String pDepartmentOpt,
            @Param("pDesignationFilter") String pDesignationFilter, @Param("pDesignationOpt") String pDesignationOpt,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter, @Param("pStaffCategoryOpt") String pStaffCategoryOpt,
            Pageable pageable
    );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory,tempEmp.editedEntryDateTime " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof ON emp.employeeCode = eof.employeeInfo.employeeCode " +
            "INNER JOIN TempManualEntryEmployeeCode tempEmp ON emp.employeeCode = tempEmp.employeeCode " +
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
            "AND (" +
            "LOWER(:pEmpCodeFilter)='all' OR (" +
                "(LOWER(:pEmpCodeOpt) = 'eq' AND LOWER(emp.employeeCode) = LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'neq' AND LOWER(emp.employeeCode) != LOWER(:pEmpCodeFilter)) OR " +
                "(LOWER(:pEmpCodeOpt) = 'startswith' AND LOWER(emp.employeeCode) LIKE CONCAT('', LOWER(:pEmpCodeFilter), '%')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'endswith' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '')) OR " +
                "(LOWER(:pEmpCodeOpt) = 'contains' AND LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pEmpCodeFilter), '%')))" +
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
            "LOWER(:pFirstNameFilter)='all' OR (" +
                "(LOWER(:pFirstNameOpt) = 'eq' AND LOWER(emp.firstName) = LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'neq' AND LOWER(emp.firstName) != LOWER(:pFirstNameFilter)) OR " +
                "(LOWER(:pFirstNameOpt) = 'startswith' AND LOWER(emp.firstName) LIKE CONCAT('', LOWER(:pFirstNameFilter), '%')) OR " +
                "(LOWER(:pFirstNameOpt) = 'endswith' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '')) OR " +
                "(LOWER(:pFirstNameOpt) = 'contains' AND LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pFirstNameFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pUnitFilter)='all' OR (" +
                "(LOWER(:pUnitFilterOpt) = 'eq' AND LOWER(eof.unit) = LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'neq' AND LOWER(eof.unit) != LOWER(:pUnitFilter)) OR " +
                "(LOWER(:pUnitFilterOpt) = 'startswith' AND LOWER(eof.unit) LIKE CONCAT('', LOWER(:pUnitFilter), '%')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'endswith' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '')) OR " +
                "(LOWER(:pUnitFilterOpt) = 'contains' AND LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pUnitFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pDepartmentFilter)='all' OR (" +
                "(LOWER(:pDepartmentOpt) = 'eq' AND LOWER(eof.department) = LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'neq' AND LOWER(eof.department) != LOWER(:pDepartmentFilter)) OR " +
                "(LOWER(:pDepartmentOpt) = 'startswith' AND LOWER(eof.department) LIKE CONCAT('', LOWER(:pDepartmentFilter), '%')) OR " +
                "(LOWER(:pDepartmentOpt) = 'endswith' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '')) OR " +
                "(LOWER(:pDepartmentOpt) = 'contains' AND LOWER(eof.department) LIKE CONCAT('%', LOWER(:pDepartmentFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pDesignationFilter)='all' OR (" +
                "(LOWER(:pDesignationOpt) = 'eq' AND LOWER(eof.designation) = LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'neq' AND LOWER(eof.designation) != LOWER(:pDesignationFilter)) OR " +
                "(LOWER(:pDesignationOpt) = 'startswith' AND LOWER(eof.designation) LIKE CONCAT('', LOWER(:pDesignationFilter), '%')) OR " +
                "(LOWER(:pDesignationOpt) = 'endswith' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '')) OR " +
                "(LOWER(:pDesignationOpt) = 'contains' AND LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pDesignationFilter), '%')))" +
            ") AND " +
            "(" +
            "LOWER(:pStaffCategoryFilter)='all' OR (" +
                "(LOWER(:pStaffCategoryOpt) = 'eq' AND LOWER(eof.staffCategory) = LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'neq' AND LOWER(eof.staffCategory) != LOWER(:pStaffCategoryFilter)) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'startswith' AND LOWER(eof.staffCategory) LIKE CONCAT('', LOWER(:pStaffCategoryFilter), '%')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'endswith' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '')) OR " +
                "(LOWER(:pStaffCategoryOpt) = 'contains' AND LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pStaffCategoryFilter), '%')))" +
            ")"
    )
    Page<Object[]> getAllSelectedManualAttendanceEmployees(
            @Param("pEmpCodeFilter") String pEmpCodeFilter, @Param("pEmpCodeOpt") String pEmpCodeOpt,
            @Param("pPunchCardFilter") String pPunchCardFilter, @Param("pPunchCardOpt") String pPunchCardOpt,
            @Param("pFirstNameFilter") String pFirstNameFilter, @Param("pFirstNameOpt") String pFirstNameOpt,
            @Param("pUnitFilter") String pUnitFilter, @Param("pUnitFilterOpt") String pUnitFilterOpt,
            @Param("pDepartmentFilter") String pDepartmentFilter, @Param("pDepartmentOpt") String pDepartmentOpt,
            @Param("pDesignationFilter") String pDesignationFilter, @Param("pDesignationOpt") String pDesignationOpt,
            @Param("pStaffCategoryFilter") String pStaffCategoryFilter, @Param("pStaffCategoryOpt") String pStaffCategoryOpt,
            Pageable pageable
    );

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof ON emp.employeeCode = eof.employeeInfo.employeeCode " +
            "LEFT OUTER JOIN EmployeeRuleTag ert ON emp.employeeCode = ert.employeeInfo.employeeCode " +
            "LEFT OUTER JOIN EmployeeRuleTag ert ON emp.employeeCode = ert.employeeInfo.employeeCode " +
            " AND (" +
                "(LOWER(:pRuleName)='Bonus Rule' AND LOWER(ert.bonusPolicyCode)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='OT Rule' AND LOWER(ert.otRule)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='ALD Rule' AND LOWER(ert.attendanceLateDeductionRule)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='Final Settlement Rule' AND LOWER(ert.finalSettlementRule)=LOWER(:pRuleCode)) " +
                "OR (LOWER(:pRuleName)='Additional Salary Rule' AND LOWER(ert.additionalSalaryRule)=LOWER(:pRuleCode)) " +
            ") "+
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
            " AND (" +
                "LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR "+
                "LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.department) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
                "LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%')" +
            ") AND ert.employeeInfo.employeeCode IS NULL"
    )
    Page<Object[]> getAllRuleUnTaggedEmployeeAdvanceSearchByFilters(
            @Param("pRuleName") String pRuleName,
            @Param("pRuleCode") String pRuleCode,
            @Param("pAdvanceSearchFilter") String pAdvanceSearchFilter,
            Pageable pageable
    );
    /*End*/

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof ON emp.employeeCode = eof.employeeInfo.employeeCode " +
            "LEFT OUTER JOIN EmployeeRuleTag ert ON emp.employeeCode = ert.employeeInfo.employeeCode " +
            "LEFT OUTER JOIN EmployeeRuleTag ert ON emp.employeeCode = ert.employeeInfo.employeeCode " +
            " AND (" +
            "(LOWER(:pRuleName)='Bonus Rule' AND LOWER(ert.bonusPolicyCode)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='OT Rule' AND LOWER(ert.otRule)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='ALD Rule' AND LOWER(ert.attendanceLateDeductionRule)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='Final Settlement Rule' AND LOWER(ert.finalSettlementRule)=LOWER(:pRuleCode)) " +
            "OR (LOWER(:pRuleName)='Additional Salary Rule' AND LOWER(ert.additionalSalaryRule)=LOWER(:pRuleCode)) " +
            ") "+
            "WHERE emp.employeeStatus='Active' AND emp.isCandidate = false " +
            " AND (" +
            "LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR "+
            "LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(eof.department) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%')" +
            ") AND ert.employeeInfo.employeeCode IS NULL"
    )
    Page<Object[]> getAllEmployeeCodeByFilter(
            @Param("pRuleName") String pRuleName,
            @Param("pRuleCode") String pRuleCode,
            @Param("pAdvanceSearchFilter") String pAdvanceSearchFilter,
            Pageable pageable
    );

    @Query("SELECT EMP.salutation,EMP.firstName,EMP.middleName,EMP.lastName,EMP.fathersName,EMP.spouseName," +
            "EMP.presentAddress,EMP.presentPS,EMP.presentZIPCode,EMP.presentDistrict,EMP.presentCountry," +
            "EMP.punchCardNo,EMP.dob,EOI.department,EOI.designation,EOI.doj,EOI.department,EOI.unit,EMP.phone," +
            "EMP.permanentAddress,EMP.permanentZIPCode,EMP.permanentPS,EMP.permanentDistrict,EMP.permanentCountry " +
            "FROM EmployeeInfo EMP " +
            "LEFT OUTER JOIN EmployeeOfficeInfo EOI ON EMP.employeeCode = EOI.employeeInfo.employeeCode " +
            "WHERE EMP.employeeCode= :pEmployeeCode")
    Object[] getEmployeeBasicInfo(@Param("pEmployeeCode")String pEmployeeCode);


    @Query("SELECT er.shiftID FROM EmployeeRuleInfo er WHERE er.employeeInfo.employeeCode= :pEmployeeCode")
    String getEmployeeShiftId(@Param("pEmployeeCode")String pEmployeeCode);

    @Query( "SELECT DISTINCT new com.erp.hrm.domain.EmployeeReport(EMP.employeeCode,EMP.displayEmployeeCode," +
            " EMP.punchCardNo,EMP.salutation,EMP.firstName,EMP.lastName,EMP.dob,EMP.email,EMP.gender," +
            " EMP.presentAddress,EMP.permanentAddress,EMP.nationality,EMP.maritalStatus,EMP.employeeType," +
            " EMP.bloodGroup,EMP.religion,EMP.employeeStatus,EMP.presentCountry, " +
            " EOI.doj,EOI.doc,EOI.dos,EOI.unit,EOI.section,EOI.subSection,EOI.floor,EOI.line, " +
            " EOI.department,EOI.designation,EOI.staffCategory,EOI.grade," +
            " ERI.leaveRuleCode, ERI.maternityLeaveRuleCode, ERI.shiftID,ES.amount)" +
            " FROM EmployeeInfo EMP " +
            " INNER JOIN EmployeeOfficeInfo EOI ON EMP.employeeCode = EOI.employeeInfo.employeeCode " +
            " INNER JOIN EmployeeRuleInfo ERI ON EMP.employeeCode = ERI.employeeInfo.employeeCode " +
            " INNER JOIN EmployeeSalary ES ON EMP.employeeCode = ES.employeeInfo.employeeCode " +
            " AND ES.salaryHeadID = 'GROSS'" +
            " WHERE EMP.isProcessed = false")
    List<EmployeeReport> getProcessableEmp();

    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeReport ER " +
            " WHERE ER.employeeCode IN (SELECT EMP.employeeCode FROM EmployeeInfo EMP WHERE EMP.isProcessed = false)")
    int deleteOldProcessableEmp();

    @Transactional
    @Modifying
    @Query( "UPDATE EmployeeInfo " +
            " SET isProcessed = true" +
            " WHERE isProcessed = false")
    int updateProcess();

}
