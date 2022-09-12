package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.TransferDTO;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.domain.Transfer;
import com.erp.hrm.repository.employee.EmployeeInfoRepository;
import com.erp.hrm.repository.employee.TransferRepository;
import com.erp.hrm.service.TransferService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class TransferServiceImpl implements TransferService {
    private TransferRepository transferRepository;
    private EmployeeInfoRepository employeeInfoRepository;
    public TransferServiceImpl(TransferRepository transferRepository,EmployeeInfoRepository employeeInfoRepository){
        this.transferRepository = transferRepository;
        this.employeeInfoRepository = employeeInfoRepository;
    }

    @Override
    public ActionResult save(TransferDTO transferDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(transferDTO.getEmployeeCode());
            Transfer transferObj = new Transfer();
            transferObj.setEmployeeInfo(employeeInfo);
            transferObj.setTransferType(transferDTO.getTransferType());
            transferObj.setTransferLocation(transferDTO.getTransferLocation());
            transferObj.setEffectiveDate(transferDTO.getEffectiveDate());
            transferObj.setApprovedBy(transferDTO.getApprovedBy());
            transferObj.setDateApproved(transferDTO.getDateApproved());
            transferObj.setPreTransferLocation(transferDTO.getPreTransferLocation());
            transferRepository.save(transferObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Transfer saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(TransferDTO transferDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            EmployeeInfo employeeInfo = employeeInfoRepository.getEmployeeInfo(transferDTO.getEmployeeCode());
            Transfer transferObj = new Transfer();
            transferObj.setId(transferDTO.getTransferId());
            transferObj.setEmployeeInfo(employeeInfo);
            transferObj.setTransferType(transferDTO.getTransferType());
            transferObj.setTransferLocation(transferDTO.getTransferLocation());
            transferObj.setEffectiveDate(transferDTO.getEffectiveDate());
            transferObj.setApprovedBy(transferDTO.getApprovedBy());
            transferObj.setDateApproved(transferDTO.getDateApproved());
            transferObj.setPreTransferLocation(transferDTO.getPreTransferLocation());
            transferRepository.save(transferObj);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Transfer updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<TransferDTO> findAllTransferByEmployeeCode(String pEmployeeCode) {
        List<Transfer> transfers = transferRepository.findAllTransferByEmployeeCode(pEmployeeCode);
        List<TransferDTO> transferDTOS = new ArrayList<>();
        for (Transfer transfer:transfers)
        {
            TransferDTO transferDTO = new TransferDTO();
            transferDTO.setTransferId(transfer.getId());
            transferDTO.setEmployeeCode(transfer.getEmployeeInfo().getEmployeeCode());
            transferDTO.setTransferType(transfer.getTransferType());
            transferDTO.setTransferLocation(transfer.getTransferLocation());
            transferDTO.setEffectiveDate(transfer.getEffectiveDate());
            transferDTO.setApprovedBy(transfer.getApprovedBy());
            transferDTO.setDateApproved(transfer.getDateApproved());
            transferDTO.setPreTransferLocation(transfer.getPreTransferLocation());
            transferDTOS.add(transferDTO);
        }
        return transferDTOS;
    }

    @Override
    public TransferDTO findOne(Long id) {
        Transfer transfer = transferRepository.getOne(id);//.findOne(id);
        TransferDTO transferDTO = new TransferDTO();
        transferDTO.setTransferId(transfer.getId());
        transferDTO.setEmployeeCode(transfer.getEmployeeInfo().getEmployeeCode());
        transferDTO.setTransferType(transfer.getTransferType());
        transferDTO.setTransferLocation(transfer.getTransferLocation());
        transferDTO.setEffectiveDate(transfer.getEffectiveDate());
        transferDTO.setApprovedBy(transfer.getApprovedBy());
        transferDTO.setDateApproved(transfer.getDateApproved());
        transferDTO.setPreTransferLocation(transfer.getPreTransferLocation());
        return transferDTO;
    }

    @Override
    public void delete(Long id) {
        transferRepository.deleteById(id);//.delete(id);
    }
}
