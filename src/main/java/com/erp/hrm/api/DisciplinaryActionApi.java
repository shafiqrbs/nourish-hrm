package com.erp.hrm.api;

import com.erp.hrm.api.dto.DisciplinaryActionDTO;
import com.erp.hrm.service.DisciplinaryActionService;
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
@RequestMapping("/api/v1/disciplinaryAction")
public class DisciplinaryActionApi {
    private DisciplinaryActionService disciplinaryActionService;
    public DisciplinaryActionApi(DisciplinaryActionService disciplinaryActionService){
        this.disciplinaryActionService = disciplinaryActionService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public DisciplinaryActionDTO findOne(Long id){
        return disciplinaryActionService.findOne(id);
    }

    @RequestMapping(value = "/findAllDisciplinaryActionByEmployeeCode", method = RequestMethod.GET)
    public List<DisciplinaryActionDTO> findAllDisciplinaryActionByEmployeeCode(String pEmployeeCode){
        return disciplinaryActionService.findAllDisciplinaryActionByEmployeeCode(pEmployeeCode);
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody DisciplinaryActionDTO disciplinaryActionDTO){
        return disciplinaryActionService.save(disciplinaryActionDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody DisciplinaryActionDTO disciplinaryActionDTO){
        return disciplinaryActionService.update(disciplinaryActionDTO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        disciplinaryActionService.delete(id);
    }
}