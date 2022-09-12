package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.SMSSettingsDTO;
import com.erp.hrm.domain.SMSSettings;
import com.erp.hrm.repository.SMSSettingsRepository;
import com.erp.hrm.service.SMSSettingsService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Service
public class SMSSettingsServiceImpl implements SMSSettingsService {
    private SMSSettingsRepository smsSettingsRepository;
    public SMSSettingsServiceImpl(SMSSettingsRepository smsSettingsRepository){
        this.smsSettingsRepository = smsSettingsRepository;
    }

    @Override
    public ActionResult save(SMSSettings smsSettings) {
        ActionResult actionResult = new ActionResult();
        try{
            smsSettingsRepository.save(smsSettings);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("SMSSettings setting saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(SMSSettings smsSettings) {
        ActionResult actionResult = new ActionResult();
        try{
            smsSettingsRepository.save(smsSettings);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("SMSSettings setting updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<SMSSettingsDTO> findAllSMSSettings() {
        List<SMSSettingsDTO> smsSettingsDTOS = new ArrayList<>();
        List<SMSSettings> sMSSettingsData =  smsSettingsRepository.findAllSMSSettings();
        for(SMSSettings smsSettings : sMSSettingsData) {
            SMSSettingsDTO smsSettingsDTO = new SMSSettingsDTO();
            smsSettingsDTO.setId(smsSettings.getId());
            smsSettingsDTO.setSectionCode(smsSettings.getSectionCode());
            smsSettingsDTO.setSectionName(smsSettings.getSectionName());
            smsSettingsDTO.setSequence(smsSettings.getSequence());
            smsSettingsDTO.setCompanyName(smsSettings.getCompanySettings().getCompanyName());
            smsSettingsDTO.setBranch(smsSettings.getBranch());
            smsSettingsDTO.setNotes(smsSettings.getNotes());
            smsSettingsDTOS.add(smsSettingsDTO);
        }
        return smsSettingsDTOS;
    }

    @Override
    public SMSSettingsDTO findOne(Integer id) {
        //Get SMSSettings through id
        SMSSettings smsSettings =  smsSettingsRepository.getOne(id);//.findOne(id);
        SMSSettingsDTO smsSettingsDTO = new SMSSettingsDTO();
        smsSettingsDTO.setId(smsSettings.getId());
        smsSettingsDTO.setSectionCode(smsSettings.getSectionCode());
        smsSettingsDTO.setSectionName(smsSettings.getSectionName());
        smsSettingsDTO.setSequence(smsSettings.getSequence());
        smsSettingsDTO.setCompanyName(smsSettings.getCompanySettings().getCompanyName());
        smsSettingsDTO.setBranch(smsSettings.getBranch());
        smsSettingsDTO.setNotes(smsSettings.getNotes());
        return smsSettingsDTO;
    }

    @Override
    public void delete(Integer id) {
        smsSettingsRepository.deleteById(id);//.delete(id);
    }
}
