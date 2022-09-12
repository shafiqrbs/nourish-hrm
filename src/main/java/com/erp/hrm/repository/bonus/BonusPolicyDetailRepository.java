package com.erp.hrm.repository.bonus;

import com.erp.hrm.domain.BonusPolicyDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 26/09/2018.
 */

@Repository
public interface BonusPolicyDetailRepository extends JpaRepository<BonusPolicyDetail, Long>{

    @Query("SELECT BPD FROM BonusPolicyDetail BPD WHERE BPD.bonusCode= :pBonusRuleCode")
    List<BonusPolicyDetail> getAllBonusPolicyDetailByRuleCode(@Param("pBonusRuleCode")String pBonusRuleCode);
}
