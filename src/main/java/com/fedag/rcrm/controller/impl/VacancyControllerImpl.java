package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vacancies")
public class VacancyControllerImpl{


    private final VacancyService vacancyService;
    @GetMapping("/{id}")
    public VacancyDto getById(@PathVariable Long id) {
        return vacancyService.getVacancyById(id);

    }
}
