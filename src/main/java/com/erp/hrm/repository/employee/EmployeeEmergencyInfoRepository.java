package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.EmergencyPersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeEmergencyInfoRepository extends JpaRepository<EmergencyPersonInfo, Long> {
    // Return employee office info based on employee code
   /* @Query("SELECT EO FROM EmergencyPersonInfo EO WHERE EO.employeeInfo.EmployeeCode=?1")
    public List<EmergencyPersonInfo> getAllByEmpCode(String pEmployeeCode);

    @Query("SELECT EO FROM EmergencyPersonInfo EO WHERE EO.id=?1")
    public EmergencyPersonInfo get(Long Id);*/

    @Query("SELECT EO FROM EmergencyPersonInfo EO WHERE EO.employeeInfo.employeeCode= :pEmployeeCode")
    public EmergencyPersonInfo get(@Param("pEmployeeCode")String pEmployeeCode);
}
