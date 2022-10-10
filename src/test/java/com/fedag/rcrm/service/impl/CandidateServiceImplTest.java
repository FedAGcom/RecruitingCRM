package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.CandidateMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.repos.CandidateRepo;
import com.fedag.rcrm.service.CandidateService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class CandidateServiceImplTest {

    @Mock
    private CandidateRepo repo;

    @Mock
    private CandidateMapper mapper;

    @InjectMocks
    private CandidateService service;

    Pageable pageable;

    @BeforeEach
    void prepareData() {
        pageable = PageRequest.of(0, 5);
    }

    @Test
    void getCandidate() {
        Long invalidId = -1L;
        Long validId = 1L;
        when(repo.findById(invalidId)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> service.getCandidate(invalidId));

        when(repo.findById(anyLong())).thenReturn(Optional.of(new CandidateModel()));
        assertDoesNotThrow(() -> service.getCandidate(validId));
    }

    @Test
    void getAllCandidate() {
        service.getAllCandidate(pageable);
        verify(repo).findAll(pageable);
    }
}