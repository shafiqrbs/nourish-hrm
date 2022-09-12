package com.erp.hrm.repository;

import com.erp.hrm.domain.Floor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */

@Repository
public interface FloorRepository extends JpaRepository<Floor, Integer>{
    @Query("SELECT d FROM Floor d")
    List<Floor> findAllFloor();

    @Query("SELECT fl FROM Floor fl WHERE fl.floorName= :pFloorName")
    Floor getFloorInfoByName(@Param("pFloorName")String pFloorName);
}
