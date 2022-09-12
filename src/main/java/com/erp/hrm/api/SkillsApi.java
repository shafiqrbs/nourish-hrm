package com.erp.hrm.api;

import com.erp.hrm.api.dto.SkillDTO;
import com.erp.hrm.domain.Country;
import com.erp.hrm.domain.Skills;
import com.erp.hrm.service.CountryService;
import com.erp.hrm.service.SkillsService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/skills")
public class SkillsApi {
    private SkillsService skillsService;
    public SkillsApi(SkillsService skillsService){
        this.skillsService = skillsService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SkillDTO findOne(Long id){
        return skillsService.findOne(id);
    }

    @RequestMapping(value = "/findAllSkillsByEmployeeCode", method = RequestMethod.GET)
    public List<SkillDTO> findAllSkillsByEmployeeCode(String pEmployeeCode){
        return skillsService.findAllSkillsByEmployeeCode(pEmployeeCode);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody SkillDTO skillDTO){
        return skillsService.save(skillDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody SkillDTO skillDTO){
        return skillsService.update(skillDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        skillsService.delete(id);
    }
}