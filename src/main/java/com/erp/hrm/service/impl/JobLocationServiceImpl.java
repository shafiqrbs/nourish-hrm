package com.erp.hrm.service.impl;

import com.erp.hrm.domain.JobLocation;
import com.erp.hrm.repository.JobLocationRepository;
import com.erp.hrm.service.JobLocationService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
@Service
public class JobLocationServiceImpl implements JobLocationService {
    private JobLocationRepository jobLocationRepository;
    public JobLocationServiceImpl(JobLocationRepository jobLocationRepository){
        this.jobLocationRepository = jobLocationRepository;
    }

    @Override
    public ActionResult save(JobLocation jobLocation) {
        ActionResult actionResult = new ActionResult();

        try{
            jobLocationRepository.save(jobLocation);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Job location saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(JobLocation jobLocation) {
        ActionResult actionResult = new ActionResult();

        try{
            jobLocationRepository.save(jobLocation);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Job location updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<JobLocation> getAllJobLocation() {
        return jobLocationRepository.findAllJobLocation();
    }

    @Override
    public JobLocation findOne(Long id) {
        return jobLocationRepository.getOne(id);//.findOne(id);
    }

    @Override
    public void delete(Long id) {
        jobLocationRepository.deleteById(id);//.delete(id);
    }
}
