package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.CompanySettingsDTO;
import com.erp.hrm.domain.CompanySettings;
import com.erp.hrm.repository.CompanySettingsRepository;
import com.erp.hrm.service.CompanySettingsService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SOHAG on 5/5/2018.
 */
@Service
public class CompanySettingsServiceImpl implements CompanySettingsService {
    private CompanySettingsRepository companySettingsRepository;
    public CompanySettingsServiceImpl(CompanySettingsRepository companySettingsRepository){
        this.companySettingsRepository = companySettingsRepository;
    }

    @Override
    public ActionResult save(CompanySettings companySettings) {
        ActionResult actionResult = new ActionResult();
        try{
            //Set initial Status
            if(companySettings.getId() == 0){
                companySettings.setIsActive(true);
                companySettings.setIsDelete(false);
            }

            companySettingsRepository.save(companySettings);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Company setting saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(CompanySettings companySettings) {
        ActionResult actionResult = new ActionResult();
        try{
            companySettingsRepository.save(companySettings);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Company setting updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<CompanySettingsDTO> findAllCompanySettings() {
        List<CompanySettingsDTO> companySettingsDTOS = new ArrayList<>();
        List<CompanySettings> companySettingsData =  companySettingsRepository.findAllCompanySettings();
        for(CompanySettings companySettings : companySettingsData) {
            CompanySettingsDTO companySettingsDTO = new CompanySettingsDTO();
            companySettingsDTO.setId(companySettings.getId());
            companySettingsDTO.setCompanyName(companySettings.getCompanyName());
            companySettingsDTO.setCompanyLogo(companySettings.getCompanyLogo());
            companySettingsDTO.setAddress(companySettings.getAddress());
            companySettingsDTO.setCompanyCity(companySettings.getCompanyCity());
            companySettingsDTO.setCompanyState(companySettings.getCompanyState());
            companySettingsDTO.setZip(companySettings.getZip());
            companySettingsDTO.setCountry(companySettings.getCountry());
            companySettingsDTO.setCompanyPhone(companySettings.getCompanyPhone());
            companySettingsDTO.setContactName(companySettings.getContactName());
            companySettingsDTO.setContactPhone(companySettings.getContactPhone());
            companySettingsDTO.setDesignation(companySettings.getDesignation());
            companySettingsDTO.setContactEmail(companySettings.getContactEmail());
            companySettingsDTO.setLinkedInInfoURL(companySettings.getLinkedInInfoURL());
            companySettingsDTO.setFacebookURL(companySettings.getFacebookURL());
            companySettingsDTO.setIsDefault(companySettings.getIsDefault());
            companySettingsDTO.setIsActive(companySettings.getIsActive());
            companySettingsDTO.setIsDelete(companySettings.getIsDelete());
            companySettingsDTOS.add(companySettingsDTO);
        }
        return companySettingsDTOS;
    }

    @Override
    public CompanySettingsDTO findOne(Integer id) {
        //Get Company settings through id
        CompanySettings companySettings = companySettingsRepository.getOne(id);//.findOne(id);
        CompanySettingsDTO companySettingsDTO = new CompanySettingsDTO();
        companySettingsDTO.setId(companySettings.getId());
        companySettingsDTO.setCompanyName(companySettings.getCompanyName());
        companySettingsDTO.setCompanyLogo(companySettings.getCompanyLogo());
        companySettingsDTO.setAddress(companySettings.getAddress());
        companySettingsDTO.setCompanyCity(companySettings.getCompanyCity());
        companySettingsDTO.setCompanyState(companySettings.getCompanyState());
        companySettingsDTO.setZip(companySettings.getZip());
        companySettingsDTO.setCountry(companySettings.getCountry());
        companySettingsDTO.setCompanyPhone(companySettings.getCompanyPhone());
        companySettingsDTO.setContactName(companySettings.getContactName());
        companySettingsDTO.setContactPhone(companySettings.getContactPhone());
        companySettingsDTO.setDesignation(companySettings.getDesignation());
        companySettingsDTO.setContactEmail(companySettings.getContactEmail());
        companySettingsDTO.setLinkedInInfoURL(companySettings.getLinkedInInfoURL());
        companySettingsDTO.setFacebookURL(companySettings.getFacebookURL());
        companySettingsDTO.setIsDefault(companySettings.getIsDefault());
        return companySettingsDTO;
    }

    @Override
    public ActionResult RecordStatusUpdateById(boolean isActive,Integer id) {
        ActionResult actionResult = new ActionResult();
        try {
            companySettingsRepository.RecordStatusUpdateById(isActive, id);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            if(isActive == true)
                actionResult.setSuccessMessage("Company setting activated successfully");
            else
                actionResult.setSuccessMessage("Company setting deactivated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult RecordIsDeleteStatusUpdateById(Integer id) {
        ActionResult actionResult = new ActionResult();
        try {
            companySettingsRepository.RecordIsDeleteStatusUpdateById(id);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Company setting deleted successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public void delete(Integer id) {
//        companySettingsRepository.delete(id);
    	companySettingsRepository.deleteById(id);
    }

}
