package com.fedag.rcrm.model.dto.security;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtResponse {

    private String token;
    private String type = "Bearer";
    private Long id;
    private String login;
    private List<String> roles;

    public JwtResponse(String token, String type, Long id, String login, List<String> roles) {
        this.token = token;
        this.type = type;
        this.id = id;
        this.login = login;
        this.roles = roles;
    }
}
