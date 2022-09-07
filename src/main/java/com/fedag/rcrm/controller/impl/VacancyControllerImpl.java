package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.dao.impl.VacancyDao;
import com.fedag.rcrm.model.dto.VacancyDto;
import com.fedag.rcrm.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequiredArgsConstructor
@Controller
@RequestMapping("/vacancies")
public class VacancyControllerImpl{

    private final VacancyService vacancyService;

    public void createVacancy(VacancyDto vacancyDto) {

    }


    public void getById(Long id) {
        //Vacancy vacancy = vacancies.getVacancyById(id);

    }


    public void deleteVacancy(Long id) {

    }


    public void updateVacancy(VacancyDao vacancyDao, Long id) {

    }
}
