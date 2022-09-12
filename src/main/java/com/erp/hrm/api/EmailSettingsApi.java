package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.EmailSettingsDTO;
import com.erp.hrm.domain.EmailSettings;
import com.erp.hrm.service.EmailSettingsService;
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
@RequestMapping("/api/v1/emailSettings")
public class EmailSettingsApi {
    private EmailSettingsService emailSettingsService;
    public EmailSettingsApi(EmailSettingsService emailSettingsService){
        this.emailSettingsService = emailSettingsService;
    }

    @RequestMapping(value = "/findOneEmailSettings", method = RequestMethod.GET)
    public EmailSettingsDTO findOne(Integer id){
        return emailSettingsService.findOne(id);
    }

    @RequestMapping(value = "/findAllEmailSettings", method = RequestMethod.GET)
    public List<EmailSettingsDTO> findAllEmailSettings(){
        return emailSettingsService.findAllEmailSettings();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody EmailSettings emailSettings){
        return emailSettingsService.save(emailSettings);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody EmailSettings emailSettings){
        return emailSettingsService.update(emailSettings);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Integer id){
        emailSettingsService.delete(id);
    }
}