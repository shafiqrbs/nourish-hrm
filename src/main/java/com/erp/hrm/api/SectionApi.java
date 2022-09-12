package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.SectionDTO;
import com.erp.hrm.domain.Section;
import com.erp.hrm.domain.SectionInfo;
import com.erp.hrm.service.SectionInfoService;
import com.erp.hrm.service.SectionService;
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
@RequestMapping("/api/v1/sections")
public class SectionApi {
    private SectionService sectionService;
    public SectionApi(SectionService sectionService){
        this.sectionService = sectionService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SectionDTO findOne(Integer id){
        return sectionService.findOne(id);
    }

    @RequestMapping(value = "/getAllSection", method = RequestMethod.GET)
    public List<SectionDTO> findAllSectionInfo(){
        return sectionService.findAllSection();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody SectionDTO sectionDTO){
        return sectionService.save(sectionDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody SectionDTO sectionDTO){
        return sectionService.update(sectionDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Integer id){
        sectionService.delete(id);
    }
}