package com.fedag.rcrm.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class HRRequestDto {
    private String firstName;
    private String lastname;
    private String login;
    private char[] password;
    private List<String> roles;
}
