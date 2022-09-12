package com.erp.hrm.repository.payment;

import com.erp.hrm.domain.MonthWiseAttendanceInfoReport;
import com.erp.hrm.domain.MonthWiseSalaryReport;
import com.erp.hrm.domain.SalaryProcess;
import com.erp.hrm.domain.SalaryWiseEmployeeInfoReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sohag on 5/13/2017.
 */
public interface SalaryProcessRepository extends JpaRepository<SalaryProcess, Long>{

    @Query("SELECT new com.erp.hrm.domain.MonthWiseSalaryReport(SP.EmployeeCode, SP.SalaryProcID, SP.FromDate, SP.ToDate, SP.ProcDate,SP.MonthNo,SP.YearNo, " +
            " SUM(CASE WHEN SP.SalaryHeadID = 'ATTENDANCE BONUS' THEN SP.PayCurrencyValue ELSE 0 END),"+//  attendanceBonus
            " SUM(CASE WHEN SP.SalaryHeadID = 'BASIC' THEN SP.PayCurrencyValue ELSE 0 END)," + // basic
            " SUM(CASE WHEN SP.SalaryHeadID = 'BONUS' THEN SP.PayCurrencyValue ELSE 0 END)," + // bonus
            " SUM(CASE WHEN SP.SalaryHeadID = 'EOT' THEN SP.PayCurrencyValue ELSE 0 END), " + // eot
            " SUM(CASE WHEN SP.SalaryHeadID = 'GROSS' THEN SP.PayCurrencyValue ELSE 0 END), " + // gross
            " SUM(CASE WHEN SP.SalaryHeadID = 'HOUSE RENT' THEN SP.PayCurrencyValue ELSE 0 END)," + // houseRent
            " SUM(CASE WHEN SP.SalaryHeadID = 'MEDICAL' THEN SP.PayCurrencyValue ELSE 0 END)," + // medical
            " SUM(CASE WHEN SP.SalaryHeadID = 'OT' THEN SP.PayCurrencyValue ELSE 0 END)," + //ot
            " SUM(CASE WHEN SP.SalaryHeadID = 'ABSENTEEISM' THEN SP.PayCurrencyValue ELSE 0 END)," + //absenteeism
            " SUM(CASE WHEN SP.SalaryHeadID = 'ADVANCE' THEN SP.PayCurrencyValue ELSE 0 END)," + // advance
            " SUM(CASE WHEN SP.SalaryHeadID = 'CONVEYANCE' THEN SP.PayCurrencyValue ELSE 0 END)," + // conveyance
            " SUM(CASE WHEN SP.SalaryHeadID = 'Income Tax' THEN SP.PayCurrencyValue ELSE 0 END)," + // incomeTax
            " SUM(CASE WHEN SP.SalaryHeadID = 'STAMP' THEN SP.PayCurrencyValue ELSE 0 END)," + //stamp
            " SUM(CASE WHEN SP.SalaryHeadID = 'EncashAmount' THEN SP.PayCurrencyValue ELSE 0 END)," + // encashAmount
            " SUM(CASE WHEN SP.SalaryHeadID = 'LUNCH BILL' THEN SP.PayCurrencyValue ELSE 0 END)," + // lunchBill
            " SUM(CASE WHEN SP.SalaryHeadID = 'LUNCH DEDUCTION' THEN SP.PayCurrencyValue ELSE 0 END)," + // lunchDeduction
            " SUM(CASE WHEN SP.SalaryHeadID = 'OTHER DEDUCTION' THEN SP.PayCurrencyValue ELSE 0 END))" + // otherDeduction
            " FROM SalaryProcess SP" +
            " WHERE SP.isProcessed = false" +
            " GROUP BY SP.EmployeeCode, SP.SalaryProcID, SP.FromDate, SP.ToDate, SP.ProcDate,SP.MonthNo,SP.YearNo")
    List<MonthWiseSalaryReport> getProcessableMonthWiseSalary();

    @Transactional
    @Modifying
    @Query("UPDATE SalaryProcess SP SET SP.isProcessed = true " +
            " WHERE SP.isProcessed = false")
    int updateProcessableMonthWiseSalary();



    @Query("SELECT DISTINCT  new com.erp.hrm.domain.SalaryWiseEmployeeInfoReport(ER.employeeCode,SP.SalaryProcID, " +
            " ER,EMP.permanentZIPCode, EMP.presentZIPCode, EMP.presentDistrict ,ER.employeeName,SR.salaryRuleCode, " +
            " ERI.shiftRuleCode,true,EMP.presentDistrict,'tin' , ERI.bankName,ERI.accountNo)" +
            " FROM SalaryProcess SP" +
            " INNER JOIN SalaryRule SR ON SP.SalaryHeadID = SR.salaryHeadID" +
            " INNER JOIN EmployeeReport ER ON SP.EmployeeCode = ER.employeeCode" +
            " INNER JOIN EmployeeInfo EMP ON ER.employeeCode = EMP.employeeCode" +
            " INNER JOIN EmployeeRuleInfo ERI ON ER.employeeCode = ERI.employeeInfo.employeeCode" +
            " WHERE SP.isProcessSalaryWiseEmployeeReport = false" )
    List<SalaryWiseEmployeeInfoReport> getProcessableSalaryWiseEmployeeReport();

    @Transactional
    @Modifying
    @Query("UPDATE SalaryProcess SP SET SP.isProcessSalaryWiseEmployeeReport = true " +
            " WHERE SP.isProcessSalaryWiseEmployeeReport = false")
    int updateProcessableSalaryWiseEmployeeReport();

   /*@Query("SELECT DISTINCT  new com.erp.hrm.domain.MonthWiseAttendanceInfoReport(ER.employeeCode,SP.SalaryProcID, " +
            " ER,EMP.permanentZIPCode, EMP.presentZIPCode, EMP.presentDistrict ,ER.employeeName,SR.salaryRuleCode, " +
            " ERI.shiftRuleCode,true,EMP.presentDistrict,'tin' , ERI.bankName,ERI.accountNo)" +
            " FROM SalaryProcess SP" +
            " INNER JOIN SalaryRule SR ON SP.SalaryHeadID = SR.salaryHeadID" +
            " INNER JOIN EmployeeReport ER ON SP.EmployeeCode = ER.employeeCode" +
            " INNER JOIN EmployeeInfo EMP ON ER.employeeCode = EMP.employeeCode" +
            " INNER JOIN EmployeeRuleInfo ERI ON ER.employeeCode = ERI.employeeInfo.employeeCode" +
            " WHERE SP.isMonthlyAttendanceReportProcess s = false" )
    List<MonthWiseAttendanceInfoReport> getMonthWiseAttendanceInfoReport();

*/
    @Transactional
    @Modifying
    @Query("UPDATE SalaryProcess SP SET SP.isMonthlyAttendanceReportProcess  = true " +
            " WHERE SP.isMonthlyAttendanceReportProcess = false")
    int updateMonthWiseAttendanceInfoReport();
}
