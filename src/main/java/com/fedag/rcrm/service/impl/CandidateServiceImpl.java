package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.mapper.CandidateMapper;
import com.fedag.rcrm.mapper.CycleAvoidingMappingContext;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.CandidateDto;
import com.fedag.rcrm.model.dto.VacancyDto;
import com.fedag.rcrm.repos.CanditateRepo;
import com.fedag.rcrm.service.CandidateService;
import com.fedag.rcrm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("candidate service")
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private static int count = 0;

    private final CandidateMapper candidateMapper;
    private final CanditateRepo candidateRepo;

    //private final CandidateMapper candidateMapper;


    public CandidateDto getCandidate(Long id) {
        Optional<CandidateModel> candidateModel = candidateRepo.findById(id);

        if(candidateModel.isPresent()){
//            for(int i = 0; i < candidateModel.get().getExperienceOfWorksList().size(); ++i){
//                System.out.println(candidateModel.get().getExperienceOfWorksList().get(i).getPosition() +
//                        candidateModel.get().getExperienceOfWorksList().get(i).getCandidate().getId());
//            }
            return candidateMapper.toDto(candidateModel.get(), new CycleAvoidingMappingContext());
        }
        else{
            return new CandidateDto();
        }
    }

    public CandidateDto createCandidate(CandidateModel candidateModel) {
        return CandidateMapper.INSTANCE.toDto(candidateModel, new CycleAvoidingMappingContext());
    }
}
