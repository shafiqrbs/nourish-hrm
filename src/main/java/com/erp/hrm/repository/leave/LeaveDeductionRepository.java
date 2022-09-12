package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.LeaveDeductionPolicyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveDeductionRepository extends JpaRepository<LeaveDeductionPolicyInfo, Long> {
    @Query("SELECT ld FROM LeaveDeductionPolicyInfo ld WHERE ld.LeavePolicyID= :leavePolicyID")
    LeaveDeductionPolicyInfo findOneByLeavePolicyId(@Param("leavePolicyID")String leavePolicyID);
}
