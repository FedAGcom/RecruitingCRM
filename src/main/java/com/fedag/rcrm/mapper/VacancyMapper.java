package com.fedag.rcrm.mapper;


import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.VacancyDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface VacancyMapper {
    VacancyDto toDto(VacancyModel vacancyModel,  @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);
    VacancyModel toModel(VacancyDto vacancyDto);

}
