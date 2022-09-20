package com.fedag.rcrm.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedag.rcrm.mapper.FeedbackMapper;
import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.dto.request.FeedbackRequestDto;
import com.fedag.rcrm.model.dto.request.FeedbackRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.FeedbackResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class FeedbackMapperImpl implements FeedbackMapper {
    private final ObjectMapper objectMapper;

    @Override
    public FeedbackResponseDto toResponse(FeedbackModel feedbackModel) {
        return new FeedbackResponseDto()
                .setId(feedbackModel.getId())
                .setCandidateId(feedbackModel.getCandidate().getId())
                .setHrId(feedbackModel.getHr().getId())
                .setRating(feedbackModel.getRating())
                .setComment(feedbackModel.getComment())
                .setCreated(feedbackModel.getCreated())
                .setUpdated(feedbackModel.getUpdated())
                .setDeleted(feedbackModel.isDeleted());
    }

    @Override
    public FeedbackModel fromRequest(FeedbackRequestDto feedbackRequestDto) {
        return objectMapper.convertValue(feedbackRequestDto, FeedbackModel.class);
    }

    @Override
    public FeedbackModel fromRequestUpdate(FeedbackRequestUpdateDto feedbackRequestUpdateDto) {
        return objectMapper.convertValue(feedbackRequestUpdateDto, FeedbackModel.class);
    }

    @Override
    public FeedbackModel toUpdateModel(FeedbackModel source, FeedbackModel target) {
        target.setRating(source.getRating());
        target.setComment(source.getComment());
        target.setUpdated(LocalDateTime.now());
        return target;
    }
}
