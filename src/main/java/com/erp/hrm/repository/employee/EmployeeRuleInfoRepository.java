package com.erp.hrm.repository.employee;

//import com.erp.hrm.domain.EmployeeOfficeInfo;
import com.erp.hrm.domain.EmployeeRuleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRuleInfoRepository extends JpaRepository<EmployeeRuleInfo, Long> {
    // Return employee office info based on employee code
    @Query("SELECT ER FROM EmployeeRuleInfo ER WHERE ER.employeeInfo.employeeCode= :pEmployeeCode")
    public EmployeeRuleInfo get(@Param("pEmployeeCode")String pEmployeeCode);

}
