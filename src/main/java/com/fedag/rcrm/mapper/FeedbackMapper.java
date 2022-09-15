package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.dto.request.FeedbackRequestDto;
import com.fedag.rcrm.model.dto.request.FeedbackRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.FeedbackResponseDto;


public interface FeedbackMapper {
    FeedbackResponseDto toResponse(FeedbackModel feedbackModel);
    FeedbackModel fromRequest(FeedbackRequestDto feedbackRequestDto);
    FeedbackModel fromRequestUpdate(FeedbackRequestUpdateDto feedbackRequestUpdateDto);
    FeedbackModel merge(FeedbackModel source, FeedbackModel target);
}
