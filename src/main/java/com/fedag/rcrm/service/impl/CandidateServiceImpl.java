package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.impl.CandidateMapperImpl;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import com.fedag.rcrm.repos.CandidateRepo;
import com.fedag.rcrm.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("candidate service")
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepo repo;
    private final CandidateMapperImpl mapper;

    @Override
    public CandidateResponseDto getCandidate(Long id) {
        CandidateModel model = repo.findById(id).orElseThrow(() -> new EntityNotFoundException("HR", "ID", id));
        return mapper.toCandidateResponseDto(model);
    }

    @Override
    public Page<CandidateResponseDto> getAllCandidate(Pageable pageable) {
        return repo.findAll(pageable).map(mapper::toCandidateResponseDto);
    }

    @Override
    public Page<CandidateResponseDto> getAllCandidateWithStatus(Pageable pageable, String status) {
        return repo.findAllByStatus(status, pageable).map(mapper::toCandidateResponseDto);
    }

    //    ('NEW', 'ACCEPT', 'CV_APPROVE', 'INTERVIEW_APPOINTED',
//     'INTERVIEW_PASSED', 'ON_APPROVAL', 'OFFER', 'PROBATION',
//     'STAFF', 'DENIAL_BY_HR', 'DENIAL_BY_CANDIDATE');

    @Override
    @Transactional
    public CandidateResponseDto createCandidate(CandidateRequestDto dto, Long vacancyId) {
        return mapper.toCandidateResponseDto(repo.save(mapper.toCandidateModel(dto, vacancyId)));
    }

    @Override
    @Transactional
    public void deleteCandidate(Long id) {
        setCandidateStatus(id, "DENIAL_BY_HR");
    }

    @Override
    @Transactional
    public CandidateResponseDto setCandidateStatus(Long id, String status) {
        CandidateModel model = repo.findById(id).orElseThrow(() -> new RuntimeException("Candidate with id " + id + " not found"));
        model.setStatus(status);
        return mapper.toCandidateResponseDto(model);
    }

    @Override
    @Transactional
    public CandidateResponseDto updateCandidate(CandidateRequestUpdateDto dto, Long candidateId) {

       CandidateModel model = repo.findById(candidateId).orElseThrow(() -> new EntityNotFoundException("Candidate", "ID", candidateId));

       mapper.candidateModelMerge(model, dto);

       return mapper.toCandidateResponseDto(model);
    }


}
