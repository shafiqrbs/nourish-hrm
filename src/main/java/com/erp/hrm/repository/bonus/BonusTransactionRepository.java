package com.erp.hrm.repository.bonus;

import com.erp.hrm.domain.BonusTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sohag on 26/09/2018.
 */
@Repository
public interface BonusTransactionRepository extends JpaRepository<BonusTransaction, Long>{
}
