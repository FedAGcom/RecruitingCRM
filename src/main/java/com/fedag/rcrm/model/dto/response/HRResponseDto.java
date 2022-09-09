package com.fedag.rcrm.model.dto.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class HRResponseDto {
    private Long id;
    private String firstName;
    private String lastname;
    private List<String> roles;
    private LocalDateTime creationDate;
    private List<Long> candidatesId;
    private List<Long> vacanciesId;
}
