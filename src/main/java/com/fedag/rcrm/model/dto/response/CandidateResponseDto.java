package com.fedag.rcrm.model.dto.response;

import com.fedag.rcrm.model.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
public class CandidateResponseDto extends UserModel {
    private String phoneNumber;
    private String email;
    private String residence;
    private String country;
    private String city;
    private String position;
    private double salary;
    private LocalDate birthdate;
    private LocalDateTime creationDate;
    private HRModel hr;
    private String status;
    private double totalRating;
    private String cvLink;
    private List<Long> experienceId;
    private List<Long> feedbackId;
    private VacancyModel vacancy;
}
