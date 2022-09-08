
package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.HRDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {VacancyMapper.class, CandidateMapper.class})
public interface HRMapper {


    HRMapper INSTANCE = Mappers.getMapper(HRMapper.class);
    @Mapping(ignore = true, target = "candidateDto")
    @Mapping(source = "vacancies", target = "vacancies")
    HRDto toDto(HRModel hrModel, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    HRModel toModel(HRDto hrDto);


}