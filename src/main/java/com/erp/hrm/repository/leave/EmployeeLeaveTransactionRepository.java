package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.EmpLeaveTransactionApplied;
import com.erp.hrm.domain.LeaveReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */

@Repository
public interface EmployeeLeaveTransactionRepository extends JpaRepository<EmpLeaveTransactionApplied, Long>{
    @Query("SELECT lta.employeeInfo.employeeCode,lta.leavePolicyInfo.policyDescription,lta.fromDate,lta.toDate," +
            "lta.leaveDays,lta.leaveReason,lta.isApproved " +
            "FROM EmpLeaveTransactionApplied lta WHERE lta.employeeInfo.employeeCode= :pEmployeeCode")
    List<Object[]> getAllEmployeeAppliedLeaveTrans(@Param("pEmployeeCode")String pEmployeeCode);

    @Query("SELECT COUNT(lta) FROM EmpLeaveTransactionApplied lta WHERE lta.employeeInfo.employeeCode=?1")
    int getEmployeeLeaveTransactionCount(String pEmployeeCode);

    @Query("SELECT new com.erp.hrm.domain.LeaveReport(ER.employeeCode,ER.employeeName, ER.punchCardNo," +
            " ER.unit,ER.section,ER.floor,ER.line,ER.department,ER.designation,ER.staffCategory,ER.doj," +
            " LTA.transactionID,LTA.transactionDate,LTA.fromDate,LTA.toDate,LTA.leaveDays,LTA.leaveReason, " +
            " LPI.leavePolicyID,LPI.leaveType,LPI.policyDescription )" +
            " FROM EmpLeaveTransactionApplied LTA " +
            " INNER JOIN EmployeeReport ER ON LTA.employeeInfo.employeeCode = ER.employeeCode " +
            " INNER JOIN LeavePolicyInfo LPI ON LTA.leavePolicyInfo.leavePolicyID = LPI.leavePolicyID " +
            " WHERE LTA.isProcessed=false")
    List<LeaveReport> getProcessableLeaves();

    @Transactional
    @Modifying
    @Query("UPDATE EmpLeaveTransactionApplied SET " +
            " isProcessed = true " +
            " WHERE isProcessed = false")
    int UpdateProcessableLeaves();
}
