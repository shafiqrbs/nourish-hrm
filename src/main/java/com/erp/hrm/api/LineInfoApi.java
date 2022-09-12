package com.erp.hrm.api;

import com.erp.hrm.domain.LineInfo;
import com.erp.hrm.service.LineInfoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@RestController
@RequestMapping("/api/v1/lineInfos")
public class LineInfoApi {
    private LineInfoService lineInfoService;
    public LineInfoApi(LineInfoService lineInfoService){
        this.lineInfoService = lineInfoService;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public LineInfo findOne(Long id){
        return lineInfoService.findOne(id);
    }

    @RequestMapping(value = "/findAllLineInfo", method = RequestMethod.GET)
    public List<LineInfo> findAllLineInfo(){
        return lineInfoService.findAllLineInfo();
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<LineInfo> findAll(){
        return lineInfoService.findAll();
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public LineInfo save(@RequestBody LineInfo lineInfo){
        return lineInfoService.save(lineInfo);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public LineInfo update(@RequestBody LineInfo lineInfo){
        return lineInfoService.update(lineInfo);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(Long id){
        lineInfoService.delete(id);
    }
}