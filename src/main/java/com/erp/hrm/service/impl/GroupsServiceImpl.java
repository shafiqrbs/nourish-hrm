package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.GroupsDTO;
import com.erp.hrm.domain.Groups;
import com.erp.hrm.repository.GroupsRepository;
import com.erp.hrm.service.GroupsService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Service
public class GroupsServiceImpl implements GroupsService {
    private GroupsRepository groupsRepository;
    public GroupsServiceImpl(GroupsRepository groupsRepository){
        this.groupsRepository = groupsRepository;
    }

    @Override
    public ActionResult save(GroupsDTO groupsDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Groups groups = new Groups();
            groups.setGroupName(groupsDTO.getGroupName());
            groups.setGroupCode(groupsDTO.getGroupCode());
            groups.setSequence(groupsDTO.getSequence());
            groups.setNotes(groupsDTO.getNotes());
            groups.setIsDefault(groupsDTO.getIsDefault());
            groupsRepository.save(groups);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Groups setting saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(GroupsDTO groupsDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Groups groups = new Groups();
            groups.setId(groupsDTO.getId());
            groups.setGroupName(groupsDTO.getGroupName());
            groups.setGroupCode(groupsDTO.getGroupCode());
            groups.setSequence(groupsDTO.getSequence());
            groups.setNotes(groupsDTO.getNotes());
            groups.setIsDefault(groupsDTO.getIsDefault());
            groupsRepository.save(groups);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Groups setting updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<GroupsDTO> findAllGroups() {
        List<GroupsDTO> groupsDTOS = new ArrayList<>();
        List<Groups> groupsData =  groupsRepository.findAllGroups();
        for(Groups groups : groupsData) {
            GroupsDTO groupsDTO = new GroupsDTO();
            groupsDTO.setId(groups.getId());
            groupsDTO.setGroupCode(groups.getGroupCode());
            groupsDTO.setGroupName(groups.getGroupName());
            groupsDTO.setSequence(groups.getSequence());
            groupsDTO.setNotes(groups.getNotes());
            groupsDTO.setIsDefault(groups.getIsDefault());
            groupsDTOS.add(groupsDTO);
        }
        return groupsDTOS;
    }

    @Override
    public GroupsDTO findOne(Integer id) {
        //Get Groups through id
        Groups groups =  groupsRepository.getOne(id);//.findOne(id);
        GroupsDTO groupsDTO = new GroupsDTO();
        groupsDTO.setId(groups.getId());
        groupsDTO.setGroupCode(groups.getGroupCode());
        groupsDTO.setGroupName(groups.getGroupName());
        groupsDTO.setSequence(groups.getSequence());
        groupsDTO.setNotes(groups.getNotes());
        groupsDTO.setIsDefault(groups.getIsDefault());
        return groupsDTO;
    }

    @Override
    public void delete(Integer id) {
//        groupsRepository.delete(id);
    	groupsRepository.deleteById(id);
    }
}
