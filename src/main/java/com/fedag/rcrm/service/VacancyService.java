package com.fedag.rcrm.service;

import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.VacancyRequestDto;

public interface VacancyService {
    VacancyRequestDto getVacancyById(Long id);
}
