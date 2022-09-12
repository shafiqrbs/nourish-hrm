package com.erp.hrm.repository.shift;

import com.erp.hrm.domain.RosteringTempEmployeeCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sohag on 22/02/2019.
 */
public interface RosteringTempEmployeeCodeRepository extends JpaRepository<RosteringTempEmployeeCode, Long>{
    @Query("SELECT COUNT(*) FROM RosteringTempEmployeeCode RTE WHERE RTE.userId=?1")
    int getRosteringTempEmployeeCodeCount(String pUserId);

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof " +
            "INNER JOIN RosteringTempEmployeeCode tmp ON emp.employeeCode = tmp.employeeCode " +
            "WHERE tmp.userId=?1")
    Page<Object[]> getAllTemp(String pUserId, Pageable pageable);

    @Query("SELECT RTE FROM RosteringTempEmployeeCode RTE WHERE RTE.userId =?1")
    List<RosteringTempEmployeeCode> findAllByUserId(String pUserId);

    @Transactional
    @Modifying
    @Query("DELETE FROM RosteringTempEmployeeCode r WHERE r.userId=?1")
    void delete(String pUserId);
}
