package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.EmployeeFamilyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeFamilyInfoRepository extends JpaRepository<EmployeeFamilyInfo, Long> {
    @Query("SELECT EO FROM EmployeeFamilyInfo EO WHERE EO.employeeInfo.employeeCode= :pEmployeeCode")
    public EmployeeFamilyInfo getFamilyByEmpCode(@Param("pEmployeeCode")String pEmployeeCode);

}
