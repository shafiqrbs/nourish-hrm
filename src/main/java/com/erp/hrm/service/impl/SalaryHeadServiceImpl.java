package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.HeadTypeDTO;
import com.erp.hrm.domain.HeadType;
import com.erp.hrm.domain.SalaryHead;
import com.erp.hrm.repository.payment.SalaryHeadRepository;
import com.erp.hrm.service.SalaryHeadService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
@Service
public class SalaryHeadServiceImpl implements SalaryHeadService {
    private SalaryHeadRepository salaryHeadRepository;
    public SalaryHeadServiceImpl(SalaryHeadRepository salaryHeadRepository){
        this.salaryHeadRepository = salaryHeadRepository;
    }

    @Override
    public ActionResult save(SalaryHead salaryHead) {
        ActionResult actionResult = new ActionResult();
        try{
            if(salaryHeadRepository.getSalaryHeadCountByHeadCode(salaryHead.getSalaryHeadID()) == 0) {
                int sequenceNo = 0;
                try {
                    sequenceNo = salaryHeadRepository.getLastSequenceNo();
                }catch (Exception e){
                    sequenceNo = 0;
                }

                sequenceNo = sequenceNo + 1;
                salaryHead.setSequenceNo(sequenceNo);
                salaryHead.setIsVisible(true);
                salaryHeadRepository.save(salaryHead);
                //Set custom message if success
                actionResult.setIsSuccess(true);
                actionResult.setSuccessMessage("Salary Head saved successfully");
            }
            else {
                actionResult.setIsSuccess(false);
                actionResult.setSuccessMessage("Salary Head Code exist");
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
    public ActionResult update(SalaryHead salaryHead) {
        ActionResult actionResult = new ActionResult();
        try{
            if(salaryHeadRepository.getSalaryHeadCountByHeadCodeAndId(salaryHead.getId(),salaryHead.getSalaryHeadID()) == 0)
            {
                salaryHead.setIsVisible(true);
                salaryHeadRepository.save(salaryHead);
                //Set custom message if success
                actionResult.setIsSuccess(true);
                actionResult.setSuccessMessage("Salary Head updated successfully");
            }
            else
            {
                actionResult.setIsSuccess(false);
                actionResult.setSuccessMessage("Salary Head Code exist");
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
    public List<SalaryHead> getAllSalaryHead() {
        return salaryHeadRepository.getAllSalaryHead();
    }

    @Override
    public List<HeadType> getAllHeadType() {
        return salaryHeadRepository.getAllHeadType();
    }

    @Override
    public SalaryHead findOne(Long id) {
        return salaryHeadRepository.getOne(id);//.findOne(id);
    }

    @Override
    public void delete(Long id) {
        salaryHeadRepository.deleteById(id);//.delete(id);
    }
}
