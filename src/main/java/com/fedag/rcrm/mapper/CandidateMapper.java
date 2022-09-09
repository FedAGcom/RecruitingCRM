package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.CandidateDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {FeedbackMapper.class, ExperienceOfWorkMapper.class}, imports = {Collectors.class})
public interface CandidateMapper {

    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);

    //CandidateModel toModel(CandidateDto candidateDto);

    @Mapping(source = "experienceOfWorksList", target = "experienceOfWorksListDto")
    @Mapping(source = "feedback", target = "feedbackDto")
    @Mapping(target = "hr.candidate", expression = "java(hRModel.getCandidate().stream().map(CandidateModel::getId).collect(Collectors.toList()))")
    CandidateDto toDto(CandidateModel candidateModel,  @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
