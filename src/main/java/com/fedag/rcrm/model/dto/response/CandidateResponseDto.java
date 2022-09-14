package com.fedag.rcrm.model.dto.response;

import com.fedag.rcrm.model.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
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
    private Long hrId;
    private String status;
    private double totalRating;
    private String cvLink;
    private List<Long> experienceId; // передавать лист ExpResponseDto
    private List<Long> feedbackId; // передавать лист FeedbackResponseDto
    private String vacancyTitle;
}
