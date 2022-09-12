package com.erp.hrm.api;

import com.erp.hrm.api.dto.*;
import com.erp.hrm.api.dto.EmployeeInfo.EmployeeInfoGridDTO;
import com.erp.hrm.api.dto.recruitment.*;
import com.erp.hrm.service.recruitment.*;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sohag on 19/10/2017.
 */
@RestController
@RequestMapping("/api/v1/recruitment")
public class RecruitmentApi {
    private CandidateApplicationService candidateApplicationService;
    private CandidateAppointmentLetterService appointmentLetterService;
    private InterviewCardService interviewCardService;
    private IEDepartmentSkillMatrixService skillMatrixService;
    private DoctorDepartmentService doctorDepartmentService;
    private CandidateJobVerificationReportService reportService;

    public RecruitmentApi(CandidateApplicationService candidateApplicationService,
                          InterviewCardService interviewCardService,
                          IEDepartmentSkillMatrixService skillMatrixService,
                          CandidateAppointmentLetterService appointmentLetterService,
                          DoctorDepartmentService doctorDepartmentService,
                          CandidateJobVerificationReportService reportService){
        this.candidateApplicationService = candidateApplicationService;
        this.interviewCardService = interviewCardService;
        this.skillMatrixService = skillMatrixService;
        this.appointmentLetterService = appointmentLetterService;
        this.doctorDepartmentService = doctorDepartmentService;
        this.reportService = reportService;
    }

    /* Candidate application api Start*/

    @RequestMapping(value = "/candidate/getAll", method = RequestMethod.GET)
    public CandidateGridDTO getAllCandidateInfo(PageableDTO pageableDTO){
        return candidateApplicationService.getAllCandidateInfo(pageableDTO);
    }

    @RequestMapping(value = "/generalInfo/save", method = RequestMethod.POST)
    public @ResponseBody
    ActionResult saveGeneralInfo(@RequestBody CandidateGeneralInfoDTO generalInfoDTO){
        return candidateApplicationService.saveGeneralInfo(generalInfoDTO);
    }

    @RequestMapping(value = "/generalInfo/get", method = RequestMethod.GET)
    public @ResponseBody CandidateGeneralInfoDTO getGeneralInfo(String pEmployeeTempCode){
        return candidateApplicationService.getEmployeeInfo(pEmployeeTempCode);
    }

    @RequestMapping(value = "/knownEmployee/save", method = RequestMethod.POST)
    public @ResponseBody
    ActionResult saveKnownEmployeeInfo(@RequestBody KnownEmployeeDTO knownEmployeeDTO){
        return candidateApplicationService.saveKnownEmployeeInfo(knownEmployeeDTO);
    }

    @RequestMapping(value = "/knownEmployee/get", method = RequestMethod.GET)
    public @ResponseBody KnownEmployeeDTO getKnownEmployeeInfo(String pEmployeeTempCode){
        return candidateApplicationService.getKnownEmployeeInfo(pEmployeeTempCode);
    }
    @RequestMapping(value = "/knownEmployee/search", method = RequestMethod.GET)
    public @ResponseBody KnownEmployeeDTO searchKnownEmployeeInfo(String pEmployeeTempCode){
        return candidateApplicationService.searchKnownEmployeeInfo(pEmployeeTempCode);
    }


    @RequestMapping(value = "/emergencyInfo/save", method = RequestMethod.POST)
    public ActionResult saveEmployeeEmergencyPersonInfo(@RequestBody CandidateEmergencyInfoDTO dto){
        return candidateApplicationService.saveEmergencyInfo(dto);
    }

    @RequestMapping(value = "/emergencyInfo/get", method = RequestMethod.GET)
    public @ResponseBody CandidateEmergencyInfoDTO getEmployeeEmergencyPersonInfoList(String pEmployeeTempCode){
        return candidateApplicationService.getEmergencyPersonInfo(pEmployeeTempCode);
    }

    @RequestMapping(value = "/educationInfo/save", method = RequestMethod.POST)
    public @ResponseBody ActionResult saveEmployeeEducationInfo(@RequestBody CandidateEducationInfoDTO dto){
        return candidateApplicationService.saveEducationalInfo(dto);
    }

    @RequestMapping(value = "/educationInfo/getAll", method = RequestMethod.GET)
    public @ResponseBody List<CandidateEducationInfoDTO> getEmployeeEducationInfoList(String pEmployeeTempCode) {
        return candidateApplicationService.getEducationInfoList(pEmployeeTempCode);
    }
    @RequestMapping(value = "/educationInfo/get", method = RequestMethod.GET)
    public @ResponseBody CandidateEducationInfoDTO getEmployeeEducationInfo(Long Id){
        return candidateApplicationService.getEducationInfo(Id);
    }

    @RequestMapping(value = "/professionalQualificationInfo/save", method = RequestMethod.POST)
    public @ResponseBody ActionResult saveEmployeePQInfo(@RequestBody CandidateProfessionalQualificationDTO dto){
        return candidateApplicationService.savePQualificationInfo(dto);
    }

    @RequestMapping(value = "/professionalQualificationInfo/getAll", method = RequestMethod.GET)
    public @ResponseBody List<CandidateProfessionalQualificationDTO> getEmployeePQInfo(String pEmployeeTempCode){
        return candidateApplicationService.getPQualificationInfoList(pEmployeeTempCode);
    }

    @RequestMapping(value = "/professionalQualificationInfo/get", method = RequestMethod.GET)
    public CandidateProfessionalQualificationDTO getEmployeePQInfo(Long Id){
        return candidateApplicationService.getPQualificationInfo(Id);
    }

    @RequestMapping(value = "/employementHistory/save", method = RequestMethod.POST)
    public @ResponseBody ActionResult saveEmployeeHistoryInfo(@RequestBody CandidateJobHistoryDTO dto){
        return candidateApplicationService.saveEmployeeJobHistory(dto);
    }

    @RequestMapping(value = "/employementHistory/getAll", method = RequestMethod.GET)
    public @ResponseBody List<CandidateJobHistoryDTO> getEmploymentHistoryInfoList(String pEmployeeTempCode){
        return candidateApplicationService.getEmploymentHistoryInfoList(pEmployeeTempCode);
    }

    @RequestMapping(value = "/employementHistory/get", method = RequestMethod.GET)
    public @ResponseBody CandidateJobHistoryDTO getEmploymentHistoryInfo(Long Id){
        return candidateApplicationService.getEmploymentHistoryInfo(Id);
    }

    @RequestMapping(value = "/language/save", method = RequestMethod.POST)
    public @ResponseBody ActionResult saveEmployeeLanguageInfo(@RequestBody CandidateLanguageDTO dto){
        return candidateApplicationService.saveLanguage(dto);
    }

    @RequestMapping(value = "/language/getAll", method = RequestMethod.GET)
    public @ResponseBody List<CandidateLanguageDTO> getEmploymentLanguageInfoList(String pEmployeeTempCode){
        return candidateApplicationService.getEmployeeLanguageInfoList(pEmployeeTempCode);
    }

    @RequestMapping(value = "/language/get", method = RequestMethod.GET)
    public @ResponseBody CandidateLanguageDTO getEmploymentLanguageInfo(Long Id){
        return candidateApplicationService.getEmployeeLanguageInfo(Id);
    }

    @RequestMapping(value = "/family/save", method = RequestMethod.POST)
    public ActionResult saveEmployeeFamilyInfo(@RequestBody CandidateFamilyInfoDTO dto){
        return candidateApplicationService.saveFamilyInfo(dto);
    }

    @RequestMapping(value = "/family/get", method = RequestMethod.GET)
    public CandidateFamilyInfoDTO getEmploymentFamilyInfoList(String pEmployeeTempCode){
        return candidateApplicationService.getEmployeeFamilyInfo(pEmployeeTempCode);
    }

    @RequestMapping(value = "/nominee/save", method = RequestMethod.POST)
    public ActionResult saveNominee(@RequestBody CandidateNomineeInfoDTO dto) {
        return candidateApplicationService.saveNominee(dto);
    }

    @RequestMapping(value = "/nominee/get", method = RequestMethod.GET)
    public CandidateNomineeInfoDTO getNomineeInfo(String pEmployeeTempCode) {
        return candidateApplicationService.getNomineeInfo(pEmployeeTempCode);
    }

    /* Candidate application api End*/

    /* Interview card api Start */
    @RequestMapping(value = "/interviewCard/update", method = RequestMethod.PUT)
    public ActionResult updateInterviewCard(@RequestBody InterviewCardDTO interviewCardDTO){
        return interviewCardService.saveInterviewCard(interviewCardDTO);
    }

    @RequestMapping(value = "/interviewCard/get", method = RequestMethod.GET)
    public InterviewCardDTO getInterviewCardInfo(String pEmployeeTempCode){
        return interviewCardService.getInterviewCardInfo(pEmployeeTempCode);
    }
    /* Interview cart api End */

    @RequestMapping(value = "/skillMatrix/section/save", method = RequestMethod.POST)
    public ActionResult saveSkillMatrixSection(@RequestBody CandidateSkillMatrixSectionDTO sectionDTO){
        return skillMatrixService.saveSkillMatrixSection(sectionDTO);
    }

    @RequestMapping(value = "/skillMatrix/section/details/save", method = RequestMethod.POST)
    public ActionResult saveSectionDetails(@RequestBody CandidateSectionProcessDTO sectionProcessDTO){
        return skillMatrixService.saveSkillMatrixSectionProcess(sectionProcessDTO);
    }

    @RequestMapping(value = "/skillMatrix/save", method = RequestMethod.POST)
    public ActionResult saveSkillMatrix(String pEmployeeTempCode,@RequestBody List<SkillMatrixDTO> skillMatrixDTOS){
        return skillMatrixService.save(pEmployeeTempCode,skillMatrixDTOS);
    }

    @RequestMapping(value = "/skillMatrix/process/update", method = RequestMethod.GET)
    public ActionResult updateSectionProcess(int pSectionId, int pSectionProcessId, String pSectionProcessName){
        return skillMatrixService.updateSectionName(pSectionId,pSectionProcessId,pSectionProcessName);
    }

    @RequestMapping(value = "/skillMatrix/getAll", method = RequestMethod.GET)
    public List<SkillMatrixDTO> getAllSkillMatrix(String pEmployeeTempCode){
        return skillMatrixService.getAllSkillMatrix(pEmployeeTempCode);
    }

    @RequestMapping(value = "/skillMatrix/section/getAll", method = RequestMethod.GET)
    public List<SkillMatrixSectionDTO> getAllSkillMatrixSection(String pEmployeeTempCode){
        return skillMatrixService.getAllRecruitSkillMatrixSection(pEmployeeTempCode);
    }

    @RequestMapping(value = "/skillMatrix/section/delete", method = RequestMethod.GET)
    public ActionResult deleteCandidateSection(int pCandidateSectionId){
        return skillMatrixService.deleteCandidateSection(pCandidateSectionId);
    }

    @RequestMapping(value = "/skillMatrix/section/details/delete", method = RequestMethod.GET)
    public ActionResult deleteCandidateProcess(int pCandidateProcessId){
        return skillMatrixService.deleteCandidateProcess(pCandidateProcessId);
    }

    /*Candidate Appointment Letter Start*/
    @RequestMapping(value = "/candidateDetailsInfo/get", method = RequestMethod.GET)
    public CandidateDetailsInfoDTO getCandidateDetailsInfo(String pEmployeeTempCode){
        return appointmentLetterService.getCandidateDetailsInfo(pEmployeeTempCode);
    }
    /*End*/

    /* Doctor age and capability certificate api Start */
    @RequestMapping(value = "/doctors/ageAndCapabilityCertificate/save", method = RequestMethod.POST)
    public ActionResult saveCandidateAgeAndCertificate(@RequestBody CandidateAgeAndCapabilityCertificateDTO dto){
        return doctorDepartmentService.saveCandidateAgeAndCertificate(dto);
    }

    @RequestMapping(value = "/doctors/ageAndCapabilityCertificate/update", method = RequestMethod.PUT)
    public ActionResult updateCandidateAgeAndCertificate(@RequestBody CandidateAgeAndCapabilityCertificateDTO dto){
        return doctorDepartmentService.updateCandidateAgeAndCertificate(dto);
    }

    @RequestMapping(value = "/doctors/ageAndCapabilityCertificate/get", method = RequestMethod.GET)
    public CandidateAgeAndCapabilityCertificateDTO getCandidateAgeAndCertificate(String pEmployeeTempCode){
        return doctorDepartmentService.getCandidateAgeAndCertificate(pEmployeeTempCode);
    }
    /*End */

    /* Doctor fitness certificate api Start */
    @RequestMapping(value = "/doctors/fitnessCertificate/save", method = RequestMethod.POST)
    public ActionResult saveCandidateFitnessCertificate(@RequestBody CandidateFitnessCertificateDTO dto){
        return doctorDepartmentService.saveCandidateFitnessCertificate(dto);
    }

    @RequestMapping(value = "/doctors/fitnessCertificate/update", method = RequestMethod.PUT)
    public ActionResult updateCandidateFitnessCertificate(@RequestBody CandidateFitnessCertificateDTO dto){
        return doctorDepartmentService.updateCandidateFitnessCertificate(dto);
    }

    @RequestMapping(value = "/doctors/fitnessCertificate/get", method = RequestMethod.GET)
    public CandidateFitnessCertificateDTO getCandidateFitnessCertficate(String pEmployeeTempCode){
        return doctorDepartmentService.getCandidateFitnessCertificate(pEmployeeTempCode);
    }
    /*End */

    /* Doctor addiction certificate api Start */
    @RequestMapping(value = "/doctors/addictionCertificate/save", method = RequestMethod.POST)
    public ActionResult saveCandidateAddictionCertificate(@RequestBody CandidateAddictionCertificateDTO dto){
        return doctorDepartmentService.saveCandidateAddictionCertificate(dto);
    }

    @RequestMapping(value = "/doctors/addictionCertificate/update", method = RequestMethod.PUT)
    public ActionResult updateCandidateAddictionCertificate(@RequestBody CandidateAddictionCertificateDTO dto){
        return doctorDepartmentService.updateCandidateAddictionCertificate(dto);
    }

    @RequestMapping(value = "/doctors/addictionCertificate/get", method = RequestMethod.GET)
    public CandidateAddictionCertificateDTO saveCandidateAddictionCertificate(String pEmployeeTempCode){
        return doctorDepartmentService.getCandidateAddictionCertificate(pEmployeeTempCode);
    }
    /*End */

    /* Job verified report api Start */
    @RequestMapping(value = "/admin/jobVerificationReport/save", method = RequestMethod.POST)
    public ActionResult saveCandidateJobVerificationReport(@RequestBody CandidateJobVerificationReportDTO dto){
        return reportService.saveCandidateJobVerificationReport(dto);
    }

    @RequestMapping(value = "/admin/jobVerificationReport/update", method = RequestMethod.PUT)
    public ActionResult updateCandidateJobVerificationReport(@RequestBody CandidateJobVerificationReportDTO dto){
        return reportService.updateCandidateJobVerificationReport(dto);
    }

    @RequestMapping(value = "/admin/jobVerificationReport/get", method = RequestMethod.GET)
    public CandidateJobVerificationReportDTO getCandidateJobVerificationReport(String pEmployeeTempCode){
        return reportService.getCandidateJobVerificationReport(pEmployeeTempCode);
    }
    /*End */
}