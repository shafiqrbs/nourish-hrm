package com.erp.hrm.repository.employee;

import com.erp.hrm.domain.EmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeJobHistoryInfoRepository extends JpaRepository<EmploymentHistory, Long> {
    @Query("SELECT EO FROM EmploymentHistory EO WHERE EO.employeeInfo.employeeCode= :pEmployeeCode")
    public List<EmploymentHistory> getEmploymentHistoryByEmpCode(@Param("pEmployeeCode")String pEmployeeCode);

    @Query("SELECT EO FROM EmploymentHistory EO WHERE EO.id= :Id")
    public EmploymentHistory get(@Param("Id")Long Id);
}
