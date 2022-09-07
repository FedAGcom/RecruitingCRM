package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.mapper.CandidateMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.CandidateDto;
import com.fedag.rcrm.service.CandidateService;
import com.fedag.rcrm.service.UserService;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Service("candidate service")
public class CandidateServiceImpl implements CandidateService {

    public CandidateModel getCandidate(Long id) {
        return new CandidateModel(); // todo
    }

    public CandidateDto createCandidate(CandidateModel candidateModel) {
        return CandidateMapper.INSTANCE.toDto(candidateModel);
    }
}
