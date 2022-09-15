package com.fedag.rcrm.model.dto.request;

import com.fedag.rcrm.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "Создание HR", description = "Запрос для создания HR")
public class HRRequestDto {

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

    @Schema(description = "Роль HR",
            example = "USER")
    @NotNull
    private Set<Role> roles;

    @Schema(description = "Email HR",
            maxLength = 255,
            minLength = 1,
            example = "some@mail.com")
    @Email
    @Size(max = 255)
    private String login;

    @Schema(description = "Пароль HR",
            maxLength = 255,
            minLength = 1,
            example = "qwerty")
    @NotBlank
    @Size(max = 255)
    private char[] password;
}
