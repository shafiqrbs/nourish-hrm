package com.erp.hrm.service.impl;

import com.erp.hrm.domain.SectionInfo;
import com.erp.hrm.repository.SectionInfoRepository;
import com.erp.hrm.service.SectionInfoService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class SectionInfoServiceImpl implements SectionInfoService {
    private SectionInfoRepository sectionInfoRepository;
    public SectionInfoServiceImpl(SectionInfoRepository sectionInfoRepository){
        this.sectionInfoRepository = sectionInfoRepository;
    }

    @Override
    public ActionResult save(SectionInfo sectionInfo) {
        ActionResult actionResult = new ActionResult();

        try{
            sectionInfoRepository.save(sectionInfo);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Section saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(SectionInfo sectionInfo) {
        ActionResult actionResult = new ActionResult();

        try{
            sectionInfoRepository.save(sectionInfo);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Section updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<SectionInfo> findAllSection() {
        return sectionInfoRepository.findAllSectionInfo();
    }

    @Override
    public SectionInfo findOne(Long id) {
        return sectionInfoRepository.getOne(id);//.findOne(id);
    }

    @Override
    public void delete(Long id) {
        sectionInfoRepository.deleteById(id);//.delete(id);
    }
}
