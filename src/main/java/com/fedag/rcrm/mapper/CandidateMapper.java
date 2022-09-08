package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.CandidateDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {FeedbackMapper.class, ExperienceOfWorkMapper.class, CandidateMapper.class})
public interface CandidateMapper {

    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);

    CandidateModel toModel(CandidateDto candidateDto);

    @Mapping(source = "experienceOfWorksList", target = "experienceOfWorksListDto")
    @Mapping(source = "feedback", target = "feedbackDto")
    CandidateDto toDto(CandidateModel candidateModel,  @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
