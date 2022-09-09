package com.fedag.rcrm.model.dto.request;

import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.VacancyModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@NoArgsConstructor
@Accessors(chain = true)
public class CandidateRequestUpdateDto {
    private HRModel hr;
    private String status;
    private double totalRating;
}
