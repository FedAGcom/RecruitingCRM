package com.fedag.rcrm.model.dto.request;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "Обновление вакансии", description = "Запрос для обновления вакансии")
public class VacancyRequestUpdateDto {

    @Schema(description = "Название вакансии",
            maxLength = 255,
            minLength = 1, example = "someName")
    @NotBlank
    @Size(max = 255)
    private String title;

    @Schema(description = "Название должности",
            maxLength = 255,
            minLength = 1, example = "someName")
    @NotBlank
    @Size(max = 255)
    private String position;
    private double salary;

    @Schema(description = "Дополнительные сведения",
            maxLength = 255,
            minLength = 1, example = "someComment")
    @NotBlank
    @Size(max = 255)
    private String comment;

    @Schema(description = "Описание",
            maxLength = 255,
            minLength = 1, example = "someDescription")
    @NotBlank
    @Size(max = 255)
    private String description;

    @Schema(description = "Статус вакансии",
            maxLength = 255,
            minLength = 1, example = "someStatus")
    @NotBlank
    @Size(max = 255)
    private String status;
//
}
