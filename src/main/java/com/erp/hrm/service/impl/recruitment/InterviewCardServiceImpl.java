package com.erp.hrm.service.impl.recruitment;

import com.erp.hrm.api.dto.recruitment.InterviewCardDTO;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.repository.employee.EmployeeGeneralInfoRepository;
import com.erp.hrm.repository.recruitment.CandidateApplicationRepository;
import com.erp.hrm.service.recruitment.InterviewCardService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

@Service
public class InterviewCardServiceImpl implements InterviewCardService {
    private CandidateApplicationRepository applicationRepository;

    public InterviewCardServiceImpl(CandidateApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public ActionResult saveInterviewCard(InterviewCardDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = applicationRepository.getOne(dto.getEmployeeTempCode());
            employeeInfo.setInterviewDate(dto.getInterviewDate());
            employeeInfo.setCandidateOtherInfo(dto.getOthers());
            employeeInfo.setCandidateBehaviour(dto.getBehave());
            applicationRepository.save(employeeInfo);

            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Interview card updated successfully!");
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
    public InterviewCardDTO getInterviewCardInfo(String pEmployeeTempCode) {
        InterviewCardDTO interviewCardDTO = new InterviewCardDTO();
        EmployeeInfo employeeInfo = applicationRepository.getOne(pEmployeeTempCode);

        //Prepare candidate name
        String vCandidateName = (employeeInfo.getSalutation()!=null?employeeInfo.getSalutation()+" ":"");
        vCandidateName = vCandidateName + (employeeInfo.getFirstName()!=null?employeeInfo.getFirstName()+" ":"");
        vCandidateName = vCandidateName + (employeeInfo.getLastName()!=null?employeeInfo.getLastName():"");

        //Preparing interview card object
        interviewCardDTO.setEmployeeTempCode(employeeInfo.getEmployeeCode());
        interviewCardDTO.setInterviewDate(employeeInfo.getInterviewDate());
        interviewCardDTO.setCandidateName(vCandidateName);
        interviewCardDTO.setFatherName(employeeInfo.getFathersName());
        interviewCardDTO.setSpouseName(employeeInfo.getSpouseName());
        interviewCardDTO.setApplyForPosition(employeeInfo.getApplyForPosition());
        interviewCardDTO.setDateOfBirth(employeeInfo.getDob());
        interviewCardDTO.setOthers(employeeInfo.getCandidateOtherInfo());
        interviewCardDTO.setBehave(employeeInfo.getCandidateBehaviour());

        try {
            interviewCardDTO.setNIDSubmit(employeeInfo.isSubmitNID());
        }
        catch (Exception ex){
            interviewCardDTO.setNIDSubmit(false);
        }

        try {
            interviewCardDTO.setBirthDateCertSubmit(employeeInfo.isSubmitBirthDateCertificate());
        }
        catch (Exception ex){
            interviewCardDTO.setBirthDateCertSubmit(false);
        }

        try {
            interviewCardDTO.setChairmanCertSubmit(employeeInfo.isSubmitChairmanCertificate());
        }
        catch (Exception ex){
            interviewCardDTO.setChairmanCertSubmit(false);
        }
        return interviewCardDTO;
    }
}
