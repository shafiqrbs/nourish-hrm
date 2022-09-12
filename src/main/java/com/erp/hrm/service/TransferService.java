package com.erp.hrm.service;

import com.erp.hrm.api.dto.TransferDTO;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
public interface TransferService {
    ActionResult save(TransferDTO transferDTO);

    ActionResult update(TransferDTO transferDTO);

    List<TransferDTO> findAllTransferByEmployeeCode(String pEmployeeCode);

    TransferDTO findOne(Long id);

    void delete(Long id);
}
