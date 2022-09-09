package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.mapper.HRMapper;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import com.fedag.rcrm.repos.HRRepo;
import com.fedag.rcrm.service.HRService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class HRServiceImpl implements HRService {
    private final HRMapper hrMapper;
    private final HRRepo hrRepo;

    @Override
    public HRResponseDto findById(Long id) {
        HRModel hrModel = hrRepo.findById(id).orElseThrow(()->new RuntimeException("HR with id " + id + " not found"));
        return hrMapper.toResponse(hrModel);
    }

    @Override
    public HRResponseDto findByLogin(String login) {
        HRModel hrModel = hrRepo.findByLogin(login).orElseThrow(()-> new RuntimeException("HR with login" +
                login + " not found"));
        return hrMapper.toResponse(hrModel);
    }

    @Override
    public List<HRResponseDto> getAllHRs() {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(HRRequestUpdateDto hrRequest) {
        HRModel hrModel = hrMapper.fromRequestUpdate(hrRequest);
        hrRepo.save(hrModel);
    }

    @Override
    public void addHr(HRRequestDto hrRequest) {

    }
}
