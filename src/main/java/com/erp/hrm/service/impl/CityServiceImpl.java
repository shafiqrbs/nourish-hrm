package com.erp.hrm.service.impl;

import com.erp.hrm.api.dto.Configuration.CityDTO;
import com.erp.hrm.domain.City;
import com.erp.hrm.domain.Country;
import com.erp.hrm.repository.CityRepository;
import com.erp.hrm.repository.CountryRepository;
import com.erp.hrm.service.CityService;
import com.erp.hrm.util.ActionResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Navid on 18/04/2018.
 */
@Service
public class CityServiceImpl implements CityService {
    private CityRepository cityRepository;
    private CountryRepository countryRepository;
    public CityServiceImpl(CityRepository cityRepository,CountryRepository countryRepository){
        this.countryRepository = countryRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public ActionResult save(CityDTO cityDTO) {
        ActionResult actionResult = new ActionResult();
        try{
            City city = new City();
            city.setName(cityDTO.getName());
            city.setDisplayCode(cityDTO.getDisplayCode());
            city.setSequenceNo(cityDTO.getSequenceNo());
            city.setIsDefault(cityDTO.getIsDefault());
            city.setDescriptions(cityDTO.getDescriptions());

            long countryId = 1;
//            Country country = countryRepository.findOne(countryId);
            Country country = countryRepository.getOne(countryId);//.findOne(countryId);
            city.setCountry(country);

            cityRepository.save(city);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("City saved successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public ActionResult update(CityDTO cityDTO) {
        ActionResult actionResult = new ActionResult();

        try{
            City city = new City();
            city.setId(cityDTO.getId());
            city.setName(cityDTO.getName());
            city.setDisplayCode(cityDTO.getDisplayCode());
            city.setSequenceNo(cityDTO.getSequenceNo());
            city.setIsDefault(cityDTO.getIsDefault());
            city.setDescriptions(cityDTO.getDescriptions());

            long countryId = 1;
            Country country = countryRepository.getOne(countryId);
            city.setCountry(country);

            cityRepository.save(city);
            //Set custom message if success
            actionResult.setIsSuccess(true);
            actionResult.setSuccessMessage("City updated successfully");
        }
        catch (Exception e){
            //Set custom message if error
            actionResult.setIsSuccess(false);
            actionResult.setErrorMessage(e.getMessage());
        }

        return actionResult;
    }

    @Override
    public List<CityDTO> findAllCity() {
        List<CityDTO> cityDTOS = new ArrayList<>();
        List<City> cities = cityRepository.findAllCity();
        for (City city:cities) {
            CityDTO cityDTO = new CityDTO();
            cityDTO.setId(city.getId());
            cityDTO.setName(city.getName());
            cityDTO.setDisplayCode(city.getDisplayCode());
            cityDTO.setDescriptions(city.getDescriptions());
            cityDTO.setIsDefault(city.getIsDefault());
            cityDTO.setSequenceNo(city.getSequenceNo());
            cityDTOS.add(cityDTO);
        }
        return cityDTOS;
    }

    @Override
    public CityDTO findOne(Long id) {
        City city = cityRepository.getOne(id);//.findOne(id);
        CityDTO cityDTO = new CityDTO();
        cityDTO.setId(city.getId());
        cityDTO.setName(city.getName());
        cityDTO.setDisplayCode(city.getDisplayCode());
        cityDTO.setDescriptions(city.getDescriptions());
        cityDTO.setIsDefault(city.getIsDefault());
        cityDTO.setSequenceNo(city.getSequenceNo());
        return cityDTO;
    }

    @Override
    public void delete(Long id) {
//        cityRepository.delete(id);
    	cityRepository.deleteById(id);;//(id);
    }
}
