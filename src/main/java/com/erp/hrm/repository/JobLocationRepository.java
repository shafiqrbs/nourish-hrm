package com.erp.hrm.repository;

import com.erp.hrm.domain.JobLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 5/13/2017.
 */

@Repository
public interface JobLocationRepository extends JpaRepository<JobLocation, Long>{
    @Query("SELECT JL FROM JobLocation JL")
    List<JobLocation> findAllJobLocation();
}
