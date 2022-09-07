package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.model.VacancyModel;
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
    public VacancyModel createVacancy(VacancyDto vacancyDto) {

        return null; //vacancyRepo.save();
    }

    @Override
    public VacancyModel updateVacancy(Long id, String title) {

        return null;
    }

    @Override
    public VacancyModel deleteVacancy(Long id) {
        return null;
    }

    @Override
    public VacancyModel getVacancyById(Long id) {
        return null;
    }
}
