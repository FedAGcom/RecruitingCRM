package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.dto.FeedbackDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {
    FeedbackModel toFeedbackModel(FeedbackDto feedbackDto);
    FeedbackDto toFeedbackDto(FeedbackModel feedbackModel);
}
