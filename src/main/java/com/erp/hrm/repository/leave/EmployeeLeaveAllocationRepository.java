package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.EmployeeLeaveMaster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeLeaveAllocationRepository extends JpaRepository<EmployeeLeaveMaster, Long> {
    @Query("SELECT elm.employeeInfo.employeeCode,elm.leavePolicyInfo.leavePolicyID,elm.leavePolicyInfo.leaveType, " +
            "elm.leavePolicyInfo.policyDescription,elm.allocatedDays,elm.openingBalance,elm.encashDays,elm.leaveAvailHour, " +
            "elm.adjustedHLeave,elm.entitlementDate " +
            "FROM EmployeeLeaveMaster elm WHERE elm.employeeInfo.employeeCode= :pEmployeeCode")
    List<Object[]> getAllLeaveAllocationHistoryByEmployeeCode(@Param("pEmployeeCode")String pEmployeeCode);
}
