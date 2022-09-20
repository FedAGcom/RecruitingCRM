package com.fedag.rcrm.model.dto.response;

import com.fedag.rcrm.model.*;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CandidateResponseDto extends UserModel {

    @Schema(description = "Candidate phone number",
            maxLength = 255,
            minLength = 1,
            example = "+7-921-970-34-56")
    private String phoneNumber;

    @Schema(description = "Candidate email",
            maxLength = 255,
            minLength = 1,
            example = "some@mail.com")
    private String email;

    @Schema(description = "Candidate residence")
    private String residence;

    @Schema(description = "Candidate country")
    private String country;

    @Schema(description = "Candidate city")
    private String city;

    @Schema(description = "Candidate desired position")
    private String position;

    @Schema(description = "Candidate desired salary")
    private double salary;

    @Schema(description = "Candidate birthdate - LocalDate.class",
            example = "1990-12-13")
    private LocalDate birthdate;

    @Schema(description = "Candidate creation date - LocalDateTime.class")
    private LocalDateTime creationDate;

    @Schema(description = "ID HR who works with this candidate")
    private Long hrId;

    @Schema(description = "Candidate current status")
    private String status;

    @Schema(description = "Candidate total rating, double",
            example = "5.3")
    private double totalRating;

    @Schema(description = "Candidate CV URL")
    private String cvLink;

    @Schema(description = "Candidate exp ID list",
            example = "[1, 2, 3]")
    private List<Long> experienceId; // передавать лист ExpOfWorkResponseDto

    @Schema(description = "Candidate feedbacks ID",
            example = "[1, 2, 3]")
    private List<Long> feedbackId; // передавать лист FeedbackResponseDto

    @Schema(description = "Vacancy title")
    private String vacancyTitle;

    @Schema(description = "Delete status. If true - candidate marks for delete")
    private boolean delete;
}
