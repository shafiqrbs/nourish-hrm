package com.erp.hrm.service;

import com.erp.hrm.api.dto.EmployeeEmergencyInfoDTO;
import com.erp.hrm.domain.EmergencyPersonInfo;
import com.erp.hrm.domain.EmployeeDetails;

import java.util.List;

public interface EmergencyPersonService {
    EmergencyPersonInfo save(EmergencyPersonInfo details);

    EmergencyPersonInfo update(EmergencyPersonInfo details);

    List<EmergencyPersonInfo> findAllEmergencyInfo();

    EmergencyPersonInfo findOne(String EmployeeCode);

    EmergencyPersonInfo saveEmployeeEmergencyPerson(EmployeeEmergencyInfoDTO dto);
}
