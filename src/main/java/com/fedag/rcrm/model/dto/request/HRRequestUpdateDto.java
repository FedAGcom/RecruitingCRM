package com.fedag.rcrm.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HRRequestUpdateDto {
    private String firstName;
    private String lastname;
    private String login;
}
