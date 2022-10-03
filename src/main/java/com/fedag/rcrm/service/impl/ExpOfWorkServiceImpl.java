package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.impl.ExpOfWorkMapperImpl;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.ExpOfWorkModel;
import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestDto;
import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.ExpOfWorkResponseDto;
import com.fedag.rcrm.repos.CandidateRepo;
import com.fedag.rcrm.repos.ExpOfWorkRepo;
import com.fedag.rcrm.service.ExpOfWorkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExpOfWorkServiceImpl implements ExpOfWorkService {

    private final ExpOfWorkRepo expRepo;
    private final CandidateRepo candidateRepo;
    private final ExpOfWorkMapperImpl expMapper;

    @Override
    public ExpOfWorkResponseDto getCandidateExperienceByExpId(Long expId) {
        log.info("Получение опыта кандидата с Id: {}", expId);
        ExpOfWorkModel model = expRepo.findById(expId).orElseThrow(() -> new EntityNotFoundException("Experience of work", "ID", expId));
        ExpOfWorkResponseDto result = expMapper.toExpResponseDto(model);
        log.info("Опыт кандидата с Id: {} получен", expId);
        return result;
    }

    @Override
    public Page<ExpOfWorkResponseDto> getAllCandidateExperience(Pageable pageable, Long candidateId) {
        log.info("Получение страницы с опытом кандидата");
        Page<ExpOfWorkResponseDto> result = expRepo.findAllByDeleteFalse(pageable).map(expMapper::toExpResponseDto);
        log.info("Страница с опытом кандидата получена");
        return result;
    }

    @Override
    @Transactional
    public ExpOfWorkResponseDto addExpOfWork(ExpOfWorkRequestDto request, Long candidateId) {
        log.info("Добавление опыта работы кандидату с Id: {}", candidateId);
        ExpOfWorkModel model = expMapper.toExpModelRequest(request, candidateId);
        ExpOfWorkResponseDto result = expMapper.toExpResponseDto(expRepo.save(model));
        log.info("Опыт работы кандидату с Id: {} добавлен", candidateId);
        return result;
    }

    @Override
    @Transactional
    public ExpOfWorkResponseDto updateExpOfWork(ExpOfWorkRequestUpdateDto requestUpdate, Long id) {
        log.info("Обновление опыта работы с Id: {}", id);
        ExpOfWorkModel model = expRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Exp of work", "ID", id));
        CandidateModel candidateModel = candidateRepo.findById(requestUpdate.getCandidateId())
                .orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", requestUpdate.getCandidateId()));
        ExpOfWorkResponseDto result = expMapper.toExpResponseDto(expMapper.toExpModelUpdate(model, requestUpdate, candidateModel));
        log.info("Опыт работы с Id: {} обновлен", id);
        return result;
    }

    @Override
    @Transactional
    public void deleteExpOfWorkById(Long expId) {
        log.info("Удаление опыта с Id: {}", expId);
        ExpOfWorkModel model = expRepo.findById(expId).orElseThrow(() -> new EntityNotFoundException("Exp", "ID", expId));
        model.setDelete(true);
        log.info("Опыт работы с Id: {} удален", expId);
    }

    @Override
    @Transactional
    public void deleteAllCandidateExp(Long candidateId) {
        log.info("Удаление всего опыта кандидата с Id: {}", candidateId);
        CandidateModel model = candidateRepo.findById(candidateId).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", candidateId));
        for (ExpOfWorkModel exp : model.getExperienceOfWorksList()) {
            exp.setDelete(true);
        }
        log.info("Весь опыт кандидата с Id: {} удален", candidateId);
    }
}
