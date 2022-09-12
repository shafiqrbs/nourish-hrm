package com.erp.hrm.repository.menu;

import com.erp.hrm.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by WS on 26/01/2019.
 */
public interface MenuRepository extends JpaRepository<Menu, Integer>{
    @Query("SELECT m FROM Menu m ORDER BY m.sequenceNo")
    List<Menu> findAll();
}
