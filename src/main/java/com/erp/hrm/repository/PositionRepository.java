package com.erp.hrm.repository;

import com.erp.hrm.domain.Division;
import com.erp.hrm.domain.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 5/13/2017.
 */
@Repository
public interface PositionRepository extends JpaRepository<Position, Long>{
    @Query("SELECT p FROM Position p")
    List<Position> findAllPosition();
}
