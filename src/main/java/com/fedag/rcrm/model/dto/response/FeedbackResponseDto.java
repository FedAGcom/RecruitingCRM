package com.fedag.rcrm.model.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
@Schema(name = "Отзыв", description = "Информация об отзыве")
public class FeedbackResponseDto {

    @Schema(description = "Идентификатор отзыва",
            example = "1")
    private Long id;

    @Schema(description = "Идентификатор кандидата, которому оставили отзыв", example = "1")
    private Long candidateId;

    @Schema(description = "Идентификатор HR оставившего отзыв", example = "1")
    private Long hrId;

    @Schema(description = "Рейтинг отзыва",
            maximum = "5",
            minimum = "1",
            example = "2")
    private int rating;

    @Schema(description = "Текст отзыва",
            maxLength = 2000,
            minLength = 1,
            example = "some text")
    private String comment;

    @Schema(description = "Дата создания отзыва", example = "2022-02-03")
    private LocalDateTime created;

    @Schema(description = "Дата обновления отзыва", example = "2022-04-03")
    private LocalDateTime updated;

    @Schema(description = "Информация об удалении отзыва", example = "true")
    private boolean deleted;


}
