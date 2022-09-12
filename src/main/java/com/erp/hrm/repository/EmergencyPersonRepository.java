package com.erp.hrm.repository;

import com.erp.hrm.domain.EmergencyPersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmergencyPersonRepository extends JpaRepository<EmergencyPersonInfo, Long> {
    /*
    @Query("SELECT i FROM EmergencyPersonInfo i")
    List<EmergencyPersonInfo> getAll();

    @Query("SELECT i FROM EmergencyPersonInfo i WHERE i.employee.EmployeeCode = ?")
    EmergencyPersonInfo findOneByEmployeeCode(String employeeCode);
    */
}
