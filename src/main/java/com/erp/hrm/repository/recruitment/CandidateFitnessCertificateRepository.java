package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.CandidateFitnessCertificate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateFitnessCertificateRepository extends JpaRepository<CandidateFitnessCertificate, Integer> {
    @Query("SELECT CFC FROM CandidateFitnessCertificate CFC " +
            "WHERE CFC.employeeCode=?1")
    CandidateFitnessCertificate getFitnessCertificate(String pEmployeeCode);
}
