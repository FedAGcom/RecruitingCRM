package com.fedag.rcrm.service;

import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


import java.util.List;

public interface HRService {
    HRResponseDto findById(Long id);
    HRResponseDto findByLogin(String login);
    void create(HRRequestDto hrRequestDto);
    void deleteById(Long id);
    void update(HRRequestUpdateDto hrRequestUpdateDto);
    Page<HRResponseDto> findAll(Pageable pageable);

}
