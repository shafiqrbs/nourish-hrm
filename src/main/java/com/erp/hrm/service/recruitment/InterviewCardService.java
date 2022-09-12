package com.erp.hrm.service.recruitment;

import com.erp.hrm.api.dto.recruitment.InterviewCardDTO;
import com.erp.hrm.util.ActionResult;

/**
 * Created by Sohag on 19/10/2018.
 */
public interface InterviewCardService {
    ActionResult saveInterviewCard(InterviewCardDTO dto);

    InterviewCardDTO getInterviewCardInfo(String pEmployeeTempCode);
}
