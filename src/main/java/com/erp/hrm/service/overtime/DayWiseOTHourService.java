package com.erp.hrm.service.overtime;

import com.erp.hrm.domain.DayWiseOTHour;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 26/09/2018.
 */
public interface DayWiseOTHourService {
    ActionResult save(DayWiseOTHour dayWiseOTHour);

    ActionResult update(DayWiseOTHour dayWiseOTHour);

    List<DayWiseOTHour> getAllDayWiseOTHour();

    DayWiseOTHour findOne(Long id);

    void delete(Long id);
}
