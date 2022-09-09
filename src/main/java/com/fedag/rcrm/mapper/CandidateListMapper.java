package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.CandidateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateListMapper {
    //List<CandidateModel> toModel(List<CandidateDto> candidateDtoList);

    //List<CandidateDto> toDto(List<CandidateModel> candidateModelList);
}
