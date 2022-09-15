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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("candidate service")
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepo candidateRepo;
    private final HRRepo hrRepo;
    private final VacancyRepo vacancyRepo;
    private final CandidateMapperImpl mapper;

    @Override
    public CandidateResponseDto getCandidate(Long id) {
        CandidateModel model = candidateRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("HR", "ID", id));
        return mapper.toCandidateResponseDto(model);
    }

    @Override
    public Page<CandidateResponseDto> getAllCandidate(Pageable pageable) {
        return candidateRepo.findAll(pageable).map(mapper::toCandidateResponseDto);
    }

    @Override
    public Page<CandidateResponseDto> getAllCandidateWithStatus(Pageable pageable, String status) {
        return candidateRepo.findAllByStatus(status, pageable).map(mapper::toCandidateResponseDto);
    }

    @Override
    @Transactional
    public CandidateResponseDto createCandidate(CandidateRequestDto dto, Long vacancyId) {
        return mapper.toCandidateResponseDto(candidateRepo.save(mapper.toCandidateModel(dto, vacancyId)));
    }

    @Override
    @Transactional
    public void deleteCandidate(Long id) {
        CandidateModel model = candidateRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", id));
        model.setDelete(true);
    }

    @Override
    @Transactional
    public CandidateResponseDto setCandidateStatus(Long id, String status) {
        CandidateModel model = candidateRepo.findById(id).orElseThrow(() -> new RuntimeException("Candidate with id " + id + " not found"));
        model.setStatus(status);
        return mapper.toCandidateResponseDto(model);
    }

    @Override
    @Transactional
    public CandidateResponseDto updateCandidate(CandidateRequestUpdateDto dto, Long candidateId) {

        CandidateModel candidate = candidateRepo.findById(candidateId).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", candidateId));
        HRModel hrModel = hrRepo.findById(dto.getHrId()).get();
        VacancyModel vacancyModel = vacancyRepo.findById(dto.getVacancyId()).get();
        mapper.toCandidateModelUpdate(candidate, dto, hrModel, vacancyModel);
        return mapper.toCandidateResponseDto(candidate);
    }
}
