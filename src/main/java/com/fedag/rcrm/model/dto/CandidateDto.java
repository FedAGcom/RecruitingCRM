package com.fedag.rcrm.model.dto;


import com.fedag.rcrm.model.ExperienceOfWorkModel;
import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.VacancyModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@RequiredArgsConstructor
public class CandidateDto {

    private Long id;

    private String phoneNumber;

    private String email;

    private String residence;

    private String country;

    private String city;

    private String position;

    private double salary;

    private LocalDate birthdate;

    private LocalDateTime creationDate;

    private HRDto hr;

    private String status;

    private double totalRating;

    private String cvLink;

    private List<ExperienceOfWorkDto> experienceOfWorksListDto;

    private List<FeedbackDto> feedbackDto;

    private VacancyDto vacancy;

}
