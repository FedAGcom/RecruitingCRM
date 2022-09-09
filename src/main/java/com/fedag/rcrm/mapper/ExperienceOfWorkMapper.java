package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.ExperienceOfWorkModel;

public interface ExperienceOfWorkMapper {
    ExperienceOfWorkModel toModel(ExperienceOfWorkDto experienceOfWorkDto);
    ExperienceOfWorkDto toDto(ExperienceOfWorkModel experienceOfWorkModel);
}
