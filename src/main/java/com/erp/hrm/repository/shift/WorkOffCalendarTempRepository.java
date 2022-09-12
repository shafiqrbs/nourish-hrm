package com.erp.hrm.repository.shift;

import com.erp.hrm.domain.WorkOffCalendarTemp;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WorkOffCalendarTempRepository extends JpaRepository<WorkOffCalendarTemp,Long> {
    @Query("SELECT COUNT(*) FROM WorkOffCalendarTemp emp WHERE emp.userId=?1")
    int getTempWorkOfCalEmployeeCodeCount(String pUserId);

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof " +
            "INNER JOIN WorkOffCalendarTemp tmp ON emp.employeeCode = tmp.employeeCode " +
            "WHERE tmp.userId=?1")
    Page<Object[]> getAllTemp(String pUserId,Pageable pageable);

    @Query("SELECT tmpWct FROM WorkOffCalendarTemp tmpWct " +
            "LEFT OUTER JOIN WorkOffCalendar wct ON tmpWct.employeeCode = wct.employeeCode " +
                "AND tmpWct.shiftId = wct.shiftID " +
                "AND tmpWct.shiftType = wct.shiftType " +
                "AND tmpWct.workOffDate = wct.workOffDate " +
            "WHERE tmpWct.userId =?1 AND wct.workOffDate IS NULL")
    List<WorkOffCalendarTemp> findAllByUserId(String pUserId);

    @Transactional
    @Modifying
    @Query("DELETE FROM WorkOffCalendarTemp emp WHERE emp.userId =?1")
    void deleteAllByUserId(String pUserId);
}
