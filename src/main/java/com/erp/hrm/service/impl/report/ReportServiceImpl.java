package com.erp.hrm.service.impl.report;

import com.erp.hrm.api.dto.Configuration.CompanySettingsDTO;
import com.erp.hrm.api.dto.ReportFilterDTO;
import com.erp.hrm.api.dto.ReportFilterDataDTO;
import com.erp.hrm.api.dto.report.ReportItemsDTO;
import com.erp.hrm.api.dto.report.ReportMenuDTO;
import com.erp.hrm.domain.AllReports;
import com.erp.hrm.domain.CompanySettings;
import com.erp.hrm.repository.reports.AllReportRepository;
import com.erp.hrm.service.report.ReportService;
import com.erp.hrm.util.StaticName;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service("ReportService")
public class ReportServiceImpl implements ReportService {
    private AllReportRepository allReportRepository;
    private AttendanceReportData attendanceReportData;
    private EmployeeReportData employeeReportData;
    private LeaveReportData leaveReportData;
    private PaymentReportData paymentReportData;
    private BonusReportData bonusReportData;
    public ReportServiceImpl(AllReportRepository allReportRepository,
                             AttendanceReportData attendanceReportData,
                             EmployeeReportData employeeReportData,
                             LeaveReportData leaveReportData,
                             PaymentReportData paymentReportData,
                             BonusReportData bonusReportData){
        this.allReportRepository = allReportRepository;
        this.attendanceReportData = attendanceReportData;
        this.employeeReportData = employeeReportData;
        this.leaveReportData = leaveReportData;
        this.paymentReportData = paymentReportData;
        this.bonusReportData = bonusReportData;
    }

    @Override
    public String getReportTemplateURL(long pReportId) {
        String reportTemplate = allReportRepository.getReportTemplateByReportId(pReportId);
        return StaticName.REPORT_TEMPLATE_PATH+reportTemplate;
    }

    @Override
    public String getReportName(long pReportId) {
        AllReports reportInfo = allReportRepository.getReportInfoByReportId(pReportId);
        return reportInfo.getReportName();
    }

    @Override
    public CompanySettingsDTO getCompanyInfo(long pReportId) {
        CompanySettings companySettings = allReportRepository.getCompanyInfo(pReportId);
        CompanySettingsDTO companySettingsDTO = new CompanySettingsDTO();
        companySettingsDTO.setId(companySettings.getId());
        companySettingsDTO.setCompanyName(companySettings.getCompanyName());
        companySettingsDTO.setCompanyLogo(companySettings.getCompanyLogo());
        companySettingsDTO.setAddress(companySettings.getAddress());
        companySettingsDTO.setCompanyCity(companySettings.getCompanyCity());
        companySettingsDTO.setCompanyState(companySettings.getCompanyState());
        companySettingsDTO.setZip(companySettings.getZip());
        companySettingsDTO.setCountry(companySettings.getCountry());
        companySettingsDTO.setCompanyPhone(companySettings.getCompanyPhone());
        companySettingsDTO.setContactName(companySettings.getContactName());
        companySettingsDTO.setContactPhone(companySettings.getContactPhone());
        companySettingsDTO.setDesignation(companySettings.getDesignation());
        companySettingsDTO.setContactEmail(companySettings.getContactEmail());
        companySettingsDTO.setLinkedInInfoURL(companySettings.getLinkedInInfoURL());
        companySettingsDTO.setFacebookURL(companySettings.getFacebookURL());
        companySettingsDTO.setIsDefault(companySettings.getIsDefault());
        return companySettingsDTO;
    }

    @Override
    public List<Map<String, Object>> report(ReportFilterDataDTO reportFilterDataDTO) throws ParseException {
        //Initialize
        List<Map<String, Object>> result = null;
        AllReports reportInfo = allReportRepository.getReportInfoByReportId(reportFilterDataDTO.getReportId());
        String vReportName = reportInfo.getReportName();
        String vSubModuleName = reportInfo.getSubModuleName();

        //Taking Decision for service calling based on Report Name
        if(vSubModuleName.contentEquals(StaticName.ATTENDANCE_SUB_MODULE)){
            //For Attendance Report Data
            if(vReportName.contentEquals(StaticName.ATTENDANCE_ABSENT_REPORT_NAME)){
                result = attendanceReportData.getAttendanceAbsentReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.DAILY_LATE_REPORT_NAME)){
                result = attendanceReportData.getDailyLateReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.DAILY_ATTENDANCE_REPORT_NAME)){
                result = attendanceReportData.getDailyAttendanceReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.DAY_PRESENT_INFO_REPORT_NAME)){
                result = attendanceReportData.getDayPresentInformationReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.EMPLOYEE_IN_PUNCH_MISSING_REPORT_NAME)){
                result = attendanceReportData.getEmployeeInPunchMissingInfoReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.EMPLOYEE_OUT_PUNCH_MISSING_REPORT_NAME)){
                result = attendanceReportData.getEmployeeOutPunchMissingInfoReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.CONTINUOUS_ABSENT_REPORT_NAME)){
                result = attendanceReportData.getContinuousAbsentReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.WORK_DATE_WISE_ATTENDANCE_REPORT_NAME)){
                result = attendanceReportData.getWorkDateWiseAttendanceReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.DAILY_LINE_WISE_ATTENDANCE_SUMMARY_REPORT_NAME)){
                result = attendanceReportData.getDailyLineWiseAttendanceSummaryReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.DAILY_EMPLOYEE_ATTENDANCE_REPORT_NAME)){
                result = attendanceReportData.getDailyEmployeeAttendanceReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.MONTHLY_ATTENDANCE_SHEET_REPORT_NAME)){
                result = attendanceReportData.getMonthlyAttendanceSheetReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.EMPLOYEE_ATTENDANCE_HISTORY_FOR_BUYER_REPORT_NAME)){
                result = attendanceReportData.getEmployeeAttendanceHistoryForBuyerReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.DAILY_ATTENDANCE_ACTUAL_HISTORY_REPORT_NAME)){
                result = attendanceReportData.getDailyAttendanceActualHistoryReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.EMPLOYEE_JOB_CARDS_NAME)){
                result = attendanceReportData.getEmployeeJobCardsReport(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
        }
        else if(vSubModuleName.contentEquals(StaticName.EMPLOYEE_SUB_MODULE)){
            //For Employee Report Data
            if(vReportName.contentEquals(StaticName.DEPARTMENT_WISE_EMPLOYEE_REPORT_NAME)){
                result = employeeReportData.getDepartmentWiseEmployeeData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.DESIGNATION_WISE_EMPLOYEE_REPORT_NAME)){
                result = employeeReportData.getDesignationWiseEmployeeData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.GENDER_WISE_EMPLOYEE_REPORT_NAME)){
                result = employeeReportData.getGenderWiseEmployeeData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.GRADE_WISE_NUMBER_OF_EMPLOYEE_NAME)){
                result = employeeReportData.getGradeWiseNumberOfEmployeeData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.NEW_EMPLOYEE_JOINING_STATUS_REPORT_NAME)){
                result = employeeReportData.getNewEmployeeJoiningStatusData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.SEPARATED_EMPLOYEE_REPORT_NAME)){
                result = employeeReportData.getSeparatedEmployeeData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
        }
        else if(vSubModuleName.contentEquals(StaticName.LEAVE_SUB_MODULE)){
            //For Leave Report Data
            if(vReportName.contentEquals(StaticName.MONTHLY_LEAVE_TRANSACTION_REPORT_NAME)){
                result = leaveReportData.getMonthlyLeaveTransactionData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.EMPLOYEE_LEAVE_TRANSACTION_REPORT_NAME)){
                result = leaveReportData.getEmployeeLeaveTransactionData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
        }
        else if(vSubModuleName.contentEquals(StaticName.PAYMENT_SUB_MODULE)){
            //For Payment Report Data
            if(vReportName.contentEquals(StaticName.SALARY_AND_OVERTIME_SHEET_REPORT_NAME)){
                result = paymentReportData.getSalaryAndOvertimeSheetData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.SALARY_AND_OVERTIME_SHEET_FOR_BUYER_REPORT_NAME)){
                result = paymentReportData.getSalaryAndOvertimeSheetForBuyerData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.SALARY_AND_OT_TOP_SHEET_FOR_BUYER_REPORT_NAME)){
                result = paymentReportData.getSalaryAndOTTopSheetForBuyerData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.EXTRA_OVERTIME_SHEET_REPORT_NAME)){
                result = paymentReportData.getExtraOvertimeSheetData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
            else if(vReportName.contentEquals(StaticName.PAYSLIP_REPORT_NAME)){
                result = paymentReportData.getPayslipData(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
            }
        }
        else if(vSubModuleName.contentEquals(StaticName.BONUS_SUB_MODULE)){
            //For Bonus Report Data
            result = bonusReportData.getBonusInfo(reportFilterDataProcess(reportFilterDataDTO.getFilters()));
        }
        else{
            //Return null
            result = null;
        }

        return result;
    }

    @Override
    public String getReportDateRange(String filtersStr) throws ParseException {
        String reportDateRanges = "";
        String fromDate="",toDate="";

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat dateParse = new SimpleDateFormat("yyyy-MM-dd");

        if(filtersStr !=null) {
            String[] filtersObj = filtersStr.split("~");
            for (String filters : filtersObj) {
                String[] filter = filters.split("_");

                if(filter[0].contains("fmd")){
                    fromDate=dateFormat.format(dateParse.parse(filter[1]));
                    continue;
                }
                if(filter[0].contains("tod")){
                    toDate=dateFormat.format(dateParse.parse(filter[1]));
                    continue;
                }
            }
        }
        reportDateRanges = fromDate + (toDate == ""?"":" - "+toDate);
        return reportDateRanges;
    }

    @Override
    public List<ReportMenuDTO> getAllReports() {
        List<ReportMenuDTO> reportMenuDTOS = new ArrayList<>();
        List<Object[]> subModules = allReportRepository.getAllSubModules();
        for (Object[] subModule: subModules) {
            ReportMenuDTO reportMenuDTO = new ReportMenuDTO();
            reportMenuDTO.setLabel(subModule[0].toString()+" Reports");
            reportMenuDTO.setIcon(subModule[1].toString());

            List<ReportItemsDTO> reportItemsDTOS = new ArrayList<>();
            List<AllReports> reports = allReportRepository.getAllReportSubModuleItems(subModule[0].toString());
            for (AllReports report:reports) {
                ReportItemsDTO reportItemsDTO = new ReportItemsDTO();
                reportItemsDTO.setReportId(report.getId());
                reportItemsDTO.setLabel(report.getReportLabel());
                reportItemsDTO.setName(report.getReportName());
                reportItemsDTOS.add(reportItemsDTO);
            }
            reportMenuDTO.setItems(reportItemsDTOS);
            reportMenuDTOS.add(reportMenuDTO);
        }
        return reportMenuDTOS;
    }

    private ReportFilterDTO reportFilterDataProcess(String filterStr){
        ReportFilterDTO reportFilterDTO = new ReportFilterDTO();
        // Initial set
        reportFilterDTO.setEmployeeCode("All");
        reportFilterDTO.setPunchCardNo("All");
        reportFilterDTO.setUnit("All");
        reportFilterDTO.setSection("All");
        reportFilterDTO.setFloor("All");
        reportFilterDTO.setLine("All");
        reportFilterDTO.setDepartment("All");
        reportFilterDTO.setDesignation("All");
        reportFilterDTO.setStaffCategory("All");

        if(filterStr !=null) {
            String[] filtersObj = filterStr.split("~");
            for (String filters : filtersObj) {
                String[] filter = filters.split("_");

                if(filter[0].contains("fmd")){
                    reportFilterDTO.setFromDate(filter[1]);
                    continue;
                }
                if(filter[0].contains("tod")){
                    reportFilterDTO.setToDate(filter[1]);
                    continue;
                }
                if(filter[0].contains("emp")){
                    reportFilterDTO.setEmployeeCode(filter[1]);
                    continue;
                }
                if(filter[0].contains("pcn")){
                    reportFilterDTO.setPunchCardNo(filter[1]);
                    continue;
                }
                if(filter[0].contains("un")){
                    reportFilterDTO.setUnit(filter[1]);
                    continue;
                }
                if(filter[0].contains("sec")){
                    reportFilterDTO.setSection(filter[1]);
                    continue;
                }
                if(filter[0].contains("flr")){
                    reportFilterDTO.setFloor(filter[1]);
                    continue;
                }
                if(filter[0].contains("lin")){
                    reportFilterDTO.setLine(filter[1]);
                    continue;
                }
                if(filter[0].contains("dep")){
                    reportFilterDTO.setDepartment(filter[1]);
                    continue;
                }
                if(filter[0].contains("dsg")){
                    reportFilterDTO.setDesignation(filter[1]);
                    continue;
                }
                if(filter[0].contains("stc")){
                    reportFilterDTO.setStaffCategory(filter[1]);
                    continue;
                }
            }
        }
        return reportFilterDTO;
    }
}
