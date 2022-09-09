package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.dto.FeedbackDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring", uses = {FeedbackMapper.class, CandidateMapper.class, HRMapper.class})
public interface FeedbackListMapper {
    //List<FeedbackModel> toModel(List<FeedbackDto> feedbackDtoList);

//    @Mapping(expression = "java(hrModel.getCandidate().stream().map(CandidateModel::getId()).collect(Collectors.toList()))", target = "feedbackDto.hrModel.candidate")
//    List<FeedbackDto> toDto(List<FeedbackModel> feedbackModelList);
}
