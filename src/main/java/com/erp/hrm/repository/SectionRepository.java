package com.erp.hrm.repository;

import com.erp.hrm.domain.Section;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Repository
public interface SectionRepository extends JpaRepository<Section, Integer>{
    @Query("SELECT d FROM Section d")
    List<Section> findAllSection();

    @Query("SELECT sec FROM Section sec WHERE sec.sectionName= :pSectionName")
    Section getSectionInfoByName(@Param("pSectionName")String pSectionName);
}
