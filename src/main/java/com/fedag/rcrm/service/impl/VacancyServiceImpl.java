package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.impl.VacancyMapperImpl;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.VacancyRequestDto;
import com.fedag.rcrm.model.dto.request.VacancyRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;
import com.fedag.rcrm.repos.CandidateRepo;
import com.fedag.rcrm.repos.HRRepo;
import com.fedag.rcrm.repos.VacancyRepo;
import com.fedag.rcrm.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyMapperImpl vacancyMapper;
    private final VacancyRepo vacancyRepo;


    @Override
    public VacancyResponseDto findById(Long id) {
        VacancyModel vacancyModel = vacancyRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Vacancy", "ID", id));
        return vacancyMapper.toResponse(vacancyModel);
    }

    @Override
    public VacancyResponseDto findByTitle(String title) {
        VacancyModel vacancyModel = vacancyRepo.findByTitle(title).orElseThrow(()-> new RuntimeException("Vacancy with title" +
                title + " not found"));
        return vacancyMapper.toResponse(vacancyModel);
    }


    @Override
    @Transactional
    public VacancyResponseDto create(VacancyRequestDto vacancyRequestDto) {
        VacancyModel vacancyModel = vacancyMapper.fromRequest(vacancyRequestDto);
        vacancyModel.setCreationDate(LocalDateTime.now());
        vacancyRepo.save(vacancyModel);
        return vacancyMapper.toResponse(vacancyModel);

    }

    @Override
    public Page<VacancyResponseDto> findAllByStatus( String status, Pageable pageable) {
        return vacancyRepo.findAllByStatusContains(status, pageable).map(vacancyMapper::toResponse);
    }



    @Override
    @Transactional
    public void deleteById(Long id) {
        this.findById(id);
        vacancyRepo.deleteById(id);
    }

    @Override
    @Transactional
    public VacancyResponseDto update(Long id, VacancyRequestUpdateDto vacancyRequestUpdateDto) {
        VacancyModel model = vacancyRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Vacancy", "ID", id));
        return vacancyMapper.toResponse(vacancyMapper.toVacancyModelUpdate(model, vacancyRequestUpdateDto));
    }

    @Override
    public Page<VacancyResponseDto> findAll(Pageable pageable) {
        return vacancyRepo.findAll(pageable).map(vacancyMapper::toResponse);
    }
}
