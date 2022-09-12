package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.SalaryRuleCodeDTO;
import com.erp.hrm.api.dto.SalaryRuleDTO;
import com.erp.hrm.domain.SalaryRule;
import com.erp.hrm.repository.payment.SalaryRuleRepository;
import com.erp.hrm.service.SalaryRuleService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
@Service
public class SalaryRuleServiceImpl implements SalaryRuleService {
    private SalaryRuleRepository salaryRuleRepository;
    public SalaryRuleServiceImpl(SalaryRuleRepository salaryRuleRepository){
        this.salaryRuleRepository = salaryRuleRepository;
    }

    @Override
    public ActionResult save(SalaryRule salaryRule) {
        ActionResult actionResult = new ActionResult();
        try{
            if(salaryRuleRepository.getSalaryHeadCount(salaryRule.getSalaryRuleCode(),salaryRule.getSalaryHeadID()) == 0) {
                int sequenceNo = 0;
                try {
                    sequenceNo = salaryRuleRepository.getLastSequenceNo();
                } catch (Exception e) {
                    sequenceNo = 0;
                }

                sequenceNo = sequenceNo + 1;
                salaryRule.setSequenceNo(sequenceNo);

                if(salaryRule.getsCriteria() == "F"){
                    salaryRule.setFixed(true);
                }else {
                    salaryRule.setFixed(false);
                }

                salaryRuleRepository.save(salaryRule);
                //Set custom message if success
                actionResult.setIsSuccess(true);
                actionResult.setSuccessMessage("Salary rule saved successfully");
            }
            else {
                //Set custom message if success
                actionResult.setIsSuccess(false);
                actionResult.setErrorMessage("Salary Head already exists");
            }
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(SalaryRule salaryRule) {
        ActionResult actionResult = new ActionResult();
        try{
//            SalaryRule salaryRuleObj = salaryRuleRepository.findOne(salaryRule.getId());
        	SalaryRule salaryRuleObj = salaryRuleRepository.getOne(salaryRule.getId());
            salaryRuleObj.setParentHeadValue(salaryRule.getParentHeadValue());

            if(salaryRule.getsCriteria() == "F"){
                salaryRuleObj.setFixed(true);
            }else {
                salaryRuleObj.setFixed(false);
                salaryRuleObj.setParentHeadID(salaryRule.getParentHeadID());
            }

            salaryRuleRepository.save(salaryRuleObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Salary rule updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<SalaryRuleDTO> getAllSalaryRuleByRuleCode(String pSalaryRuleCode) {
        List<Object[]> salaryRulesObj = salaryRuleRepository.getAllSalaryRuleByRuleCode(pSalaryRuleCode);
        List<SalaryRuleDTO> salaryRuleDTOS = new ArrayList<>();
        for (Object[] salaryRule:salaryRulesObj)
        {
            SalaryRuleDTO salaryRuleDTO = new SalaryRuleDTO();
            salaryRuleDTO.setId((long) salaryRule[0]);
            salaryRuleDTO.setSalaryRuleCode((String) salaryRule[1]);
            salaryRuleDTO.setSalaryHeadID((String) salaryRule[2]);
            salaryRuleDTO.setsCriteria((String) salaryRule[3]);
            salaryRuleDTO.setParentHeadID((String) salaryRule[4]);
            salaryRuleDTO.setParentHeadValue((float) salaryRule[5]);
            salaryRuleDTO.setFixed((boolean) salaryRule[6]);
            salaryRuleDTO.setHigher((boolean) salaryRule[7]);
            salaryRuleDTO.setFormula1((String) salaryRule[8]);
            salaryRuleDTO.setFormula2((String) salaryRule[9]);
            salaryRuleDTO.setSequenceNo((int) salaryRule[10]);
            salaryRuleDTOS.add(salaryRuleDTO);
        }
        return salaryRuleDTOS;
    }

    @Override
    public List<SalaryRuleCodeDTO> getAllSalaryRuleCode() {
        List<String> salaryAllRuleCode = salaryRuleRepository.getAllSalaryRuleCode();
        List<SalaryRuleCodeDTO> salaryRuleCodeDTOS = new ArrayList<>();
        for (int i=0; i<salaryAllRuleCode.size(); i++){
            SalaryRuleCodeDTO salaryRuleCodeDTO = new SalaryRuleCodeDTO();
            salaryRuleCodeDTO.setSalaryRuleCode(salaryAllRuleCode.get(i));
            salaryRuleCodeDTOS.add(salaryRuleCodeDTO);
        }

        return salaryRuleCodeDTOS;
    }

    @Override
    public SalaryRuleDTO findOne(Long id) {
        List<Object[]> salaryRulesObj = salaryRuleRepository.getSalaryRuleById(id);
        SalaryRuleDTO salaryRuleDTO = new SalaryRuleDTO();
        for (Object[] salaryRule:salaryRulesObj)
        {
            salaryRuleDTO.setId((long) salaryRule[0]);
            salaryRuleDTO.setSalaryRuleCode((String) salaryRule[1]);
            salaryRuleDTO.setSalaryHeadID((String) salaryRule[2]);
            salaryRuleDTO.setsCriteria((String) salaryRule[3]);
            salaryRuleDTO.setParentHeadID((String) salaryRule[4]);
            salaryRuleDTO.setParentHeadValue((float) salaryRule[5]);
            salaryRuleDTO.setFixed((boolean) salaryRule[6]);
            salaryRuleDTO.setHigher((boolean) salaryRule[7]);
            salaryRuleDTO.setFormula1((String) salaryRule[8]);
            salaryRuleDTO.setFormula2((String) salaryRule[9]);
            salaryRuleDTO.setSequenceNo((int) salaryRule[10]);
        }
        return salaryRuleDTO;
    }

    @Override
    public void delete(Long id) {
        salaryRuleRepository.deleteById(id);//.delete(id);
    }
}
