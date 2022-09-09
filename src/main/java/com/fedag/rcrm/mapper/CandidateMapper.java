package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

public interface CandidateMapper {
    CandidateModel toModel(CandidateRequestDto candidateDto);
    CandidateRequestDto toRequestDto(CandidateModel candidateModel);
}
