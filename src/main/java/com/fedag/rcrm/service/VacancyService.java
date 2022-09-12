package com.fedag.rcrm.service;

import com.fedag.rcrm.model.dto.request.VacancyRequestDto;
import com.fedag.rcrm.model.dto.request.VacancyRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface VacancyService {

    VacancyResponseDto findById(Long id);
    VacancyResponseDto findByTitle(String title);
    VacancyResponseDto create(VacancyRequestDto vacancyRequestDto);
    void deleteById(Long id);
    void update(VacancyRequestUpdateDto vacancyRequestUpdateDto);
    public abstract Page<VacancyResponseDto> findAll(Pageable pageable);

}
