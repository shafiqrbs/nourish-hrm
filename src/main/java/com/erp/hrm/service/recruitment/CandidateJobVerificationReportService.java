package com.erp.hrm.service.recruitment;

import com.erp.hrm.api.dto.recruitment.CandidateJobVerificationReportDTO;
import com.erp.hrm.util.ActionResult;

public interface CandidateJobVerificationReportService {

    ActionResult saveCandidateJobVerificationReport(CandidateJobVerificationReportDTO dto);
    ActionResult updateCandidateJobVerificationReport(CandidateJobVerificationReportDTO dto);
    CandidateJobVerificationReportDTO getCandidateJobVerificationReport(String pEmployeeCode);
}
