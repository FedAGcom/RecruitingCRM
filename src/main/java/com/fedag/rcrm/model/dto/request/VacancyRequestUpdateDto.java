package com.fedag.rcrm.model.dto.request;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class VacancyRequestUpdateDto {

    private String title;
    private String position;
    private double salary;
    private String comment;
    private String description;
    private String status;
//
}
