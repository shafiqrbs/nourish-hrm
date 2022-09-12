package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.CandidateJobVerificationReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateJobVerificationReportRepository extends JpaRepository<CandidateJobVerificationReport, Integer> {
    @Query("SELECT JVR FROM CandidateJobVerificationReport JVR " +
            "WHERE JVR.employeeCode=?1")
    CandidateJobVerificationReport getCandidateJobVerificationReport(String pEmployeeCode);
}
