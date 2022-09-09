package com.fedag.rcrm.mapper;


import com.fedag.rcrm.model.VacancyModel;

public interface VacancyMapper {
    VacancyDto toDto(VacancyModel vacancyModel);
    VacancyModel toModel(VacancyDto vacancyDto);

}
