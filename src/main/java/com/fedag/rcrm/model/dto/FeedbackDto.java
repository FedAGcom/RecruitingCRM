package com.fedag.rcrm.model.dto;

import com.fedag.rcrm.model.CandidateModel;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@RequiredArgsConstructor
public class FeedbackDto {

    private Long candidateId;//todo

    private Long hrId;

    private int rating;

    private String comment;

}
