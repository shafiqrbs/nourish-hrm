package com.erp.hrm.api;

import com.erp.hrm.api.dto.HeadTypeDTO;
import com.erp.hrm.domain.HeadType;
import com.erp.hrm.domain.SalaryHead;
import com.erp.hrm.service.SalaryHeadService;
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
@RequestMapping("/api/v1/salaryHead")
public class SalaryHeadApi {
    private SalaryHeadService salaryHeadService;
    public SalaryHeadApi(SalaryHeadService salaryHeadService){
        this.salaryHeadService = salaryHeadService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SalaryHead findOne(Long id){
        return salaryHeadService.findOne(id);
    }

    @RequestMapping(value = "/getAllSalaryHead", method = RequestMethod.GET)
    public List<SalaryHead> getAllSalaryHead(){
        return salaryHeadService.getAllSalaryHead();
    }

    @RequestMapping(value = "/getAllHeadType", method = RequestMethod.GET)
    public List<HeadType> getAllHeadType(){
        return salaryHeadService.getAllHeadType();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody SalaryHead salaryHead){
        return salaryHeadService.save(salaryHead);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody SalaryHead salaryHead){
        return salaryHeadService.update(salaryHead);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        salaryHeadService.delete(id);
    }
}