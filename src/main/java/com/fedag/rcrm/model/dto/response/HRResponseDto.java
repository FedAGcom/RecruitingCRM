package com.fedag.rcrm.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "HR", description = "Информация об HR")
public class HRResponseDto {

    @Schema(description = "Идентификатор HR",
            example = "1")
    private Long id;

    @Schema(description = "Имя HR", example = "someName")
    private String firstName;

    @Schema(description = "Фамилия HR", example = "someLastname")
    private String lastname;

    @Schema(description = "Логин HR",
            example = "hr@yandex.ru")
    private String login;

    @Schema(description = "Роли HR", example = "USER")
    private String role;

    @Schema(description = "Дата создания HR", example = "2022-03-03")
    private LocalDateTime creationDate;

    @Schema(description = "Информация об удалении HR", example = "true")
    private boolean active;

    @Schema(description = "Информация о кандидатах, с которыми работает HR",
            example = "[1, 2]")
    private List<Long> candidatesId;

    @Schema(description = "Информация о вакансиях, с которыми работает HR",
            example = "[1, 2]")
    private List<Long> vacanciesId;
}
