package com.fedag.rcrm.model.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class VacancyResponseDto {

    private Long id;
    private String title;
    private String position;
    private double salary;
    private String comment;
    private String description;
    private String status;
    private boolean delete;
    private List<Long> hrsId;
    private List<Long> candidatesId;
//
}
