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

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class HRMapperImpl implements HRMapper {
    private final ObjectMapper objectMapper;

    @Override
    public HRResponseDto toResponse(HRModel hrModel) {
        HRResponseDto responseDto = new HRResponseDto();
        responseDto.setId(hrModel.getId());
        responseDto.setFirstName(hrModel.getFirstName());
        responseDto.setLastname(hrModel.getLastname());
        responseDto.setLogin(hrModel.getLogin());
        if (hrModel.getRoles()!=  null){
            responseDto.setRoles(hrModel.getRoles()
                    .stream()
                    .map(Role::name)
                    .collect(Collectors.toList()));
        }
        responseDto.setCreationDate(hrModel.getCreationDate());
        responseDto.setActive(hrModel.isActive());
        if (hrModel.getCandidates() !=null){
            responseDto.setCandidatesId(hrModel.getCandidates()
                    .stream()
                    .map(CandidateModel::getId)
                    .collect(Collectors.toList()));
        }
        if(hrModel.getVacancies()!=null){
            responseDto.setVacanciesId(hrModel.getVacancies()
                    .stream()
                    .map(VacancyModel::getId)
                    .collect(Collectors.toList()));
        }
        return responseDto;

        /*return new HRResponseDto()
                .setId(hrModel.getId())
                .setFirstName(hrModel.getFirstName())
                .setLastname(hrModel.getLastname())
                .setLogin(hrModel.getLogin())
                .setRoles(hrModel.getRoles()
                        .stream()
                        .map(Role::name)
                        .collect(Collectors.toList()))
                .setCreationDate(hrModel.getCreationDate())
                .setEnabled(hrModel.isEnabled())
                .setCandidatesId(hrModel.getCandidates()
                        .stream()
                        .map(CandidateModel::getId)
                        .collect(Collectors.toList()))
                .setVacanciesId(hrModel.getVacancies()
                        .stream()
                        .map(VacancyModel::getId)
                        .collect(Collectors.toList()));*/
    }

    @Override
    public HRModel fromRequest(HRRequestDto hrRequestDto) {
        return objectMapper.convertValue(hrRequestDto, HRModel.class);
    }

    @Override
    public HRModel fromRequestUpdate(HRRequestUpdateDto hrRequestUpdateDto) {
        return objectMapper.convertValue(hrRequestUpdateDto, HRModel.class);
    }

    @Override
    public HRModel merge(HRModel source, HRModel target) {
        if(source.getFirstName()!=null){
            target.setFirstName(source.getFirstName());
        }
        if(source.getLastname()!=null){
            target.setLastname(source.getLastname());
        }
        if(source.getLogin()!=null){
            target.setLogin(source.getLogin());
        }
        return target;
    }
}
