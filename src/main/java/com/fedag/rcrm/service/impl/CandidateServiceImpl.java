package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.impl.CandidateMapperImpl;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import com.fedag.rcrm.repos.CandidateRepo;
import com.fedag.rcrm.repos.HRRepo;
import com.fedag.rcrm.repos.VacancyRepo;
import com.fedag.rcrm.service.CandidateService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service("candidate service")
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepo candidateRepo;
    private final HRRepo hrRepo;
    private final VacancyRepo vacancyRepo;
    private final CandidateMapperImpl mapper;

    @Override
    public CandidateResponseDto getCandidate(Long id) {
        log.info("Получение кандидата с Id: {}", id);
        CandidateModel model = candidateRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("HR", "ID", id));
        CandidateResponseDto result = mapper.toCandidateResponseDto(model);
        log.info("Кандидат с Id: {} найден", id);
        return result;
    }

    @Override
    public Page<CandidateResponseDto> getAllCandidate(Pageable pageable) {
        log.info("Получение страницы с кандидатами");
        Page<CandidateResponseDto> result = candidateRepo.findAll(pageable).map(mapper::toCandidateResponseDto);
        log.info("Страница с кандидатами получена");
        return result;
    }

    @Override
    public Page<CandidateResponseDto> getAllCandidateWithStatus(Pageable pageable, String status) {
        log.info("Получение кандидата со статусом: {}", status);
        Page<CandidateResponseDto> result = candidateRepo.findAllByStatus(status, pageable).map(mapper::toCandidateResponseDto);
        log.info("Кандидат со статусом: {} получен", status);
        return result;
    }

    @Override
    @Transactional
    public CandidateResponseDto createCandidate(CandidateRequestDto dto, Long vacancyId) {
        log.info("Создание кандидата");
        CandidateResponseDto result = mapper.toCandidateResponseDto(candidateRepo.save(mapper.toCandidateModel(dto, vacancyId)));
        log.info("Кандидат создан");
        return result;
    }

    @Override
    @Transactional
    public void deleteCandidate(Long id) {
        log.info("Удаление кандидата с Id: {}", id);
        CandidateModel model = candidateRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", id));
        model.setDelete(true);
        log.info("Кандидат с Id: {} удален", id);
    }

    @Override
    @Transactional
    public CandidateResponseDto setCandidateStatus(Long id, String status) {
        log.info("Установление статуса {} кандидату с Id: {}", status, id);
        CandidateModel model = candidateRepo.findById(id).orElseThrow(() -> new RuntimeException("Candidate with id " + id + " not found"));
        model.setStatus(status);
        CandidateResponseDto result = mapper.toCandidateResponseDto(model);
        log.info("Статус {} установлен кандидату с Id: {}", status, id);
        return result;
    }

    @Override
    @Transactional
    public CandidateResponseDto updateCandidate(CandidateRequestUpdateDto dto, Long candidateId) {
        log.info("Обновление кандидата с Id: {}", candidateId);
        CandidateModel candidate = candidateRepo.findById(candidateId).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", candidateId));
        HRModel hrModel = hrRepo.findById(dto.getHrId()).get();
        VacancyModel vacancyModel = vacancyRepo.findById(dto.getVacancyId()).get();
        mapper.toCandidateModelUpdate(candidate, dto, hrModel, vacancyModel);
        CandidateResponseDto result = mapper.toCandidateResponseDto(candidate);
        log.info("Кандидат с Id: {} обновлен", candidateId);
        return result;
    }

    @Transactional
    @Override
    public void updateTotalRating(Long candidateId) {
        log.info("Обновление рейтинга кандидата с Id: {}", candidateId);
        CandidateModel candidate = candidateRepo.findById(candidateId).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", candidateId));
        candidate.updateTotalRating();
        log.info("Рейтинг кандидата с Id: {} обновлен", candidateId);
    }
}
