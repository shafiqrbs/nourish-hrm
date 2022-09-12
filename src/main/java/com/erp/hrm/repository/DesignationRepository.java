package com.erp.hrm.repository;

import com.erp.hrm.domain.Designation;
import com.erp.hrm.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Repository
public interface DesignationRepository extends JpaRepository<Designation, Long>{
	
    @Query("SELECT d FROM Designation d")
    List<Designation> findAllDesignation();

    @Query("SELECT d FROM Designation d WHERE d.name = :designation")
    Employee findOneByName(@Param("designation")String designation);
    
}
