package com.fedag.rcrm.service;

import com.fedag.rcrm.model.dto.request.CandidateRequestDto;

public interface CandidateService {
    public CandidateRequestDto getCandidate(Long id);
}
