package com.erp.hrm.repository.shift;

import com.erp.hrm.domain.EmployeeRuleInfo;
import com.erp.hrm.domain.ShiftRuleDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by WS on 18/04/2018.
 */
public interface ShiftRuleDetailRepository extends JpaRepository<ShiftRuleDetail, Long>{
    @Query("SELECT srd FROM ShiftRuleDetail srd WHERE srd.ShiftRuleCode=?1 ORDER BY srd.SequenceNo ASC")
    List<ShiftRuleDetail> getAllShiftRosteringBySRC(String ShiftRuleCode);


}
