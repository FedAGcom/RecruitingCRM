package com.fedag.rcrm.service;

import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;

public interface CandidateService {
    CandidateResponseDto getCandidate(Long id);
}
