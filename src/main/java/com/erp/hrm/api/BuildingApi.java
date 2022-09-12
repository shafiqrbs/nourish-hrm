package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.BuildingDTO;
import com.erp.hrm.service.BuildingService;
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
@RequestMapping("/api/v1/building")
public class BuildingApi {
    private BuildingService buildingService;
    public BuildingApi(BuildingService buildingService){
        this.buildingService = buildingService;
    }

    @RequestMapping(value = "/findOneBuilding", method = RequestMethod.GET)
    public BuildingDTO findOne(Integer id){
        return buildingService.findOne(id);
    }

    @RequestMapping(value = "/findAllBuilding", method = RequestMethod.GET)
    public List<BuildingDTO> findAllBuilding(){
        return buildingService.findAllBuilding();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody BuildingDTO buildingDTO){
        return buildingService.save(buildingDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody BuildingDTO buildingDTO){
        return buildingService.update(buildingDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Integer id){
        buildingService.delete(id);
    }
}