package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.ExperienceOfWorkModel;
import com.fedag.rcrm.model.dto.ExperienceOfWorkDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ExperienceOfWorkMapper {
    ExperienceOfWorkModel toModel(ExperienceOfWorkDto experienceOfWorkDto);
    @Mapping(ignore = true, target = "candidateDto")
    ExperienceOfWorkDto toDto(ExperienceOfWorkModel experienceOfWorkModel,  @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
}
