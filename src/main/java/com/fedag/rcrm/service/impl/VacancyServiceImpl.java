package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.model.Vacancy;
import com.fedag.rcrm.model.dto.VacancyDto;
import com.fedag.rcrm.repos.VacancyRepo;
import com.fedag.rcrm.service.VacancyService;
import org.springframework.stereotype.Service;

@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepo vacancyRepo;

    public VacancyServiceImpl(VacancyRepo vacancyRepo) {
        this.vacancyRepo = vacancyRepo;
    }

    @Override
    public Vacancy createVacancy(VacancyDto vacancyDto) {

        return vacancyRepo.save(vacancy);
    }

    @Override
    public Vacancy updateVacancy(Long id, String title) {

        return null;
    }

    @Override
    public Vacancy deleteVacancy(Long id) {
        return null;
    }

    @Override
    public Vacancy getVacancyById(Long id) {
        return null;
    }
}
