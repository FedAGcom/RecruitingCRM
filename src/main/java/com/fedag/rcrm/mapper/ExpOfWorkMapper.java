package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.ExpOfWorkModel;
import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestDto;
import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.ExpOfWorkResponseDto;

import java.util.List;

public interface ExpOfWorkMapper {
    ExpOfWorkResponseDto toExpResponseDto(ExpOfWorkModel model);

    List<ExpOfWorkResponseDto> toListExpResponseDto(List<ExpOfWorkModel> list);

    ExpOfWorkModel toExpModelRequest(ExpOfWorkRequestDto requestDto, Long candidateId);

    ExpOfWorkModel toExpModelUpdate(ExpOfWorkModel source, ExpOfWorkRequestUpdateDto dto, CandidateModel candidate);
}

