package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.LeavePolicyInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeavePolicyRepository extends JpaRepository<LeavePolicyInfo, Long> {
    @Query("SELECT lp FROM LeavePolicyInfo lp WHERE lp.leavePolicyID = :LeavePolicyID ")
    LeavePolicyInfo findOneByLeavePolicyID(@Param("LeavePolicyID")String LeavePolicyID);

    @Query("SELECT DISTINCT lp.leavePolicyID,lp.leaveType FROM LeavePolicyInfo lp")
    List<Object[]> getAllLeaveType();

    @Query("SELECT DISTINCT lp.leaveCategory FROM LeavePolicyInfo lp")
    List<Object[]> getAllLeaveCategory();

    @Query("SELECT DISTINCT lp.leaveCredit FROM LeavePolicyInfo lp")
    List<Object[]> getAllLeaveCredit();

    @Query("SELECT MAX(lp.leavePolicyID) FROM LeavePolicyInfo lp")
    String generateLeavePolicyId();
}
