package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.EmployeeRuleTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 19/01/2018.
 */

@Repository
public interface EmployeeRuleTagRepository extends JpaRepository<EmployeeRuleTag, Long>{

    @Query("SELECT ERT FROM EmployeeRuleTag ERT " +
            "INNER JOIN TemporaryRuleTagEmployeeCode TRT ON ERT.employeeInfo.employeeCode = TRT.employeeCode " +
            "WHERE TRT.ruleCode= :pRuleCode AND TRT.userId= :pUserId")
    List<EmployeeRuleTag> getAllEmployeesForUpdateRuleCode(@Param("pRuleCode")String pRuleCode, @Param("pUserId")String pUserId);

    @Query("SELECT TRT.employeeCode FROM TemporaryRuleTagEmployeeCode TRT " +
            "LEFT OUTER JOIN EmployeeRuleTag ERT ON TRT.employeeCode = ERT.employeeInfo.employeeCode " +
            "WHERE TRT.ruleCode= :pRuleCode AND TRT.userId= :pUserId AND ERT.employeeInfo.employeeCode IS NULL")
    List<Object[]> getAllEmployeesForInsertRuleCode(@Param("pRuleCode")String pRuleCode,@Param("pUserId")String pUserId);
}
