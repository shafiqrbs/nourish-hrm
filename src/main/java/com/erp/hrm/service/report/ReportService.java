package com.erp.hrm.service.report;

import com.erp.hrm.api.dto.Configuration.CompanySettingsDTO;
import com.erp.hrm.api.dto.ReportFilterDTO;
import com.erp.hrm.api.dto.ReportFilterDataDTO;
import com.erp.hrm.api.dto.report.ReportMenuDTO;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ReportService {
    String getReportTemplateURL(long pReportId);
    String getReportName(long pReportId);
    String getReportDateRange(String filtersStr) throws ParseException;
    CompanySettingsDTO getCompanyInfo(long pReportId);
    List<Map<String,Object>> report(ReportFilterDataDTO reportFilterDataDTO) throws ParseException;
    List<ReportMenuDTO> getAllReports();
}
