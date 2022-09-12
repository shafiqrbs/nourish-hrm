package com.erp.hrm.repository.menu;

import com.erp.hrm.domain.ApprovalPermissionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by WS on 26/01/2019.
 */
public interface ApprovalPermissionTypeRepository extends JpaRepository<ApprovalPermissionType, Integer>{
    @Query("SELECT a FROM ApprovalPermissionType a")
    List<ApprovalPermissionType> findAll();

}
