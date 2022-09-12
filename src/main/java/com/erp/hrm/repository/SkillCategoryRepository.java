package com.erp.hrm.repository;

import com.erp.hrm.domain.SkillCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 5/13/2017.
 */
@Repository
public interface SkillCategoryRepository extends JpaRepository<SkillCategory, Long>{
    @Query("SELECT SC FROM SkillCategory SC")
    List<SkillCategory> findAllSkillCategory();
}
