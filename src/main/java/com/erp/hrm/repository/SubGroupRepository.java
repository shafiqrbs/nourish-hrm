package com.erp.hrm.repository;

import com.erp.hrm.domain.SubGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Repository
public interface SubGroupRepository extends JpaRepository<SubGroup, Integer>{
    @Query("SELECT d FROM SubGroup d")
    List<SubGroup> findAllSubGroup();
}
