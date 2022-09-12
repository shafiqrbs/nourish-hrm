package com.erp.hrm.service.impl.recruitment;

import com.erp.hrm.api.dto.recruitment.CandidateDetailsInfoDTO;
import com.erp.hrm.domain.EmployeeInfo;
import com.erp.hrm.repository.recruitment.CandidateApplicationRepository;
import com.erp.hrm.service.recruitment.CandidateAppointmentLetterService;
import org.springframework.stereotype.Service;

@Service
public class CandidateAppointmentLetterServiceImpl implements CandidateAppointmentLetterService {
    private CandidateApplicationRepository applicationRepository;

    public CandidateAppointmentLetterServiceImpl(CandidateApplicationRepository applicationRepository) {
        this.applicationRepository = applicationRepository;
    }

    @Override
    public CandidateDetailsInfoDTO getCandidateDetailsInfo(String pEmployeeTempCode) {
        CandidateDetailsInfoDTO dto = new CandidateDetailsInfoDTO();

        EmployeeInfo info = applicationRepository.getOne(pEmployeeTempCode);
        if(info == null)
            throw new RuntimeException("Employee Not available");

        dto.setEmployeeCode(info.getEmployeeCode());
        dto.setFirstName(info.getFirstName());
        dto.setMiddleName(info.getMiddleName());
        dto.setLastName(info.getLastName());
        dto.setNickName(info.getNickName());
        dto.setSalutation(info.getSalutation());
        dto.setFathersName(info.getFathersName());
        dto.setMothersName(info.getMothersName());
        dto.setNid(info.getNid());
        dto.setPunchCardNo(info.getPunchCardNo());
        dto.setEmployeeType(info.getEmployeeType());
        dto.setWorkerEmploymentType(info.getWorkerEmploymentType());

        dto.setPresentAddress(info.getPresentAddress());
        dto.setPresentPS(info.getPresentPS());
        dto.setPresentZIPCode(info.getPresentZIPCode());
        dto.setPresentDistrict(info.getPresentDistrict());
        dto.setPresentCountry(info.getPresentCountry());

        dto.setPermanentAddress(info.getPermanentAddress());
        dto.setPermanentPS(info.getPermanentPS());
        dto.setPermanentZIPCode(info.getPermanentZIPCode());
        dto.setPermanentDistrict(info.getPermanentDistrict());
        dto.setPermanentCountry(info.getPermanentCountry());

        dto.setMaritalStatus(info.getMaritalStatus());
        dto.setSpouseName(info.getSpouseName());
        dto.setSpouseOccupation(info.getSpouseOccupation());
        dto.setNoOfChildren(info.getNoOfChildren());
        dto.setDob(info.getDob());
        dto.setGender(info.getGender());
        dto.setReligion(info.getReligion());
        dto.setNationality(info.getNationality());
        dto.setBloodGroup(info.getBloodGroup());
        dto.setPhone(info.getPhone());
        dto.setEmail(info.getEmail());
        dto.setReferenceAddress(info.getReferenceAddress());
        dto.setPersonalRemarks(info.getPersonalRemarks());
        dto.setEmpImage(info.getEmpImage());
        dto.setEmpSignature(info.getEmpSignature());
        return dto;
    }
}
