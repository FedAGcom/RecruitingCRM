package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.controller.UserController;
import com.fedag.rcrm.mapper.CandidateMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.CandidateDto;
import com.fedag.rcrm.service.impl.CandidateServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class CandidateControllerImpl implements UserController {

    private final CandidateServiceImpl candidateService;

    @GetMapping(value = "/candidate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CandidateDto getCandidate(@PathVariable Long id) {
        return new CandidateDto();
    }

//    @GetMapping(value = "/candidate/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
//    public CandidateDto getCandidate(@PathVariable Long id) {
//        return CandidateMapper.INSTANCE.toDto(candidateService.getCandidate(id));
//    }

    //todo
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public CandidateModel createCandidate(@RequestBody CandidateDto candidateDto) {
        return CandidateMapper.INSTANCE.toModel(candidateDto);
    }


}
