package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.ExperienceOfWorkModel;
import com.fedag.rcrm.model.dto.ExperienceOfWorkDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ExperienceOfWorkMapper.class, CandidateMapper.class})
public interface ExperienceOfWorkListMapper {
    List<ExperienceOfWorkModel> toModel(List<ExperienceOfWorkDto> experienceOfWorkDtoList);
    List<ExperienceOfWorkDto> toDto(List<ExperienceOfWorkModel> experienceOfWorkModelList);
}
