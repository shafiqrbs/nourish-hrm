package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.CandidateAddictionCertificate;
import com.erp.hrm.domain.CandidateFitnessCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateAddictionCertificateRepository extends JpaRepository<CandidateAddictionCertificate, Integer> {
    @Query("SELECT CAC FROM CandidateAddictionCertificate CAC " +
            "WHERE CAC.employeeCode=?1")
    CandidateAddictionCertificate getAddictionCertificate(String pEmployeeCode);
}
