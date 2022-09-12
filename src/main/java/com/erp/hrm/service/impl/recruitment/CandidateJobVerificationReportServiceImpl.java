package com.erp.hrm.service.impl.recruitment;

import com.erp.hrm.api.dto.recruitment.CandidateJobVerificationReportDTO;
import com.erp.hrm.domain.CandidateJobVerificationReport;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.recruitment.CandidateJobVerificationReportRepository;
import com.erp.hrm.service.recruitment.CandidateJobVerificationReportService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CandidateJobVerificationReportServiceImpl implements CandidateJobVerificationReportService {
    private EmployeeInfoRepository employeeInfoRepository;
    private CandidateJobVerificationReportRepository reportRepository;

    public CandidateJobVerificationReportServiceImpl(
            EmployeeInfoRepository employeeInfoRepository,
            CandidateJobVerificationReportRepository reportRepository) {
        this.employeeInfoRepository = employeeInfoRepository;
        this.reportRepository = reportRepository;
    }

    @Override
    public ActionResult saveCandidateJobVerificationReport(CandidateJobVerificationReportDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            CandidateJobVerificationReport data = new CandidateJobVerificationReport();
            data.setEmployeeCode(dto.getEmployeeCode());
            data.setIsContactedWithLastCompany(dto.getIsContactedWithLastCompany());
            data.setCommunicationMediaWithLastCompany(dto.getCommunicationMediaWithLastCompany());
            data.setLastCompanyName(dto.getLastCompanyName());
            data.setLastCompanyAddress(dto.getLastCompanyAddress());
            data.setLastCompanyDesignation(dto.getLastCompanyDesignation());
            data.setLastSection(dto.getLastSection());
            data.setLastJobPeriod(dto.getLastJobPeriod());
            data.setLastEmploymentResult(dto.getLastEmploymentResult());
            data.setIsContactedWithReference(dto.getIsContactedWithReference());
            data.setCommunicationMediaWithReference(dto.getCommunicationMediaWithReference());
            data.setReferenceInfoProviderName(dto.getReferenceInfoProviderName());
            data.setReferencePosition(dto.getReferencePosition());
            data.setReferenceMobileNo(dto.getReferenceMobileNo());
            data.setReferenceResult(dto.getReferenceResult());
            data.setIsContactedForCriminalBackground(dto.getIsContactedForCriminalBackground());
            data.setCommunicationMediaWithPolice(dto.getCommunicationMediaWithPolice());
            data.setCriminalInfoProviderName(dto.getCriminalInfoProviderName());
            data.setCriminalInfoProviderPosition(dto.getCriminalInfoProviderPosition());
            data.setCriminalInfoProvidingDate(dto.getCriminalInfoProvidingDate());
            data.setCriminalInfoProvidingResult(dto.getCriminalInfoProvidingResult());
            data.setIsContactedForReferenceCheck(dto.getIsContactedForReferenceCheck());
            data.setCommunicationMediaForReferenceCheck(dto.getCommunicationMediaForReferenceCheck());
            data.setReferenceCheckInfoProviderName(dto.getReferenceCheckInfoProviderName());
            data.setReferenceCheckInfoProviderAddress(dto.getReferenceCheckInfoProviderAddress());
            data.setReferenceCheckInfoProviderMobile(dto.getReferenceCheckInfoProviderMobile());
            data.setReferenceCheckInfoProvidingResult(dto.getReferenceCheckInfoProvidingResult());
            reportRepository.save(data);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Job verification report saved successfully!");
        }
        catch (Exception ex){
            //Set custom message if error
            ex.printStackTrace();
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(ex.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult updateCandidateJobVerificationReport(CandidateJobVerificationReportDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            CandidateJobVerificationReport data = reportRepository.getOne(dto.getId());
            data.setEmployeeCode(dto.getEmployeeCode());
            data.setIsContactedWithLastCompany(dto.getIsContactedWithLastCompany());
            data.setCommunicationMediaWithLastCompany(dto.getCommunicationMediaWithLastCompany());
            data.setLastCompanyName(dto.getLastCompanyName());
            data.setLastCompanyAddress(dto.getLastCompanyAddress());
            data.setLastCompanyDesignation(dto.getLastCompanyDesignation());
            data.setLastSection(dto.getLastSection());
            data.setLastJobPeriod(dto.getLastJobPeriod());
            data.setLastEmploymentResult(dto.getLastEmploymentResult());
            data.setIsContactedWithReference(dto.getIsContactedWithReference());
            data.setCommunicationMediaWithReference(dto.getCommunicationMediaWithReference());
            data.setReferenceInfoProviderName(dto.getReferenceInfoProviderName());
            data.setReferencePosition(dto.getReferencePosition());
            data.setReferenceMobileNo(dto.getReferenceMobileNo());
            data.setReferenceResult(dto.getReferenceResult());
            data.setIsContactedForCriminalBackground(dto.getIsContactedForCriminalBackground());
            data.setCommunicationMediaWithPolice(dto.getCommunicationMediaWithPolice());
            data.setCriminalInfoProviderName(dto.getCriminalInfoProviderName());
            data.setCriminalInfoProviderPosition(dto.getCriminalInfoProviderPosition());
            data.setCriminalInfoProvidingDate(dto.getCriminalInfoProvidingDate());
            data.setCriminalInfoProvidingResult(dto.getCriminalInfoProvidingResult());
            data.setIsContactedForReferenceCheck(dto.getIsContactedForReferenceCheck());
            data.setCommunicationMediaForReferenceCheck(dto.getCommunicationMediaForReferenceCheck());
            data.setReferenceCheckInfoProviderName(dto.getReferenceCheckInfoProviderName());
            data.setReferenceCheckInfoProviderAddress(dto.getReferenceCheckInfoProviderAddress());
            data.setReferenceCheckInfoProviderMobile(dto.getReferenceCheckInfoProviderMobile());
            data.setReferenceCheckInfoProvidingResult(dto.getReferenceCheckInfoProvidingResult());
            reportRepository.save(data);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Job verification report updated successfully!");
        }
        catch (Exception ex){
            //Set custom message if error
            ex.printStackTrace();
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(ex.getMessage());
        }
        return actionResult;
    }

    @Override
    public CandidateJobVerificationReportDTO getCandidateJobVerificationReport(String pEmployeeCode) {
        CandidateJobVerificationReportDTO dto = new CandidateJobVerificationReportDTO();
        Object[] empBasicInfo = (Object[]) employeeInfoRepository.getEmployeeBasicInfo(pEmployeeCode)[0];
        CandidateJobVerificationReport candidateJobVerificationReport = reportRepository.getCandidateJobVerificationReport(pEmployeeCode);

        String candidateName = "";
        try {
            candidateName = empBasicInfo[0].toString()+" "+empBasicInfo[1].toString()+" "+empBasicInfo[3].toString();
        } catch (Exception ex){}

        dto.setEmployeeCode(pEmployeeCode);
        dto.setCandidateName(candidateName);

        try {
            dto.setCandidateCardNo(empBasicInfo[11].toString());
        }catch (Exception ex){
            dto.setCandidateCardNo("");
        }

        try {
            dto.setCandidateDesignation(empBasicInfo[14].toString());
        }catch (Exception ex){
            dto.setCandidateDesignation("");
        }

        try {
            dto.setCandidateJoiningDate((Date) empBasicInfo[15]);
        }catch (Exception ex){
            dto.setCandidateJoiningDate(null);
        }

        try {
            dto.setMobileNo(empBasicInfo[18].toString());
        }catch (Exception ex){
            dto.setCandidateJoiningDate(null);
        }

        try {
            dto.setPermanentVillage(empBasicInfo[19].toString());
        }catch (Exception ex){
            dto.setPermanentVillage("");
        }

        try {
            dto.setPermanentPO(empBasicInfo[20].toString());
        }catch (Exception ex){
            dto.setPermanentPO("");
        }

        try {
            dto.setPermanentPS(empBasicInfo[21].toString());
        }catch (Exception ex){
            dto.setPermanentPS("");
        }

        try {
            dto.setPermanentDistrict(empBasicInfo[22].toString());
        }catch (Exception ex){
            dto.setPermanentDistrict("");
        }

        try {
            dto.setPresentVillage(empBasicInfo[6].toString());
        }catch (Exception ex){
            dto.setPresentVillage("");
        }

        try {
            dto.setPresentPS(empBasicInfo[7].toString());
        }catch (Exception ex){
            dto.setPresentPS("");
        }

        try {
            dto.setPresentPO(empBasicInfo[8].toString());
        }catch (Exception ex){
            dto.setPresentPO("");
        }

        try {
            dto.setPresentDistrict(empBasicInfo[9].toString());
        }catch (Exception ex){
            dto.setPresentDistrict("");
        }

        if(candidateJobVerificationReport != null){
            dto.setId(candidateJobVerificationReport.getId());
            dto.setIsContactedWithLastCompany(candidateJobVerificationReport.getIsContactedWithLastCompany());
            dto.setCommunicationMediaWithLastCompany(candidateJobVerificationReport.getCommunicationMediaWithLastCompany());
            dto.setLastCompanyName(candidateJobVerificationReport.getLastCompanyName());
            dto.setLastCompanyAddress(candidateJobVerificationReport.getLastCompanyAddress());
            dto.setLastCompanyDesignation(candidateJobVerificationReport.getLastCompanyDesignation());
            dto.setLastSection(candidateJobVerificationReport.getLastSection());
            dto.setLastJobPeriod(candidateJobVerificationReport.getLastJobPeriod());
            dto.setLastEmploymentResult(candidateJobVerificationReport.getLastEmploymentResult());
            dto.setIsContactedWithReference(candidateJobVerificationReport.getIsContactedWithReference());
            dto.setCommunicationMediaWithReference(candidateJobVerificationReport.getCommunicationMediaWithReference());
            dto.setReferenceInfoProviderName(candidateJobVerificationReport.getReferenceInfoProviderName());
            dto.setReferencePosition(candidateJobVerificationReport.getReferencePosition());
            dto.setReferenceMobileNo(candidateJobVerificationReport.getReferenceMobileNo());
            dto.setReferenceResult(candidateJobVerificationReport.getReferenceResult());
            dto.setIsContactedForCriminalBackground(candidateJobVerificationReport.getIsContactedForCriminalBackground());
            dto.setCommunicationMediaWithPolice(candidateJobVerificationReport.getCommunicationMediaWithPolice());
            dto.setCriminalInfoProviderName(candidateJobVerificationReport.getCriminalInfoProviderName());
            dto.setCriminalInfoProviderPosition(candidateJobVerificationReport.getCriminalInfoProviderPosition());
            dto.setCriminalInfoProvidingDate(candidateJobVerificationReport.getCriminalInfoProvidingDate());
            dto.setCriminalInfoProvidingResult(candidateJobVerificationReport.getCriminalInfoProvidingResult());
            dto.setIsContactedForReferenceCheck(candidateJobVerificationReport.getIsContactedForReferenceCheck());
            dto.setCommunicationMediaForReferenceCheck(candidateJobVerificationReport.getCommunicationMediaForReferenceCheck());
            dto.setReferenceCheckInfoProviderName(candidateJobVerificationReport.getReferenceCheckInfoProviderName());
            dto.setReferenceCheckInfoProviderAddress(candidateJobVerificationReport.getReferenceCheckInfoProviderAddress());
            dto.setReferenceCheckInfoProviderMobile(candidateJobVerificationReport.getReferenceCheckInfoProviderMobile());
            dto.setReferenceCheckInfoProvidingResult(candidateJobVerificationReport.getReferenceCheckInfoProvidingResult());
        }
        return dto;
    }
}
