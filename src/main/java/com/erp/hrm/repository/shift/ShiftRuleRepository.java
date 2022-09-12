package com.erp.hrm.repository.shift;

import com.erp.hrm.domain.ShiftRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by WS on 18/04/2018.
 */
public interface ShiftRuleRepository extends JpaRepository<ShiftRule, Long>{
    @Query("SELECT r FROM ShiftRule r WHERE r.ShiftRuleCode=?1")
    ShiftRule getShiftRuleByCode(String RuleCode);

    @Query("SELECT r.ShiftRuleCode FROM ShiftRule r")
    List<Object[]> getAllShiftRuleCode();
}
