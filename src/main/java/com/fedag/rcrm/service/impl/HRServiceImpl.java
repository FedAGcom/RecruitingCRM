package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.mapper.HRMapper;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.repos.HRRepo;
import com.fedag.rcrm.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HRServiceImpl implements UserService {

    private final HRRepo hrRepo;

    private final HRMapper hrMapper;


    public HRDto getHR(Long id) {
        Optional<HRModel>  hrModel = hrRepo.findById(id);

        if(hrModel.isPresent()){
            System.out.println(hrModel.get().getCandidate().get(0).getFirstName());
            System.out.println(hrModel.get().getCandidate().get(0).getId());
            System.out.println(hrModel.get().getCandidate().get(0).getLastname());
            System.out.println(hrModel.get().getCandidate().get(0).getPhoneNumber());
            System.out.println(hrModel.get().getCandidate().get(0).getEmail());
            System.out.println(hrModel.get().getCandidate().get(0).getResidence());
            System.out.println(hrModel.get().getCandidate().get(0).getCountry());
            System.out.println(hrModel.get().getCandidate().get(0).getCity());
            System.out.println(hrModel.get().getCandidate().get(0).getPosition());
            System.out.println(hrModel.get().getCandidate().get(0).getSalary());
            System.out.println(hrModel.get().getCandidate().get(0).getBirthdate());
            System.out.println(hrModel.get().getCandidate().get(0).getSalary());
            System.out.println(hrModel.get().getCandidate().get(0).getHr().getId());
            System.out.println(hrModel.get().getCandidate().get(0).getStatus());
            System.out.println(hrModel.get().getCandidate().get(0).getTotalRating());
            System.out.println(hrModel.get().getCandidate().get(0).getExperienceOfWorksList().get(0).getPosition());
            System.out.println(hrModel.get().getCandidate().get(0).getVacancy().getPosition());
            System.out.println(hrModel.get().getCandidate().get(0).getFeedback().get(0).getComment());
            System.out.println("");
            HRDto hrDto = hrMapper.toDto(hrModel.get());
            System.out.println("");
            return hrDto;
        }
        else{
            return new HRDto();
        }
    }

}
