package com.fedag.rcrm.controller.impl;


import com.fedag.rcrm.mapper.VacancyMapper;
import com.fedag.rcrm.model.dto.VacancyDto;
import com.fedag.rcrm.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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



//
//
//    public void deleteVacancy(Long id) {
//
//    }


//    public void updateVacancy(VacancyDao vacancyDao, Long id) {
//
//    }
}
