package com.erp.hrm.repository.leave;

import com.erp.hrm.domain.MaternityLeaveRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaternityLeaveRuleRepository extends JpaRepository<MaternityLeaveRule, Long> {
    @Query("SELECT ml FROM MaternityLeaveRule ml WHERE ml.maternityLeaveRuleID = :pMaternityLeaveRuleID")
    MaternityLeaveRule findOneByMaternityLeaveRuleID(@Param("pMaternityLeaveRuleID")String pMaternityLeaveRuleID);

    @Query("SELECT DISTINCT ml.maternityLeaveRuleID FROM MaternityLeaveRule ml")
    List<Object[]> getAllDistinctMaternityLeaveRule();
}
