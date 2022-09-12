package com.erp.hrm.service.recruitment;

import com.erp.hrm.api.dto.PageableDTO;
import com.erp.hrm.api.dto.recruitment.*;
import com.erp.hrm.util.ActionResult;

import java.util.List;

public interface CandidateApplicationService {

    CandidateGridDTO getAllCandidateInfo(PageableDTO pageableDTO);

    ActionResult saveGeneralInfo(CandidateGeneralInfoDTO dto);
    CandidateGeneralInfoDTO getEmployeeInfo(String pEmployeeCode);

    ActionResult saveEmergencyInfo(CandidateEmergencyInfoDTO dto);
    CandidateEmergencyInfoDTO getEmergencyPersonInfo(String pEmployeeCode);

    ActionResult saveEducationalInfo(CandidateEducationInfoDTO dto);
    List<CandidateEducationInfoDTO> getEducationInfoList(String pEmployeeCode);
    CandidateEducationInfoDTO getEducationInfo(Long Id);

    ActionResult savePQualificationInfo(CandidateProfessionalQualificationDTO dto);
    List<CandidateProfessionalQualificationDTO> getPQualificationInfoList(String pEmployeeCode);
    CandidateProfessionalQualificationDTO getPQualificationInfo(Long Id);

    ActionResult saveEmployeeJobHistory(CandidateJobHistoryDTO dto);
    List<CandidateJobHistoryDTO> getEmploymentHistoryInfoList(String pEmployeeCode);
    CandidateJobHistoryDTO getEmploymentHistoryInfo(Long Id);

    ActionResult saveLanguage(CandidateLanguageDTO dto);
    List<CandidateLanguageDTO> getEmployeeLanguageInfoList(String pEmployeeCode);
    CandidateLanguageDTO getEmployeeLanguageInfo(Long Id);

    ActionResult saveNominee(CandidateNomineeInfoDTO dto);
    CandidateNomineeInfoDTO getNomineeInfo(String pEmployeeCode);

    ActionResult saveFamilyInfo(CandidateFamilyInfoDTO dto);
    CandidateFamilyInfoDTO getEmployeeFamilyInfo(String pEmployeeCode);

    ActionResult saveKnownEmployeeInfo(KnownEmployeeDTO dto);
    KnownEmployeeDTO getKnownEmployeeInfo(String pEmployeeCode);
    KnownEmployeeDTO searchKnownEmployeeInfo(String pEmployeeCode);

}
