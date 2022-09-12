package com.erp.hrm.repository.attendance;

import com.erp.hrm.domain.TempManualEntryEmployeeCode;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sohag on 22/02/2019.
 */

@Repository
public interface TempManualEntryEmployeeRepository extends JpaRepository<TempManualEntryEmployeeCode, Long>{
    @Query("SELECT COUNT(*) FROM TempManualEntryEmployeeCode TEE WHERE TEE.userId= :pUserId")
    int getTempEmployeeCodeCount(@Param("pUserId") String pUserId);

    @Query("SELECT DISTINCT emp.employeeCode,emp.displayEmployeeCode,emp.salutation,emp.firstName,emp.middleName," +
            "emp.lastName,emp.punchCardNo,emp.employeeStatus,eof.department,eof.designation," +
            "eof.unit,eof.doc,eof.doj,eof.staffCategory " +
            "FROM EmployeeInfo emp " +
            "INNER JOIN emp.employeeOfficeInfo eof " +
            "INNER JOIN TempManualEntryEmployeeCode TEE ON emp.employeeCode = TEE.employeeCode " +
            "WHERE TEE.userId= :pUserId")
    Page<Object[]> getAllTemp(@Param("pUserId") String pUserId, Pageable pageable);

    @Query("SELECT TEE FROM TempManualEntryEmployeeCode TEE WHERE TEE.userId = :pUserId")
    List<TempManualEntryEmployeeCode> findAllByUserId(@Param("pUserId") String pUserId);

    @Query("SELECT TEE FROM TempManualEntryEmployeeCode TEE " +
            "LEFT OUTER JOIN DailyAttendance DA ON TEE.employeeCode = DA.employeeCode " +
            "AND TEE.entryDate = DA.workDate " +
            "AND TEE.entryType = DA.punchType " +
            "WHERE TEE.userId = :pUserId AND DA.employeeCode IS NULL")
    List<TempManualEntryEmployeeCode> getAllSelectedManualBulkAttendances(@Param("pUserId") String pUserId);

    @Transactional
    @Modifying
    @Query("DELETE FROM TempManualEntryEmployeeCode TEE WHERE TEE.userId= :pUserId")
    void delete(@Param("pUserId") String pUserId);
}
