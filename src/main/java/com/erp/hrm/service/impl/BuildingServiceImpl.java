package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.BuildingDTO;
import com.erp.hrm.domain.Building;
import com.erp.hrm.domain.CompanySettings;
import com.erp.hrm.repository.BuildingRepository;
import com.erp.hrm.repository.CompanySettingsRepository;
import com.erp.hrm.service.BuildingService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Service
public class BuildingServiceImpl implements BuildingService {
    private BuildingRepository buildingRepository;
    private CompanySettingsRepository companySettingsRepository;
    public BuildingServiceImpl(BuildingRepository buildingRepository,CompanySettingsRepository companySettingsRepository){
        this.buildingRepository = buildingRepository;
        this.companySettingsRepository = companySettingsRepository;
    }

    @Override
    public ActionResult save(BuildingDTO buildingDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Building building = new Building();
            building.setBuildingCode(buildingDTO.getBuildingCode());
            building.setBuildingName(buildingDTO.getBuildingName());
            building.setSequence(buildingDTO.getSequence());
            building.setAddress(buildingDTO.getAddress());
            building.setIsDefault(buildingDTO.getIsDefault());

            CompanySettings companySettings = companySettingsRepository.getCompanySettingsByName(buildingDTO.getCompanyName());
            building.setCompanySettings(companySettings);
            buildingRepository.save(building);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Building setting saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(BuildingDTO buildingDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Building building = new Building();
            building.setId(buildingDTO.getId());
            building.setBuildingCode(buildingDTO.getBuildingCode());
            building.setBuildingName(buildingDTO.getBuildingName());
            building.setSequence(buildingDTO.getSequence());
            building.setAddress(buildingDTO.getAddress());
            building.setIsDefault(buildingDTO.getIsDefault());

            CompanySettings companySettings = companySettingsRepository.getCompanySettingsByName(buildingDTO.getCompanyName());
            building.setCompanySettings(companySettings);
            buildingRepository.save(building);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Building setting updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<BuildingDTO> findAllBuilding() {
        List<BuildingDTO> buildingDTOS = new ArrayList<>();
        List<Building> buildingsData =  buildingRepository.findAllBuilding();
        for(Building building : buildingsData) {
            BuildingDTO buildingDTO = new BuildingDTO();
            buildingDTO.setId(building.getId());
            buildingDTO.setBuildingCode(building.getBuildingCode());
            buildingDTO.setBuildingName(building.getBuildingName());
            buildingDTO.setSequence(building.getSequence());
            buildingDTO.setCompanyName(building.getCompanySettings().getCompanyName());
            buildingDTO.setAddress(building.getAddress());
            buildingDTO.setSequence(building.getSequence());
            buildingDTO.setIsDefault(building.getIsDefault());
            buildingDTOS.add(buildingDTO);
        }
        return buildingDTOS;
    }

    @Override
    public BuildingDTO findOne(Integer id) {
        //Get Building through id
        Building building =  buildingRepository.getOne(id);//.findOne(id);
        BuildingDTO buildingDTO = new BuildingDTO();
        buildingDTO.setId(building.getId());
        buildingDTO.setBuildingCode(building.getBuildingCode());
        buildingDTO.setBuildingName(building.getBuildingName());
        buildingDTO.setSequence(building.getSequence());
        buildingDTO.setCompanyName(building.getCompanySettings().getCompanyName());
        buildingDTO.setAddress(building.getAddress());
        buildingDTO.setSequence(building.getSequence());
        buildingDTO.setIsDefault(building.getIsDefault());
        return buildingDTO;
    }

    @Override
    public void delete(Integer id) {
        buildingRepository.deleteById(id);
    }
}
