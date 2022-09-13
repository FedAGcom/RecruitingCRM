package com.fedag.rcrm.model.dto.request;

import com.fedag.rcrm.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class HRRequestDto {
    private String firstName;
    private String lastname;
    private Set<Role> roles;
    private String login;
    private char[] password;
}
