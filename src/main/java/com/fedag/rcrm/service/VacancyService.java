package com.fedag.rcrm.service;

import com.fedag.rcrm.model.dto.request.VacancyRequestDto;
import com.fedag.rcrm.model.dto.request.VacancyRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;
import jdk.jshell.Snippet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VacancyService {

    VacancyResponseDto findById(Long id);
    VacancyResponseDto findByTitle(String title);
    VacancyResponseDto create(VacancyRequestDto vacancyRequestDto);

    Page<VacancyResponseDto> findAllByStatus(String status, Pageable pageable);

    void deleteById(Long id);
    VacancyResponseDto update(Long id, VacancyRequestUpdateDto vacancyRequestUpdateDto);
    public abstract Page<VacancyResponseDto> findAll(Pageable pageable);
//
}
