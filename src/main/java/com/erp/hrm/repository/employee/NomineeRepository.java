package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NomineeRepository extends JpaRepository<Nominee, Long> {
    // Return employee office info based on employee code
    @Query("SELECT ER FROM Nominee ER WHERE ER.employeeInfo.employeeCode= :pEmployeeCode")
    public Nominee get(@Param("pEmployeeCode")String pEmployeeCode);

}
