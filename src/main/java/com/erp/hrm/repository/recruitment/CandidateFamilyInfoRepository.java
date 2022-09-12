package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.EmployeeFamilyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateFamilyInfoRepository extends JpaRepository<EmployeeFamilyInfo, Long> {
    @Query("SELECT EO FROM EmployeeFamilyInfo EO WHERE EO.employeeInfo.employeeCode=?1")
    public EmployeeFamilyInfo getFamilyByEmpCode(String pEmployeeCode);

}
