package com.erp.hrm.service;

import com.erp.hrm.domain.JobLocation;
import com.erp.hrm.util.ActionResult;

import java.util.List;

/**
 * Created by Sohag on 4/10/2018.
 */
public interface JobLocationService {
    ActionResult save(JobLocation jobLocation);

    ActionResult update(JobLocation jobLocation);

    List<JobLocation> getAllJobLocation();

    JobLocation findOne(Long id);

    void delete(Long id);
}
