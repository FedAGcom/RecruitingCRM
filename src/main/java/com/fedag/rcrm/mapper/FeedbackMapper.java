package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.FeedbackModel;

public interface FeedbackMapper {

    FeedbackModel toModel(FeedbackDto feedbackDto);
    FeedbackDto toFeedbackDto(FeedbackModel feedbackModel);
}
