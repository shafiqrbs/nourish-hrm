package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.FloorDTO;
import com.erp.hrm.domain.Floor;
import com.erp.hrm.service.FloorService;
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
@RequestMapping("/api/v1/floor")
public class FloorApi {
    private FloorService floorService;
    public FloorApi(FloorService floorService){
        this.floorService = floorService;
    }

    @RequestMapping(value = "/findOneFloor", method = RequestMethod.GET)
    public FloorDTO findOne(Integer id){
        return floorService.findOne(id);
    }

    @RequestMapping(value = "/findAllFloor", method = RequestMethod.GET)
    public List<FloorDTO> findAllFloor(){
        return floorService.findAllFloor();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody FloorDTO floorDTO){
        return floorService.save(floorDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody FloorDTO floorDTO){
        return floorService.update(floorDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Integer id){
        floorService.delete(id);
    }
}