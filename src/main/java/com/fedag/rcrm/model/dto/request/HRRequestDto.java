package com.fedag.rcrm.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class HRRequestDto {
    private String firstName;
    private String lastname;
    private String login;
    private char[] password;
}
