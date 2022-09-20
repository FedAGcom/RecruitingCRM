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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FeedbackServiceImpl implements FeedbackService {
    private final FeedbackMapper feedbackMapper;
    private final FeedbackRepo feedbackRepo;
    private final CandidateRepo candidateRepo;

    @Override
    public FeedbackResponseDto findById(Long id) {
        FeedbackModel feedbackModel = feedbackRepo.findById(id)
                .orElseThrow(()->new EntityNotFoundException("Feedback", "id", id));
        return feedbackMapper.toResponse(feedbackModel);
    }

    @Override
    public Page<FeedbackResponseDto> findAll(Pageable pageable) {
        return feedbackRepo.findAll(pageable).map(feedbackMapper::toResponse);
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
        this.findById(id);
        feedbackRepo.deleteById(id);
    }

    @Transactional
    @Override
    public FeedbackResponseDto update(Long id, FeedbackRequestUpdateDto feedbackRequestUpdateDto) {
        FeedbackModel updateModel = feedbackMapper.fromRequestUpdate(feedbackRequestUpdateDto);
        FeedbackModel modelFromBD= feedbackRepo.findById(id).orElseThrow(()->new EntityNotFoundException("Feedback", "ID", id));
        FeedbackModel update = feedbackMapper.toUpdateModel(updateModel, modelFromBD);
        return feedbackMapper.toResponse(feedbackRepo.save(update));
    }
}
