package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.SectionDTO;
import com.erp.hrm.domain.Section;
import com.erp.hrm.repository.SectionRepository;
import com.erp.hrm.service.SectionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Service
public class SectionServiceImpl implements SectionService {
    private SectionRepository sectionRepository;
    public SectionServiceImpl(SectionRepository sectionRepository){
        this.sectionRepository = sectionRepository;
    }

    @Override
    public ActionResult save(SectionDTO sectionDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Section section = new Section();
            section.setSectionName(sectionDTO.getSectionName());
            section.setSectionCode(sectionDTO.getSectionCode());
            section.setSequence(sectionDTO.getSequence());
            section.setNotes(sectionDTO.getNotes());
            section.setIsDefault(sectionDTO.getIsDefault());
            sectionRepository.save(section);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Section setting saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(SectionDTO sectionDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Section section = new Section();
            section.setId(sectionDTO.getId());
            section.setSectionName(sectionDTO.getSectionName());
            section.setSectionCode(sectionDTO.getSectionCode());
            section.setSequence(sectionDTO.getSequence());
            section.setNotes(sectionDTO.getNotes());
            section.setIsDefault(sectionDTO.getIsDefault());
            sectionRepository.save(section);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Section setting updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<SectionDTO> findAllSection() {
        List<SectionDTO> sectionDTOS = new ArrayList<>();
        List<Section> sectionData =  sectionRepository.findAllSection();
        for(Section section : sectionData) {
            SectionDTO sectionDTO = new SectionDTO();
            sectionDTO.setId(section.getId());
            sectionDTO.setSectionName(section.getSectionName());
            sectionDTO.setSectionCode(section.getSectionCode());
            sectionDTO.setSequence(section.getSequence());
            sectionDTO.setNotes(section.getNotes());
            sectionDTO.setIsDefault(section.getIsDefault());
            sectionDTOS.add(sectionDTO);
        }
        return sectionDTOS;
    }

    @Override
    public SectionDTO findOne(Integer id) {
        //Get Section through id
        Section section =  sectionRepository.getOne(id);//.findOne(id);
        SectionDTO sectionDTO = new SectionDTO();
        sectionDTO.setId(section.getId());
        sectionDTO.setSectionName(section.getSectionName());
        sectionDTO.setSectionCode(section.getSectionCode());
        sectionDTO.setSequence(section.getSequence());
        sectionDTO.setNotes(section.getNotes());
        sectionDTO.setIsDefault(section.getIsDefault());
        return sectionDTO;
    }

    @Override
    public void delete(Integer id) {
        sectionRepository.deleteById(id);//.delete(id);
    }
}
