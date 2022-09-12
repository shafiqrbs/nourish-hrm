package com.erp.hrm.service;

import com.erp.hrm.api.dto.Configuration.GroupsDTO;
import com.erp.hrm.domain.Groups;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
public interface GroupsService {
    ActionResult save(GroupsDTO groupsDTO);

    ActionResult update(GroupsDTO groupsDTO);

    List<GroupsDTO> findAllGroups();

    GroupsDTO findOne(Integer id);

    void delete(Integer id);
}
