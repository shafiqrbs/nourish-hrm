package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.CandidateAgeAndCapabilityCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateAgeAndCapabilityCertificateRepository extends JpaRepository<CandidateAgeAndCapabilityCertificate, Integer> {
    @Query("SELECT ACC FROM CandidateAgeAndCapabilityCertificate ACC " +
            "WHERE ACC.employeeCode=?1")
    CandidateAgeAndCapabilityCertificate getAgeAndCapabilityCertificate(String pEmployeeCode);



}
