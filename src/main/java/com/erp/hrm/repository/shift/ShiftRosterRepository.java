package com.erp.hrm.repository.shift;

import com.erp.hrm.domain.ShiftRoster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public interface ShiftRosterRepository extends JpaRepository<ShiftRoster,Long> {

    /*@Query("SELECT r FROM ShiftRoster r WHERE r.EmployeeCode=?1 AND r.ShiftDate =?2 AND r.ShiftID = ?3")
    ShiftRoster getRoster(String pEmployeeCode, Date pShiftDate, String pShiftID);*/

    @Query("SELECT r FROM ShiftRoster r WHERE r.EmployeeCode=?1 AND r.ShiftDate =?2 ")
    ShiftRoster getRoster(String pEmployeeCode, Date pShiftDate);

    @Transactional
    @Modifying
    @Query("DELETE FROM ShiftRoster r WHERE r.ShiftDate >=?1 AND r.ShiftDate <= ?2")
    void deleteShiftRosterByDate(Date fromDate, Date toDate);

    @Transactional
    @Modifying
    @Query("DELETE FROM ShiftRoster r WHERE r.EmployeeCode IN (?1) AND r.ShiftDate >=?2 AND r.ShiftDate <= ?3")
    void delete(List<String> pEmployeeCodes, Date pFromDate, Date pToDate);

    @Transactional
    @Modifying
    @Query("DELETE FROM ShiftRoster r WHERE r.EmployeeCode IN (?1) AND r.ShiftDate IN(?2)")
    void delete(List<String> pEmployeeCodes, List<Date> pDate);

}
