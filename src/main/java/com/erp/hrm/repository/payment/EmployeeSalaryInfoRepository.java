package com.erp.hrm.repository.payment;

import com.erp.hrm.domain.EmployeeSalary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

/**
 * Created by Sohag on 5/13/2017.
 */
public interface EmployeeSalaryInfoRepository extends JpaRepository<EmployeeSalary, Long>{
    @Query("SELECT SR.salaryRuleCode,SR.salaryHeadID,SR.sCriteria,SR.parentHeadValue,ES.amount FROM SalaryRule SR " +
            "LEFT OUTER JOIN SR.employeeSalaries ES " +
            "WHERE SR.salaryRuleCode=?1 AND ES.employeeInfo.employeeCode=?2 AND SR.salaryHeadID !='GROSS' " +
            "ORDER BY SR.sequenceNo ASC")
    List<Object[]> getAllEmployeeSalaryInfo(String pSalaryRuleCode,String pEmployeeCode);

    @Query("SELECT ES.amount FROM EmployeeSalary ES " +
            "WHERE ES.salaryHeadID = 'GROSS' AND ES.employeeInfo.employeeCode=?1")
    float getEmployeeGrossSalary(String pEmployeeCode);

    @Query("SELECT SR.salaryRuleCode FROM EmployeeSalary ES " +
            "INNER JOIN ES.salaryRule SR ON ES.salaryRule.id = SR.id " +
            "WHERE ES.salaryHeadID = 'GROSS' AND ES.employeeInfo.employeeCode=?1")
    String getEmployeeSalaryRuleCode(String pEmployeeCode);

    @Query("SELECT COUNT(ES.id) FROM EmployeeSalary ES " +
            "WHERE ES.salaryRule.salaryRuleCode =?1 AND ES.employeeInfo.employeeCode=?2")
    int getEmployeeSalaryCount(String pSalaryRuleCode,String pEmployeeCode);

    @Query("SELECT ES.salaryHeadID,ES.amount FROM EmployeeSalary ES WHERE ES.employeeInfo.employeeCode=?1")
    List<Objects[]> getEmployeeSalaryByEmployeeCode(String pEmployeeCode);

    @Transactional
    @Modifying
    @Query("DELETE FROM EmployeeSalary ES WHERE ES.employeeInfo.employeeCode=?1")
    void deleteEmployeeSalary(String pEmployeeCode);
}
