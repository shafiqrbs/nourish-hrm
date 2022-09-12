package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.EmergencyPersonInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CandidateEmergencyInfoRepository extends JpaRepository<EmergencyPersonInfo, Long> {

    @Query("SELECT EO FROM EmergencyPersonInfo EO WHERE EO.employeeInfo.employeeCode=?1")
    public EmergencyPersonInfo get(String pEmployeeCode);
}
