
package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.HRDto;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ValueMapping;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {VacancyMapper.class, CandidateMapper.class}, imports = {CandidateModel.class, Collectors.class})
public interface HRMapper {


    HRMapper INSTANCE = Mappers.getMapper(HRMapper.class);

    @Mapping(target = "candidate", expression = "java(hrModel.getCandidate().stream().map(CandidateModel::getId).collect(Collectors.toList()))" )
    @Mapping(source = "vacancies", target = "vacancies")
    HRDto toDto(HRModel hrModel, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    //HRModel toModel(HRDto hrDto);


}