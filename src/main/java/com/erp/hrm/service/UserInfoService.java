package com.erp.hrm.service;

import com.erp.hrm.api.dto.UserDTO;
import com.erp.hrm.domain.Unit;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 26/01/2019.
 */
public interface UserInfoService {
    public UserDTO getUser(String pEmail);

    ActionResult saveUser(UserDTO dto);
}
