package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.CompanySettingsDTO;
import com.erp.hrm.domain.CompanySettings;
import com.erp.hrm.service.CompanySettingsService;
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
@RequestMapping("/api/v1/companySettings")
public class CompanySettingsApi {
    private CompanySettingsService companySettingsService;
    public CompanySettingsApi(CompanySettingsService companySettingsService){
        this.companySettingsService = companySettingsService;
    }

    @RequestMapping(value = "/findOneCompanySetting", method = RequestMethod.GET)
    public CompanySettingsDTO findOne(Integer id){
        return companySettingsService.findOne(id);
    }

    @RequestMapping(value = "/findAllCompanySettings", method = RequestMethod.GET)
    public List<CompanySettingsDTO> findAllCompanySettings(){
        return companySettingsService.findAllCompanySettings();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody CompanySettings companySettings){
        return companySettingsService.save(companySettings);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody CompanySettings companySettings){
        return companySettingsService.update(companySettings);
    }

    @RequestMapping(value = "/statusUpdateById", method = RequestMethod.GET)
    public ActionResult RecordStatusUpdateById(boolean isActive,Integer id){
        return companySettingsService.RecordStatusUpdateById(isActive,id);
    }

    @RequestMapping(value = "/isDeleteStatusUpdateById", method = RequestMethod.GET)
    public ActionResult RecordIsDeleteStatusUpdateById(Integer id){
        return companySettingsService.RecordIsDeleteStatusUpdateById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Integer id){
        companySettingsService.delete(id);
    }
}