package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.EmployeeGrossSalaryDTO;
import com.erp.hrm.api.dto.EmployeeSalaryDTO;
import com.erp.hrm.api.dto.EmployeeSalaryInfoDTO;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.EmployeeSalary;
import com.erp.hrm.domain.SalaryRule;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.payment.EmployeeSalaryInfoRepository;
import com.erp.hrm.repository.payment.SalaryRuleRepository;
import com.erp.hrm.service.EmployeeSalaryInfoService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * Created by Sohag on 4/10/2018.
 */
@Service
public class EmployeeSalaryInfoServiceImpl implements EmployeeSalaryInfoService {
    private EmployeeSalaryInfoRepository employeeSalaryInfoRepository;
    private SalaryRuleRepository salaryRuleRepository;
    private EmployeeInfoRepository employeeInfoRepository;
    public EmployeeSalaryInfoServiceImpl(EmployeeSalaryInfoRepository employeeSalaryInfoRepository,
                                         SalaryRuleRepository salaryRuleRepository,
                                         EmployeeInfoRepository employeeInfoRepository)
    {
        this.employeeSalaryInfoRepository = employeeSalaryInfoRepository;
        this.salaryRuleRepository = salaryRuleRepository;
        this.employeeInfoRepository = employeeInfoRepository;
    }

    @Override
    public ActionResult save(EmployeeSalaryInfoDTO dto) {
        ActionResult actionResult = new ActionResult();
        try{
            float totalLMC = 0, basic = 0, grossSalary=0;
            try {
                grossSalary = employeeSalaryInfoRepository.getEmployeeGrossSalary(dto.getEmployeeCode());
            }
            catch (Exception e){grossSalary=0;}

            if(dto.getEmployeeGrossSalary() != grossSalary) {
                int itemCount = employeeSalaryInfoRepository.getEmployeeSalaryCount(dto.getSalaryRuleCode(), dto.getEmployeeCode());
                if (itemCount > 0) {
                    employeeSalaryInfoRepository.deleteEmployeeSalary(dto.getEmployeeCode());
                }

                String salaryHead = "";
                List<Object[]> salaryRuleObj = salaryRuleRepository.getAllSalaryRuleWithGrossByRuleCode(dto.getSalaryRuleCode());
                for (Object[] ruleObj : salaryRuleObj) {
                    salaryHead = (String) ruleObj[1];
                    if (salaryHead.contains("LUNCH BILL") || salaryHead.contains("MEDICAL") || salaryHead.contains("CONVEYANCE"))
                        totalLMC += (float) ruleObj[4];
                }

                List<EmployeeSalary> salaries = new ArrayList<>();

                EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(dto.getEmployeeCode());

                for (Object[] empSalaryInfo : salaryRuleObj) {
                    EmployeeSalary employeeSalary = new EmployeeSalary();
                    employeeSalary.setEmployeeInfo(employeeInfo);

                    SalaryRule salaryRule = salaryRuleRepository.getSalaryRuleByRuleAndSalaryHead(dto.getSalaryRuleCode(), (String) empSalaryInfo[1]);
                    employeeSalary.setSalaryRule(salaryRule);
                    employeeSalary.setSalaryHeadID((String) empSalaryInfo[1]);
                    if (((String) empSalaryInfo[2]).contains("%"))
                        employeeSalary.setFixed(false);
                    else
                        employeeSalary.setFixed(true);

                    salaryHead = (String) empSalaryInfo[1];
                    if (salaryHead.contains("BASIC")) {
                        basic = Math.round((float) ((dto.getEmployeeGrossSalary() - totalLMC) / 1.4));
                        employeeSalary.setAmount(basic);
                    } else if (salaryHead.contains("GROSS")) {
                        employeeSalary.setAmount(dto.getEmployeeGrossSalary());
                    } else {
                        if (((String) empSalaryInfo[2]).contains("F"))
                            employeeSalary.setAmount((float) empSalaryInfo[4]);
                        else if (((String) empSalaryInfo[2]).contains("%")) {
                            if (empSalaryInfo[4] == null)
                                employeeSalary.setAmount(0);
                            else
                                employeeSalary.setAmount(Math.round((float) (basic * (float) empSalaryInfo[4] * 0.01)));
                        } else
                            employeeSalary.setAmount(0);
                    }

                    Date date = new Date();
                    employeeSalary.setDateAdded(date);

                    salaries.add(employeeSalary);
                }

                EmployeeSalary employeeSalary = new EmployeeSalary();


                //Insert into EmployeeSalary
//                employeeSalaryInfoRepository.save(salaries);
                employeeSalaryInfoRepository.saveAll(salaries);
            }

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
    public List<EmployeeSalaryDTO> getAllEmployeeSalaryInfo(String pEmployeeCode, String pSalaryRuleCode, int pCalculate, float pGrossSalary) {
        List<EmployeeSalaryDTO> list = new ArrayList<>();
        if(pCalculate == 1){
            float totalLMC = 0, basic = 0;

            String salaryHead = "";
            List<Object[]> salaryRuleObj = salaryRuleRepository.getAllSalaryRuleExceptGrossByRuleCode(pSalaryRuleCode);
            for(Object[] ruleObj:salaryRuleObj){
                salaryHead = (String) ruleObj[1];
                if(salaryHead.contains("LUNCH BILL") || salaryHead.contains("MEDICAL") || salaryHead.contains("CONVEYANCE"))
                    totalLMC += (float) ruleObj[4];
            }

            for(Object[] empSalaryInfo:salaryRuleObj){
                EmployeeSalaryDTO employeeSalaryDTO = new EmployeeSalaryDTO();

                employeeSalaryDTO.setSalaryRuleCode((String) empSalaryInfo[0]);
                employeeSalaryDTO.setSalaryHeadID((String) empSalaryInfo[1]);
                employeeSalaryDTO.setsCriteria((String) empSalaryInfo[2]);

                if(empSalaryInfo[4] == null)
                    employeeSalaryDTO.setAmount(0);
                else
                    employeeSalaryDTO.setAmount((float) empSalaryInfo[4]);

                salaryHead = (String) empSalaryInfo[1];
                if(salaryHead.contains("BASIC")){
                    basic = (float) ((pGrossSalary - totalLMC) / 1.4);
                    employeeSalaryDTO.setNetAmount(basic);
                }
                else {
                    if(((String) empSalaryInfo[2]).contains("F"))
                        employeeSalaryDTO.setNetAmount((float) empSalaryInfo[4]);
                    else if(((String) empSalaryInfo[2]).contains("%")) {
                        if(empSalaryInfo[4] == null)
                            employeeSalaryDTO.setNetAmount(0);
                        else
                            employeeSalaryDTO.setNetAmount((float) (basic * (float) empSalaryInfo[4] * 0.01));
                    }
                    else
                        employeeSalaryDTO.setNetAmount(0);
                }

                list.add(employeeSalaryDTO);
            }
        }
        else {
            List<Object[]> employeeSalaries = employeeSalaryInfoRepository.getAllEmployeeSalaryInfo(pSalaryRuleCode,pEmployeeCode);

            for (Object[] empSalaryInfo : employeeSalaries)
            {
                EmployeeSalaryDTO employeeSalaryDTO = new EmployeeSalaryDTO();
                employeeSalaryDTO.setSalaryRuleCode((String) empSalaryInfo[0]);
                employeeSalaryDTO.setSalaryHeadID((String) empSalaryInfo[1]);
                employeeSalaryDTO.setsCriteria((String) empSalaryInfo[2]);

                if(empSalaryInfo[3] == null)
                    employeeSalaryDTO.setAmount(0);
                else
                    employeeSalaryDTO.setAmount((float) empSalaryInfo[3]);

                if(empSalaryInfo[3] == null)
                    employeeSalaryDTO.setNetAmount(0);
                else
                    employeeSalaryDTO.setNetAmount((float) empSalaryInfo[4]);

                list.add(employeeSalaryDTO);
            }
        }
        return list;
    }

    @Override
    public EmployeeGrossSalaryDTO getEmployeeGrossSalary(String pSalaryRuleCode, String pEmployeeCode) {
        EmployeeGrossSalaryDTO employeeGrossSalaryDTO = new EmployeeGrossSalaryDTO();
        try{
           float grossSalary = employeeSalaryInfoRepository.getEmployeeGrossSalary(pEmployeeCode);
           employeeGrossSalaryDTO.setGrossSalary(grossSalary);
           if(grossSalary > 0)
               employeeGrossSalaryDTO.setSalaryGenerateDisabled(true);
           else
               employeeGrossSalaryDTO.setSalaryGenerateDisabled(false);
        }
        catch (Exception e){
            employeeGrossSalaryDTO.setGrossSalary(0);
            employeeGrossSalaryDTO.setSalaryGenerateDisabled(false);
        }

        String salaryRuleCode = employeeSalaryInfoRepository.getEmployeeSalaryRuleCode(pEmployeeCode);
        employeeGrossSalaryDTO.setSalaryRuleCode(salaryRuleCode);

        return employeeGrossSalaryDTO;
    }
}
