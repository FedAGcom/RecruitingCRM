package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.FeedbackMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.request.FeedbackRequestDto;
import com.fedag.rcrm.model.dto.request.FeedbackRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.FeedbackResponseDto;
import com.fedag.rcrm.repos.CandidateRepo;
import com.fedag.rcrm.repos.FeedbackRepo;
import com.fedag.rcrm.service.CandidateService;
import com.fedag.rcrm.service.CurrentHRService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class FeedbackServiceImplTest {

    @Mock
    private FeedbackMapper feedbackMapper;

    @Mock
    private FeedbackRepo feedbackRepo;

    @Mock
    private CandidateService candidateService;

    @Mock
    private CandidateRepo candidateRepo;

    @Mock
    CurrentHRService currentHRService;

    @InjectMocks
    private FeedbackServiceImpl feedbackService;

    @Test
    public void findFeedbackByIdTestWhenIdIsValid(){
        when(feedbackRepo.findById(anyLong())).thenReturn(Optional.of(new FeedbackModel()));
        assertDoesNotThrow(()->feedbackService.findById(anyLong()));
    }

    @Test
    public void findFeedbackByIdTestWhenIdIsInvalid(){
        when(feedbackRepo.findById(-1L)).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, ()-> feedbackService.findById(-1L));
    }


    @Test
    public void findAllFeedbacksTest(){
        Pageable pageable = PageRequest.of(0, 5);
        when(feedbackRepo.findAll(pageable))
                .thenReturn(new PageImpl<>(Collections.singletonList(new FeedbackModel())));
        feedbackService.findAll(pageable);
        verify(feedbackRepo).findAll(pageable);
    }

    @Test
    public void deleteFeedbackByValidId(){
        FeedbackModel feedback = Mockito.mock(FeedbackModel.class);
        when(feedbackRepo.findById(anyLong())).thenReturn(Optional.of(feedback));
        when(feedback.getCandidate()).thenReturn(new CandidateModel());
        feedbackService.deleteById(anyLong());
        verify(feedbackRepo).deleteById(anyLong());
        verify(candidateService).updateTotalRating(feedback.getCandidate().getId());
    }

    @Test
    public void deleteFeedbackByInvalidId(){
        when(feedbackRepo.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, ()->feedbackService.deleteById(anyLong()));
    }

    @Test
    public void updateFeedbackTestWithValidId(){
        FeedbackRequestUpdateDto request = Mockito.mock(FeedbackRequestUpdateDto.class);
        when(feedbackMapper.fromRequestUpdate(request)).thenReturn(new FeedbackModel());
        when(feedbackRepo.findById(anyLong())).thenReturn(Optional.of(new FeedbackModel()));
        when(feedbackMapper.toUpdateModel(any(FeedbackModel.class), any(FeedbackModel.class))).thenReturn(new FeedbackModel());
        feedbackService.update(anyLong(), request);
        verify(feedbackRepo).save(any(FeedbackModel.class));
    }

    @Test
    public void updateFeedbackTestWithInvalidId(){
        FeedbackRequestUpdateDto request = Mockito.mock(FeedbackRequestUpdateDto.class);
        when(feedbackRepo.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, ()->feedbackService.update(anyLong(), request));
    }

    @Test
    public void createFeedbackTestWithInvalidCandidateId() {
        FeedbackRequestDto request = Mockito.mock(FeedbackRequestDto.class);
        when(candidateRepo.findById(anyLong())).thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class, ()-> feedbackService.create(anyLong(), request));
    }

    @Test
    public void createFeedbackTestWithValidCandidateId() {
        FeedbackRequestDto request = Mockito.mock(FeedbackRequestDto.class);
        CandidateModel candidate = Mockito.mock(CandidateModel.class);
        HRModel hr = Mockito.mock(HRModel.class);
        hr.setFeedbacks(new ArrayList<>());
        candidate.setFeedbacks(new ArrayList<>());
        when(currentHRService.getCurrentHR()).thenReturn(hr);
        when(candidateRepo.findById(anyLong())).thenReturn(Optional.of(candidate));
        when(feedbackMapper.fromRequest(request)).thenReturn(new FeedbackModel());
        feedbackService.create(anyLong(), request);
        verify(candidateService).updateTotalRating(anyLong());
        verify(feedbackRepo).save(any(FeedbackModel.class));
    }
}
