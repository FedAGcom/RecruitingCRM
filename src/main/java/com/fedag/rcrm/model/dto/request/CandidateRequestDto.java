package com.fedag.rcrm.model.dto.request;

import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.VacancyModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class CandidateRequestDto {
    private String phoneNumber;
    private String email;
    private String residence;
    private String country;
    private String city;
    private String position;
    private double salary;
    private LocalDate birthdate;
    private String cvLink;
    private VacancyModel vacancy;
}
