package com.erp.hrm.service.impl;

import com.erp.hrm.domain.JobLocation;
import com.erp.hrm.domain.SkillCategory;
import com.erp.hrm.repository.JobLocationRepository;
import com.erp.hrm.repository.SkillCategoryRepository;
import com.erp.hrm.service.JobLocationService;
import com.erp.hrm.service.SkillCategoryService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
@Service
public class SkillCategoryServiceImpl implements SkillCategoryService {
    private SkillCategoryRepository skillCategoryRepository;
    public SkillCategoryServiceImpl(SkillCategoryRepository skillCategoryRepository){
        this.skillCategoryRepository = skillCategoryRepository;
    }

    @Override
    public ActionResult save(SkillCategory skillCategory) {
        ActionResult actionResult = new ActionResult();

        try{
            skillCategoryRepository.save(skillCategory);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Skill category saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(SkillCategory skillCategory) {
        ActionResult actionResult = new ActionResult();

        try{
            skillCategoryRepository.save(skillCategory);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Skill category updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<SkillCategory> getAllSkillCategory() {
        return skillCategoryRepository.findAllSkillCategory();
    }

    @Override
    public SkillCategory findOne(Long id) {
        return skillCategoryRepository.getOne(id);//.findOne(id);
    }

    @Override
    public void delete(Long id) {
        skillCategoryRepository.deleteById(id);//.delete(id);
    }
}
