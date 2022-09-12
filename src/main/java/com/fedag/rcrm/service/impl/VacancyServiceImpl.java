package com.fedag.rcrm.service.impl;

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

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyMapperImpl vacancyMapper;
    private final HRRepo hrRepo;
    private final CandidateRepo candidateRepo;
    private final VacancyRepo vacancyRepo;


    @Override
    public VacancyResponseDto findById(Long id) {
        VacancyModel vacancyModel = vacancyRepo.findById(id).orElseThrow(()->new RuntimeException("Vacancy with id " + id + " not found"));
        return vacancyMapper.toResponse(vacancyModel);
    }

    @Override
    public VacancyResponseDto findByTitle(String title) {
        VacancyModel vacancyModel = vacancyRepo.findByTitle(title).orElseThrow(()-> new RuntimeException("Vacancy with title" +
                title + " not found"));
        return vacancyMapper.toResponse(vacancyModel);
    }


    @Override
    public VacancyResponseDto create(VacancyRequestDto vacancyRequestDto) {
        VacancyModel vacancyModel = new VacancyModel();
        vacancyModel.setStatus(vacancyRequestDto.getStatus());
        vacancyModel.setComment(vacancyRequestDto.getComment());
        vacancyModel.setCreationDate(LocalDateTime.now());
        vacancyModel.setDescription(vacancyRequestDto.getDescription());
        vacancyModel.setPosition(vacancyRequestDto.getPosition());
        vacancyModel.setSalary(vacancyRequestDto.getSalary());
        vacancyModel.setTitle(vacancyRequestDto.getTitle());
        vacancyRepo.save(vacancyModel);
        return vacancyMapper.toResponse(vacancyModel);

    }

    @Override
    public void deleteById(Long id) {
        VacancyModel vacancyModel = vacancyRepo.findById(id).orElseThrow(()->new RuntimeException("Vacancy with id " + id + " not found"));
        vacancyModel.setStatus("CLOSE");
        vacancyRepo.save(vacancyModel);
    }

    @Override
    public void update(VacancyRequestUpdateDto vacancyRequestUpdateDto) {
        VacancyModel vacancyModel = vacancyMapper.fromRequestUpdate(vacancyRequestUpdateDto);
        vacancyRepo.save(vacancyModel);
    }

    @Override
    public Page<VacancyResponseDto> findAll(Pageable pageable) {
        return vacancyRepo.findAll(pageable).map(vacancyMapper::toResponse);
    }
}
