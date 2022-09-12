package com.erp.hrm.api;

import com.erp.hrm.domain.Designation;
import com.erp.hrm.service.DesignationService;
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
@RequestMapping("/api/v1/designations")
public class DesignationApi {
    private DesignationService designationService;
    public DesignationApi(DesignationService designationService){
        this.designationService = designationService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Designation findOne(Long id){
        return designationService.findOne(id);
    }

    @RequestMapping(value = "/getAllDesignation", method = RequestMethod.GET)
    public List<Designation> findAllDesignation(){
        return designationService.findAllDesignation();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody Designation designation){
        return designationService.save(designation);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody Designation designation){
        return designationService.update(designation);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        designationService.delete(id);
    }
}