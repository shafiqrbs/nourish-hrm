package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.CompanySettingsDTO;
import com.erp.hrm.api.dto.ReportFilterDataDTO;
import com.erp.hrm.api.dto.report.ReportMenuDTO;
import com.erp.hrm.service.report.ReportService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.HashPrintServiceAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.PrintServiceAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.PrinterName;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Sohag on 10/03/2019.
 */
@RestController
@RequestMapping("/api/v1/reports")
public class ReportApi {
    @Autowired
    private ApplicationContext applicationContext;
    private ReportService reportService;
    public ReportApi(ReportService reportService){
        this.reportService = reportService;
    }

    @RequestMapping(value = "/menu/getAll", method = RequestMethod.GET)
    public List<ReportMenuDTO> getAllReports(){
        return reportService.getAllReports();
    }

    @RequestMapping(value = "/generate/pdf", method = RequestMethod.GET)
    public void getPDF(HttpServletResponse response,ReportFilterDataDTO reportFilterDataDTO) throws ParseException,Exception {
        try{
            String reportName = reportService.getReportName(reportFilterDataDTO.getReportId());
            response.setContentType("application/x-pdf");
            String headers = "attachment; filename="+reportName+".pdf";
            response.setHeader("Content-disposition", headers);

            CompanySettingsDTO companyInfo = reportService.getCompanyInfo(reportFilterDataDTO.getReportId());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportService.report(reportFilterDataDTO));
            InputStream inputStream = this.getClass().getResourceAsStream(reportService.getReportTemplateURL(reportFilterDataDTO.getReportId()));
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            //Set parameters
            Map<String,Object> param = new HashMap<>();
            param.put("companyTitle",companyInfo.getCompanyName());
            param.put("companyAddress",companyInfo.getAddress());
            param.put("companyLogoUrl",companyInfo.getCompanyLogo());
            param.put("reportFilterRange",reportService.getReportDateRange(reportFilterDataDTO.getFilters()));

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,param,dataSource);

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));

            SimplePdfReportConfiguration reportConfig=new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);

            SimplePdfExporterConfiguration exportConfig=new SimplePdfExporterConfiguration();
            exportConfig.setMetadataAuthor("baeldung");

            exportConfig.setEncrypted(true);
            exportConfig.setAllowedPermissionsHint("PRINTING");

            exporter.setConfiguration(reportConfig);
            exporter.setConfiguration(exportConfig);

            exporter.exportReport();

        }
        catch (Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/generate/xls", method = RequestMethod.GET)
    public void getXLS(HttpServletResponse response,ReportFilterDataDTO reportFilterDataDTO) throws ParseException,Exception{
        try{
            String reportName = reportService.getReportName(reportFilterDataDTO.getReportId());
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.addHeader("Content-disposition", "attachment; filename="+reportName+".xlsx");

            CompanySettingsDTO companyInfo = reportService.getCompanyInfo(reportFilterDataDTO.getReportId());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportService.report(reportFilterDataDTO));
            InputStream inputStream = this.getClass().getResourceAsStream(reportService.getReportTemplateURL(reportFilterDataDTO.getReportId()));
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            //Set parameters
            Map<String,Object> param = new HashMap<>();
            param.put("companyTitle",companyInfo.getCompanyName());
            param.put("companyAddress",companyInfo.getAddress());
            param.put("companyLogoUrl",companyInfo.getCompanyLogo());
            param.put("reportFilterRange",reportService.getReportDateRange(reportFilterDataDTO.getFilters()));

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,param,dataSource);

            JRXlsxExporter exporter = new JRXlsxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));

            SimpleXlsxReportConfiguration reportConfig
                    = new SimpleXlsxReportConfiguration();
            reportConfig.setSheetNames(new String[] { "Employee Data" });

            exporter.setConfiguration(reportConfig);
            exporter.exportReport();
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/generate/doc", method = RequestMethod.GET)
    public void getDOC(HttpServletResponse response,ReportFilterDataDTO reportFilterDataDTO) throws ParseException,Exception{
        try{
            String reportName = reportService.getReportName(reportFilterDataDTO.getReportId());
            response.setContentType("application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            response.addHeader("Content-disposition", "attachment; filename="+reportName+".docx");

            CompanySettingsDTO companyInfo = reportService.getCompanyInfo(reportFilterDataDTO.getReportId());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportService.report(reportFilterDataDTO));
            InputStream inputStream = this.getClass().getResourceAsStream(reportService.getReportTemplateURL(reportFilterDataDTO.getReportId()));
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            //Set parameters
            Map<String,Object> param = new HashMap<>();
            param.put("companyTitle",companyInfo.getCompanyName());
            param.put("companyAddress",companyInfo.getAddress());
            param.put("companyLogoUrl",companyInfo.getCompanyLogo());
            param.put("reportFilterRange",reportService.getReportDateRange(reportFilterDataDTO.getFilters()));

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,param,dataSource);

            JRDocxExporter exporter = new JRDocxExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));
            exporter.exportReport();
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/print", method = RequestMethod.POST)
    public void printReport(ReportFilterDataDTO reportFilterDataDTO) throws ParseException,Exception {
        try{
            CompanySettingsDTO companyInfo = reportService.getCompanyInfo(reportFilterDataDTO.getReportId());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportService.report(reportFilterDataDTO));
            InputStream inputStream = this.getClass().getResourceAsStream(reportService.getReportTemplateURL(reportFilterDataDTO.getReportId()));
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            //Set parameters
            Map<String,Object> param = new HashMap<>();
            param.put("companyTitle",companyInfo.getCompanyName());
            param.put("companyAddress",companyInfo.getAddress());
            param.put("companyLogoUrl",companyInfo.getCompanyLogo());
            param.put("reportFilterRange",reportService.getReportDateRange(reportFilterDataDTO.getFilters()));

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,param,dataSource);

            PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
            String selectedPrinter = services[3].getName();
            this.printReport(jasperPrint, selectedPrinter);
        }
        catch (Exception ex){
            throw ex;
        }
    }

    @RequestMapping(value = "/generate/preview", method = RequestMethod.GET)
    public void getHTML(HttpServletResponse response,ReportFilterDataDTO reportFilterDataDTO) throws ParseException,Exception {
        try{

            String reportName = reportService.getReportName(reportFilterDataDTO.getReportId());
            response.setContentType("application/pdf");
            response.addHeader("Content-disposition", "attachment; filename="+reportName+".pdf");

            CompanySettingsDTO companyInfo = reportService.getCompanyInfo(reportFilterDataDTO.getReportId());
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(reportService.report(reportFilterDataDTO));
            InputStream inputStream = this.getClass().getResourceAsStream(reportService.getReportTemplateURL(reportFilterDataDTO.getReportId()));
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);

            //Set parameters
            Map<String,Object> param = new HashMap<>();
            param.put("companyTitle",companyInfo.getCompanyName());
            param.put("companyAddress",companyInfo.getAddress());
            param.put("companyLogoUrl",companyInfo.getCompanyLogo());
            param.put("reportFilterRange",reportService.getReportDateRange(reportFilterDataDTO.getFilters()));
            param.put("reportMonth",11);
            param.put("reportYear",2018);

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,param,dataSource);

            JRPdfExporter exporter = new JRPdfExporter();
            exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(response.getOutputStream()));

            SimplePdfReportConfiguration reportConfig=new SimplePdfReportConfiguration();
            reportConfig.setSizePageToContent(true);
            reportConfig.setForceLineBreakPolicy(false);

            SimplePdfExporterConfiguration exportConfig=new SimplePdfExporterConfiguration();
            exportConfig.setMetadataAuthor("SA");

            exportConfig.setEncrypted(true);

            exportConfig.setAllowedPermissionsHint("PRINTING");

            exporter.setConfiguration(reportConfig);
            exporter.setConfiguration(exportConfig);
            exporter.exportReport();
        }
        catch (Exception ex){
            ex.printStackTrace();
            throw ex;
        }
    }

    private void printReport(JasperPrint jasperPrint, String selectedPrinter) throws JRException {
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        printRequestAttributeSet.add(MediaSizeName.ISO_A4);
        if (jasperPrint.getOrientationValue() == net.sf.jasperreports.engine.type.OrientationEnum.LANDSCAPE) {
            printRequestAttributeSet.add(OrientationRequested.LANDSCAPE);
        } else {
            printRequestAttributeSet.add(OrientationRequested.PORTRAIT);
        }
        PrintServiceAttributeSet printServiceAttributeSet = new HashPrintServiceAttributeSet();
        printServiceAttributeSet.add(new PrinterName(selectedPrinter, null));

        JRPrintServiceExporter exporter = new JRPrintServiceExporter();
        SimplePrintServiceExporterConfiguration configuration = new SimplePrintServiceExporterConfiguration();
        configuration.setPrintRequestAttributeSet(printRequestAttributeSet);
        configuration.setPrintServiceAttributeSet(printServiceAttributeSet);
        configuration.setDisplayPageDialog(false);
        configuration.setDisplayPrintDialog(false);

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setConfiguration(configuration);

        PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);
        PrintService selectedService = null;
        if (services.length != 0 || services != null) {
            for (PrintService service : services) {
                String existingPrinter = service.getName();
                if (existingPrinter.equals(selectedPrinter)) {
                    selectedService = service;
                    break;
                }
            }
        }

        if (selectedService != null) {
            exporter.exportReport();
        } else {
            System.out.println("You did not set the printer!");
        }
    }
}