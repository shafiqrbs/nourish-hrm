package com.erp.hrm.repository.shift;

import com.erp.hrm.domain.ShiftPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ShiftPlanRepository extends JpaRepository<ShiftPlan, Long> {
    @Query("SELECT p FROM ShiftPlan p WHERE p.shiftID= :ShiftID")
    ShiftPlan findOneByShiftPlan(@Param("ShiftID") String ShiftID);

    @Query("SELECT DISTINCT sft.shiftID FROM ShiftPlan sft")
    List<Object[]> getAllShiftPlan();

    @Query("SELECT DISTINCT sft.shiftType FROM ShiftPlan sft")
    List<Object[]> getAllShiftType();

    @Query("SELECT p FROM ShiftPlan p WHERE p.descriptions='For security'")
    List<ShiftPlan> getAllRosteringShiftPlan();

    @Query("SELECT p FROM ShiftPlan p WHERE p.descriptions!='For security'")
    List<ShiftPlan> getAllFixedShiftPlan();
}
