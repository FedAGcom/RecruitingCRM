package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.ExperienceOfWorkModel;
import com.fedag.rcrm.model.dto.ExperienceOfWorkDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ExperienceOfWorkMapper {
    ExperienceOfWorkModel toExpModel(ExperienceOfWorkDto experienceOfWorkDto);
    ExperienceOfWorkDto toExpDto(ExperienceOfWorkModel experienceOfWorkModel);
}
