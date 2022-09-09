package com.fedag.rcrm.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class HRRequestUpdateDto {
    private String firstName;
    private String lastname;
    private String login;
    private String password;
}
