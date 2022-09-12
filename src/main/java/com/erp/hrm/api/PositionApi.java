package com.erp.hrm.api;

import com.erp.hrm.domain.Division;
import com.erp.hrm.domain.Position;
import com.erp.hrm.service.DivisionService;
import com.erp.hrm.service.PositionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MY PC on 5/13/2017.
 */
@RestController
@RequestMapping("/api/v1/positions")
public class PositionApi {
    private PositionService positionService;
    public PositionApi(PositionService positionService){
        this.positionService = positionService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public Position findOne(Long id){
        return positionService.findOne(id);
    }

    @RequestMapping(value = "/getAllPosition", method = RequestMethod.GET)
    public List<Position> findAllPosition(){
        return positionService.findAllPosition();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody Position position){
        return positionService.save(position);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody Position position){
        return positionService.update(position);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        positionService.delete(id);
    }
}