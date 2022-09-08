package com.fedag.rcrm.model.dto;

import com.fedag.rcrm.enums.Role;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.VacancyModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@RequiredArgsConstructor
public class HRDto {

    private String login;

    private char[] password;

    private Set<Role> roles;

    private LocalDateTime creationDate;

    private List<CandidateDto> candidateDto;

    private List<VacancyDto> vacancies;

}
