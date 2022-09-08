package com.fedag.rcrm.model.dto;

import com.fedag.rcrm.model.CandidateModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor
public class FeedbackDto {

    private CandidateDto candidateDto;

    private HRDto hrModel;

    private int rating;

    private String comment;

}
