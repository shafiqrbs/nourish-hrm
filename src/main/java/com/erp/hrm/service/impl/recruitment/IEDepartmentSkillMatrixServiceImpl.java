package com.erp.hrm.service.impl.recruitment;

import com.erp.hrm.api.dto.recruitment.*;
import com.erp.hrm.domain.*;
import com.erp.hrm.repository.recruitment.*;
import com.erp.hrm.service.recruitment.IEDepartmentSkillMatrixService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IEDepartmentSkillMatrixServiceImpl implements IEDepartmentSkillMatrixService {
    private RecruitmentIESkillMatrixRepository recruitmentIESkillMatrixRepository;
    private CandidateApplicationRepository recruitmentInterviewCardRepository;
    private RecruitmentIESkillMatrixSectionDetailsRepository sectionDetailsRepository;
    private RecruitmentIESkillMatrixSectionRepository sectionMatrixRepository;
    private CandidateSkillMatrixSectionRepository candidateSkillMatrixSectionRepository;
    private CandidateSkillMatrixSectionDetailsRepository candidateSectionDetailsRepository;
    private CandidateSkillMatrixResultRepository candidateSkillMatrixResultRepository;
    private CandidateApplicationRepository candidateApplicationRepository;

    public IEDepartmentSkillMatrixServiceImpl(RecruitmentIESkillMatrixRepository recruitmentIESkillMatrixRepository,
                                              CandidateApplicationRepository recruitmentInterviewCardRepository,
                                              RecruitmentIESkillMatrixSectionDetailsRepository sectionDetailsRepository,
                                              RecruitmentIESkillMatrixSectionRepository sectionMatrixRepository,
                                              CandidateSkillMatrixSectionRepository candidateSkillMatrixSectionRepository,
                                              CandidateSkillMatrixSectionDetailsRepository candidateSectionDetailsRepository,
                                              CandidateSkillMatrixResultRepository candidateSkillMatrixResultRepository,
                                              CandidateApplicationRepository candidateApplicationRepository) {
        this.recruitmentIESkillMatrixRepository = recruitmentIESkillMatrixRepository;
        this.recruitmentInterviewCardRepository = recruitmentInterviewCardRepository;
        this.sectionDetailsRepository = sectionDetailsRepository;
        this.sectionMatrixRepository = sectionMatrixRepository;
        this.candidateSkillMatrixSectionRepository = candidateSkillMatrixSectionRepository;
        this.candidateSectionDetailsRepository = candidateSectionDetailsRepository;
        this.candidateSkillMatrixResultRepository = candidateSkillMatrixResultRepository;
        this.candidateApplicationRepository = candidateApplicationRepository;
    }

    @Override
    public ActionResult save(String pEmployeeTempCode,List<SkillMatrixDTO> skillMatrixDTOS) {
        ActionResult actionResult = new ActionResult();
        try{
            List<CandidateSkillMatrixResult> candidateResults = new ArrayList<>();

            EmployeeInfo candidateObj =  candidateApplicationRepository.getOne(pEmployeeTempCode);
            for (SkillMatrixDTO skillMatrixDTO: skillMatrixDTOS) {
                for (SkillMatrixDetailsDTO skillMatrixDetailsDTO:skillMatrixDTO.getSkillMatrixDetailsDTOS()) {
                    CandidateSkillMatrixResult candidateResult = new CandidateSkillMatrixResult();
                    if(skillMatrixDetailsDTO.getSkillMatrixResultId() == 0){
                        CandidateSkillMatrixSectionDetails sectionDetails = candidateSectionDetailsRepository.getOne(skillMatrixDetailsDTO.getCandidateSectionDetailId());
                        candidateResult.setCandidateSkillMatrixSectionDetails(sectionDetails);
                        candidateResult.setExamTarget(skillMatrixDetailsDTO.getExamTarget());
                        candidateResult.setHowMuchCanGet(skillMatrixDetailsDTO.getHowMuchCanGet());
                        candidateResult.setPscPerSec(skillMatrixDetailsDTO.getPscPerSec());
                        candidateResult.setEfficiencyPct(skillMatrixDetailsDTO.getEfficiencyPct());
                    }
                    else {
                        candidateResult = candidateSkillMatrixResultRepository.getOne(skillMatrixDetailsDTO.getSkillMatrixResultId());
                        candidateResult.setExamTarget(skillMatrixDetailsDTO.getExamTarget());
                        candidateResult.setHowMuchCanGet(skillMatrixDetailsDTO.getHowMuchCanGet());
                        candidateResult.setPscPerSec(skillMatrixDetailsDTO.getPscPerSec());
                        candidateResult.setEfficiencyPct(skillMatrixDetailsDTO.getEfficiencyPct());
                    }

                    candidateResults.add(candidateResult);
                }
            }

//            candidateSkillMatrixResultRepository.save(candidateResults);
            candidateSkillMatrixResultRepository.saveAll(candidateResults);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Candidate skill matrix saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult saveSkillMatrixSectionProcess(CandidateSectionProcessDTO sectionProcessDTO) {
        ActionResult actionResult = new ActionResult();
        try {
            CandidateSkillMatrixSectionDetails sectionDetails = new CandidateSkillMatrixSectionDetails();

            RecruitIEDeptSkillMatrixSectionDetails skillMatrixSectionDetailsObj = null;
            if(sectionProcessDTO.getProcessId() == 0){
                RecruitIEDeptSkillMatrixSectionDetails newSectionDetails = new RecruitIEDeptSkillMatrixSectionDetails();
                int sectionCount = recruitmentIESkillMatrixRepository.getSectionProcessCount(sectionProcessDTO.getSectionId());
                sectionCount = sectionCount + 1;
                String processName = "Unnamed "+sectionCount;
                RecruitIEDeptSkillMatrixSection skillMatrixSectionObj = sectionMatrixRepository.getOne(sectionProcessDTO.getSectionId());
                newSectionDetails.setRecruitIEDeptSkillMatrixSection(skillMatrixSectionObj);
                newSectionDetails.setProcessName(processName);
                skillMatrixSectionDetailsObj = sectionDetailsRepository.save(newSectionDetails);
            }else {
                skillMatrixSectionDetailsObj = sectionDetailsRepository.getOne(sectionProcessDTO.getProcessId());
            }

            CandidateSkillMatrixSection candidateSectionObj = candidateSkillMatrixSectionRepository.getOne(sectionProcessDTO.getCandidateSectionId());
            sectionDetails.setCandidateSkillMatrixSection(candidateSectionObj);
            sectionDetails.setRecruitIEDeptSkillMatrixSectionDetails(skillMatrixSectionDetailsObj);
            candidateSectionDetailsRepository.save(sectionDetails);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Section's process successfully added");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult saveSkillMatrixSection(CandidateSkillMatrixSectionDTO sectionDTO) {
        ActionResult actionResult = new ActionResult();
        try {
            CandidateSkillMatrixSection section = new CandidateSkillMatrixSection();
            EmployeeInfo employeeInfo = candidateApplicationRepository.getOne(sectionDTO.getCandidateCode());
            RecruitIEDeptSkillMatrixSection skillMatrixSectionObj = sectionMatrixRepository.getOne(sectionDTO.getSectionId());
            section.setEmployeeInfo(employeeInfo);
            section.setRecruitIEDeptSkillMatrixSection(skillMatrixSectionObj);

            candidateSkillMatrixSectionRepository.save(section);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Section successfully added");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult updateSectionName(int pSectionId, int pSectionProcessId, String pSectionProcessName) {
        ActionResult actionResult = new ActionResult();
        try {
            int sectionDetailCount = sectionDetailsRepository.getExistingProcessCount(pSectionId,pSectionProcessName);
            if(sectionDetailCount == 0){
                RecruitIEDeptSkillMatrixSectionDetails sectionDetails = sectionDetailsRepository.getOne(pSectionProcessId);
                sectionDetails.setProcessName(pSectionProcessName);
                sectionDetailsRepository.save(sectionDetails);

                //Set custom message if success
                actionResult.setIsSuccess(true);
            }
            else {
                //Set custom message if exis
                actionResult.setIsSuccess(false);
                actionResult.setErrorMessage("Already Exists");
            }
        }
        catch (Exception ex){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(ex.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult deleteCandidateSection(int pCandidateSectionId) {
        ActionResult actionResult = new ActionResult();
        try{
            List<CandidateSkillMatrixResult> skillMatrixResults = candidateSkillMatrixResultRepository.getSkillMatrixResultBySectionId(pCandidateSectionId);
//            candidateSkillMatrixResultRepository.delete(skillMatrixResults);
            candidateSkillMatrixResultRepository.deleteAll(skillMatrixResults);
            candidateSectionDetailsRepository.deleteCandidateSectionDetailsBySectionId(pCandidateSectionId);
            candidateSectionDetailsRepository.deleteCandidateSectionBySectionId(pCandidateSectionId);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Candidate Section successfully deleted!");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult deleteCandidateProcess(int pCandidateProcessId) {
        ActionResult actionResult = new ActionResult();
        try{
            candidateSectionDetailsRepository.deleteCandidateProcessResult(pCandidateProcessId);
            candidateSectionDetailsRepository.deleteCandidateProcess(pCandidateProcessId);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Candidate Section process successfully deleted!");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public List<SkillMatrixDTO> getAllSkillMatrix(String pEmployeeTempCode) {
        List<SkillMatrixDTO> skillMatrixDTOS = new ArrayList<>();

        List<Object[]> skillMatrixSections = recruitmentIESkillMatrixRepository.getCandidateAllSection(pEmployeeTempCode);
        for(Object[] skillMatrixSection: skillMatrixSections ) {
            SkillMatrixDTO skillMatrixDTO = new SkillMatrixDTO();
            int vCandidateSectionId = (int) skillMatrixSection[1];
            int vSectionId = (int) skillMatrixSection[0];
            skillMatrixDTO.setSectionId((int) skillMatrixSection[0]);
            skillMatrixDTO.setCandidateSectionId((int) skillMatrixSection[1]);
            skillMatrixDTO.setSectionName(skillMatrixSection[2].toString());

            List<SkillMatrixSectionProcessDTO> processDTOS = new ArrayList<>();
            try {
                List<Object[]> skillMatrixProcessObj = recruitmentIESkillMatrixRepository.getAllUnAddedSectionProcess(vCandidateSectionId,vSectionId);
                for (Object[] processObj:skillMatrixProcessObj) {
                    SkillMatrixSectionProcessDTO processDTO = new SkillMatrixSectionProcessDTO();
                    processDTO.setProcessId((int) processObj[0]);
                    try {processDTO.setCandidateProcessId((int) processObj[1]);} catch (Exception e){}
                    processDTO.setProcessName(processObj[2].toString());
                    processDTOS.add(processDTO);
                }
            }
            catch (Exception e){}

            skillMatrixDTO.setSectionProcessDTOS(processDTOS);

            List<SkillMatrixDetailsDTO> skillMatrixDetailsDTOS = new ArrayList<>();
            try {

                List<Object[]> skillMatrixObj = recruitmentIESkillMatrixRepository.getCandidateAllSectionDetailsWithResult(vCandidateSectionId);
                for(Object[] skillMatrix:skillMatrixObj) {
                    SkillMatrixDetailsDTO skillMatrixDetailsDTO = new SkillMatrixDetailsDTO();
                    skillMatrixDetailsDTO.setSkillMatrixDetailId((int) skillMatrix[0]);
                    skillMatrixDetailsDTO.setProcessName((String) skillMatrix[1]);

                    try {
                        skillMatrixDetailsDTO.setExamTarget((int) skillMatrix[2]);
                    }
                    catch (Exception e){
                    }

                    try{
                        skillMatrixDetailsDTO.setHowMuchCanGet((int) skillMatrix[3]);
                    }
                    catch (Exception e){
                    }

                    try{
                        skillMatrixDetailsDTO.setPscPerSec((int) skillMatrix[4]);
                    }
                    catch (Exception e){
                    }

                    try{
                        skillMatrixDetailsDTO.setEfficiencyPct((int) skillMatrix[5]);
                    }
                    catch (Exception e){
                    }

                    try{
                        skillMatrixDetailsDTO.setCandidateSectionDetailId((int) skillMatrix[6]);
                    }
                    catch (Exception e){
                    }

                    try{
                        skillMatrixDetailsDTO.setSkillMatrixResultId((int) skillMatrix[7]);
                    }
                    catch (Exception e){
                    }

                    skillMatrixDetailsDTOS.add(skillMatrixDetailsDTO);
                }
            }
            catch (Exception e){
                String message = e.getMessage();
            }

            skillMatrixDTO.setSkillMatrixDetailsDTOS(skillMatrixDetailsDTOS);
            skillMatrixDTOS.add(skillMatrixDTO);
        }

        return skillMatrixDTOS;
    }

    @Override
    public List<SkillMatrixSectionDTO> getAllRecruitSkillMatrixSection(String pEmployeeTempCode) {
        //Initialization
        List<SkillMatrixSectionDTO> sectionDTOS = new ArrayList<>();
        List<RecruitIEDeptSkillMatrixSection> skillMatrixSections = null;

        if(pEmployeeTempCode.isEmpty()){
            skillMatrixSections = sectionMatrixRepository.findAll();
        }
        else {
            skillMatrixSections = sectionMatrixRepository.getAllUnSavedSection(pEmployeeTempCode);
        }

        for (RecruitIEDeptSkillMatrixSection section :skillMatrixSections) {
            SkillMatrixSectionDTO sectionDTO = new SkillMatrixSectionDTO();
            sectionDTO.setSectionId(section.getId());
            sectionDTO.setSectionName(section.getSkillMatrixSectionName());
            sectionDTOS.add(sectionDTO);
        }
        return sectionDTOS;
    }
}
