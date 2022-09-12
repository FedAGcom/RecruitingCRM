package com.fedag.rcrm.mapper.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedag.rcrm.mapper.VacancyMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.VacancyRequestDto;
import com.fedag.rcrm.model.dto.request.VacancyRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.VacancyResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class VacancyMapperImpl implements VacancyMapper {

    private final ObjectMapper objectMapper;

    @Override
    public VacancyResponseDto toResponse(VacancyModel vacancyModel) {
        return new VacancyResponseDto()
                .setId(vacancyModel.getId())
                .setTitle(vacancyModel.getTitle())
                .setPosition(vacancyModel.getPosition())
                .setSalary(vacancyModel.getSalary())
                .setComment(vacancyModel.getComment())
                .setDescription(vacancyModel.getDescription())
                .setStatus(vacancyModel.getStatus())
                .setHrsId(Optional.ofNullable(vacancyModel.getHrs())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(HRModel::getId).
                        collect(Collectors.toList()))
                .setCandidatesId(Optional.ofNullable(vacancyModel.getCandidates())
                        .orElseGet(Collections::emptyList)
                        .stream()
                        .map(CandidateModel::getId)
                        .collect(Collectors.toList()));
    }

    @Override
    public VacancyModel fromRequest(VacancyRequestDto vacancyRequestDto) {
        return objectMapper.convertValue(vacancyRequestDto, VacancyModel.class);
    }

    @Override
    public VacancyModel fromRequestUpdate(VacancyRequestUpdateDto vacancyRequestUpdateDto) {
        return objectMapper.convertValue(vacancyRequestUpdateDto, VacancyModel.class);
    }


}
