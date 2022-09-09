
package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.HRModel;

public interface HRMapper {
    HRDto toDto(HRModel hrModel);
    HRModel toModel(HRDto hrDto);


}