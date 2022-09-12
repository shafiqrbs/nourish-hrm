package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.LeaveEncashmentPolicyInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveEncashmentRepository extends JpaRepository<LeaveEncashmentPolicyInfo, Long> {
}
