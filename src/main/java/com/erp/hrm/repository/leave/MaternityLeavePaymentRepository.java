package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.MaternityLeavePayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaternityLeavePaymentRepository extends JpaRepository<MaternityLeavePayment, Long> {

}
