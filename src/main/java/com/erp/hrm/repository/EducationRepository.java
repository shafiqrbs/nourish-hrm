package com.erp.hrm.repository;

import com.erp.hrm.domain.EducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<EducationInfo, Long> {
    @Query("SELECT e FROM EducationInfo e")
    List<EducationInfo> findAllEducation();
/*
    @Query("SELECT e FROM EducationInfo e WHERE e.employee.EmployeeCode = ?")
    List<EducationInfo> findAllEducationByEmployeeCode(String EmployeeCode);
*/
}
