package com.fedag.rcrm.service;

import com.fedag.rcrm.model.ExpOfWorkModel;
import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestDto;
import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.ExpOfWorkResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ExpOfWorkService {

    ExpOfWorkResponseDto getCandidateExperienceByExpId(Long expId);
    Page<ExpOfWorkResponseDto> getAllCandidateExperience(Pageable pageable, Long candidateId);

    ExpOfWorkResponseDto addExpOfWork(ExpOfWorkRequestDto request, Long candidateId);
    ExpOfWorkResponseDto updateExpOfWork(ExpOfWorkRequestUpdateDto requestUpdate, Long id);

    void deleteExpOfWorkById(Long expId);
    void deleteAllCandidateExp(Long candidateId);
}
