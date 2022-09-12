package com.erp.hrm.repository.menu;

import com.erp.hrm.domain.ApprovalAssignUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by WS on 26/01/2019.
 */
public interface ApprovalAssignUserRoleRepository extends JpaRepository<ApprovalAssignUserRole, Integer>{
    @Query("SELECT a FROM ApprovalAssignUserRole a")
    List<ApprovalAssignUserRole> findAll();

}
