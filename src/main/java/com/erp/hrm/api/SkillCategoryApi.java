package com.erp.hrm.api;

import com.erp.hrm.domain.JobLocation;
import com.erp.hrm.domain.SkillCategory;
import com.erp.hrm.service.JobLocationService;
import com.erp.hrm.service.SkillCategoryService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MY PC on 5/13/2017.
 */
@RestController
@RequestMapping("/api/v1/skillCategories")
public class SkillCategoryApi {
    private SkillCategoryService skillCategoryService;
    public SkillCategoryApi(SkillCategoryService skillCategoryService){
        this.skillCategoryService = skillCategoryService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SkillCategory findOne(Long id){
        return skillCategoryService.findOne(id);
    }

    @RequestMapping(value = "/getAllSkillCategory", method = RequestMethod.GET)
    public List<SkillCategory> findAllSkillCategory(){
        return skillCategoryService.getAllSkillCategory();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody SkillCategory skillCategory){
        return skillCategoryService.save(skillCategory);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody SkillCategory skillCategory){
        return skillCategoryService.update(skillCategory);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        skillCategoryService.delete(id);
    }
}