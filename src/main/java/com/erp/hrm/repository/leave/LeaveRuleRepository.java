package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.LeaveRuleInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaveRuleRepository extends JpaRepository<LeaveRuleInfo, Long> {
    @Query("SELECT DISTINCT lr.leaveRuleID FROM LeaveRuleInfo lr")
    List<Object[]> getAllDistinctLeaveRule();
}
