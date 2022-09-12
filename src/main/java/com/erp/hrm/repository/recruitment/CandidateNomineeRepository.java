package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.Nominee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateNomineeRepository extends JpaRepository<Nominee, Long> {
    // Return employee office info based on employee code
    @Query("SELECT ER FROM Nominee ER WHERE ER.employeeInfo.employeeCode=?1")
    public Nominee get(String pEmployeeCode);

}
