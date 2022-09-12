package com.erp.hrm.repository;

import com.erp.hrm.domain.SubSection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Repository
public interface SubSectionRepository extends JpaRepository<SubSection, Integer>{
    @Query("SELECT d FROM SubSection d")
    List<SubSection> findAllSubSection();
}
