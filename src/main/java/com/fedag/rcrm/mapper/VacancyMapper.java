package com.fedag.rcrm.mapper;


import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.VacancyRequestDto;

public interface VacancyMapper {
    VacancyRequestDto toDto(VacancyModel vacancyModel);
    VacancyModel toModel(VacancyRequestDto vacancyDto);

}
