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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class ExpOfWorkServiceImpl implements ExpOfWorkService {

    private final ExpOfWorkRepo expRepo;
    private final CandidateRepo candidateRepo;
    private final ExpOfWorkMapperImpl expMapper;

    @Override
    public ExpOfWorkResponseDto getCandidateExperienceByExpId(Long expId) {
        ExpOfWorkModel model = expRepo.findById(expId).orElseThrow(() -> new EntityNotFoundException("Experience of work", "ID", expId));
        return expMapper.toExpResponseDto(model);
    }

    @Override
    public Page<ExpOfWorkResponseDto> getAllCandidateExperience(Pageable pageable, Long candidateId) {
        return expRepo.findAllByDeleteFalse(pageable).map(expMapper::toExpResponseDto);
    }

    @Override
    @Transactional
    public ExpOfWorkResponseDto addExpOfWork(ExpOfWorkRequestDto request, Long candidateId) {
        ExpOfWorkModel model = expMapper.toExpModelRequest(request, candidateId);
        return expMapper.toExpResponseDto(expRepo.save(model));
    }

    @Override
    @Transactional
    public ExpOfWorkResponseDto updateExpOfWork(ExpOfWorkRequestUpdateDto requestUpdate, Long id) {
        ExpOfWorkModel model = expRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Exp of work", "ID", id));
        CandidateModel candidateModel = candidateRepo.findById(requestUpdate.getCandidateId()).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", requestUpdate.getCandidateId()));
        return expMapper.toExpResponseDto(expMapper.toExpModelUpdate(model, requestUpdate, candidateModel));
    }

    @Override
    @Transactional
    public void deleteExpOfWorkById(Long expId) {
        ExpOfWorkModel model = expRepo.findById(expId).orElseThrow(() -> new EntityNotFoundException("Exp", "ID", expId));
        model.setDelete(true);
    }

    @Override
    @Transactional
    public void deleteAllCandidateExp(Long candidateId) {
        CandidateModel model = candidateRepo.findById(candidateId).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", candidateId));
        for (ExpOfWorkModel exp : model.getExperienceOfWorksList()) {
            exp.setDelete(true);
        }
    }
}
