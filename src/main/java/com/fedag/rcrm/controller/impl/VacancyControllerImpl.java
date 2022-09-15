package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.request.VacancyRequestDto;
import com.fedag.rcrm.model.dto.request.VacancyRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;
import com.fedag.rcrm.service.VacancyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.OK;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/vacancies")
@Api(description = "Контроллер для управления вакансиями")
public class VacancyControllerImpl{

    private final VacancyService vacancyService;


    @GetMapping("/{id}")
    @ApiOperation("Получения вакансии по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ОК"),
            @ApiResponse(code = 401, message = "Пользователь не авторизован"),
            @ApiResponse(code = 403, message = "Доступ запрещён"),
            @ApiResponse(code = 404, message = "Страница не найдена")
    })
    public VacancyResponseDto findById(@PathVariable Long id){
        return vacancyService.findById(id);
    }

    @GetMapping
    @ApiOperation("Получения всех доступных вакансий")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ОК"),
            @ApiResponse(code = 401, message = "Пользователь не авторизован"),
            @ApiResponse(code = 403, message = "Доступ запрещён"),
            @ApiResponse(code = 404, message = "Страница не найдена")
    })
    public ResponseEntity<Page<VacancyResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable){
        return  new ResponseEntity<>(vacancyService.findAll(pageable), OK);
    }


    @GetMapping("/status/{status}")
    @ApiOperation("Получения всех вакансий по заданному статусу")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ОК"),
            @ApiResponse(code = 401, message = "Пользователь не авторизован"),
            @ApiResponse(code = 403, message = "Доступ запрещён"),
            @ApiResponse(code = 404, message = "Страница не найдена")
    })
    public ResponseEntity<Page<VacancyResponseDto>> findAllByStatus(@PageableDefault(size = 5) Pageable pageable, @PathVariable String status){
        return  new ResponseEntity<>(vacancyService.findAllByStatus(status.toUpperCase(), pageable), OK);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Удаление вакансии по id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ОК"),
            @ApiResponse(code = 204, message = "Пустое сообщение в ответе"),
            @ApiResponse(code = 401, message = "Пользователь не авторизован"),
            @ApiResponse(code = 403, message = "Доступ запрещён")
    })
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        vacancyService.deleteById(id);
        return new ResponseEntity<>("vacancy deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    @ApiOperation("Обновление содержимого существующей вакансии")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ОК"),
            @ApiResponse(code = 201, message = "Вакансия обновлена"),
            @ApiResponse(code = 401, message = "Пользователь не авторизован"),
            @ApiResponse(code = 403, message = "Доступ запрещён"),
            @ApiResponse(code = 404, message = "Страница не найдена")
    })
    public ResponseEntity<VacancyResponseDto> update(@PathVariable Long id,
                                                @RequestBody @Valid VacancyRequestUpdateDto vacancyRequestUpdateDto) {
        return new ResponseEntity<>(vacancyService.update(id, vacancyRequestUpdateDto), HttpStatus.OK);
    }



    @PostMapping
    @ApiOperation("Создание вакансии")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "ОК"),
            @ApiResponse(code = 201, message = "Вакансия создана"),
            @ApiResponse(code = 401, message = "Пользователь не авторизован"),
            @ApiResponse(code = 403, message = "Доступ запрещён"),
            @ApiResponse(code = 404, message = "Страница не найдена")
    })
    public ResponseEntity<VacancyResponseDto> createVacancy(@RequestBody VacancyRequestDto vacancyRequestDto){

        return new ResponseEntity<>(vacancyService.create(vacancyRequestDto), HttpStatus.CREATED);
    }




}
