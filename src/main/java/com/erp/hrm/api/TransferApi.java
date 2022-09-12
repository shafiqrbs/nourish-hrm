package com.erp.hrm.api;

import com.erp.hrm.api.dto.TransferDTO;
import com.erp.hrm.service.TransferService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/transfer")
public class TransferApi {
    private TransferService transferService;
    public TransferApi(TransferService transferService){
        this.transferService = transferService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public TransferDTO findOne(Long id){
        return transferService.findOne(id);
    }

    @RequestMapping(value = "/findAllTransferByEmployeeCode", method = RequestMethod.GET)
    public List<TransferDTO> findAllTransferByEmployeeCode(String pEmployeeCode){
        return transferService.findAllTransferByEmployeeCode(pEmployeeCode);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody TransferDTO transferDTO){
        return transferService.save(transferDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody TransferDTO transferDTO){
        return transferService.update(transferDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        transferService.delete(id);
    }
}