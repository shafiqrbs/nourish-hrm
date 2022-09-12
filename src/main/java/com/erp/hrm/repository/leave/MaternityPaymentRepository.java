package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.MaternityPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface MaternityPaymentRepository extends JpaRepository<MaternityPayment, Long> {
    @Query("SELECT COUNT(mp) FROM MaternityPayment mp" +
            " WHERE mp.firstPaymentDate >= :pFromFate AND mp.firstPaymentDate <= :pToDate")
    int getNumberOfPaymentByYear(@Param("pFromFate")Date pFromFate,@Param("pToDate") Date pToDate);
}
