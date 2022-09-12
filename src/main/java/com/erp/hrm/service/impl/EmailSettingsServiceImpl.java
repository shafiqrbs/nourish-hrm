package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.EmailSettingsDTO;
import com.erp.hrm.domain.EmailSettings;
import com.erp.hrm.repository.EmailSettingsRepository;
import com.erp.hrm.service.EmailSettingsService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Service
public class EmailSettingsServiceImpl implements EmailSettingsService {
    private EmailSettingsRepository emailSettingsRepository;
    public EmailSettingsServiceImpl(EmailSettingsRepository emailSettingsRepository){
        this.emailSettingsRepository = emailSettingsRepository;
    }

    @Override
    public ActionResult save(EmailSettings emailSettings) {
        ActionResult actionResult = new ActionResult();
        try{
            emailSettingsRepository.save(emailSettings);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("EmailSettings setting saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(EmailSettings emailSettings) {
        ActionResult actionResult = new ActionResult();
        try{
            emailSettingsRepository.save(emailSettings);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("EmailSettings setting updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<EmailSettingsDTO> findAllEmailSettings() {
        List<EmailSettingsDTO> emailSettingsDTOS = new ArrayList<>();
        List<EmailSettings> emailSettingsData =  emailSettingsRepository.findAllEmailSettings();
        for(EmailSettings emailSettings : emailSettingsData) {
            EmailSettingsDTO emailSettingsDTO = new EmailSettingsDTO();
            emailSettingsDTO.setId(emailSettings.getId());
            emailSettingsDTO.setForm(emailSettings.getForm());
            emailSettingsDTO.setFormName(emailSettings.getFormName());
            emailSettingsDTO.setSMTPHost(emailSettings.getSMTPHost());
            emailSettingsDTO.setSMTPSecure(emailSettings.getSMTPSecure());
            emailSettingsDTO.setSMTPPort(emailSettings.getSMTPPort());
            emailSettingsDTO.setAuthentication(emailSettings.getAuthentication());
            emailSettingsDTO.setUserName(emailSettings.getUserName());
            emailSettingsDTO.setPassword(emailSettings.getPassword());
            emailSettingsDTOS.add(emailSettingsDTO);
        }
        return emailSettingsDTOS;
    }

    @Override
    public EmailSettingsDTO findOne(Integer id) {
        //Get EmailSettings through id
        EmailSettings emailSettings =  emailSettingsRepository.getOne(id);
        EmailSettingsDTO emailSettingsDTO = new EmailSettingsDTO();
        emailSettingsDTO.setId(emailSettings.getId());
        emailSettingsDTO.setForm(emailSettings.getForm());
        emailSettingsDTO.setFormName(emailSettings.getFormName());
        emailSettingsDTO.setSMTPHost(emailSettings.getSMTPHost());
        emailSettingsDTO.setSMTPSecure(emailSettings.getSMTPSecure());
        emailSettingsDTO.setSMTPPort(emailSettings.getSMTPPort());
        emailSettingsDTO.setAuthentication(emailSettings.getAuthentication());
        emailSettingsDTO.setUserName(emailSettings.getUserName());
        emailSettingsDTO.setPassword(emailSettings.getPassword());
        return emailSettingsDTO;
    }

    @Override
    public void delete(Integer id) {
        emailSettingsRepository.deleteById(id);
    }
}
