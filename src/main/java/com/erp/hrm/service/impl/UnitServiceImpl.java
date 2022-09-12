package com.erp.hrm.service.impl;

import com.erp.hrm.domain.Unit;
import com.erp.hrm.repository.UnitRepository;
import com.erp.hrm.service.UnitService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class UnitServiceImpl implements UnitService {
    private UnitRepository unitRepository;
    public UnitServiceImpl(UnitRepository unitRepository){
        this.unitRepository = unitRepository;
    }

    @Override
    public ActionResult save(Unit unit) {
        ActionResult actionResult = new ActionResult();

        try{
            unitRepository.save(unit);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Unit saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(Unit unit) {
        ActionResult actionResult = new ActionResult();

        try{
            unitRepository.save(unit);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Unit updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<Unit> findAllUnit() {
        return unitRepository.findAllUnit();
    }

    @Override
    public Unit findOne(Long id) {
        return unitRepository.getOne(id);//.findOne(id);
    }

    @Override
    public void delete(Long id) {
        unitRepository.deleteById(id);//.delete(id);
    }
}
