package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.InsuranceNominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceNomineeRepository extends JpaRepository<InsuranceNominee, Long> {
    // Return employee office info based on employee code
    @Query("SELECT ER FROM InsuranceNominee ER WHERE ER.employeeInfo.employeeCode= :pEmployeeCode")
    public InsuranceNominee get(@Param("pEmployeeCode")String pEmployeeCode);

}
