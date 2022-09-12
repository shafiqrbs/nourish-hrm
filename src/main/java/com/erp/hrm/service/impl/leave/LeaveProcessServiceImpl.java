package com.erp.hrm.service.impl.leave;

import com.erp.hrm.domain.LeaveReport;
import com.erp.hrm.repository.leave.EmployeeLeaveTransactionRepository;
import com.erp.hrm.service.leave.LeaveProcessService;
import com.erp.hrm.util.ActionResult;
import com.erp.hrm.util.BulkInsetUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManagerFactory;
import java.util.List;

@Service
public class LeaveProcessServiceImpl implements LeaveProcessService {

    private EmployeeLeaveTransactionRepository employeeLeaveTransactionRepository;
    private EntityManagerFactory emf;

    public LeaveProcessServiceImpl(EmployeeLeaveTransactionRepository employeeLeaveTransactionRepository,
                                   EntityManagerFactory emf) {
        this.employeeLeaveTransactionRepository = employeeLeaveTransactionRepository;
        this.emf = emf;
    }

    @Override
    public ActionResult processLeave() {

        ActionResult actionResult = new ActionResult();

        try {

            List<LeaveReport> reports = employeeLeaveTransactionRepository.getProcessableLeaves();

            if(reports.size() > 0) {
                Thread t = new Thread(() -> {
                    bulkInsertLeaveReportWithEntityManager(reports);

                    employeeLeaveTransactionRepository.UpdateProcessableLeaves();
                });
                t.start();
                actionResult.setSuccessMessage("Process Started!");
            }else {
                actionResult.setSuccessMessage("Nothing to Process!");
            }

            actionResult.setIsSuccess(true);

        }
        catch (Exception e){
            e.printStackTrace();
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }


    private void bulkInsertLeaveReportWithEntityManager(List<LeaveReport> tempList) {
        BulkInsetUtil.bulkInsertWithEntityManager(emf,tempList);
    }
}
