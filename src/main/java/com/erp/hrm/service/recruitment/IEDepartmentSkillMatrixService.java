package com.erp.hrm.service.recruitment;

import com.erp.hrm.api.dto.recruitment.*;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 19/10/2018.
 */
public interface IEDepartmentSkillMatrixService {

    ActionResult saveSkillMatrixSection(CandidateSkillMatrixSectionDTO sectionDTO);

    ActionResult saveSkillMatrixSectionProcess(CandidateSectionProcessDTO sectionProcessDTO);

    ActionResult save(String pEmployeeTempCode,List<SkillMatrixDTO> skillMatrixDTOS);

    ActionResult updateSectionName(int pSectionId, int pSectionProcessId,String pSectionProcessName);

    ActionResult deleteCandidateProcess(int pCandidateProcessId);

    ActionResult deleteCandidateSection(int pCandidateSectionId);

    List<SkillMatrixDTO> getAllSkillMatrix(String pEmployeeTempCode);

    List<SkillMatrixSectionDTO> getAllRecruitSkillMatrixSection(String pEmployeeTempCode);
}
