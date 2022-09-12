package com.erp.hrm.repository;

import com.erp.hrm.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Repository
public interface BuildingRepository extends JpaRepository<Building, Integer>{
    @Query("SELECT d FROM Building d")
    List<Building> findAllBuilding();

    @Query("SELECT b FROM Building b WHERE b.BuildingName= :pBuildingName")
    Building getBuildingInfoByName(@Param("pBuildingName")String pBuildingName);
}
