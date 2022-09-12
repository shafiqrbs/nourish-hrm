package com.erp.hrm.repository;

import com.erp.hrm.domain.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {
    @Query("SELECT d FROM EmployeeDetails d")
    List<EmployeeDetails> findAllEmployeeDetails();

    @Query("SELECT d FROM EmployeeDetails d WHERE d.employee.EmployeeCode= :employeeCode")
    EmployeeDetails findOneByEmployeeCode(@Param("employeeCode")String employeeCode);

  /*  @Query("DELETE FROM EmployeeDetails d WHERE d.EmployeeCode=?")
    void deleteByEmployeeCode(String employeeCode);*/
}
