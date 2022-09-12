package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.GroupsDTO;
import com.erp.hrm.service.GroupsService;
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
@RequestMapping("/api/v1/groups")
public class GroupsApi {
    private GroupsService groupsService;
    public GroupsApi(GroupsService groupsService){
        this.groupsService = groupsService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public GroupsDTO findOne(Integer id){
        return groupsService.findOne(id);
    }

    @RequestMapping(value = "/findAllGroups", method = RequestMethod.GET)
    public List<GroupsDTO> findAllGroups(){
        return groupsService.findAllGroups();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody GroupsDTO groupsDTO){
        return groupsService.save(groupsDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody GroupsDTO groupsDTO){
        return groupsService.update(groupsDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Integer id){
        groupsService.delete(id);
    }
}