package com.erp.hrm.repository.employee;

import com.erp.hrm.api.dto.TransferDTO;
import com.erp.hrm.domain.Separation;
import com.erp.hrm.domain.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Repository
public interface SeparationRepository extends JpaRepository<Separation, Long>{
    @Query("SELECT sep FROM Separation sep WHERE sep.employeeInfo.employeeCode= :pEmployeeCode")
    List<Separation> findAllSeparationByEmployeeCode(@Param("pEmployeeCode")String pEmployeeCode);
}
