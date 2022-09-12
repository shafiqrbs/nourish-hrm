package com.erp.hrm.api;

import com.erp.hrm.api.dto.Configuration.LineDTO;
import com.erp.hrm.domain.Line;
import com.erp.hrm.service.LineService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@RestController
@RequestMapping("/api/v1/line")
public class LineApi {
    private LineService lineService;
    public LineApi(LineService lineService){
        this.lineService = lineService;
    }

    @RequestMapping(value = "/findOneLine", method = RequestMethod.GET)
    public LineDTO findOne(Integer id){
        return lineService.findOne(id);
    }

    @RequestMapping(value = "/findAllLine", method = RequestMethod.GET)
    public List<LineDTO> findAllLine(){
        return lineService.findAllLine();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody LineDTO lineDTO){
        return lineService.save(lineDTO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody LineDTO lineDTO){
        return lineService.update(lineDTO);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Integer id){
        lineService.delete(id);
    }
}