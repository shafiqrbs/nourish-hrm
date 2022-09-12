package com.erp.hrm.service.impl.recruitment;

import com.erp.hrm.api.dto.recruitment.CandidateAddictionCertificateDTO;
import com.erp.hrm.api.dto.recruitment.CandidateAgeAndCapabilityCertificateDTO;
import com.erp.hrm.api.dto.recruitment.CandidateFitnessCertificateDTO;
import com.erp.hrm.domain.CandidateAddictionCertificate;
import com.erp.hrm.domain.CandidateAgeAndCapabilityCertificate;
import com.erp.hrm.domain.CandidateFitnessCertificate;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.recruitment.CandidateAddictionCertificateRepository;
import com.erp.hrm.repository.recruitment.CandidateAgeAndCapabilityCertificateRepository;
import com.erp.hrm.repository.recruitment.CandidateFitnessCertificateRepository;
import com.erp.hrm.service.recruitment.DoctorDepartmentService;
import com.erp.hrm.util.ActionResult;
import com.erp.hrm.util.ErpUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DoctorDepartmentServiceImpl implements DoctorDepartmentService {
    private EmployeeInfoRepository employeeInfoRepository;
    private CandidateAgeAndCapabilityCertificateRepository ageAndCapabilityCertificateRepository;
    private CandidateFitnessCertificateRepository fitnessCertificateRepository;
    private CandidateAddictionCertificateRepository addictionCertificateRepository;

    public DoctorDepartmentServiceImpl(
            EmployeeInfoRepository employeeInfoRepository,
            CandidateAgeAndCapabilityCertificateRepository ageAndCapabilityCertificateRepository,
            CandidateFitnessCertificateRepository fitnessCertificateRepository,
            CandidateAddictionCertificateRepository addictionCertificateRepository) {
        this.employeeInfoRepository = employeeInfoRepository;
        this.ageAndCapabilityCertificateRepository = ageAndCapabilityCertificateRepository;
        this.fitnessCertificateRepository = fitnessCertificateRepository;
        this.addictionCertificateRepository = addictionCertificateRepository;
    }

    @Override
    public ActionResult saveCandidateAgeAndCertificate(CandidateAgeAndCapabilityCertificateDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            CandidateAgeAndCapabilityCertificate data = new CandidateAgeAndCapabilityCertificate();
            data.setCertificateDate(ErpUtils.todayDate());
            data.setEmployeeCode(dto.getEmployeeCode());
            data.setCandidateHeight(dto.getCandidateHeight());
            data.setCandidateWeight(dto.getCandidateWeight());
            data.setCandidateAge(dto.getCandidateAge());
            data.setCandidateDentalStructure(dto.getCandidateDentalStructure());
            data.setCandidatePeriodForWomen(dto.getCandidatePeriodForWomen());
            data.setCandidateBeardForBoy(dto.getCandidateBeardForBoy());
            data.setCandidateOthersInfo(dto.getCandidateOthersInfo());
            data.setDoctorsOpinion(dto.getDoctorsOpinion());
            ageAndCapabilityCertificateRepository.save(data);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Age and Capability Certificate saved successfully!");
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
    public ActionResult updateCandidateAgeAndCertificate(CandidateAgeAndCapabilityCertificateDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            CandidateAgeAndCapabilityCertificate data = ageAndCapabilityCertificateRepository.getOne(dto.getId());
            data.setCertificateDate(ErpUtils.todayDate());
            data.setEmployeeCode(dto.getEmployeeCode());
            data.setCandidateHeight(dto.getCandidateHeight());
            data.setCandidateWeight(dto.getCandidateWeight());
            data.setCandidateAge(dto.getCandidateAge());
            data.setCandidateDentalStructure(dto.getCandidateDentalStructure());
            data.setCandidatePeriodForWomen(dto.getCandidatePeriodForWomen());
            data.setCandidateBeardForBoy(dto.getCandidateBeardForBoy());
            data.setCandidateOthersInfo(dto.getCandidateOthersInfo());
            data.setDoctorsOpinion(dto.getDoctorsOpinion());
            ageAndCapabilityCertificateRepository.save(data);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Age and Capability Certificate updated successfully!");
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
    public CandidateAgeAndCapabilityCertificateDTO getCandidateAgeAndCertificate(String pEmployeeCode) {
        CandidateAgeAndCapabilityCertificateDTO dto = new CandidateAgeAndCapabilityCertificateDTO();
        Object[] empBasicInfo = (Object[]) employeeInfoRepository.getEmployeeBasicInfo(pEmployeeCode)[0];
        CandidateAgeAndCapabilityCertificate capabilityCertificate = ageAndCapabilityCertificateRepository.getAgeAndCapabilityCertificate(pEmployeeCode);

        String candidateName = "";
        try {
            candidateName = empBasicInfo[0].toString()+" "+empBasicInfo[1].toString()+" "+empBasicInfo[3].toString();
        } catch (Exception ex){}
        String presentAddress = "";
        try {
            presentAddress = presentAddress + (empBasicInfo[6].toString() == null ? "" : empBasicInfo[6].toString());
            presentAddress = presentAddress + (empBasicInfo[7].toString() == null ? "" : ", " + empBasicInfo[7].toString());
            presentAddress = presentAddress + (empBasicInfo[8].toString() == null ? "" : ", " + empBasicInfo[8].toString());
            presentAddress = presentAddress + (empBasicInfo[9].toString() == null ? "" : ", " + empBasicInfo[9].toString());
            presentAddress = presentAddress + (empBasicInfo[10].toString() == null ? "" : ", " + empBasicInfo[10].toString());
        } catch (Exception ex){}

        dto.setEmployeeCode(pEmployeeCode);
        dto.setCandidateName(candidateName);
        try {
            dto.setCandidateFatherName(empBasicInfo[4].toString());
        }catch (Exception ex){
            dto.setCandidateFatherName("");
        }

        try {
            dto.setCandidateSpouseName(empBasicInfo[5].toString());
        }catch (Exception ex){
            dto.setCandidateSpouseName("");
        }

        dto.setCandidatePresentAddress(presentAddress);

        try {
            dto.setCandidateCardNo(empBasicInfo[11].toString());
        }catch (Exception ex){
            dto.setCandidateCardNo("");
        }

        try {
            dto.setCandidateDOB((Date) empBasicInfo[12]);
        }catch (Exception ex){
            dto.setCandidateDOB(null);
        }

        try {
            dto.setCandidateDesignation(empBasicInfo[14].toString());
        }catch (Exception ex){
            dto.setCandidateDesignation("");
        }

        if(capabilityCertificate != null){
            dto.setId(capabilityCertificate.getId());
            dto.setCertificateDate(capabilityCertificate.getCertificateDate());
            dto.setCandidateHeight(capabilityCertificate.getCandidateHeight());
            dto.setCandidateWeight(capabilityCertificate.getCandidateWeight());
            dto.setCandidateAge(capabilityCertificate.getCandidateAge());
            dto.setCandidateDentalStructure(capabilityCertificate.getCandidateDentalStructure());
            dto.setCandidatePeriodForWomen(capabilityCertificate.getCandidatePeriodForWomen());
            dto.setCandidateBeardForBoy(capabilityCertificate.getCandidateBeardForBoy());
            dto.setCandidateOthersInfo(capabilityCertificate.getCandidateOthersInfo());
            dto.setDoctorsOpinion(capabilityCertificate.getDoctorsOpinion());
        }
        return dto;
    }

    @Override
    public ActionResult saveCandidateFitnessCertificate(CandidateFitnessCertificateDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            CandidateFitnessCertificate data = new CandidateFitnessCertificate();
            data.setCertificateDate(ErpUtils.todayDate());
            data.setEmployeeCode(dto.getEmployeeCode());
            data.setDoctorsOpinion(dto.getDoctorsOpinion());
            data.setNurseOpinion(dto.getNurseOpinion());
            fitnessCertificateRepository.save(data);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Fitness Certificate saved successfully!");
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
    public ActionResult updateCandidateFitnessCertificate(CandidateFitnessCertificateDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            CandidateFitnessCertificate data = fitnessCertificateRepository.getOne(dto.getId());
            data.setCertificateDate(ErpUtils.todayDate());
            data.setEmployeeCode(dto.getEmployeeCode());
            data.setDoctorsOpinion(dto.getDoctorsOpinion());
            data.setNurseOpinion(dto.getNurseOpinion());
            fitnessCertificateRepository.save(data);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Fitness Certificate updated successfully!");
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
    public CandidateFitnessCertificateDTO getCandidateFitnessCertificate(String pEmployeeCode) {
        CandidateFitnessCertificateDTO dto = new CandidateFitnessCertificateDTO();
        Object[] empBasicInfo = (Object[]) employeeInfoRepository.getEmployeeBasicInfo(pEmployeeCode)[0];
        CandidateFitnessCertificate fitnessCertificate = fitnessCertificateRepository.getFitnessCertificate(pEmployeeCode);

        String candidateName = "";
        try {
            candidateName = empBasicInfo[0].toString()+" "+empBasicInfo[1].toString()+" "+empBasicInfo[3].toString();
        } catch (Exception ex){}
        dto.setEmployeeCode(pEmployeeCode);
        dto.setCandidateName(candidateName);
        try {
            dto.setCandidateFatherName(empBasicInfo[4].toString());
        }catch (Exception ex){
            dto.setCandidateFatherName("");
        }

        try {
            dto.setCandidateSpouseName(empBasicInfo[5].toString());
        }catch (Exception ex){
            dto.setCandidateSpouseName("");
        }
        dto.setCandidateName(candidateName);
        if(fitnessCertificate !=null){
            dto.setId(fitnessCertificate.getId());
            dto.setCertificateDate(fitnessCertificate.getCertificateDate());
            dto.setDoctorsOpinion(fitnessCertificate.getDoctorsOpinion());
            dto.setNurseOpinion(fitnessCertificate.getNurseOpinion());
        }
        return dto;
    }

    @Override
    public ActionResult saveCandidateAddictionCertificate(CandidateAddictionCertificateDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            CandidateAddictionCertificate data = new CandidateAddictionCertificate();
            data.setCertificateDate(ErpUtils.todayDate());
            data.setEmployeeCode(dto.getEmployeeCode());

            try { data.setCheckTeethAndGum(dto.isCheckTeethAndGum()); }
            catch (Exception e){ data.setCheckTeethAndGum(false); }

            try { data.setCheckTongueAndLip(dto.isCheckTongueAndLip()); }
            catch (Exception e){ data.setCheckTongueAndLip(false); }

            try { data.setCheckEye(dto.isCheckEye()); }
            catch (Exception e){ data.setCheckEye(false); }

            try { data.setOtherSign(dto.isOtherSign()); }
            catch (Exception e){ data.setOtherSign(false); }

            data.setDoctorsOpinion(dto.getDoctorsOpinion());
            data.setNurseOpinion(dto.getNurseOpinion());
            addictionCertificateRepository.save(data);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Addiction Certificate saved successfully!");
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
    public ActionResult updateCandidateAddictionCertificate(CandidateAddictionCertificateDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            CandidateAddictionCertificate data = addictionCertificateRepository.getOne(dto.getId());
            data.setCertificateDate(ErpUtils.todayDate());
            data.setEmployeeCode(dto.getEmployeeCode());

            try { data.setCheckTeethAndGum(dto.isCheckTeethAndGum()); }
            catch (Exception e){ data.setCheckTeethAndGum(false); }

            try { data.setCheckTongueAndLip(dto.isCheckTongueAndLip()); }
            catch (Exception e){ data.setCheckTongueAndLip(false); }

            try { data.setCheckEye(dto.isCheckEye()); }
            catch (Exception e){ data.setCheckEye(false); }

            try { data.setOtherSign(dto.isOtherSign()); }
            catch (Exception e){ data.setOtherSign(false); }

            data.setDoctorsOpinion(dto.getDoctorsOpinion());
            data.setNurseOpinion(dto.getNurseOpinion());
            addictionCertificateRepository.save(data);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Addiction Certificate updated successfully!");
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
    public CandidateAddictionCertificateDTO getCandidateAddictionCertificate(String pEmployeeCode) {
        CandidateAddictionCertificateDTO dto = new CandidateAddictionCertificateDTO();
        Object[] empBasicInfo = (Object[]) employeeInfoRepository.getEmployeeBasicInfo(pEmployeeCode)[0];
        CandidateAddictionCertificate addictionCertificate = addictionCertificateRepository.getAddictionCertificate(pEmployeeCode);

        String candidateName = "";
        try {
            candidateName = empBasicInfo[0].toString()+" "+empBasicInfo[1].toString()+" "+empBasicInfo[3].toString();
        } catch (Exception ex){}
        dto.setEmployeeCode(pEmployeeCode);
        dto.setCandidateName(candidateName);
        try {
            dto.setCandidateFatherName(empBasicInfo[4].toString());
        }catch (Exception ex){
            dto.setCandidateFatherName("");
        }

        try {
            dto.setCandidateSpouseName(empBasicInfo[5].toString());
        }catch (Exception ex){
            dto.setCandidateSpouseName("");
        }

        if(addictionCertificate !=null){
            dto.setId(addictionCertificate.getId());
            dto.setCertificateDate(addictionCertificate.getCertificateDate());
            dto.setCandidateName(candidateName);

            try { dto.setCheckTeethAndGum(addictionCertificate.isCheckTeethAndGum()); }
            catch (Exception e){ dto.setCheckTeethAndGum(false); }

            try { dto.setCheckTongueAndLip(addictionCertificate.isCheckTongueAndLip()); }
            catch (Exception e){ dto.setCheckTongueAndLip(false); }

            try { dto.setCheckEye(addictionCertificate.isCheckEye()); }
            catch (Exception e){ dto.setCheckEye(false); }

            try { dto.setOtherSign(addictionCertificate.isOtherSign()); }
            catch (Exception e){ dto.setOtherSign(false); }

            dto.setDoctorsOpinion(addictionCertificate.getDoctorsOpinion());
            dto.setNurseOpinion(addictionCertificate.getNurseOpinion());
        }

        return dto;
    }
}
