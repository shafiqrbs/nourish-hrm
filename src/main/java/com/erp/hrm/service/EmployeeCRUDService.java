package com.erp.hrm.service;

import com.erp.hrm.api.dto.*;
import com.erp.hrm.domain.*;
import com.erp.hrm.util.ActionResult;

import java.util.List;

public interface EmployeeCRUDService {

    ActionResult saveGeneralInfo(EmployeeGeneralInfoDTO dto);
    EmployeeGeneralInfoDTO getEmployeeInfo(String pEmployeeCode);

    ActionResult saveOfficialInfo(EmployeeOfficeInfoDTO dto);
    EmployeeOfficeInfoDTO getEmployeeOfficeInfo(String pEmployeeCode);

    ActionResult saveRuleInfo(EmployeeRuleInfoDTO dto);
    EmployeeRuleInfoDTO getEmployeeRuleInfo(String pEmployeeCode);

    ActionResult saveEmergencyInfo(EmployeeEmergencyInfoDTO dto);
   /* List<EmployeeEmergencyInfoDTO> getEmergencyPersonInfoList(String pEmployeeCode);
    EmployeeEmergencyInfoDTO getEmergencyPersonInfo(Long Id);*/
   EmployeeEmergencyInfoDTO getEmergencyPersonInfo(String pEmployeeCode);

    ActionResult saveEducationalInfo(EmployeeEducationInfoDTO dto);
    List<EmployeeEducationInfoDTO> getEducationInfoList(String pEmployeeCode);
    EmployeeEducationInfoDTO getEducationInfo(Long Id);

    ActionResult savePQualificationInfo(EmployeeProfessionalQualificationDTO dto);
    List<EmployeeProfessionalQualificationDTO> getPQualificationInfoList(String pEmployeeCode);
    EmployeeProfessionalQualificationDTO getPQualificationInfo(Long Id);

    ActionResult saveEmployeeJobHistory(EmployeeJobHistoryDTO dto);
    List<EmployeeJobHistoryDTO> getEmploymentHistoryInfoList(String pEmployeeCode);
    EmployeeJobHistoryDTO getEmploymentHistoryInfo(Long Id);

    ActionResult saveLanguage(EmployeeLanguageDTO dto);
    List<EmployeeLanguageDTO> getEmployeeLanguageInfoList(String pEmployeeCode);
    EmployeeLanguageDTO getEmployeeLanguageInfo(Long Id);

    ActionResult saveFamilyInfo(EmployeeFamilyInfoDTO dto);
    EmployeeFamilyInfoDTO getEmployeeFamilyInfo(String pEmployeeCode);

    ActionResult savePFNominee(EmployeeNomineeInfoDTO dto);
    EmployeeNomineeInfoDTO getPFNomineeInfo(String pEmployeeCode);

    ActionResult saveInsuranceNominee(EmployeeNomineeInfoDTO dto);
    EmployeeNomineeInfoDTO getInsuranceNomineeInfo(String pEmployeeCode);

    ActionResult saveMedicalNominee(EmployeeNomineeInfoDTO dto);
    EmployeeNomineeInfoDTO getMedicalNomineeInfo(String pEmployeeCode);

    ActionResult saveGratuityNominee(EmployeeNomineeInfoDTO dto);
    EmployeeNomineeInfoDTO getGratuityNomineeInfo(String pEmployeeCode);


    ActionResult saveNominee(EmployeeNomineeInfoDTO dto);
    EmployeeNomineeInfoDTO getNomineeInfo(String pEmployeeCode);

    ActionResult processEmployee();
}
