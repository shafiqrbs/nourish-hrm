package com.erp.hrm.repository.shift;

import com.erp.hrm.domain.ManualShiftTempEmployeeCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sohag on 22/02/2019.
 */
public interface ManualShiftTempEmployeeCodeRepository extends JpaRepository<ManualShiftTempEmployeeCode, Long>{
    @Query("SELECT COUNT(*) FROM ManualShiftTempEmployeeCode RTE WHERE RTE.userId=?1")
    int getManualShiftTempEmployeeCodeCount(String pUserId);

    @Query("SELECT MTE FROM ManualShiftTempEmployeeCode MTE WHERE MTE.userId =?1")
    List<ManualShiftTempEmployeeCode> findAllByUserId(String pUserId);

    @Transactional
    @Modifying
    @Query("DELETE FROM ManualShiftTempEmployeeCode r WHERE r.userId=?1")
    void delete(String pUserId);
}
