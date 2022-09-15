package com.fedag.rcrm.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "Обновление HR", description = "Запрос для обновления HR")
public class HRRequestUpdateDto {

    @Schema(description = "Имя HR",
            maxLength = 255,
            minLength = 1, example = "someName")
    @NotBlank
    @Size(max = 255)
    private String firstName;

    @Schema(description = "Фамилия HR",
            maxLength = 255,
            minLength = 1, example = "someLastname")
    @NotBlank
    @Size(max = 255)
    private String lastname;

    @Schema(description = "Email HR",
            maxLength = 255,
            minLength = 1,
            example = "some@mail.com")
    @Email
    @Size(max = 255)
    private String login;

}
