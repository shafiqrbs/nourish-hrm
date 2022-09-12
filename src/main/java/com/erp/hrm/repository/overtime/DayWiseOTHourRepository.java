package com.erp.hrm.repository.overtime;

import com.erp.hrm.domain.DayWiseOTHour;
import com.erp.hrm.domain.OTSlabInShift;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sohag on 26/09/2018.
 */
public interface DayWiseOTHourRepository extends JpaRepository<DayWiseOTHour, Long>{
}
