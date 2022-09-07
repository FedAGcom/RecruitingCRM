package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.CandidateDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {FeedbackListMapper.class, ExperienceOfWorkListMapper.class})
public interface CandidateMapper {

    CandidateMapper INSTANCE = Mappers.getMapper(CandidateMapper.class);

    CandidateModel toModel(CandidateDto candidateDto);
    CandidateDto toDto(CandidateModel candidateModel);
}
