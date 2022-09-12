package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.FloorDTO;
import com.erp.hrm.domain.Building;
import com.erp.hrm.domain.Floor;
import com.erp.hrm.repository.BuildingRepository;
import com.erp.hrm.repository.FloorRepository;
import com.erp.hrm.service.FloorService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Service
public class FloorServiceImpl implements FloorService {
    private FloorRepository floorRepository;
    private BuildingRepository buildingRepository;
    public FloorServiceImpl(FloorRepository floorRepository,BuildingRepository buildingRepository){
        this.floorRepository = floorRepository;
        this.buildingRepository = buildingRepository;
    }

    @Override
    public ActionResult save(FloorDTO floorDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Floor floor = new Floor();
            floor.setFloorName(floorDTO.getFloorName());
            floor.setFloorCode(floorDTO.getFloorCode());
            floor.setSequence(floorDTO.getSequence());
            floor.setNotes(floorDTO.getNotes());
            floor.setIsDefault(floorDTO.getIsDefault());

            Building building = buildingRepository.getBuildingInfoByName(floorDTO.getBuildingName());
            floor.setBuilding(building);

            floorRepository.save(floor);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Floor setting saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(FloorDTO floorDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Floor floor = new Floor();
            floor.setId(floorDTO.getId());
            floor.setFloorName(floorDTO.getFloorName());
            floor.setFloorCode(floorDTO.getFloorCode());
            floor.setSequence(floorDTO.getSequence());
            floor.setNotes(floorDTO.getNotes());
            floor.setIsDefault(floorDTO.getIsDefault());

            Building building = buildingRepository.getBuildingInfoByName(floorDTO.getBuildingName());
            floor.setBuilding(building);

            floorRepository.save(floor);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Floor setting updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<FloorDTO> findAllFloor() {
        List<FloorDTO> floorDTOS = new ArrayList<>();
        List<Floor> floorData =  floorRepository.findAllFloor();
        for(Floor floor : floorData) {
            FloorDTO floorDTO = new FloorDTO();
            floorDTO.setId(floor.getId());
            floorDTO.setFloorCode(floor.getFloorCode());
            floorDTO.setFloorName(floor.getFloorName());
            floorDTO.setSequence(floor.getSequence());
            floorDTO.setBuildingName(floor.getBuilding().getBuildingName());
            floorDTO.setNotes(floor.getNotes());
            floorDTO.setIsDefault(floor.getIsDefault());
            floorDTOS.add(floorDTO);
        }
        return floorDTOS;
    }

    @Override
    public FloorDTO findOne(Integer id) {
        //Get Floor through id
        Floor floor =  floorRepository.getOne(id);//.findOne(id);
        FloorDTO floorDTO = new FloorDTO();
        floorDTO.setId(floor.getId());
        floorDTO.setFloorCode(floor.getFloorCode());
        floorDTO.setFloorName(floor.getFloorName());
        floorDTO.setSequence(floor.getSequence());
        floorDTO.setBuildingName(floor.getBuilding().getBuildingName());
        floorDTO.setNotes(floor.getNotes());
        floorDTO.setIsDefault(floor.getIsDefault());
        return floorDTO;
    }

    @Override
    public void delete(Integer id) {
//        floorRepository.delete(id);
    	floorRepository.deleteById(id);
    }
}
