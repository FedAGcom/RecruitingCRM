package com.fedag.rcrm.service;

import com.fedag.rcrm.model.dto.request.FeedbackRequestDto;
import com.fedag.rcrm.model.dto.request.FeedbackRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.FeedbackResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface FeedbackService {
    FeedbackResponseDto findById(Long id);

    Page<FeedbackResponseDto> findAll(Pageable pageable);

    FeedbackResponseDto create(Long candidateId, FeedbackRequestDto feedbackRequestDto);

    void deleteById(Long id);

    FeedbackResponseDto update(Long id, FeedbackRequestUpdateDto hrRequestUpdateDto);
}
