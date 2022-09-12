package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.GratuityNominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GratuityNomineeRepository extends JpaRepository<GratuityNominee, Long> {
    // Return employee office info based on employee code
    @Query("SELECT ER FROM GratuityNominee ER WHERE ER.employeeInfo.employeeCode= :pEmployeeCode")
    public GratuityNominee get(@Param("pEmployeeCode")String pEmployeeCode);

}
