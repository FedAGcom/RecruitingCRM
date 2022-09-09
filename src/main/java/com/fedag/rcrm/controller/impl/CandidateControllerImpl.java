package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.service.impl.CandidateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
public class CandidateControllerImpl {

    private final CandidateServiceImpl candidateService;

    @GetMapping(value = "/get{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CandidateRequestDto getCandidate(@PathVariable Long id) {
        return candidateService.getCandidate(id);
    }
}
