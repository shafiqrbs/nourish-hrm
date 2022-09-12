package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.EmployeeInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface CandidateApplicationRepository extends JpaRepository<EmployeeInfo, String> {

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.isCandidate = true")
    Page<Object[]> getAllCandidateInfo(Pageable pageable);


    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.isCandidate = true AND (LOWER(:pEmployeeStatus)='all' OR emp.employeeStatus = LOWER(:pEmployeeStatus)) AND " +
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
    Page<Object[]> getAllCandidateByFilters(
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
            "WHERE (LOWER(:pEmployeeStatus)='all' OR emp.employeeStatus = LOWER(:pEmployeeStatus)) AND " +
            "emp.isCandidate = true AND (" +
            "LOWER(emp.employeeCode) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR "+
            "LOWER(emp.punchCardNo) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(emp.firstName) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(eof.unit) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(eof.department) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(eof.designation) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%') OR " +
            "LOWER(eof.staffCategory) LIKE CONCAT('%', LOWER(:pAdvanceSearchFilter), '%')" +
            ")"
    )
    Page<Object[]> getAllCandidateAdvanceSearchByFilters(
            @Param("pAdvanceSearchFilter") String pAdvanceSearchFilter,
            @Param("pEmployeeStatus") String pEmployeeStatus,Pageable pageable
    );

    @Query("SELECT emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.phone, " +
            "eof.section,eof.position  " +
            "FROM EmployeeInfo emp " +
            "LEFT OUTER JOIN emp.employeeOfficeInfo eof " +
            "WHERE emp.isCandidate = false AND emp.employeeCode = ?1")
    Object[] getKnownEmployeeInfo(String pEmployeeCode);
}
