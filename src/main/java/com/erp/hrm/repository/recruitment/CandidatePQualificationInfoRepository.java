package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.ProfessionalQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidatePQualificationInfoRepository extends JpaRepository<ProfessionalQualification, Long> {
    @Query("SELECT PQ FROM ProfessionalQualification PQ WHERE PQ.employeeInfo.employeeCode=?1")
    public List<ProfessionalQualification> getAllByEmpCode(String pEmployeeCode);

    @Query("SELECT PQ FROM ProfessionalQualification PQ WHERE PQ.id=?1")
    public ProfessionalQualification get(Long Id);
}
