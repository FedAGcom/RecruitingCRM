package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.mapper.impl.CandidateMapperImpl;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import com.fedag.rcrm.repos.CandidateRepo;
import com.fedag.rcrm.service.CandidateService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("candidate service")
public class CandidateServiceImpl implements CandidateService {

    private CandidateRepo repo;
    private CandidateMapperImpl mapper;

    @Override
    public CandidateResponseDto getCandidate(Long id) {
        CandidateModel model = repo.findById(id).orElseThrow(()->new RuntimeException("Candidate with id " + id + " not found"));
        return mapper.toCandidateResponseDto(model);
    }
}
