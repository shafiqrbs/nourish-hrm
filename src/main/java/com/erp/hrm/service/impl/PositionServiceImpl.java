package com.erp.hrm.service.impl;

import com.erp.hrm.domain.Division;
import com.erp.hrm.domain.Position;
import com.erp.hrm.repository.DivisionRepository;
import com.erp.hrm.repository.PositionRepository;
import com.erp.hrm.service.DivisionService;
import com.erp.hrm.service.PositionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
@Service
public class PositionServiceImpl implements PositionService {
    private PositionRepository positionRepository;
    public PositionServiceImpl(PositionRepository positionRepository){
        this.positionRepository = positionRepository;
    }

    @Override
    public ActionResult save(Position position) {
        ActionResult actionResult = new ActionResult();

        try{
            positionRepository.save(position);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Position saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(Position position) {
        ActionResult actionResult = new ActionResult();

        try{
            positionRepository.save(position);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Position updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<Position> findAllPosition() {
        return positionRepository.findAllPosition();
    }

    @Override
    public Position findOne(Long id) {
        return positionRepository.getOne(id);//.findOne(id);
    }

    @Override
    public void delete(Long id) {
        positionRepository.deleteById(id);//.delete(id);
    }
}
