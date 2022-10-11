package com.fedag.rcrm.controller.impl;

import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestDto;
import com.fedag.rcrm.model.dto.request.ExpOfWorkRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.ExpOfWorkResponseDto;
import com.fedag.rcrm.service.impl.ExpOfWorkServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/candidate/exp/")
@Api(value = "ExpOfWork", tags = "ExpOfWork API")
public class ExpOfWorkControllerImpl {

    private final ExpOfWorkServiceImpl service;

    @Operation(summary = "Get all candidate exp of work ")
    @ApiResponse(responseCode = "200", description = "Candidate found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Client error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "Candidate not found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Server error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/candidate={id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<Page<ExpOfWorkResponseDto>> getAllExpOfWorkByCandidateId(@PathVariable(name = "id") Long candidateId,
                                                                                   @PageableDefault(size = 5) Pageable pageable) {
        return new ResponseEntity<>(service.getAllCandidateExperience(pageable, candidateId), HttpStatus.OK);
    }

    @Operation(summary = "Get candidate exp of work by exp id")
    @ApiResponse(responseCode = "200", description = "Exp found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Client error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "Exp not found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Server error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ExpOfWorkResponseDto> getCandidateExpOfWorkByExpId(@PathVariable(name = "id") Long id) {
        return new ResponseEntity<>(service.getCandidateExperienceByExpId(id), HttpStatus.OK);
    }

    @Operation(summary = "Add exp of work to candidate")
    @ApiResponse(responseCode = "200", description = "Exp was added",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Client error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "Candidate not found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Server error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PostMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ExpOfWorkResponseDto> addExpOfWork(@PathVariable(name = "id") Long candidateId, @RequestBody ExpOfWorkRequestDto dto) {
        return new ResponseEntity<>(service.addExpOfWork(dto, candidateId), HttpStatus.OK);
    }

    @Operation(summary = "Mark candidate exp by id as delete")
    @ApiResponse(responseCode = "200", description = "Exp was mark as delete",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Client error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "Exp not found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Server error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @DeleteMapping
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity deleteExpOfWorkById(@PathVariable(name = "id") Long id) {
        service.deleteExpOfWorkById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @Operation(summary = "Update candidate exp by expId")
    @ApiResponse(responseCode = "200", description = "Exp update",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "400", description = "Client error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "404", description = "Exp not found",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @ApiResponse(responseCode = "500", description = "Server error",
            content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE)})
    @PutMapping("/id")
    @PreAuthorize("hasAuthority('USER')")
    public ResponseEntity<ExpOfWorkResponseDto> updateCandidateExpOfWork(@PathVariable(name = "id") Long id,
                                                                         @RequestBody ExpOfWorkRequestUpdateDto updateDto) {
        return new ResponseEntity<>(service.updateExpOfWork(updateDto, id), HttpStatus.OK);
    }
}
