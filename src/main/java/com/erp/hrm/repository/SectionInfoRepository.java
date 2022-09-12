package com.erp.hrm.repository;

import com.erp.hrm.domain.SectionInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Repository
public interface SectionInfoRepository extends JpaRepository<SectionInfo, Long>{
    @Query("SELECT sec FROM SectionInfo sec")
    List<SectionInfo> findAllSectionInfo();
}
