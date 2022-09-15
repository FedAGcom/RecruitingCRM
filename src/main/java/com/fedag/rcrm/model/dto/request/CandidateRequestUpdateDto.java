package com.fedag.rcrm.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class CandidateRequestUpdateDto {
    private String firstName;
    private String lastname;
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
    private Long vacancyId;
    private boolean delete;
}
