package com.fedag.rcrm.service;

import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface HRService {
    HRResponseDto findById(Long id);

    HRResponseDto findByLogin(String login);

    HRResponseDto create(HRRequestDto hrRequestDto);

    void deleteById(Long id);

    HRResponseDto update(Long id, HRRequestUpdateDto hrRequestUpdateDto);

    Page<HRResponseDto> findAll(Pageable pageable);

    Page<HRResponseDto> findAllByRole(String role, Pageable pageable);
}
