package com.erp.hrm.service;

import com.erp.hrm.api.dto.menu.PermittedMenuDTO;

import java.util.List;

/**
 * Created by WS on 26/01/2019.
 */
public interface MenuService {
    public List<PermittedMenuDTO> getPermittedMenus(String pUserRole);
}
