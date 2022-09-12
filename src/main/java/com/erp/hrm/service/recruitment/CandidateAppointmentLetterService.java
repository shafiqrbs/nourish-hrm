package com.erp.hrm.service.recruitment;

import com.erp.hrm.api.dto.recruitment.CandidateDetailsInfoDTO;

/**
 * Created by Sohag on 06/01/2019.
 */
public interface CandidateAppointmentLetterService {
    CandidateDetailsInfoDTO getCandidateDetailsInfo(String pEmployeeTempCode);
}
