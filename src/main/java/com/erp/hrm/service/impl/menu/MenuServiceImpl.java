package com.erp.hrm.service.impl.menu;

import com.erp.hrm.api.dto.menu.PermittedMenuDTO;
import com.erp.hrm.domain.Menu;
import com.erp.hrm.domain.MenuPermission;
import com.erp.hrm.repository.menu.MenuPermissionRepository;
import com.erp.hrm.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WS on 26/01/2019.
 */
@Service
public class MenuServiceImpl implements MenuService {
    private MenuPermissionRepository menuPermissionRepository;

    public MenuServiceImpl(MenuPermissionRepository menuPermissionRepository) {
        this.menuPermissionRepository = menuPermissionRepository;
    }

    @Override
    public List<PermittedMenuDTO> getPermittedMenus(String pUserRole) {
        List<MenuPermission> permissions =  menuPermissionRepository.findAllByRole(pUserRole);
        List<PermittedMenuDTO> menuDTOS = new ArrayList<>();
        for(MenuPermission permission : permissions){
            PermittedMenuDTO dto = new PermittedMenuDTO();
            Menu menu = permission.getMenu();
            dto.setDescriptions( menu.getDescriptions());
            dto.setDisplayLabel(menu.getDisplayLabel());
            dto.setMenuKey(menu.getMenuKey());
            dto.setMenuName(menu.getMenuName());
            dto.setMenuURL(menu.getMenuURL());

            dto.setLinkable(menu.isLinkable());
            dto.setParent(menu.isParent());
            dto.setParentId(menu.getParentId());
            dto.setRoot(menu.isRoot());
            dto.setSequenceNo(menu.getSequenceNo());

            menuDTOS.add(dto);
        }

        return menuDTOS;
    }
}
