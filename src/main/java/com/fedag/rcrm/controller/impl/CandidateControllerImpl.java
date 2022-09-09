package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import com.fedag.rcrm.service.impl.CandidateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/candidate")
public class CandidateControllerImpl{

    private final CandidateServiceImpl candidateService;

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CandidateResponseDto getCandidate(@PathVariable Long id) {
        return candidateService.getCandidate(id);
    }

//    todo
//    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    public CandidateRequestDto createCandidate(@RequestBody CandidateRequestDto request) {
//        return null;
//    }


}
