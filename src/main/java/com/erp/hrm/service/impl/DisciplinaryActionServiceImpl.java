package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.DisciplinaryActionDTO;
import com.erp.hrm.api.dto.SkillDTO;
import com.erp.hrm.domain.DisciplinaryAction;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.Skills;
import com.erp.hrm.repository.employee.DisciplinaryActionRepository;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.service.DisciplinaryActionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class DisciplinaryActionServiceImpl implements DisciplinaryActionService {
    private DisciplinaryActionRepository disciplinaryActionRepository;
    private EmployeeInfoRepository employeeInfoRepository;
    public DisciplinaryActionServiceImpl(DisciplinaryActionRepository disciplinaryActionRepository,EmployeeInfoRepository employeeInfoRepository){
        this.disciplinaryActionRepository = disciplinaryActionRepository;
        this.employeeInfoRepository = employeeInfoRepository;
    }

    @Override
    public ActionResult save(DisciplinaryActionDTO disciplinaryActionDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(disciplinaryActionDTO.getEmployeeCode());
            DisciplinaryAction disciplinaryActionObj = new DisciplinaryAction();
            disciplinaryActionObj.setEmployeeInfo(employeeInfo);
            disciplinaryActionObj.setDisciplinaryActionType(disciplinaryActionDTO.getDisciplinaryActionType());
            disciplinaryActionObj.setDescription(disciplinaryActionDTO.getDescription());
            disciplinaryActionObj.setEffectiveDate(disciplinaryActionDTO.getEffectiveDate());
            disciplinaryActionObj.setDisAction(disciplinaryActionDTO.getDisAction());
            disciplinaryActionObj.setEffected(disciplinaryActionDTO.isEffected());
            disciplinaryActionObj.setActivationDate(disciplinaryActionDTO.getActivationDate());
            disciplinaryActionObj.setApprovedBy(disciplinaryActionDTO.getApprovedBy());
            disciplinaryActionObj.setDateApproved(disciplinaryActionDTO.getDateApproved());
            disciplinaryActionRepository.save(disciplinaryActionObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("DisciplinaryAction saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(DisciplinaryActionDTO disciplinaryActionDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(disciplinaryActionDTO.getEmployeeCode());
            DisciplinaryAction disciplinaryActionObj = new DisciplinaryAction();
            disciplinaryActionObj.setEmployeeInfo(employeeInfo);
            disciplinaryActionObj.setId(disciplinaryActionDTO.getDisciplinaryActionId());
            disciplinaryActionObj.setDisciplinaryActionType(disciplinaryActionDTO.getDisciplinaryActionType());
            disciplinaryActionObj.setDescription(disciplinaryActionDTO.getDescription());
            disciplinaryActionObj.setEffectiveDate(disciplinaryActionDTO.getEffectiveDate());
            disciplinaryActionObj.setDisAction(disciplinaryActionDTO.getDisAction());
            disciplinaryActionObj.setEffected(disciplinaryActionDTO.isEffected());
            disciplinaryActionObj.setActivationDate(disciplinaryActionDTO.getActivationDate());
            disciplinaryActionObj.setApprovedBy(disciplinaryActionDTO.getApprovedBy());
            disciplinaryActionObj.setDateApproved(disciplinaryActionDTO.getDateApproved());
            disciplinaryActionRepository.save(disciplinaryActionObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("DisciplinaryAction updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<DisciplinaryActionDTO> findAllDisciplinaryActionByEmployeeCode(String pEmployeeCode) {
        List<DisciplinaryAction> disciplinaryActions = disciplinaryActionRepository.findAllDisciplinaryActionByEmployeeCode(pEmployeeCode);
        List<DisciplinaryActionDTO> disciplinaryActionDTOS = new ArrayList<>();
        for (DisciplinaryAction disciplinaryAction:disciplinaryActions)
        {
            DisciplinaryActionDTO disciplinaryActionDTO = new DisciplinaryActionDTO();
            disciplinaryActionDTO.setDisciplinaryActionId(disciplinaryAction.getId());
            disciplinaryActionDTO.setEmployeeCode(disciplinaryAction.getEmployeeInfo().getEmployeeCode());
            disciplinaryActionDTO.setDisciplinaryActionType(disciplinaryAction.getDisciplinaryActionType());
            disciplinaryActionDTO.setDescription(disciplinaryAction.getDescription());
            disciplinaryActionDTO.setEffectiveDate(disciplinaryAction.getEffectiveDate());
            disciplinaryActionDTO.setDisAction(disciplinaryAction.getDisAction());
            disciplinaryActionDTO.setEffected(disciplinaryAction.isEffected());
            disciplinaryActionDTO.setActivationDate(disciplinaryAction.getActivationDate());
            disciplinaryActionDTO.setApprovedBy(disciplinaryAction.getApprovedBy());
            disciplinaryActionDTO.setDateApproved(disciplinaryAction.getDateApproved());
            disciplinaryActionDTOS.add(disciplinaryActionDTO);
        }
        return disciplinaryActionDTOS;
    }

    @Override
    public DisciplinaryActionDTO findOne(Long id) {
        DisciplinaryAction disciplinaryAction = disciplinaryActionRepository.getOne(id);
        DisciplinaryActionDTO disciplinaryActionDTO = new DisciplinaryActionDTO();
        disciplinaryActionDTO.setDisciplinaryActionId(disciplinaryAction.getId());
        disciplinaryActionDTO.setEmployeeCode(disciplinaryAction.getEmployeeInfo().getEmployeeCode());
        disciplinaryActionDTO.setDisciplinaryActionType(disciplinaryAction.getDisciplinaryActionType());
        disciplinaryActionDTO.setDescription(disciplinaryAction.getDescription());
        disciplinaryActionDTO.setEffectiveDate(disciplinaryAction.getEffectiveDate());
        disciplinaryActionDTO.setDisAction(disciplinaryAction.getDisAction());
        disciplinaryActionDTO.setEffected(disciplinaryAction.isEffected());
        disciplinaryActionDTO.setActivationDate(disciplinaryAction.getActivationDate());
        disciplinaryActionDTO.setApprovedBy(disciplinaryAction.getApprovedBy());
        disciplinaryActionDTO.setDateApproved(disciplinaryAction.getDateApproved());
        return disciplinaryActionDTO;
    }

    @Override
    public void delete(Long id) {
        disciplinaryActionRepository.deleteById(id);
    }
}
