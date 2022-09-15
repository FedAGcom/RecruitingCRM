package com.fedag.rcrm.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "Обновление отзыва", description = "Запрос для обновления отзыва")
public class FeedbackRequestUpdateDto {

    @Schema(description = "Текст отзыва",
            maxLength = 2000,
            minLength = 1, example = "someText")
    @NotBlank
    @Size(max = 2000)
    private String comment;

    @Schema(description = "Рейтинг отзыва",
            maximum = "5",
            minimum = "1",
            example = "4")
    @Min(1)
    @Max(5)
    @NotNull
    private int rating;
}
