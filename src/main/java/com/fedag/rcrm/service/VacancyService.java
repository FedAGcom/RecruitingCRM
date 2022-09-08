package com.fedag.rcrm.service;

import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.VacancyDto;

public interface VacancyService {

    VacancyModel createVacancy(VacancyDto vacancyDto);

    VacancyModel updateVacancy(Long id, String title);

    VacancyModel deleteVacancy(Long id);

    VacancyDto getVacancyById(Long id);

}
