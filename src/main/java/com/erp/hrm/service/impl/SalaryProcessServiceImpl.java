package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.EmployeeCodeDTO;
import com.erp.hrm.api.dto.SalaryProcessInfoDTO;
import com.erp.hrm.domain.MonthWiseAttendanceInfoReport;
import com.erp.hrm.domain.MonthWiseSalaryReport;
import com.erp.hrm.domain.SalaryProcess;
import com.erp.hrm.domain.SalaryWiseEmployeeInfoReport;
import com.erp.hrm.repository.payment.EmployeeSalaryInfoRepository;
import com.erp.hrm.repository.payment.SalaryProcessRepository;
import com.erp.hrm.service.EmployeeSalaryInfoService;
import com.erp.hrm.service.SalaryProcessService;
import com.erp.hrm.util.ActionResult;
import com.erp.hrm.util.BulkInsetUtil;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Sohag on 4/10/2018.
 */
@Service
public class SalaryProcessServiceImpl implements SalaryProcessService {
    private SalaryProcessRepository salaryProcessRepository;
    private EmployeeSalaryInfoRepository employeeSalaryInfoRepository;
    private EntityManagerFactory emf;

    public SalaryProcessServiceImpl( EntityManagerFactory emf,SalaryProcessRepository salaryProcessRepository,EmployeeSalaryInfoRepository employeeSalaryInfoRepository)
    {
        this.emf = emf;
        this.salaryProcessRepository = salaryProcessRepository;
        this.employeeSalaryInfoRepository = employeeSalaryInfoRepository;
    }

    @Override
    public ActionResult salaryProcessAndSave(String fromDate,String toDate,List<EmployeeCodeDTO> dto) throws ParseException {
        ActionResult actionResult = new ActionResult();
        try
        {
            List<SalaryProcess> salaryProcessObjList = new ArrayList<>();
            for (EmployeeCodeDTO empDTO:dto)
            {
                List<Objects[]> salaryObj = employeeSalaryInfoRepository.getEmployeeSalaryByEmployeeCode(empDTO.getEmployeeCode());
                for (Object[] data:salaryObj)
                {
                    SalaryProcess salaryProcessObj = new SalaryProcess();
                    salaryProcessObj.setSalaryProcID(fromDate.replace("-","")+"SP"+toDate.replace("-",""));
                    salaryProcessObj.setEmployeeCode(empDTO.getEmployeeCode());
                    salaryProcessObj.setSalaryHeadID((String) data[0]);

                    DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    Date frmDate = format.parse(fromDate);
                    Date tDate = format.parse(toDate);
                    salaryProcessObj.setFromDate(frmDate);
                    salaryProcessObj.setToDate(tDate);

                    Date processDate = new Date();
                    salaryProcessObj.setProcDate(processDate);

                    BigDecimal currencyValue = BigDecimal.valueOf((float) data[1]);
                    salaryProcessObj.setCurrencyValue(currencyValue);
                    salaryProcessObj.setPayCurrencyValue(currencyValue);
                    salaryProcessObj.setNetCurrencyValue(currencyValue);
                    salaryProcessObj.setDateAdded(new Date());
                    salaryProcessObjList.add(salaryProcessObj);
                }
            }
//            salaryProcessRepository.save(salaryProcessObjList);
            salaryProcessRepository.saveAll(salaryProcessObjList);

            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Employee salary information saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult paymentReportProcess() {
        ActionResult actionResult = new ActionResult();
        try
        {
                List<MonthWiseSalaryReport> monthWiseSalaryReports = salaryProcessRepository.getProcessableMonthWiseSalary();

                bulkInsertMonthWiseSalaryReport(monthWiseSalaryReports);
                salaryProcessRepository.updateProcessableMonthWiseSalary();

                //Set custom message if success
                actionResult.setIsSuccess(true);
                actionResult.setSuccessMessage("Process started");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult salaryWiseEmployeeReportProcess() {

        ActionResult actionResult = new ActionResult();
        try
        {
            List<SalaryWiseEmployeeInfoReport> salaryWiseEmployeeInfoReports = salaryProcessRepository.getProcessableSalaryWiseEmployeeReport();

            bulkInsertSalaryWiseEmployeeInfoReport(salaryWiseEmployeeInfoReports);
            salaryProcessRepository.updateProcessableSalaryWiseEmployeeReport();

            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Process started");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    @Override
    public ActionResult monthlyAttendanceReportProcess() {
        ActionResult actionResult = new ActionResult();
        try
        {
       //     List<MonthWiseAttendanceInfoReport> reports = salaryProcessRepository.getMonthWiseAttendanceInfoReport();

         //   bulkInsertMonthWiseAttendanceInfoReport(reports);
          //  salaryProcessRepository.updateMonthWiseAttendanceInfoReport();

            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Process started");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }
        return actionResult;
    }

    private void bulkInsertMonthWiseSalaryReport(List<MonthWiseSalaryReport> items ){
        BulkInsetUtil.bulkInsertWithEntityManager(emf,items);
    }
    private void bulkInsertSalaryWiseEmployeeInfoReport(List<SalaryWiseEmployeeInfoReport> items ){
        BulkInsetUtil.bulkInsertWithEntityManager(emf,items);
    }
    private void bulkInsertMonthWiseAttendanceInfoReport(List<MonthWiseAttendanceInfoReport> items ){
        BulkInsetUtil.bulkInsertWithEntityManager(emf,items);
    }
}
