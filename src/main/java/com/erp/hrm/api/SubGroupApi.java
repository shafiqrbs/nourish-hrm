package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.SubGroupDTO;
import com.erp.hrm.domain.SubGroup;
import com.erp.hrm.service.SubGroupService;
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
@RequestMapping("/api/v1/subGroup")
public class SubGroupApi {
    private SubGroupService subGroupService;
    public SubGroupApi(SubGroupService subGroupService){
        this.subGroupService = subGroupService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public SubGroupDTO findOne(Integer id){
        return subGroupService.findOne(id);
    }

    @RequestMapping(value = "/findAllSubGroup", method = RequestMethod.GET)
    public List<SubGroupDTO> findAllSubGroup(){
        return subGroupService.findAllSubGroup();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody SubGroupDTO subGroupDTO){
        return subGroupService.save(subGroupDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody SubGroupDTO subGroupDTO){
        return subGroupService.update(subGroupDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Integer id){
        subGroupService.delete(id);
    }
}