package com.erp.hrm.repository.employee;

import com.erp.hrm.api.dto.TransferDTO;
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
public interface TransferRepository extends JpaRepository<Transfer, Long>{
    @Query("SELECT tf FROM Transfer tf WHERE tf.employeeInfo.employeeCode= :pEmployeeCode")
    List<Transfer> findAllTransferByEmployeeCode(@Param("pEmployeeCode")String pEmployeeCode);
}
