package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.EducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeEducationInfoRepository extends JpaRepository<EducationInfo, Long> {
    @Query("SELECT EO FROM EducationInfo EO WHERE EO.employeeInfo.employeeCode= :pEmployeeCode")
    public List<EducationInfo> getAllByEmpCode(@Param("pEmployeeCode")String pEmployeeCode);

    @Query("SELECT EO FROM EducationInfo EO WHERE EO.id= :Id")
    public EducationInfo get(@Param("Id")Long Id);
}
