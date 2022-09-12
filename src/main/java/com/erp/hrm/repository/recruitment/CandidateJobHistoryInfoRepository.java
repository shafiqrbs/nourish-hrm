package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.EmploymentHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateJobHistoryInfoRepository extends JpaRepository<EmploymentHistory, Long> {
    @Query("SELECT EO FROM EmploymentHistory EO WHERE EO.employeeInfo.employeeCode=?1")
    public List<EmploymentHistory> getEmploymentHistoryByEmpCode(String pEmployeeCode);

    @Query("SELECT EO FROM EmploymentHistory EO WHERE EO.id=?1")
    public EmploymentHistory get(Long Id);
}
