package com.fedag.rcrm.model.dto.security;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponseDto {

    private String token;
    private final String type = "Bearer";
    private Long id;
    private String login;
    private List<String> roles;

    public JwtResponseDto(String token, Long id, String login, List<String> roles) {
        this.token = token;
        this.id = id;
        this.login = login;
        this.roles = roles;
    }
}
