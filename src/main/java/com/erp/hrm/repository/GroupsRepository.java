package com.erp.hrm.repository;

import com.erp.hrm.domain.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Repository
public interface GroupsRepository extends JpaRepository<Groups, Integer>{
    @Query("SELECT d FROM Groups d")
    List<Groups> findAllGroups();

    @Query("SELECT g FROM Groups g WHERE g.groupName= :groupName")
    Groups getGroupsByName(@Param("groupName")String groupName);
}
