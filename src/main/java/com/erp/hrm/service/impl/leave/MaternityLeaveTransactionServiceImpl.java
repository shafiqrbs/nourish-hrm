package com.erp.hrm.service.impl.leave;

import com.erp.hrm.api.dto.leaveManagement.MaternityLeaveTransInfoDTO;
import com.erp.hrm.api.dto.leaveManagement.MaternityLeaveTransSaveDTO;
import com.erp.hrm.domain.*;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.leave.MaternityLeavePaymentRepository;
import com.erp.hrm.repository.leave.MaternityLeaveTransactionRepository;
import com.erp.hrm.repository.leave.MaternityPaymentDetailsRepository;
import com.erp.hrm.repository.leave.MaternityPaymentRepository;
import com.erp.hrm.repository.payment.EmployeeSalaryInfoRepository;
import com.erp.hrm.service.leave.MaternityLeaveTransactionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class MaternityLeaveTransactionServiceImpl implements MaternityLeaveTransactionService {
    private EmployeeInfoRepository employeeInfoRepository;
    private EmployeeSalaryInfoRepository employeeSalaryInfoRepository;
    private MaternityLeaveTransactionRepository maternityLeaveTransactionRepository;
    private MaternityPaymentRepository maternityPaymentRepository;
    private MaternityPaymentDetailsRepository maternityPaymentDetailsRepository;
    private MaternityLeavePaymentRepository maternityLeavePaymentRepository;

    public MaternityLeaveTransactionServiceImpl(
            EmployeeInfoRepository employeeInfoRepository, MaternityLeaveTransactionRepository maternityLeaveTransactionRepository,
            EmployeeSalaryInfoRepository employeeSalaryInfoRepository,MaternityPaymentRepository maternityPaymentRepository,
            MaternityPaymentDetailsRepository maternityPaymentDetailsRepository,MaternityLeavePaymentRepository maternityLeavePaymentRepository)
    {
        this.employeeInfoRepository = employeeInfoRepository;
        this.maternityLeaveTransactionRepository = maternityLeaveTransactionRepository;
        this.employeeSalaryInfoRepository = employeeSalaryInfoRepository;
        this.maternityPaymentRepository = maternityPaymentRepository;
        this.maternityPaymentDetailsRepository = maternityPaymentDetailsRepository;
        this.maternityLeavePaymentRepository = maternityLeavePaymentRepository;
    }

    private String generateMaternityLeaveTransId(Date fromDate){


        Calendar from = Calendar.getInstance();
        Calendar to = Calendar.getInstance();
        from.setTime(fromDate);
        from.set(Calendar.DATE,01);
        from.set(Calendar.MONTH,01);
        to.setTime(fromDate);
        to.set(Calendar.DATE,31);
        to.set(Calendar.MONTH,12);

        int paymentNumbers = maternityPaymentRepository.getNumberOfPaymentByYear(from.getTime(), to.getTime());

        String transId = "ML-" + from.get(Calendar.YEAR) + "-" + (paymentNumbers + 1);
        return transId;
    }
    private Date getPreNatalToDate(Date fromDate,Date toDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis((fromDate.getTime() + toDate.getTime()) / 2);
        return calendar.getTime();
    }
    private Date getPostNatalFromDate(Date fromDate){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fromDate);
        calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) + 1 );
        return calendar.getTime();
    }
    private int getDayDiffrence(Date fromDate,Date toDate) {
        long diff = toDate.getTime() - fromDate.getTime();
        return (int) TimeUnit.DAYS.convert(diff , TimeUnit.MILLISECONDS);
    }

    @Override
    public ActionResult saveMaternityLeaveTransInfo(MaternityLeaveTransSaveDTO dto) {
        ActionResult actionResult = new ActionResult();
        try {
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(dto.getEmployeeCode());

            MaternityPayment maternityPayment = new MaternityPayment();
            maternityPayment.setTranId(this.generateMaternityLeaveTransId(dto.getFromDate()));
            maternityPayment.setFirstPaymentDate(dto.getFirstPaymentDate());
            maternityPayment.setFirstPercent(dto.getFirstPaymentPCT());
            maternityPayment.setSecondPaymentDate(dto.getSecondPaymentDate());
            maternityPayment.setStatus("PARTIAL");
            maternityPayment.setOthers(0);
            maternityPayment.setMaternityDeduction("0");
            maternityPayment = maternityPaymentRepository.save(maternityPayment);

            float totalSalary = employeeSalaryInfoRepository.getEmployeeGrossSalary(employeeInfo.getEmployeeCode());

            MaternityLeavePayment maternityLeavePayment = new MaternityLeavePayment();
            maternityLeavePayment.setMaternityPayment(maternityPayment);
            maternityLeavePayment.setActualPaymentDate(dto.getFirstPaymentDate());
            maternityLeavePayment.setEmployeeInfo(employeeInfo);

            maternityLeavePayment.setPreNatalFromDate(dto.getFromDate());
            maternityLeavePayment.setPreNatalToDate(getPreNatalToDate(dto.getFromDate(), dto.getToDate()));
            maternityLeavePayment.setPostNatalFromDate(getPostNatalFromDate(maternityLeavePayment.getPreNatalToDate()));
            maternityLeavePayment.setPostNatalToDate(dto.getToDate());
            maternityLeavePayment.setPreNatalTotalDays(getDayDiffrence(maternityLeavePayment.getPreNatalToDate(),maternityLeavePayment.getPreNatalFromDate()));
            maternityLeavePayment.setPostNatalTotalDays(getDayDiffrence(maternityLeavePayment.getPostNatalToDate(),maternityLeavePayment.getPostNatalFromDate()));

            float netPayment = totalSalary * (maternityLeavePayment.getPreNatalTotalDays() + maternityLeavePayment.getPostNatalTotalDays()) / 30;
            maternityLeavePayment.setPreNatalPayment((netPayment * dto.getFirstPaymentPCT() )/ 100); // TODO need to work on
            maternityLeavePayment.setPostNatalPayment(netPayment - maternityLeavePayment.getPreNatalPayment());
            maternityLeavePayment.setOtherAddition(0);
            maternityLeavePayment.setNetPayment(netPayment);

            maternityLeavePayment.setActualPaymentDate(dto.getEDD());
            maternityLeavePayment.setPaymentReleaseDate(new Date());

            maternityLeavePayment.setIncrementEffected(false);

            maternityLeavePayment = maternityLeavePaymentRepository.save(maternityLeavePayment);

            MaternityPaymentDetails paymentDetails = new MaternityPaymentDetails();
            paymentDetails.setSalaryHeadID("MATERNITY LEAVE");
            paymentDetails.setFirstAmount( maternityLeavePayment.getPreNatalPayment());
            paymentDetails.setSecondAmount(maternityLeavePayment.getPostNatalPayment());
            paymentDetails.setMaternityPayment(maternityPayment);

            maternityPaymentDetailsRepository.save(paymentDetails);

            MaternityLeaveTransInfo info = new MaternityLeaveTransInfo();
            info.setMaternityPayment(maternityPayment);
            info.setEmployeeInfo(employeeInfo);
            info.setMaternityLeaveRuleID("MLV");
            info.setFromDate(dto.getFromDate());
            info.setToDate(dto.getToDate());
            info.setIsBenefitGiven(1);

            info.setTotalLeaveAvail(maternityLeaveTransactionRepository.getLeaveCountByEmployeeCode(employeeInfo.getEmployeeCode()) + 1 );

            info.setEDD(dto.getEDD());
            info.setDays(maternityLeavePayment.getPreNatalTotalDays() + maternityLeavePayment.getPostNatalTotalDays());
            info.setApprovedBy(null);
            info.setDateApproved(null);
            info.setHrdMemoNo(null);
            info.setHrdMemoDate(null);
            info.setRemarks(null);

            maternityLeaveTransactionRepository.save(info);
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Maternity leave applied successfully!");
        }
        catch (Exception e){
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<MaternityLeaveTransInfoDTO> getMaternityLeaveTransInfo(String EmployeeCode) {
        List<MaternityLeaveTransInfoDTO> leaveTransInfoDTOS = new ArrayList<>();
        try {
            List<Object[]> leaveTransObj = maternityLeaveTransactionRepository.getAllByEmployeeCode(EmployeeCode);
            for (Object[] info:leaveTransObj){
                MaternityLeaveTransInfoDTO dto = new MaternityLeaveTransInfoDTO();

                dto.setEmployeeCode((String) info[0]);
                dto.setMaternityLeaveRuleID((String) info[1]);
                dto.setFromDate((Date) info[2]);
                dto.setToDate((Date) info[3]);
                dto.setIsBenefitGiven((int) info[4]);
                dto.setTotalLeaveAvail((int) info[5]);
                dto.setEDD((Date) info[6]);
                dto.setTranID((String) info[7]);
                dto.setDays((int) info[8]);
                dto.setApprovedBy((String) info[9]);
                dto.setDateApproved((Date) info[10]);
                dto.setHrdMemoNo((String) info[11]);
                dto.setHrdMemoDate((Date) info[12]);
                dto.setRemarks((String) info[13]);

                leaveTransInfoDTOS.add(dto);
            }
        } catch (Exception ex){
            leaveTransInfoDTOS = null;
        }
        return leaveTransInfoDTOS;
    }
}
