package com.fedag.rcrm.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedag.rcrm.enums.Role;
import com.fedag.rcrm.mapper.HRMapper;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.VacancyModel;
import com.fedag.rcrm.model.dto.request.HRRequestDto;
import com.fedag.rcrm.model.dto.request.HRRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HRMapperImpl implements HRMapper {
    private final ObjectMapper objectMapper;

    @Override
    public HRResponseDto toResponse(HRModel hrModel) {
        return new HRResponseDto()
                .setId(hrModel.getId())
                .setFirstName(hrModel.getFirstName())
                .setLastname(hrModel.getLastname())
                .setRoles(hrModel.getRoles()
                        .stream()
                        .map(Role::name)
                        .collect(Collectors.toList()))
                .setCreationDate(hrModel.getCreationDate())
                .setCandidatesId(hrModel.getCandidates()
                        .stream()
                        .map(CandidateModel::getId)
                        .collect(Collectors.toList()))
                .setVacanciesId(hrModel.getVacancies()
                        .stream()
                        .map(VacancyModel::getId)
                        .collect(Collectors.toList()));
    }

    @Override
    public HRModel fromRequest(HRRequestDto hrRequestDto) {
        return objectMapper.convertValue(hrRequestDto, HRModel.class);
    }

    @Override
    public HRModel fromRequestUpdate(HRRequestUpdateDto hrRequestUpdateDto) {
        return objectMapper.convertValue(hrRequestUpdateDto, HRModel.class);
    }
}
