
package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.request.HRRequestDto;

public interface HRMapper {
    HRRequestDto toDto(HRModel hrModel);
    HRModel toModel(HRRequestDto hrDto);


}