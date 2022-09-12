package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.ProfessionalQualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeePQualificationInfoRepository extends JpaRepository<ProfessionalQualification, Long> {
    @Query("SELECT PQ FROM ProfessionalQualification PQ WHERE PQ.employeeInfo.employeeCode= :pEmployeeCode")
    public List<ProfessionalQualification> getAllByEmpCode(@Param("pEmployeeCode")String pEmployeeCode);

    @Query("SELECT PQ FROM ProfessionalQualification PQ WHERE PQ.id= :Id")
    public ProfessionalQualification get(@Param("Id")Long Id);
}
