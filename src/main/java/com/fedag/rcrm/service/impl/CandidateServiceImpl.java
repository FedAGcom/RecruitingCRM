package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.mapper.CandidateMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.repos.CanditateRepo;
import com.fedag.rcrm.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("candidate service")
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateMapper candidateMapper;
    private final CanditateRepo candidateRepo;

    @Override
    public CandidateRequestDto getCandidate(Long id) {

        Optional<CandidateModel> candidateModel = candidateRepo.findById(id);

        if(candidateModel.isPresent()){
            return candidateMapper.toRequestDto(candidateModel.get());
        }
        else{
            return new CandidateRequestDto();
        }
    }
}
