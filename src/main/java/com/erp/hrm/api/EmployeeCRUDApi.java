package com.erp.hrm.api;

import com.erp.hrm.api.dto.*;
import com.erp.hrm.service.EmployeeCRUDService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sohag on 15/04/2018.
 */
@RestController
@RequestMapping("/api/v1/employees/")
public class EmployeeCRUDApi {
    private EmployeeCRUDService employeeCRUDService;
    public EmployeeCRUDApi(EmployeeCRUDService employeeCRUDService){
        this.employeeCRUDService = employeeCRUDService;
    }

    @RequestMapping(value = "/generalInfo/save", method = RequestMethod.POST)
    public @ResponseBody ActionResult saveGeneralInfo(@RequestBody EmployeeGeneralInfoDTO generalInfoDTO){
        return employeeCRUDService.saveGeneralInfo(generalInfoDTO);
    }

    @RequestMapping(value = "/generalInfo/get", method = RequestMethod.GET)
    public @ResponseBody EmployeeGeneralInfoDTO getGeneralInfo(String pEmployeeCode){
        return employeeCRUDService.getEmployeeInfo(pEmployeeCode);
    }

    @RequestMapping(value = "/officialInfo/save", method = RequestMethod.POST)
    public  @ResponseBody ActionResult saveEmployeeOfficeInfo(@RequestBody EmployeeOfficeInfoDTO officeInfoDTO){
        return employeeCRUDService.saveOfficialInfo(officeInfoDTO);
    }

    @RequestMapping(value = "/officialInfo/get", method = RequestMethod.GET)
    public @ResponseBody EmployeeOfficeInfoDTO getEmployeeOfficeInfo(String pEmployeeCode){
        return employeeCRUDService.getEmployeeOfficeInfo(pEmployeeCode);
    }

    @RequestMapping(value = "/ruleInfo/save", method = RequestMethod.POST)
    public ActionResult saveEmployeeRuleInfo(@RequestBody  EmployeeRuleInfoDTO dto){
        return employeeCRUDService.saveRuleInfo(dto);
    }

    @RequestMapping(value = "/ruleInfo/get", method = RequestMethod.GET)
    public @ResponseBody EmployeeRuleInfoDTO getEmployeeRuleInfo(String pEmployeeCode){
        return employeeCRUDService.getEmployeeRuleInfo(pEmployeeCode);
    }

    @RequestMapping(value = "/emergencyInfo/save", method = RequestMethod.POST)
    public ActionResult saveEmployeeEmergencyPersonInfo(@RequestBody EmployeeEmergencyInfoDTO dto){
        return employeeCRUDService.saveEmergencyInfo(dto);
    }

    @RequestMapping(value = "/emergencyInfo/get", method = RequestMethod.GET)
    public @ResponseBody EmployeeEmergencyInfoDTO getEmployeeEmergencyPersonInfoList(String pEmployeeCode){
        return employeeCRUDService.getEmergencyPersonInfo(pEmployeeCode);
    }


   /* @RequestMapping(value = "/emergencyInfo/getAll", method = RequestMethod.GET)
    public @ResponseBody List<EmployeeEmergencyInfoDTO> getEmployeeEmergencyPersonInfoList(String pEmployeeCode){
        List<EmployeeEmergencyInfoDTO> list = employeeCRUDService.getEmergencyPersonInfoList(pEmployeeCode);
        return list;
    }
*/
    /*@RequestMapping(value = "/emergencyInfo/get", method = RequestMethod.GET)
    public @ResponseBody EmployeeEmergencyInfoDTO getEmployeeEmergencyPersonInfo(Long Id){
        return employeeCRUDService.getEmergencyPersonInfo(Id);
    }
*/
    @RequestMapping(value = "/educationInfo/save", method = RequestMethod.POST)
    public @ResponseBody ActionResult saveEmployeeEducationInfo(@RequestBody EmployeeEducationInfoDTO dto){
        return employeeCRUDService.saveEducationalInfo(dto);
    }

    @RequestMapping(value = "/educationInfo/getAll", method = RequestMethod.GET)
    public @ResponseBody List<EmployeeEducationInfoDTO> getEmployeeEducationInfoList(String pEmployeeCode) {
        return employeeCRUDService.getEducationInfoList(pEmployeeCode);
    }
    @RequestMapping(value = "/educationInfo/get", method = RequestMethod.GET)
    public @ResponseBody EmployeeEducationInfoDTO getEmployeeEducationInfo(Long Id){
            return employeeCRUDService.getEducationInfo(Id);
    }

    @RequestMapping(value = "/professionalQualificationInfo/save", method = RequestMethod.POST)
    public @ResponseBody ActionResult saveEmployeePQInfo(@RequestBody EmployeeProfessionalQualificationDTO dto){
        return employeeCRUDService.savePQualificationInfo(dto);
    }

    @RequestMapping(value = "/professionalQualificationInfo/getAll", method = RequestMethod.GET)
    public @ResponseBody List<EmployeeProfessionalQualificationDTO> getEmployeePQInfo(String pEmployeeCode){
        return employeeCRUDService.getPQualificationInfoList(pEmployeeCode);
    }

    @RequestMapping(value = "/professionalQualificationInfo/get", method = RequestMethod.GET)
    public EmployeeProfessionalQualificationDTO getEmployeePQInfo(Long Id){
        return employeeCRUDService.getPQualificationInfo(Id);
    }

    @RequestMapping(value = "/employementHistory/save", method = RequestMethod.POST)
    public @ResponseBody ActionResult saveEmployeeHistoryInfo(@RequestBody EmployeeJobHistoryDTO dto){
        return employeeCRUDService.saveEmployeeJobHistory(dto);
    }

    @RequestMapping(value = "/employementHistory/getAll", method = RequestMethod.GET)
    public @ResponseBody List<EmployeeJobHistoryDTO> getEmploymentHistoryInfoList(String pEmployeeCode){
        return employeeCRUDService.getEmploymentHistoryInfoList(pEmployeeCode);
    }

    @RequestMapping(value = "/employementHistory/get", method = RequestMethod.GET)
    public @ResponseBody EmployeeJobHistoryDTO getEmploymentHistoryInfo(Long Id){
        return employeeCRUDService.getEmploymentHistoryInfo(Id);
    }

    @RequestMapping(value = "/language/save", method = RequestMethod.POST)
    public @ResponseBody ActionResult saveEmployeeLanguageInfo(@RequestBody EmployeeLanguageDTO dto){
        return employeeCRUDService.saveLanguage(dto);
    }

    @RequestMapping(value = "/language/getAll", method = RequestMethod.GET)
    public @ResponseBody List<EmployeeLanguageDTO> getEmploymentLanguageInfoList(String pEmployeeCode){
        return employeeCRUDService.getEmployeeLanguageInfoList(pEmployeeCode);
    }
    @RequestMapping(value = "/language/get", method = RequestMethod.GET)
    public @ResponseBody EmployeeLanguageDTO getEmploymentLanguageInfo(Long Id){
        return employeeCRUDService.getEmployeeLanguageInfo(Id);
    }

    @RequestMapping(value = "/family/save", method = RequestMethod.POST)
    public ActionResult saveEmployeeFamilyInfo(@RequestBody EmployeeFamilyInfoDTO dto){
        return employeeCRUDService.saveFamilyInfo(dto);
    }

    @RequestMapping(value = "/family/get", method = RequestMethod.GET)
    public EmployeeFamilyInfoDTO getEmploymentFamilyInfoList(String pEmployeeCode){
        return employeeCRUDService.getEmployeeFamilyInfo(pEmployeeCode);
    }


    @RequestMapping(value = "/nominee/save", method = RequestMethod.POST)
    public ActionResult saveNominee(@RequestBody EmployeeNomineeInfoDTO dto) {
        return employeeCRUDService.saveNominee(dto);
    }

    @RequestMapping(value = "/nominee/get", method = RequestMethod.GET)
    public EmployeeNomineeInfoDTO getNomineeInfo(String pEmployeeCode) {
        return employeeCRUDService.getNomineeInfo(pEmployeeCode);
    }

    @RequestMapping(value = "/pfNominee/save", method = RequestMethod.POST)
    public ActionResult savePFNominee(@RequestBody EmployeeNomineeInfoDTO dto) {
        return employeeCRUDService.savePFNominee(dto);
    }

    @RequestMapping(value = "/pfNominee/get", method = RequestMethod.GET)
    public EmployeeNomineeInfoDTO getPFNomineeInfo(String pEmployeeCode) {
        return employeeCRUDService.getPFNomineeInfo(pEmployeeCode);
    }

    @RequestMapping(value = "/iNominee/save", method = RequestMethod.POST)
    public ActionResult saveInsuranceNominee(@RequestBody EmployeeNomineeInfoDTO dto) {
        return employeeCRUDService.saveInsuranceNominee(dto);
    }

    @RequestMapping(value = "/iNominee/get", method = RequestMethod.GET)
    public EmployeeNomineeInfoDTO getInsuranceNomineeInfo(String pEmployeeCode) {
        return employeeCRUDService.getInsuranceNomineeInfo(pEmployeeCode);
    }

    @RequestMapping(value = "/mNominee/save", method = RequestMethod.POST)
    public ActionResult saveMedicalNominee(@RequestBody EmployeeNomineeInfoDTO dto) {
        return employeeCRUDService.saveMedicalNominee(dto);
    }

    @RequestMapping(value = "/mNominee/get", method = RequestMethod.GET)
    public EmployeeNomineeInfoDTO getMedicalNomineeInfo(String pEmployeeCode) {
        return employeeCRUDService.getMedicalNomineeInfo(pEmployeeCode);
    }

    @RequestMapping(value = "/gNominee/save", method = RequestMethod.POST)
    public ActionResult saveGratuityNominee(@RequestBody EmployeeNomineeInfoDTO dto) {
        return employeeCRUDService.saveGratuityNominee(dto);
    }

    @RequestMapping(value = "/gNominee/get", method = RequestMethod.GET)
    public EmployeeNomineeInfoDTO getGratuityNomineeInfo(String pEmployeeCode) {
        return employeeCRUDService.getGratuityNomineeInfo(pEmployeeCode);
    }


    @RequestMapping(value = "/process", method = RequestMethod.POST)
    public ActionResult processEmployee() {
        return employeeCRUDService.processEmployee();
    }


}
