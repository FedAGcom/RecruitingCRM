package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.FeedbackMapper;
import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.dto.request.FeedbackRequestDto;
import com.fedag.rcrm.model.dto.request.FeedbackRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.FeedbackResponseDto;
import com.fedag.rcrm.repos.CandidateRepo;
import com.fedag.rcrm.repos.FeedbackRepo;
import com.fedag.rcrm.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackMapper feedbackMapper;
    private final FeedbackRepo feedbackRepo;
    private final CandidateRepo candidateRepo;

    @Override
    public FeedbackResponseDto findById(Long id) {
        log.info("Поиск отзыва с Id: {}", id);
        FeedbackModel feedbackModel = feedbackRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Feedback", "id", id));
        FeedbackResponseDto result = feedbackMapper.toResponse(feedbackModel);
        log.info("Отзыв с Id: {} найден", id);
        return result;
    }

    @Override
    public Page<FeedbackResponseDto> findAll(Pageable pageable) {
        log.info("Получение страницы с отзывами");
        Page<FeedbackResponseDto> result = feedbackRepo.findAll(pageable).map(feedbackMapper::toResponse);
        log.info("Страница с отзывами получена");
        return result;
    }

    @Transactional
    @Override
    public FeedbackResponseDto create(Long candidateId, FeedbackRequestDto feedbackRequestDto) {
        /*FeedbackModel feedback = feedbackMapper.fromRequest(feedbackRequestDto);
        HRModel hr = currentUserService.getCurrentUser();
        hr.addFeedback(feedback);
        CandidateModel candidate = candidateRepo.findById(candidateId)
                .orElseThrow(()->new EntityNotFoundException("Candidate", "id", candidateId));
        candidate.addFeedback(feedback);
        FeedbackModel result = feedbackRepo.save(feedback);
        return feedbackMapper.toResponse(result);*/
        return null;
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        log.info("Удаление отзыва с Id: {}", id);
        this.findById(id);
        feedbackRepo.deleteById(id);
        log.info("Отзыв с Id: {} удален", id);
    }

    @Transactional
    @Override
    public FeedbackResponseDto update(Long id, FeedbackRequestUpdateDto feedbackRequestUpdateDto) {
        log.info("Обновление отзыва с Id: {}", id);
        FeedbackModel updateModel = feedbackMapper.fromRequestUpdate(feedbackRequestUpdateDto);
        FeedbackModel modelFromBD= feedbackRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Feedback", "ID", id));
        FeedbackModel update = feedbackMapper.toUpdateModel(updateModel, modelFromBD);
        FeedbackResponseDto result = feedbackMapper.toResponse(feedbackRepo.save(update));
        log.info("Отзыв с Id: {} обновлен", id);
        return result;
    }
}
