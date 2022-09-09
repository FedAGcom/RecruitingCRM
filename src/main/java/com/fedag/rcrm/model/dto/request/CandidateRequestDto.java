package com.fedag.rcrm.model.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
public class CandidateRequestDto {
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
