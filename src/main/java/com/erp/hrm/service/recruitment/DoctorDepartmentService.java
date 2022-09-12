package com.erp.hrm.service.recruitment;

import com.erp.hrm.api.dto.recruitment.*;
import com.erp.hrm.util.ActionResult;

public interface DoctorDepartmentService {

    ActionResult saveCandidateAgeAndCertificate(CandidateAgeAndCapabilityCertificateDTO dto);
    ActionResult updateCandidateAgeAndCertificate(CandidateAgeAndCapabilityCertificateDTO dto);
    CandidateAgeAndCapabilityCertificateDTO getCandidateAgeAndCertificate(String pEmployeeCode);

    ActionResult saveCandidateFitnessCertificate(CandidateFitnessCertificateDTO dto);
    ActionResult updateCandidateFitnessCertificate(CandidateFitnessCertificateDTO dto);
    CandidateFitnessCertificateDTO getCandidateFitnessCertificate(String pEmployeeCode);

    ActionResult saveCandidateAddictionCertificate(CandidateAddictionCertificateDTO dto);
    ActionResult updateCandidateAddictionCertificate(CandidateAddictionCertificateDTO dto);
    CandidateAddictionCertificateDTO getCandidateAddictionCertificate(String pEmployeeCode);
}
