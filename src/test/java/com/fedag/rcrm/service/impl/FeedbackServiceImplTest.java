package com.fedag.rcrm.service.impl;

import com.fedag.rcrm.exception.EntityNotFoundException;
import com.fedag.rcrm.mapper.FeedbackMapper;
import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.dto.request.FeedbackRequestUpdateDto;
import com.fedag.rcrm.repos.FeedbackRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

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
        when(feedbackRepo.findById(anyLong())).thenReturn(Optional.of(new FeedbackModel()));
        feedbackService.deleteById(anyLong());
        verify(feedbackRepo).deleteById(anyLong());
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

}
