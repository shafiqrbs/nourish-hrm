package com.erp.hrm.repository;

import com.erp.hrm.domain.ProfessionalQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessionalQualificationRepository extends JpaRepository<ProfessionalQualification,Long> {
}
