package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.dto.FeedbackDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface FeedbackMapper {

    FeedbackMapper INSTANCE = Mappers.getMapper(FeedbackMapper.class);
    FeedbackModel toModel(FeedbackDto feedbackDto);

    @Mapping(ignore = true, target = "hrModel")
    @Mapping(ignore = true, target = "candidateDto")
    FeedbackDto toFeedbackDto(FeedbackModel feedbackModel,  @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
