package com.fedag.rcrm.mapper;

import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.VacancyRequestDto;
import com.fedag.rcrm.model.dto.request.VacancyRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;

public interface VacancyMapper {

    VacancyResponseDto toResponse(VacancyModel vacancyModel);
    VacancyModel fromRequest(VacancyRequestDto vacancyRequestDto);
    VacancyModel fromRequestUpdate(VacancyRequestUpdateDto vacancyRequestUpdateDto);

}
