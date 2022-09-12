package com.erp.hrm.service;

import com.erp.hrm.api.dto.EmployeeEducationInfoDTO;
import com.erp.hrm.api.dto.EmployeeEmergencyInfoDTO;
import com.erp.hrm.domain.EducationInfo;
import com.erp.hrm.domain.EmergencyPersonInfo;

import java.util.List;

public interface EducationService {

    EducationInfo save(EducationInfo info);

    EducationInfo update(EducationInfo info);

    List<EducationInfo> findAllEducationInfo();

    List<EducationInfo> findByEmployeeCode(String EmployeeCode);

    EducationInfo saveEmployeeEducationInfo(EmployeeEducationInfoDTO dto);
}
