package com.erp.hrm.repository.employee;

import com.erp.hrm.api.dto.SkillDTO;
import com.erp.hrm.domain.Skills;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Repository
public interface SkillsRepository extends JpaRepository<Skills, Long>{
    @Query("SELECT sk FROM Skills sk WHERE sk.employeeInfo.employeeCode= :pEmployeeCode")
    List<Skills> findAllSkillsByEmployeeCode(@Param("pEmployeeCode")String pEmployeeCode);
}
