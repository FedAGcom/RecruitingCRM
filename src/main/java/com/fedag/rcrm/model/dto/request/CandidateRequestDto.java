package com.fedag.rcrm.model.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fedag.rcrm.model.VacancyModel;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Schema(name = "Create new candidate", description = "Create new candidate request")
public class CandidateRequestDto {

    @Schema(description = "User name",
            maxLength = 255,
            minLength = 1,
            example = "someName")
    @NotBlank
    private String firstName;

    @Schema(description = "User lastname",
            maxLength = 255,
            minLength = 1,
            example = "someLastname")
    @NotBlank
    private String lastname;

    @Schema(description = "Candidate phone number",
            maxLength = 255,
            minLength = 1,
            example = "+7-921-970-34-56")
    @NotBlank
    private String phoneNumber;

    @Schema(description = "Candidate email",
            maxLength = 255,
            minLength = 1,
            example = "some@mail.com")
    @Email
    @Size(max = 255)
    @NotBlank
    private String email;

    @Schema(description = "Candidate residence")
    private String residence;

    @Schema(description = "Candidate country")
    private String country;

    @Schema(description = "Candidate city")
    private String city;

    @Schema(description = "Candidate desired position")
    @NotBlank
    private String position;

    @Schema(description = "Candidate desired salary")
    private double salary;

    @Schema(description = "Candidate birthdate - LocalDate.class",
            example = "1990-12-13")
    private LocalDate birthdate;

    @Schema(description = "Candidate CV URL",
            example = "https:/")
    private String cvLink;
}
