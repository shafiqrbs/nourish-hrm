package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.SubSectionDTO;
import com.erp.hrm.domain.SubSection;
import com.erp.hrm.service.SubSectionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@RestController
@RequestMapping("/api/v1/subSections")
public class SubSectionApi {
    private SubSectionService subSectionService;
    public SubSectionApi(SubSectionService subSectionService){
        this.subSectionService = subSectionService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SubSectionDTO findOne(Integer id){
        return subSectionService.findOne(id);
    }

    @RequestMapping(value = "/getAllSubSection", method = RequestMethod.GET)
    public List<SubSectionDTO> findAllSubSection(){
        return subSectionService.getAllSubSection();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody SubSectionDTO subSectionDTO){
        return subSectionService.save(subSectionDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody SubSectionDTO subSectionDTO){
        return subSectionService.update(subSectionDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Integer id){
        subSectionService.delete(id);
    }
}