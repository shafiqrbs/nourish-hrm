package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.LineDTO;
import com.erp.hrm.domain.Floor;
import com.erp.hrm.domain.Line;
import com.erp.hrm.repository.FloorRepository;
import com.erp.hrm.repository.LineRepository;
import com.erp.hrm.service.LineService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 06/05/2018.
 */
@Service
public class LineServiceImpl implements LineService {
    private LineRepository lineRepository;
    private FloorRepository floorRepository;
    public LineServiceImpl(LineRepository lineRepository,FloorRepository floorRepository){
        this.lineRepository = lineRepository;
        this.floorRepository = floorRepository;
    }

    @Override
    public ActionResult save(LineDTO lineDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Line line = new Line();
            line.setLineName(lineDTO.getLineName());
            line.setLineCode(lineDTO.getLineCode());
            line.setSequence(lineDTO.getSequence());
            line.setNotes(lineDTO.getNotes());
            line.setIsDefault(lineDTO.getIsDefault());

            Floor floor = floorRepository.getFloorInfoByName(lineDTO.getFloorName());
            line.setFloor(floor);

            lineRepository.save(line);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Line setting saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(LineDTO lineDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Line line = new Line();
            line.setId(lineDTO.getId());
            line.setLineName(lineDTO.getLineName());
            line.setLineCode(lineDTO.getLineCode());
            line.setSequence(lineDTO.getSequence());
            line.setNotes(lineDTO.getNotes());
            line.setIsDefault(lineDTO.getIsDefault());

            Floor floor = floorRepository.getFloorInfoByName(lineDTO.getFloorName());
            line.setFloor(floor);

            lineRepository.save(line);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Line setting updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<LineDTO> findAllLine() {
        List<LineDTO> lineDTOS = new ArrayList<>();
        List<Line> lineData =  lineRepository.findAllLine();
        for(Line line : lineData) {
            LineDTO lineDTO = new LineDTO();
            lineDTO.setId(line.getId());
            lineDTO.setLineName(line.getLineName());
            lineDTO.setLineCode(line.getLineCode());
            lineDTO.setSequence(line.getSequence());
            lineDTO.setFloorName(line.getFloor().getFloorName());
            lineDTO.setNotes(line.getNotes());
            lineDTO.setIsDefault(line.getIsDefault());
            lineDTOS.add(lineDTO);
        }
        return lineDTOS;
    }

    @Override
    public LineDTO findOne(Integer id) {
        //Get Line through id
        Line line =  lineRepository.getOne(id);//.findOne(id);
        LineDTO lineDTO = new LineDTO();
        lineDTO.setId(line.getId());
        lineDTO.setLineName(line.getLineName());
        lineDTO.setLineCode(line.getLineCode());
        lineDTO.setSequence(line.getSequence());
        lineDTO.setFloorName(line.getFloor().getFloorName());
        lineDTO.setNotes(line.getNotes());
        lineDTO.setIsDefault(line.getIsDefault());
        return lineDTO;
    }

    @Override
    public void delete(Integer id) {
        lineRepository.deleteById(id);//.delete(id);
    }
}
