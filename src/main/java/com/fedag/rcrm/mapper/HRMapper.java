package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;

public interface HRMapper {
    HRResponseDto toResponse(HRModel hrModel);

    HRModel fromRequest(HRRequestDto hrRequestDto);

    HRModel fromRequestUpdate(HRRequestUpdateDto hrRequestUpdateDto);

    HRModel toUpdateModel(HRModel source, HRModel target);
}
