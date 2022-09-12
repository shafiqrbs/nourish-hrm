package com.erp.hrm.service.impl;

import com.erp.hrm.domain.Designation;
import com.erp.hrm.repository.DesignationRepository;
import com.erp.hrm.service.DesignationService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class DesignationServiceImpl implements DesignationService {
    private DesignationRepository designationRepository;
    public DesignationServiceImpl(DesignationRepository designationRepository){
        this.designationRepository = designationRepository;
    }

    @Override
    public ActionResult save(Designation designation) {
        ActionResult actionResult = new ActionResult();

        try{
            designationRepository.save(designation);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Designation saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(Designation designation) {
        ActionResult actionResult = new ActionResult();

        try{
            designationRepository.save(designation);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Designation updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<Designation> findAllDesignation() {
        return designationRepository.findAllDesignation();
    }

    @Override
    public Designation findOne(Long id) {
        return designationRepository.getOne(id);
    }

    @Override
    public void delete(Long id) {
        designationRepository.deleteById(id);
    }
}
