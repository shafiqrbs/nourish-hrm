package com.erp.hrm.api;


import com.erp.hrm.api.dto.menu.PermittedMenuDTO;
import com.erp.hrm.service.MenuService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by WS on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/menu")
public class MenuApi {
    private MenuService menuService;

    public MenuApi(MenuService menuService) {
        this.menuService = menuService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public List<PermittedMenuDTO> getMenuList(String pUserRole){
        return menuService.getPermittedMenus(pUserRole);
    }


}
