package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.request.VacancyRequestDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;
import com.fedag.rcrm.service.VacancyService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/vacancies")
public class VacancyControllerImpl{

    private final VacancyService vacancyService;


    @GetMapping("/{id}")
    public VacancyResponseDto findById(@PathVariable Long id){
        return vacancyService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Page<VacancyResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable){
        return  new ResponseEntity<>(vacancyService.findAll(pageable), OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> doDelete(@PathVariable Long id){
        vacancyService.deleteById(id);
        //
        return new ResponseEntity<>("vacancy deleted", HttpStatus.OK);
        //return new ResponseEntity<>(OK);
    }


    @PostMapping
    public ResponseEntity<VacancyResponseDto> createVacancy(@RequestBody VacancyRequestDto vacancyRequestDto){

        return new ResponseEntity<>(vacancyService.create(vacancyRequestDto), HttpStatus.CREATED);
    }




}
