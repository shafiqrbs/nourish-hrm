package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.CandidateSkillMatrixResult;
import com.erp.hrm.domain.CandidateSkillMatrixSectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface CandidateSkillMatrixSectionDetailsRepository extends JpaRepository<CandidateSkillMatrixSectionDetails, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM CandidateSkillMatrixResult CMR " +
            "WHERE CMR.candidateSkillMatrixSectionDetails.id=?1")
    void deleteCandidateProcessResult(int pCandidateProcessId);

    @Transactional
    @Modifying
    @Query("DELETE FROM CandidateSkillMatrixSectionDetails CSD " +
            "WHERE CSD.id=?1")
    void deleteCandidateProcess(int pCandidateProcessId);

    @Transactional
    @Modifying
    @Query("DELETE FROM CandidateSkillMatrixSectionDetails CSD " +
            "WHERE CSD.candidateSkillMatrixSection.id=?1")
    void deleteCandidateSectionDetailsBySectionId(int pCandidateSectionId);

    @Transactional
    @Modifying
    @Query("DELETE FROM CandidateSkillMatrixSection CMS WHERE CMS.id=?1")
    void deleteCandidateSectionBySectionId(int pCandidateSectionId);
}
