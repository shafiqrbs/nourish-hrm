package com.erp.hrm.repository;

import com.erp.hrm.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Repository
public interface CityRepository extends JpaRepository<City, Long>{
    @Query("SELECT CT FROM City CT")
    List<City> findAllCity();

    /*
    @Query("SELECT CT FROM City CT ORDER BY CT.Name")
    List<City> findAllCityPageableTest(Pageable pageable);
    */
}
