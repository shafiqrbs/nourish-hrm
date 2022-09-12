package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.MaternityPaymentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaternityPaymentDetailsRepository extends JpaRepository<MaternityPaymentDetails, Long> {

}
