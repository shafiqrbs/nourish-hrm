package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.CountryDTO;
import com.erp.hrm.domain.Country;
import com.erp.hrm.repository.CountryRepository;
import com.erp.hrm.service.CountryService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class CountryServiceImpl implements CountryService {
    private CountryRepository countryRepository;
    public CountryServiceImpl(CountryRepository countryRepository){
        this.countryRepository = countryRepository;
    }

    @Override
    public ActionResult save(CountryDTO countryDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Country country = new Country();
            country.setName(countryDTO.getName());
            country.setDisplayCode(countryDTO.getDisplayCode());
            country.setDescriptions(countryDTO.getDescriptions());
            country.setSequenceNo(countryDTO.getSequenceNo());
            country.setIsDefault(countryDTO.getIsDefault());
            countryRepository.save(country);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Country saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(CountryDTO countryDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            Country country = new Country();
            country.setId(countryDTO.getId());
            country.setName(countryDTO.getName());
            country.setDisplayCode(countryDTO.getDisplayCode());
            country.setDescriptions(countryDTO.getDescriptions());
            country.setSequenceNo(countryDTO.getSequenceNo());
            country.setIsDefault(countryDTO.getIsDefault());
            countryRepository.save(country);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("Country updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<CountryDTO> findAllCountry() {
        List<CountryDTO> countryDTOS = new ArrayList<>();
        List<Country> countries = countryRepository.findAllCountry();
        for(Country country:countries)
        {
           CountryDTO countryDTO = new CountryDTO();
           countryDTO.setId(country.getId());
           countryDTO.setName(country.getName());
           countryDTO.setDisplayCode(country.getDisplayCode());
           countryDTO.setSequenceNo(country.getSequenceNo());
           countryDTO.setIsDefault(country.getIsDefault());
           countryDTO.setDescriptions(country.getDescriptions());
           countryDTOS.add(countryDTO);
        }
        return countryDTOS;
    }

    @Override
    public CountryDTO findOne(Long id) {
        Country country = countryRepository.getOne(id);//.findOne(id);
        CountryDTO countryDTO = new CountryDTO();
        countryDTO.setId(country.getId());
        countryDTO.setName(country.getName());
        countryDTO.setDisplayCode(country.getDisplayCode());
        countryDTO.setSequenceNo(country.getSequenceNo());
        countryDTO.setIsDefault(country.getIsDefault());
        countryDTO.setDescriptions(country.getDescriptions());
        return countryDTO;
    }

    @Override
    public void delete(Long id) {
//        countryRepository.delete(id);
    	countryRepository.deleteById(id);
    }
}
