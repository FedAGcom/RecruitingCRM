package com.fedag.rcrm.model.dto;

import com.fedag.rcrm.model.CandidateModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class ExperienceOfWorkDto {

    private CandidateDto candidateDto;

    private String position;

    private LocalDate date_start;

    private LocalDate date_end;

    private String comment;

}
