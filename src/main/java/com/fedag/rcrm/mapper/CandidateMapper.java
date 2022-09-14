package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;

import java.util.List;

public interface CandidateMapper {

    CandidateResponseDto toCandidateResponseDto(CandidateModel model);
    List<CandidateResponseDto> toListCandidateResponseDto(List<CandidateModel> list);
    CandidateModel toCandidateModel(CandidateRequestDto dto, Long vacancyId);
    CandidateModel toCandidateModelUpdate(CandidateRequestUpdateDto dto, CandidateModel model);
    CandidateRequestUpdateDto toCandidateRequestUpdateDto(CandidateModel model);
    CandidateModel candidateModelMerge(CandidateModel source, CandidateRequestUpdateDto dto);
}
