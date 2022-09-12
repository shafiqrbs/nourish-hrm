package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.PFNominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PFNomineeRepository extends JpaRepository<PFNominee, Long> {
    // Return employee office info based on employee code
    @Query("SELECT ER FROM PFNominee ER WHERE ER.employeeInfo.employeeCode= :pEmployeeCode")
    public PFNominee get(@Param("pEmployeeCode")String pEmployeeCode);

}
