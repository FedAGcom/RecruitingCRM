package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.mapper.VacancyMapper;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.repos.VacancyRepo;
import com.fedag.rcrm.service.VacancyService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VacancyServiceImpl implements VacancyService {
    private final VacancyRepo vacancyRepo;

    private final VacancyMapper vacancyMapper;

    public VacancyServiceImpl(VacancyRepo vacancyRepo, VacancyMapper vacancyMapper) {
        this.vacancyRepo = vacancyRepo;
        this.vacancyMapper = vacancyMapper;
    }

    @Override
    public VacancyModel createVacancy(VacancyDto vacancyDto) {
        return vacancyRepo.save(vacancyMapper.toModel(vacancyDto));
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
    public VacancyDto getVacancyById(Long id) {
        Optional<VacancyModel> vacancyModel = vacancyRepo.findById(id);
        if(vacancyModel.isPresent()){
            return vacancyMapper.toDto(vacancyModel.get());
        }
        else{
            return new VacancyDto();
        }
    }
}
