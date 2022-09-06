package com.fedag.rcrm.service;

import com.fedag.rcrm.model.Vacancy;
import com.fedag.rcrm.model.dto.VacancyDto;

public interface VacancyService {

    Vacancy createVacancy(VacancyDto vacancyDto);

    Vacancy updateVacancy(Long id, String title);

    Vacancy deleteVacancy(Long id);

    Vacancy getVacancyById(Long id);

}
