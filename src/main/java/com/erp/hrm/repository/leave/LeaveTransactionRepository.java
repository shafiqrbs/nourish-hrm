package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.LeaveTransInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveTransactionRepository extends JpaRepository<LeaveTransInfo, Long> {
    @Query("SELECT lt.leaveTypeID,lt.fromDate,lt.toDate,lt.days,lt.leaveReason,lt.leaveAvailPlace,lt.isPostApproved " +
            "FROM LeaveTransInfo lt WHERE lt.employeeInfo.employeeCode = :employeeCode")
    List<Object[]> findOneByEmployeeCode(@Param("employeeCode")String employeeCode);
}
