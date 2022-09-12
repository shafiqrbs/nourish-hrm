package com.erp.hrm.api;

import com.erp.hrm.api.dto.SalaryRuleCodeDTO;
import com.erp.hrm.api.dto.SalaryRuleDTO;
import com.erp.hrm.domain.SalaryRule;
import com.erp.hrm.service.SalaryRuleService;
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
@RequestMapping("/api/v1/salaryRules")
public class SalaryRuleApi{
    private SalaryRuleService salaryRuleService;
    public SalaryRuleApi(SalaryRuleService salaryRuleService){
        this.salaryRuleService = salaryRuleService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SalaryRuleDTO findOne(Long id){
        return salaryRuleService.findOne(id);
    }

    @RequestMapping(value = "/getAllSalaryRuleByRuleCode", method = RequestMethod.GET)
    public List<SalaryRuleDTO> getAllSalaryRuleByRuleCode(String pSalaryRuleCode){
        return salaryRuleService.getAllSalaryRuleByRuleCode(pSalaryRuleCode);
    }

    @RequestMapping(value = "/getAllSalaryRuleCode", method = RequestMethod.GET)
    public List<SalaryRuleCodeDTO> getAllSalaryRuleCode(){
        return salaryRuleService.getAllSalaryRuleCode();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody SalaryRule salaryRule){
        return salaryRuleService.save(salaryRule);
    }


    @RequestMapping(value = "//update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody SalaryRule salaryRule){
        return salaryRuleService.update(salaryRule);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        salaryRuleService.delete(id);
    }
}