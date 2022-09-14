package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.request.FeedbackRequestDto;
import com.fedag.rcrm.model.dto.request.FeedbackRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.FeedbackResponseDto;
import com.fedag.rcrm.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/feedbacks")
public class FeedbackControllerImpl {
    private final FeedbackService feedbackService;

    @GetMapping("/{id}")
    public FeedbackResponseDto findById(@PathVariable Long id){
        return feedbackService.findById(id);
    }

    @GetMapping
    public ResponseEntity<Page<FeedbackResponseDto>> findAll(@PageableDefault(size = 5) Pageable pageable){
        return new ResponseEntity<>(feedbackService.findAll(pageable), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        feedbackService.deleteById(id);
        return new ResponseEntity<>("Feedback deleted", HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<FeedbackResponseDto> update(@PathVariable Long id,
                                                @RequestBody @Valid FeedbackRequestUpdateDto feedbackRequestUpdateDto) {
        FeedbackResponseDto feedback = feedbackService.update(id, feedbackRequestUpdateDto);

        return new ResponseEntity<>(feedback, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FeedbackResponseDto> create(@RequestParam Long candidateId,
                                                      @RequestBody @Valid FeedbackRequestDto feedbackRequestDto) {
        //FeedbackResponseDto feedback = feedbackService.create(feedbackRequestDto);

        //return new ResponseEntity<>(feedback, HttpStatus.CREATED);
        return null;
    }

}
