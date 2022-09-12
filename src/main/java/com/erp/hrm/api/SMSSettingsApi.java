package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.SMSSettingsDTO;
import com.erp.hrm.domain.SMSSettings;
import com.erp.hrm.service.SMSSettingsService;
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
@RequestMapping("/api/v1/sMSSettings")
public class SMSSettingsApi {
    private SMSSettingsService smsSettingsService;
    public SMSSettingsApi(SMSSettingsService smsSettingsService){
        this.smsSettingsService = smsSettingsService;
    }

    @RequestMapping(value = "/findOneSMSSettings", method = RequestMethod.GET)
    public SMSSettingsDTO findOne(Integer id){
        return smsSettingsService.findOne(id);
    }

    @RequestMapping(value = "/findAllSMSSettings", method = RequestMethod.GET)
    public List<SMSSettingsDTO> findAllSMSSettings(){
        return smsSettingsService.findAllSMSSettings();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody SMSSettings smsSettings){
        return smsSettingsService.save(smsSettings);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody SMSSettings smsSettings){
        return smsSettingsService.update(smsSettings);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Integer id){
        smsSettingsService.delete(id);
    }
}