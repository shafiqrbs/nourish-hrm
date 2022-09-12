package com.erp.hrm.api;

import com.erp.hrm.domain.JobLocation;
import com.erp.hrm.service.JobLocationService;
import com.erp.hrm.util.ActionResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MY PC on 5/13/2017.
 */
@RestController
@RequestMapping("/api/v1/jobLocations")
public class JobLocationApi {
    private JobLocationService jobLocationService;
    public JobLocationApi(JobLocationService jobLocationService){
        this.jobLocationService = jobLocationService;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public JobLocation findOne(Long id){
        return jobLocationService.findOne(id);
    }

    @RequestMapping(value = "/getAllJobLocation", method = RequestMethod.GET)
    public List<JobLocation> findAllJobLocation(){
        return jobLocationService.getAllJobLocation();
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ActionResult save(@RequestBody JobLocation jobLocation){
        return jobLocationService.save(jobLocation);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ActionResult update(@RequestBody JobLocation jobLocation){
        return jobLocationService.update(jobLocation);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void delete(Long id){
        jobLocationService.delete(id);
    }
}