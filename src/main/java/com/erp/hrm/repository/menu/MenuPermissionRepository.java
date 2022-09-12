package com.erp.hrm.repository.menu;

import com.erp.hrm.domain.MenuPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by WS on 26/01/2019.
 */
public interface MenuPermissionRepository extends JpaRepository<MenuPermission, Integer>{
    @Query("SELECT m FROM MenuPermission m")
    List<MenuPermission> findAll();

    @Query("SELECT m FROM MenuPermission m WHERE m.userRole=?1 ORDER BY m.menu.sequenceNo")
    List<MenuPermission> findAllByRole(String pRole);


}
