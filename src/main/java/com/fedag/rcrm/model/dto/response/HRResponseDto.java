package com.fedag.rcrm.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HRResponseDto {
    private Long id;
    private String firstName;
    private String lastname;
    private List<String> roles;
    private LocalDateTime creationDate;
    private List<Long> candidatesId;
    private List<Long> vacanciesId;
}
