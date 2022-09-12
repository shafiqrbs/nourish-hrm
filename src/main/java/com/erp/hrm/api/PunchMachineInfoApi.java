package com.erp.hrm.api;

import com.erp.hrm.domain.PunchMachine;
import com.erp.hrm.service.attendance.PunchMachineService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sohag on 03/11/2018.
 */
@RestController
@RequestMapping("/api/v1/punchMachine")
public class PunchMachineInfoApi {
    private PunchMachineService punchMachineService;
    public PunchMachineInfoApi(PunchMachineService punchMachineService){
        this.punchMachineService = punchMachineService;
    }

    @RequestMapping(value = "/getAllPunchMachineInfo", method = RequestMethod.GET)
    public List<PunchMachine> getAllPunchMachineInfo(){
        return punchMachineService.getAllPunchMachineInfo();
    }
}