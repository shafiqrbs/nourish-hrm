package com.erp.hrm.service;

import com.erp.hrm.domain.SkillCategory;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface SkillCategoryService {
    ActionResult save(SkillCategory skillCategory);

    ActionResult update(SkillCategory skillCategory);

    List<SkillCategory> getAllSkillCategory();

    SkillCategory findOne(Long id);

    void delete(Long id);
}
