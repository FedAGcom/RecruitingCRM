package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.dto.FeedbackDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = FeedbackMapper.class)
public interface FeedbackListMapper {
    List<FeedbackModel> toListFeedbackModel(List<FeedbackDto> feedbackDtoList);
    List<FeedbackDto> toListFeedbackDto(List<FeedbackModel> feedbackModelList);
}
