package com.fedag.rcrm.model.dto.security;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequestDto {
    private String login;
    private String password;
}
