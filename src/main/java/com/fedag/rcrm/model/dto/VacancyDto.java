package com.fedag.rcrm.model.dto;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class VacancyDto {

    private String title;

    private String position;

    private double salary;

    private LocalDateTime creationDate;

    private String comment;

    private String description;

    private String status;

}
