package com.fedag.rcrm.model.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
public class ExpOfWorkRequestUpdateDto {

    @Schema(description = "Candidate ID", example = "Long - 1")
    private Long candidateId;

    @Schema(description = "Candidate former position")
    private String position;

    @Schema(description = "Start of work")
    private LocalDate date_start;

    @Schema(description = "End of work")
    private LocalDate date_end;

    @Schema(description = "Comment about candidate's former work")
    private String comment;

    @Schema(description = "Mark as delete")
    private boolean delete;
}
