package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.SubGroupDTO;
import com.erp.hrm.domain.Groups;
import com.erp.hrm.domain.SubGroup;
import com.erp.hrm.repository.GroupsRepository;
import com.erp.hrm.repository.SubGroupRepository;
import com.erp.hrm.service.SubGroupService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Service
public class SubGroupServiceImpl implements SubGroupService {
    private SubGroupRepository subGroupRepository;
    private GroupsRepository groupsRepository;
    public SubGroupServiceImpl(SubGroupRepository subGroupRepository,GroupsRepository groupsRepository){
        this.subGroupRepository = subGroupRepository;
        this.groupsRepository = groupsRepository;
    }

    @Override
    public ActionResult save(SubGroupDTO subGroupDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            SubGroup subGroup = new SubGroup();
            subGroup.setSubGroupName(subGroupDTO.getSubGroupName());
            subGroup.setSubGroupCode(subGroupDTO.getSubGroupCode());
            subGroup.setSequence(subGroupDTO.getSequence());
            subGroup.setNotes(subGroupDTO.getNotes());
            subGroup.setIsDefault(subGroupDTO.getIsDefault());

            Groups groups = groupsRepository.getGroupsByName(subGroupDTO.getGroupName());
            subGroup.setGroups(groups);

            subGroupRepository.save(subGroup);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("SubGroup setting saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(SubGroupDTO subGroupDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            SubGroup subGroup = new SubGroup();
            subGroup.setId(subGroupDTO.getId());
            subGroup.setSubGroupName(subGroupDTO.getSubGroupName());
            subGroup.setSubGroupCode(subGroupDTO.getSubGroupCode());
            subGroup.setSequence(subGroupDTO.getSequence());
            subGroup.setNotes(subGroupDTO.getNotes());
            subGroup.setIsDefault(subGroupDTO.getIsDefault());

            Groups groups = groupsRepository.getGroupsByName(subGroupDTO.getGroupName());
            subGroup.setGroups(groups);

            subGroupRepository.save(subGroup);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("SubGroup setting updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<SubGroupDTO> findAllSubGroup() {
        List<SubGroupDTO> subGroupDTOS = new ArrayList<>();
        List<SubGroup> subGroupData =  subGroupRepository.findAllSubGroup();
        for(SubGroup subGroup : subGroupData) {
            SubGroupDTO subGroupDTO = new SubGroupDTO();
            subGroupDTO.setId(subGroup.getId());
            subGroupDTO.setSubGroupName(subGroup.getSubGroupName());
            subGroupDTO.setSubGroupCode(subGroup.getSubGroupCode());
            subGroupDTO.setSequence(subGroup.getSequence());
            subGroupDTO.setGroupName(subGroup.getGroups().getGroupName());
            subGroupDTO.setNotes(subGroup.getNotes());
            subGroupDTO.setIsDefault(subGroup.getIsDefault());
            subGroupDTOS.add(subGroupDTO);
        }
        return subGroupDTOS;
    }

    @Override
    public SubGroupDTO findOne(Integer id) {
        //Get SubGroup through id
        SubGroup subGroup =  subGroupRepository.getOne(id);//.findOne(id);
        SubGroupDTO subGroupDTO = new SubGroupDTO();
        subGroupDTO.setId(subGroup.getId());
        subGroupDTO.setSubGroupName(subGroup.getSubGroupName());
        subGroupDTO.setSubGroupCode(subGroup.getSubGroupCode());
        subGroupDTO.setSequence(subGroup.getSequence());
        subGroupDTO.setGroupName(subGroup.getGroups().getGroupName());
        subGroupDTO.setNotes(subGroup.getNotes());
        subGroupDTO.setIsDefault(subGroup.getIsDefault());
        return subGroupDTO;
    }

    @Override
    public void delete(Integer id) {
        subGroupRepository.deleteById(id);//.delete(id);
    }
}
