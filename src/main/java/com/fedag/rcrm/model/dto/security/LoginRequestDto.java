package com.fedag.rcrm.model.dto.security;

import lombok.Data;

@Data
public class LoginRequestDto {
    private String login;
    private String password;
}
