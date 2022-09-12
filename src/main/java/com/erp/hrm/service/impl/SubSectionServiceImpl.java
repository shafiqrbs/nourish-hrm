package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.SubSectionDTO;
import com.erp.hrm.domain.Section;
import com.erp.hrm.domain.SubSection;
import com.erp.hrm.repository.SectionRepository;
import com.erp.hrm.repository.SubSectionRepository;
import com.erp.hrm.service.SubSectionService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Service
public class SubSectionServiceImpl implements SubSectionService {
    private SubSectionRepository subSectionRepository;
    private SectionRepository sectionRepository;
    public SubSectionServiceImpl(SubSectionRepository subSectionRepository,SectionRepository sectionRepository){
        this.subSectionRepository = subSectionRepository;
        this.sectionRepository = sectionRepository;
    }

    @Override
    public ActionResult save(SubSectionDTO subSectionDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            SubSection subSection = new SubSection();
            subSection.setSubSectionName(subSectionDTO.getSubSectionName());
            subSection.setSubSectionCode(subSectionDTO.getSubSectionCode());
            subSection.setSequence(subSectionDTO.getSequence());
            subSection.setNotes(subSectionDTO.getNotes());
            subSection.setIsDefault(subSectionDTO.getIsDefault());

            Section section = sectionRepository.getSectionInfoByName(subSectionDTO.getSectionName());
            subSection.setSection(section);

            subSectionRepository.save(subSection);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("SubSection saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(SubSectionDTO subSectionDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            SubSection subSection = new SubSection();
            subSection.setId(subSectionDTO.getId());
            subSection.setSubSectionName(subSectionDTO.getSubSectionName());
            subSection.setSubSectionCode(subSectionDTO.getSubSectionCode());
            subSection.setSequence(subSectionDTO.getSequence());
            subSection.setNotes(subSectionDTO.getNotes());
            subSection.setIsDefault(subSectionDTO.getIsDefault());

            Section section = sectionRepository.getSectionInfoByName(subSectionDTO.getSectionName());
            subSection.setSection(section);

            subSectionRepository.save(subSection);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("SubSection updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<SubSectionDTO> getAllSubSection() {
        List<SubSectionDTO> subSectionDTOS = new ArrayList<>();
        List<SubSection> subSectionData =  subSectionRepository.findAllSubSection();
        for(SubSection subSection : subSectionData) {
            SubSectionDTO subSectionDTO = new SubSectionDTO();
            subSectionDTO.setId(subSection.getId());
            subSectionDTO.setSubSectionName(subSection.getSubSectionName());
            subSectionDTO.setSubSectionCode(subSection.getSubSectionCode());
            subSectionDTO.setSectionName(subSection.getSection().getSectionName());
            subSectionDTO.setSequence(subSection.getSequence());
            subSectionDTO.setNotes(subSection.getNotes());
            subSectionDTO.setIsDefault(subSection.getIsDefault());
            subSectionDTOS.add(subSectionDTO);
        }
        return subSectionDTOS;
    }

    @Override
    public SubSectionDTO findOne(Integer id) {
        SubSection subSection = subSectionRepository.getOne(id);//.findOne(id);
        SubSectionDTO subSectionDTO = new SubSectionDTO();
        subSectionDTO.setId(subSection.getId());
        subSectionDTO.setSubSectionName(subSection.getSubSectionName());
        subSectionDTO.setSubSectionCode(subSection.getSubSectionCode());
        subSectionDTO.setSectionName(subSection.getSection().getSectionName());
        subSectionDTO.setSequence(subSection.getSequence());
        subSectionDTO.setNotes(subSection.getNotes());
        subSectionDTO.setIsDefault(subSection.getIsDefault());
        return subSectionDTO;
    }

    @Override
    public void delete(Integer id) {
        subSectionRepository.deleteById(id);//.delete(id);
    }
}
