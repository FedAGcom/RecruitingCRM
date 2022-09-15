package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import com.fedag.rcrm.service.impl.CandidateServiceImpl;
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
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/candidates")
@Api(value = "Candidate", tags = "Candidate API")
public class CandidateControllerImpl{

    private final CandidateServiceImpl candidateService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "Получение данных тз БД об одном кандидате по ID", response = CandidateModel.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные получены"),
            @ApiResponse(code = 404, message = "Кандидат не найден") } )
    public ResponseEntity<CandidateResponseDto> getCandidate(@PathVariable(name = "id") Long id) {
        final CandidateResponseDto candidate = candidateService.getCandidate(id);
        return candidate != null
                ? new ResponseEntity<>(candidate, OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @ApiOperation("Получение списка всех кандидатов в БД")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Данные получены")} )
    public ResponseEntity<Page<CandidateResponseDto>> getAllCandidate(@PageableDefault(size = 5) Pageable pageable) {
        return new ResponseEntity<>(candidateService.getAllCandidate(pageable), HttpStatus.OK);

    }

    @GetMapping(value = "/status/{status}")
    @ApiOperation("Получение списка всех кандидатов с фильтром по текущему статусу")
    public ResponseEntity<Page<CandidateResponseDto>> getAllCandidateWithStatus(
            @PageableDefault(size = 5) Pageable pageable,
            @PathVariable(name = "status") String status) {
        Page<CandidateResponseDto> candidates = candidateService.getAllCandidateWithStatus(pageable, status);
        return new ResponseEntity<>(candidates, OK);
    }

    @PostMapping
    @ApiOperation("Создание записи в БД о новом кандидате")
    public ResponseEntity<CandidateResponseDto> createCandidate(@RequestBody CandidateRequestDto requestDto, Long vacancyId) {
        return new ResponseEntity<>(candidateService.createCandidate(requestDto, vacancyId), CREATED);
    }

    @DeleteMapping(value = "/{id}")
    @ApiOperation("Маркировка данных о кандидате как подлежащих удалению")
    public ResponseEntity<?> deleteCandidate(@PathVariable(name = "id") Long id) {
        candidateService.deleteCandidate(id);
        return new ResponseEntity<>("Candidate marked as deleted", HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    @ApiOperation("Обновление данных о кандидате")
    public ResponseEntity<?> updateCandidate(@PathVariable(name = "id") Long id,
                                             @RequestBody @Valid CandidateRequestUpdateDto dto) {
        CandidateResponseDto response = candidateService.updateCandidate(dto, id);
        return new ResponseEntity<>(response, OK);
    }

    @PutMapping(value = "/change/status/{id},{status}")
    @ApiOperation("Изменение статуса кандидата")
    public ResponseEntity<CandidateResponseDto> changeStatus(
            @PathVariable(name = "id") Long id,
            @PathVariable(name = "status") String status)
    {
        return new ResponseEntity<>(candidateService.setCandidateStatus(id, status), HttpStatus.OK);
    }
}
