package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.impl.VacancyMapperImpl;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.VacancyRequestDto;
import com.fedag.rcrm.model.dto.request.VacancyRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;
import com.fedag.rcrm.repos.VacancyRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class VacancyServiceImplTest {

    @Mock
    private VacancyRepo vacancyRepo;

    @Mock
    private VacancyMapperImpl vacancyMapper;

    @InjectMocks
    private VacancyServiceImpl vacancyService;


    @Test
    void findById() {
        Long invalidId = -1L;
        Long validId = 1L;
        when(vacancyRepo.findById(invalidId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,  () -> vacancyService.findById(invalidId));
        when(vacancyRepo.findById(anyLong())).thenReturn(Optional.of(new VacancyModel()));
        assertDoesNotThrow(() -> vacancyService.findById(validId));

    }

    @Test
    void findByTitle() {
        VacancyModel vacancyModel = new VacancyModel();
        String string = "Java Developer";
        when(vacancyRepo.findByTitle(string)).thenReturn(Optional.of(vacancyModel));
        when(vacancyMapper.toResponse(vacancyModel)).thenReturn(new VacancyResponseDto());
        vacancyService.findByTitle(string);
        verify(vacancyRepo).findByTitle(string);
    }

    @Test
    void create() {
        VacancyRequestDto vacancyRequestDto = new VacancyRequestDto();
        VacancyModel vacancyModel = new VacancyModel();
        when(vacancyMapper.fromRequest(vacancyRequestDto)).thenReturn(vacancyModel);
        when(vacancyMapper.toResponse(vacancyModel)).thenReturn(new VacancyResponseDto());
        vacancyService.create(vacancyRequestDto);
        verify(vacancyRepo).save(vacancyModel);
    }

    @Test
    void findAllByStatus() {
        Pageable pageable = PageRequest.of(0,5);
        String string = "OPEN";
        when(vacancyRepo.findAllByStatusContains(string,pageable)).thenReturn(new PageImpl<>(Collections.singletonList(new VacancyModel())));
        vacancyService.findAllByStatus(string, pageable);
        verify(vacancyRepo).findAllByStatusContains(string, pageable);
    }

    @Test
    void deleteById() {
        when(vacancyRepo.findById(anyLong())).thenReturn(Optional.of(new VacancyModel()));
        vacancyService.deleteById(anyLong());
        verify(vacancyRepo).deleteById(anyLong());
        verify(vacancyRepo).findById(anyLong());
    }

    @Test
    void update() {
        VacancyRequestUpdateDto vacancyRequestUpdateDto = new VacancyRequestUpdateDto();
        VacancyModel vacancyModel = new VacancyModel();
        when(vacancyRepo.findById(anyLong())).thenReturn(Optional.of(vacancyModel));
        when(vacancyMapper.toVacancyModelUpdate(vacancyModel, vacancyRequestUpdateDto)).thenReturn(vacancyModel);
        when(vacancyMapper.toResponse(vacancyModel)).thenReturn(new VacancyResponseDto());
        vacancyService.update(anyLong(), vacancyRequestUpdateDto);
        verify(vacancyRepo).findById(anyLong());

    }

    @Test
    void findAll() {
        Pageable pageable = PageRequest.of(0,5);
        when(vacancyRepo.findAll(pageable)).thenReturn(new PageImpl<>(Collections.singletonList(new VacancyModel())));
        vacancyService.findAll(pageable);
        verify(vacancyRepo).findAll(pageable);
    }
}