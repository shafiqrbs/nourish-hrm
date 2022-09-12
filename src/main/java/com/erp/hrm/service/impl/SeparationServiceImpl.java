package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.SeparationDTO;
import com.erp.hrm.api.dto.TransferDTO;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.Separation;
import com.erp.hrm.domain.Transfer;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.employee.SeparationRepository;
import com.erp.hrm.repository.employee.TransferRepository;
import com.erp.hrm.service.SeparationService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class SeparationServiceImpl implements SeparationService {
    private SeparationRepository separationRepository;
    private EmployeeInfoRepository employeeInfoRepository;
    public SeparationServiceImpl(SeparationRepository separationRepository, EmployeeInfoRepository employeeInfoRepository){
        this.separationRepository = separationRepository;
        this.employeeInfoRepository = employeeInfoRepository;
    }

    @Override
    public ActionResult save(SeparationDTO separationDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(separationDTO.getEmployeeCode());
            Separation separationObj = new Separation();
            separationObj.setEmployeeInfo(employeeInfo);
            separationObj.setSeparationCause(separationDTO.getSeparationCause());
            separationObj.setNotes(separationDTO.getNotes());
            separationObj.setEffectiveDate(separationDTO.getEffectiveDate());
            separationObj.setApprovedBy(separationDTO.getApprovedBy());
            separationObj.setDateApproved(separationDTO.getDateApproved());
            separationObj.setSepAction(separationDTO.getSepAction());
            separationObj.setEffected(separationDTO.isEffected());
            separationObj.setBlackListed(separationDTO.isBlackListed());
            separationObj.setBlackListCause(separationDTO.getBlackListCause());
            separationObj.setResignSubmissionDate(separationDTO.getResignSubmissionDate());
            separationRepository.save(separationObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Separation saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(SeparationDTO separationDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(separationDTO.getEmployeeCode());
            Separation separationObj = new Separation();
            separationObj.setId(separationDTO.getSeparationId());
            separationObj.setEmployeeInfo(employeeInfo);
            separationObj.setSeparationCause(separationDTO.getSeparationCause());
            separationObj.setNotes(separationDTO.getNotes());
            separationObj.setEffectiveDate(separationDTO.getEffectiveDate());
            separationObj.setApprovedBy(separationDTO.getApprovedBy());
            separationObj.setDateApproved(separationDTO.getDateApproved());
            separationObj.setSepAction(separationDTO.getSepAction());
            separationObj.setEffected(separationDTO.isEffected());
            separationObj.setBlackListed(separationDTO.isBlackListed());
            separationObj.setBlackListCause(separationDTO.getBlackListCause());
            separationObj.setResignSubmissionDate(separationDTO.getResignSubmissionDate());
            separationRepository.save(separationObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Separation updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<SeparationDTO> findAllSeparationByEmployeeCode(String pEmployeeCode) {
        List<Separation> separations = separationRepository.findAllSeparationByEmployeeCode(pEmployeeCode);
        List<SeparationDTO> separationDTOS = new ArrayList<>();
        for (Separation separation:separations)
        {
            SeparationDTO separationDTO = new SeparationDTO();
            separationDTO.setSeparationId(separation.getId());
            separationDTO.setEmployeeCode(separation.getEmployeeInfo().getEmployeeCode());
            separationDTO.setSeparationCause(separation.getSeparationCause());
            separationDTO.setNotes(separation.getNotes());
            separationDTO.setEffectiveDate(separation.getEffectiveDate());
            separationDTO.setApprovedBy(separation.getApprovedBy());
            separationDTO.setDateApproved(separation.getDateApproved());
            separationDTO.setSepAction(separation.getSepAction());
            separationDTO.setEffected(separation.isEffected());
            separationDTO.setBlackListed(separation.isBlackListed());
            separationDTO.setBlackListCause(separation.getBlackListCause());
            separationDTO.setResignSubmissionDate(separation.getResignSubmissionDate());
            separationDTOS.add(separationDTO);
        }
        return separationDTOS;
    }

    @Override
    public SeparationDTO findOne(Long id) {
        Separation separation = separationRepository.getOne(id);//.findOne(id);
        SeparationDTO separationDTO = new SeparationDTO();
        separationDTO.setSeparationId(separation.getId());
        separationDTO.setEmployeeCode(separation.getEmployeeInfo().getEmployeeCode());
        separationDTO.setSeparationCause(separation.getSeparationCause());
        separationDTO.setNotes(separation.getNotes());
        separationDTO.setEffectiveDate(separation.getEffectiveDate());
        separationDTO.setApprovedBy(separation.getApprovedBy());
        separationDTO.setDateApproved(separation.getDateApproved());
        separationDTO.setSepAction(separation.getSepAction());
        separationDTO.setEffected(separation.isEffected());
        separationDTO.setBlackListed(separation.isBlackListed());
        separationDTO.setBlackListCause(separation.getBlackListCause());
        separationDTO.setResignSubmissionDate(separation.getResignSubmissionDate());
        return separationDTO;
    }

    @Override
    public void delete(Long id) {
        separationRepository.deleteById(id);//.delete(id);
    }
}
