package com.erp.hrm.repository.menu;

import com.erp.hrm.domain.ApprovalNodeHierarchy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by WS on 26/01/2019.
 */
public interface ApprovalNodeHierarchyRepository extends JpaRepository<ApprovalNodeHierarchy, Integer>{
//    @Query("SELECT a FROM ApprovalNodeHiearachy a")
//    List<ApprovalNodeHierarchy> findAll();

}
