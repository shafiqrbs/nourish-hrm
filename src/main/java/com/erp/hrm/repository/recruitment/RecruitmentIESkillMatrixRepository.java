package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.RecruitIEDeptSkillMatrixSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecruitmentIESkillMatrixRepository extends JpaRepository<RecruitIEDeptSkillMatrixSection, Integer> {
    @Query("SELECT SMS FROM RecruitIEDeptSkillMatrixSection SMS WHERE SMS.uiPosition=?1")
    List<RecruitIEDeptSkillMatrixSection> getAllSkillMatrixSection(String pUIPosition);

    @Query("SELECT SMS.id AS sectionId,CMS.id AS candidateSectionId,SMS.skillMatrixSectionName " +
            "FROM RecruitIEDeptSkillMatrixSection SMS " +
            "INNER JOIN CandidateSkillMatrixSection CMS ON SMS.id = CMS.recruitIEDeptSkillMatrixSection.id " +
            "INNER JOIN CMS.employeeInfo emp ON CMS.employeeInfo.employeeCode = emp.employeeCode " +
            "WHERE emp.employeeCode=?1")
    List<Object[]> getCandidateAllSection(String pEmployeeTempCode);

    @Query("SELECT DISTINCT ieSmSD.id,ieSmSD.processName " +
            "FROM RecruitIEDeptSkillMatrixSectionDetails ieSmSD " +
            "WHERE ieSmSD.recruitIEDeptSkillMatrixSection.id=?1 " +
            "ORDER BY ieSmSD.id ASC")
    List<Object[]> getAllIESkillMatrix(int pSkillMatrixSectionId);

    @Query("SELECT DISTINCT ieSmSD.id AS processId,ieSmSD.processName," +
            "CMR.examTarget,CMR.howMuchCanGet,CMR.pscPerSec,CMR.efficiencyPct," +
            "CSD.id AS candidateProcessId,CMR.id AS result_id " +
            "FROM CandidateSkillMatrixSectionDetails CSD " +
            "INNER JOIN CSD.recruitIEDeptSkillMatrixSectionDetails ieSmSD ON CSD.recruitIEDeptSkillMatrixSectionDetails.id = ieSmSD.id " +
            "LEFT OUTER JOIN CSD.candidateSkillMatrixResults CMR ON CSD.id = CMR.candidateSkillMatrixSectionDetails.id " +
            "WHERE CSD.candidateSkillMatrixSection.id=?1 " +
            "ORDER BY ieSmSD.id ASC")
    List<Object[]> getCandidateAllSectionDetailsWithResult(int pCandidateSectionId);

    @Query("SELECT SMD.id AS processId,CMD.id AS candidateProcessId,SMD.processName " +
            "FROM RecruitIEDeptSkillMatrixSectionDetails SMD " +
            "LEFT JOIN CandidateSkillMatrixSectionDetails CMD ON (SMD.id = CMD.recruitIEDeptSkillMatrixSectionDetails.id " +
                " AND CMD.candidateSkillMatrixSection.id=?1) " +
            "WHERE SMD.recruitIEDeptSkillMatrixSection.id=?2 AND SMD.processName NOT LIKE 'Unnamed%' AND CMD.id IS NULL")
    List<Object[]> getAllUnAddedSectionProcess(int candidateSectionId,int sectionId);

    @Query("SELECT COUNT(SMD.id) FROM RecruitIEDeptSkillMatrixSectionDetails SMD " +
            "WHERE SMD.recruitIEDeptSkillMatrixSection.id=?1")
    int getSectionProcessCount(int sectionId);
}
