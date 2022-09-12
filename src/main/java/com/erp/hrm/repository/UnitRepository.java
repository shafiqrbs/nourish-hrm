package com.erp.hrm.repository;

import com.erp.hrm.domain.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Repository
public interface UnitRepository extends JpaRepository<Unit, Long>{
    @Query("SELECT d FROM Unit d")
    List<Unit> findAllUnit();
}
