package com.erp.hrm.api;

import com.erp.hrm.api.dto.ReportFilterDTO;
import com.erp.hrm.api.dto.ReportFilterDataDTO;
import com.erp.hrm.service.report.ProductsService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.view.jasperreports.JasperReportsCsvView;
//import org.springframework.web.servlet.view.jasperreports.JasperReportsHtmlView;
//import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Navid on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/products")
public class ProductApi {
    @Autowired
    private ApplicationContext applicationContext;
    private ProductsService productsService;
    public ProductApi(ProductsService productsService){
        this.productsService = productsService;
    }

//    @RequestMapping(value = "/report1", method = RequestMethod.GET)
//    public ModelAndView report1(){
//        try{
//            JasperReportsPdfView view = new JasperReportsPdfView();
//            view.setUrl("classpath:/reports/report1.jrxml");
//            view.setApplicationContext(applicationContext);
//            Map<String,Object> param = new HashMap<>();
//            param.put("datasource",productsService.report());
//            return new ModelAndView(view,param);
//        }
//        catch (Exception ex){
//            throw ex;
//        }
//    }

//    @RequestMapping(value = "/report2", method = RequestMethod.GET)
//    public ModelAndView report2(ReportFilterDataDTO reportFilterDataDTO){
//        try{
//            JasperReportsPdfView view = new JasperReportsPdfView();
//            view.setUrl("classpath:/reports/report2.jrxml");
//            view.setApplicationContext(applicationContext);
//            Map<String,Object> param = new HashMap<>();
//            param.put("datasource",productsService.report());
//            return new ModelAndView(view,param);
//        }
//        catch (Exception ex){
//            throw ex;
//        }
//    }

    @RequestMapping(value = "/report3", method = RequestMethod.GET)
    public void report3(HttpServletResponse response) throws Exception{
        try{
            response.setContentType("text/html");
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(productsService.report());
            InputStream inputStream = this.getClass().getResourceAsStream("/reports/report2.jrxml");
            JasperReport jasperReport = JasperCompileManager.compileReport(inputStream);
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,null,dataSource);
            HtmlExporter htmlExporter = new HtmlExporter(DefaultJasperReportsContext.getInstance());
            htmlExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
            htmlExporter.setExporterOutput(new SimpleHtmlExporterOutput(response.getWriter()));
            htmlExporter.exportReport();
        }
        catch (Exception ex){
            throw ex;
        }
    }
}