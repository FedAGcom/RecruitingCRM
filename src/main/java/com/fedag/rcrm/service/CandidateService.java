package com.fedag.rcrm.service;

import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CandidateService {

    CandidateResponseDto getCandidate(Long id);
    Page<CandidateResponseDto> getAllCandidate(Pageable pageable);
    CandidateResponseDto createCandidate(CandidateRequestDto dto, Long vacancyId);

    void deleteCandidate(Long id);
    CandidateResponseDto setCandidateStatus(Long id, String status);

    CandidateResponseDto updateCandidate(CandidateRequestUpdateDto dto, Long candidateId);

    Page<CandidateResponseDto> getAllCandidateWithStatus(Pageable pageable, String status);



}
