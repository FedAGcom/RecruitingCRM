package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;

public interface CandidateMapper {
    CandidateResponseDto toCandidateResponseDto(CandidateModel model);
    CandidateModel toCandidateModel(CandidateRequestDto dto);
    CandidateModel toCandidateModelUpdate(CandidateRequestUpdateDto dto);
}
