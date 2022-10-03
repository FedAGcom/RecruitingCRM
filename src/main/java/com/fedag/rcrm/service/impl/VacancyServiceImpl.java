package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.impl.VacancyMapperImpl;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.VacancyRequestDto;
import com.fedag.rcrm.model.dto.request.VacancyRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;
import com.fedag.rcrm.repos.VacancyRepo;
import com.fedag.rcrm.service.VacancyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Slf4j
@Service
@RequiredArgsConstructor
public class VacancyServiceImpl implements VacancyService {

    private final VacancyMapperImpl vacancyMapper;
    private final VacancyRepo vacancyRepo;


    @Override
    public VacancyResponseDto findById(Long id) {
        log.info("Поиск вакансии с Id: {}", id);
        VacancyModel vacancyModel = vacancyRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Vacancy", "ID", id));
        VacancyResponseDto result = vacancyMapper.toResponse(vacancyModel);
        log.info("Вакансия с Id: {} найдена", id);
        return result;
    }

    @Override//
    public VacancyResponseDto findByTitle(String title) {
        log.info("Поиск вакансии с названием: {}", title);
        VacancyModel vacancyModel = vacancyRepo.findByTitle(title).orElseThrow(() -> new RuntimeException("Vacancy with title" +
                title + " not found"));
        VacancyResponseDto result = vacancyMapper.toResponse(vacancyModel);
        log.info("Вакансия с названием: {} найдена", title);
        return result;
    }


    @Override
    @Transactional
    public VacancyResponseDto create(VacancyRequestDto vacancyRequestDto) {
        log.info("Создание вакансии");
        VacancyModel vacancyModel = vacancyMapper.fromRequest(vacancyRequestDto);
        vacancyModel.setCreationDate(LocalDateTime.now());
        vacancyRepo.save(vacancyModel);
        VacancyResponseDto result = vacancyMapper.toResponse(vacancyModel);
        log.info("Вакансия создана");
        return result;

    }

    @Override
    public Page<VacancyResponseDto> findAllByStatus(String status, Pageable pageable) {
        log.info("Получение страницы с вакансиями со статусом: {}", status);
        Page<VacancyResponseDto> result = vacancyRepo.findAllByStatusContains(status, pageable)
                .map(vacancyMapper::toResponse);
        log.info("Страница с вакансиями со статусом: {} получена", status);
        return result;
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        log.info("Удаление вакансии с Id: {}", id);
        this.findById(id);
        vacancyRepo.deleteById(id);
        log.info("Вакансия с Id: {} удалена", id);
    }

    @Override
    @Transactional
    public VacancyResponseDto update(Long id, VacancyRequestUpdateDto vacancyRequestUpdateDto) {
        log.info("Обновление вакансии с Id: {}", id);
        VacancyModel model = vacancyRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Vacancy", "ID", id));
        VacancyResponseDto result = vacancyMapper.toResponse(vacancyMapper.toVacancyModelUpdate(model, vacancyRequestUpdateDto));
        log.info("Вакансия с Id: {} обновлена", id);
        return result;
    }

    @Override
    public Page<VacancyResponseDto> findAll(Pageable pageable) {
        log.info("Получение страницы с вакансиями");
        Page<VacancyResponseDto> result = vacancyRepo.findAll(pageable).map(vacancyMapper::toResponse);
        log.info("Страница с вакансиями получена");
        return result;
    }
}
