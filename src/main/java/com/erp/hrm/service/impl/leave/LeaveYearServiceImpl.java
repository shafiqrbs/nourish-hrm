package com.erp.hrm.service.impl.leave;

import com.erp.hrm.domain.LeaveYear;
import com.erp.hrm.repository.leave.*;
import com.erp.hrm.service.leave.LeaveYearService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class LeaveYearServiceImpl implements LeaveYearService {

    private LeaveYearRepository leaveYearRepository;

    public LeaveYearServiceImpl(LeaveYearRepository leaveYearRepository) {
        this.leaveYearRepository = leaveYearRepository;
    }

    @Override
    public ActionResult saveLeaveYear(LeaveYear leaveYear) {
        ActionResult actionResult = new ActionResult();
        try {

            List<LeaveYear> leaveYears = leaveYearRepository.findAll();
            for (LeaveYear leaveYearObj:leaveYears)
            {
                leaveYearObj.setActive(false);
                leaveYearRepository.save(leaveYearObj);
            }

            leaveYear.setActive(true);
            leaveYearRepository.save(leaveYear);

            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Leave Year saved successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<LeaveYear> getLeaveYears() {
        return leaveYearRepository.findAll();
    }

    @Override
    public LeaveYear getActiveLeaveYear() {
        return leaveYearRepository.getActiveLeaveYear();
    }
}
