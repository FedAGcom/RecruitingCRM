package com.fedag.rcrm.service;

import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;

import java.util.List;

public interface HRService {
    public HRResponseDto findById(Long id);
    public HRResponseDto findByLogin(String login);
    public void addHr(HRRequestDto hrRequestDto);
    public void deleteById(Long id);
    public void update(HRRequestUpdateDto hrRequestUpdateDto);
    public List<HRResponseDto> getAllHRs();
}
