package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.RecruitIEDeptSkillMatrixSectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RecruitmentIESkillMatrixSectionDetailsRepository extends JpaRepository<RecruitIEDeptSkillMatrixSectionDetails, Integer> {

    @Query("SELECT COUNT(SMS.id) FROM RecruitIEDeptSkillMatrixSectionDetails SMS " +
            "WHERE SMS.recruitIEDeptSkillMatrixSection.id=?1 AND SMS.processName=?2")
    int getExistingProcessCount(int pSectionId,String pSectionProcessName);
}
