package com.erp.hrm.repository.reports;

import com.erp.hrm.domain.AllReports;
import com.erp.hrm.domain.CompanySettings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by Sohag on 10/03/2019.
 */
public interface AllReportRepository extends JpaRepository<AllReports, Long>{
    @Query("SELECT AR.reportName FROM AllReports AR WHERE AR.id=?1")
    String getReportNameByReportId(long pReportId);

    @Query("SELECT AR.templateName FROM AllReports AR WHERE AR.id=?1")
    String getReportTemplateByReportId(long pReportId);

    @Query("SELECT AR FROM AllReports AR WHERE AR.id=?1")
    AllReports getReportInfoByReportId(long pReportId);

    @Query("SELECT DISTINCT AR.subModuleName,AR.menuIcon FROM AllReports AR")
    List<Object[]> getAllSubModules();

    @Query("SELECT AR FROM AllReports AR WHERE AR.subModuleName=?1")
    List<AllReports> getAllReportSubModuleItems(String pSubModule);

    @Query("SELECT CS FROM CompanySettings CS " +
            "INNER JOIN AllReports AR ON CS.id = AR.companyId " +
            "WHERE AR.id=?1")
    CompanySettings getCompanyInfo(long pReportId);
}
