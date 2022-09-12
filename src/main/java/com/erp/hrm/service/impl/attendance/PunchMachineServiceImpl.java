package com.erp.hrm.service.impl.attendance;

import com.erp.hrm.domain.PunchMachine;
import com.erp.hrm.repository.attendance.PunchMachineRepository;
import com.erp.hrm.service.attendance.PunchMachineService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sohag on 03/11/2018.
 */
@Service
public class PunchMachineServiceImpl implements PunchMachineService {
    private PunchMachineRepository punchMachineRepository;
    public PunchMachineServiceImpl(PunchMachineRepository punchMachineRepository){
        this.punchMachineRepository = punchMachineRepository;
    }

    @Override
    public List<PunchMachine> getAllPunchMachineInfo() {
        return punchMachineRepository.findAll();
    }
}
