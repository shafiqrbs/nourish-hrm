package com.erp.hrm.service.impl;

import com.erp.hrm.domain.Division;
import com.erp.hrm.repository.DivisionRepository;
import com.erp.hrm.service.DivisionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
@Service
public class DivisionServiceImpl implements DivisionService {
    private DivisionRepository divisionRepository;
    public DivisionServiceImpl(DivisionRepository divisionRepository){
        this.divisionRepository = divisionRepository;
    }

    @Override
    public ActionResult save(Division division) {
        ActionResult actionResult = new ActionResult();

        try{
            divisionRepository.save(division);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Division saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(Division division) {
        ActionResult actionResult = new ActionResult();

        try{
            divisionRepository.save(division);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Division updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<Division> findAllDivision() {
        return divisionRepository.findAllDivision();
    }

    @Override
    public Division findOne(Long id) {
        return divisionRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        divisionRepository.deleteById(id);
    }
}
