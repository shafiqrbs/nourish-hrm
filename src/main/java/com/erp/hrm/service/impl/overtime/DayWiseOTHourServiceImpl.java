package com.erp.hrm.service.impl.overtime;

import com.erp.hrm.domain.DayWiseOTHour;
import com.erp.hrm.repository.overtime.DayWiseOTHourRepository;
import com.erp.hrm.service.overtime.DayWiseOTHourService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DayWiseOTHourServiceImpl implements DayWiseOTHourService {

    private DayWiseOTHourRepository dayWiseOTHourRepository;

    public DayWiseOTHourServiceImpl(DayWiseOTHourRepository dayWiseOTHourRepository) {
        this.dayWiseOTHourRepository = dayWiseOTHourRepository;
    }

    @Override
    public ActionResult save(DayWiseOTHour dayWiseOTHour) {
        return null;
    }

    @Override
    public ActionResult update(DayWiseOTHour dayWiseOTHour) {
        return null;
    }

    @Override
    public List<DayWiseOTHour> getAllDayWiseOTHour() {
        return null;
    }

    @Override
    public DayWiseOTHour findOne(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
