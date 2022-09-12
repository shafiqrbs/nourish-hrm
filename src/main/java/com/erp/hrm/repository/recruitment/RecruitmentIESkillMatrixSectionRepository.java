package com.erp.hrm.repository.recruitment;

import com.erp.hrm.domain.RecruitIEDeptSkillMatrixSection;
import com.erp.hrm.domain.RecruitIEDeptSkillMatrixSectionDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RecruitmentIESkillMatrixSectionRepository extends JpaRepository<RecruitIEDeptSkillMatrixSection, Integer> {

    @Query("SELECT SMC FROM RecruitIEDeptSkillMatrixSection SMC " +
            "LEFT JOIN CandidateSkillMatrixSection CMC ON (SMC.id = CMC.recruitIEDeptSkillMatrixSection.id " +
                " AND CMC.employeeInfo.employeeCode=?1) " +
            "WHERE CMC.id IS NULL")
    List<RecruitIEDeptSkillMatrixSection> getAllUnSavedSection(String pEmployeeTempCode);


}
