package com.fedag.rcrm.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedag.rcrm.mapper.CandidateMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.ExperienceOfWorkModel;
import com.fedag.rcrm.model.FeedbackModel;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Getter
@Setter
@Component
@RequiredArgsConstructor
@Accessors(chain = true)
public class CandidateMapperImpl implements CandidateMapper {

    private final ObjectMapper objectMapper;

    @Override
    public CandidateResponseDto toCandidateResponseDto(CandidateModel model) {
        CandidateResponseDto dto = new CandidateResponseDto();

        dto.setId(model.getId());
        dto.setFirstName(model.getFirstName());
        dto.setLastname(model.getLastname());
        dto.setPhoneNumber(model.getPhoneNumber());
        dto.setEmail(model.getEmail());
        dto.setResidence(model.getResidence());
        dto.setCountry(model.getCountry());
        dto.setCity(model.getCity());
        dto.setPosition(model.getPosition());
        dto.setSalary(model.getSalary());
        dto.setBirthdate(model.getBirthdate());
        dto.setCreationDate(model.getCreationDate());
        dto.setHr(model.getHr());
        dto.setStatus(model.getStatus());
        dto.setTotalRating(model.getTotalRating());
        dto.setCvLink(model.getCvLink());

        dto.setExperienceId(model
                .getExperienceOfWorksList()
                .stream().map(ExperienceOfWorkModel::getId)
                .collect(Collectors.toList()));

        dto.setFeedbackId(model
                .getFeedback()
                .stream()
                .map(FeedbackModel::getFeedback_id)
                .collect(Collectors.toList()));

        dto.setVacancy(model.getVacancy());
        return dto;
    }

    @Override
    public CandidateModel toCandidateModel(CandidateRequestDto dto) {
       return objectMapper.convertValue(dto, CandidateModel.class);
    }

    @Override
    public CandidateModel toCandidateModelUpdate(CandidateRequestUpdateDto dto) {
        return objectMapper.convertValue(dto, CandidateModel.class);
    }
}

