package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.MedicalNominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalNomineeRepository extends JpaRepository<MedicalNominee, Long> {
    // Return employee office info based on employee code
    @Query("SELECT ER FROM MedicalNominee ER WHERE ER.employeeInfo.employeeCode= :pEmployeeCode")
    public MedicalNominee get(@Param("pEmployeeCode")String pEmployeeCode);

}
