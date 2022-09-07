package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.CandidateDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = CandidateMapper.class)
public interface CandidateListMapper {
    List<CandidateModel> toListCandidateModel(List<CandidateDto> candidateDtoList);
    List<CandidateDto> toListCandidateDto(List<CandidateModel> candidateModelList);
}
