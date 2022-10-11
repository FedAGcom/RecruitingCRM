package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.impl.CandidateMapperImpl;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.repos.CandidateRepo;
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
class CandidateServiceImplTest {

    @Mock
    private CandidateRepo candidateRepo;

    @Mock
    private CandidateMapperImpl mapper;

    @InjectMocks
    private CandidateServiceImpl service;

    @Test
    void getCandidateWithValidIdTest() {
        when(candidateRepo.findById(anyLong())).thenReturn(Optional.of(new CandidateModel()));
        assertDoesNotThrow(() -> service.getCandidate(anyLong()));
    }

    @Test
    void getCandidateWithInvalidIdTest() {
        when(candidateRepo.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, () -> service.getCandidate(anyLong()));
    }

    @Test
    void getAllCandidateTest() {
        Pageable pageable = PageRequest.of(0, 5);
        when(candidateRepo.findAll(pageable))
                .thenReturn(new PageImpl<>(Collections.singletonList(new CandidateModel())));
        service.getAllCandidate(pageable);
        verify(candidateRepo).findAll(pageable);
    }
}