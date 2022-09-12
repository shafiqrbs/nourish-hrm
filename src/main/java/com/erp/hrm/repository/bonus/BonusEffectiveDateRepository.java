package com.erp.hrm.repository.bonus;

import com.erp.hrm.domain.BonusEffectiveDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sohag on 26/09/2018.
 */

@Repository
public interface BonusEffectiveDateRepository extends JpaRepository<BonusEffectiveDate, Long>{

    @Query("SELECT BED FROM BonusEffectiveDate BED WHERE BED.bonusCode= :pBonusRuleCode")
    List<BonusEffectiveDate> getAllBonusEffectiveDatesByRuleCode(@Param("pBonusRuleCode")String pBonusRuleCode);

    @Query("SELECT BED FROM BonusEffectiveDate BED WHERE BED.bonusCode= :pBonusRuleCode")
    BonusEffectiveDate getBonusEffectiveDatesByRuleCode(@Param("pBonusRuleCode")String pBonusRuleCode);
}
