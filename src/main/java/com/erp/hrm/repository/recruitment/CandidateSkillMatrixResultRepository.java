package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.CandidateSkillMatrixResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CandidateSkillMatrixResultRepository extends JpaRepository<CandidateSkillMatrixResult, Integer> {

    @Query("SELECT CMR FROM CandidateSkillMatrixResult CMR " +
            "INNER JOIN CandidateSkillMatrixSectionDetails CSD ON CMR.candidateSkillMatrixSectionDetails.id = CSD.id " +
            "WHERE CSD.candidateSkillMatrixSection.id=?1")
    List<CandidateSkillMatrixResult> getSkillMatrixResultBySectionId(int pCandidateSectionId);
}
