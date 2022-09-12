package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.EducationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateEducationInfoRepository extends JpaRepository<EducationInfo, Long> {
    @Query("SELECT EO FROM EducationInfo EO WHERE EO.employeeInfo.employeeCode=?1")
    public List<EducationInfo> getAllByEmpCode(String pEmployeeCode);

    @Query("SELECT EO FROM EducationInfo EO WHERE EO.id=?1")
    public EducationInfo get(Long Id);
}
