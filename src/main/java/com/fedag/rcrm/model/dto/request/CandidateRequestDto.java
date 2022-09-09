package com.fedag.rcrm.model.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class CandidateRequestDto {

    private String email;
    private String position;
    private double salary;
    private LocalDateTime creationDate;
    private HRRequestDto hr;
    private String status;
    private VacancyRequestDto vacancy;
}
