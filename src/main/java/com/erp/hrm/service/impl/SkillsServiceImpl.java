package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.SkillDTO;
import com.erp.hrm.domain.Country;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.Skills;
import com.erp.hrm.repository.CountryRepository;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.employee.SkillsRepository;
import com.erp.hrm.service.CountryService;
import com.erp.hrm.service.SkillsService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class SkillsServiceImpl implements SkillsService {
    private SkillsRepository skillsRepository;
    private EmployeeInfoRepository employeeInfoRepository;
    public SkillsServiceImpl(SkillsRepository skillsRepository,EmployeeInfoRepository employeeInfoRepository){
        this.skillsRepository = skillsRepository;
        this.employeeInfoRepository = employeeInfoRepository;
    }

    @Override
    public ActionResult save(SkillDTO skillDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(skillDTO.getEmployeeCode());
            Skills skillsObj = new Skills();
            skillsObj.setEmployeeInfo(employeeInfo);
            skillsObj.setSkillCategory(skillDTO.getSkillCategory());
            skillsObj.setSkillType(skillDTO.getSkillType());
            skillsObj.setDescription(skillDTO.getDescription());
            skillsObj.setDescription(skillDTO.getDescription());
            skillsObj.setModuleName(skillDTO.getModuleName());
            skillsRepository.save(skillsObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Skill saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(SkillDTO skillDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(skillDTO.getEmployeeCode());
            Skills skillsObj = new Skills();
            skillsObj.setId(skillDTO.getSkillId());
            skillsObj.setEmployeeInfo(employeeInfo);
            skillsObj.setSkillCategory(skillDTO.getSkillCategory());
            skillsObj.setSkillType(skillDTO.getSkillType());
            skillsObj.setDescription(skillDTO.getDescription());
            skillsObj.setDescription(skillDTO.getDescription());
            skillsObj.setModuleName(skillDTO.getModuleName());
            skillsRepository.save(skillsObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Skill updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<SkillDTO> findAllSkillsByEmployeeCode(String pEmployeeCode) {
        List<Skills> skills = skillsRepository.findAllSkillsByEmployeeCode(pEmployeeCode);
        List<SkillDTO> skillDTOS = new ArrayList<>();
        for (Skills skill:skills)
        {
            SkillDTO skillDTO = new SkillDTO();
            skillDTO.setSkillId(skill.getId());
            skillDTO.setEmployeeCode(skill.getEmployeeInfo().getEmployeeCode());
            skillDTO.setSkillCategory(skill.getSkillCategory());
            skillDTO.setSkillType(skill.getSkillType());
            skillDTO.setDescription(skill.getDescription());
            skillDTO.setModuleName(skill.getModuleName());
            skillDTO.setLabelName(skill.getLabelName());
            skillDTOS.add(skillDTO);
        }
        return skillDTOS;
    }

    @Override
    public SkillDTO findOne(Long id) {
        Skills skills = skillsRepository.getOne(id);//.findOne(id);
        SkillDTO skillDTO = new SkillDTO();
        skillDTO.setSkillId(skills.getId());
        skillDTO.setEmployeeCode(skills.getEmployeeInfo().getEmployeeCode());
        skillDTO.setSkillCategory(skills.getSkillCategory());
        skillDTO.setSkillType(skills.getSkillType());
        skillDTO.setDescription(skills.getDescription());
        skillDTO.setModuleName(skills.getModuleName());
        skillDTO.setLabelName(skills.getLabelName());
        return skillDTO;
    }

    @Override
    public void delete(Long id) {
        skillsRepository.deleteById(id);//.delete(id);
    }
}
