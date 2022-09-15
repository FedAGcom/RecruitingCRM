package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;

import java.util.List;

public interface CandidateMapper {

    CandidateResponseDto toCandidateResponseDto(CandidateModel model);
    List<CandidateResponseDto> toListCandidateResponseDto(List<CandidateModel> list);
    CandidateModel toCandidateModel(CandidateRequestDto dto, Long vacancyId);
    CandidateModel toCandidateModelUpdate(CandidateModel source, CandidateRequestUpdateDto dto, HRModel hr, VacancyModel vacancy);
}
