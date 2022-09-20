package com.fedag.rcrm.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedag.rcrm.mapper.CandidateMapper;
import com.fedag.rcrm.model.*;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import com.fedag.rcrm.repos.HRRepo;
import com.fedag.rcrm.repos.VacancyRepo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@Component
@RequiredArgsConstructor
@Accessors(chain = true)
public class CandidateMapperImpl implements CandidateMapper {
    private final ObjectMapper objectMapper;
    private final HRRepo hrRepo;
    private final VacancyRepo vacancyRepo;

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
        dto.setHrId(model.getHr().getId());
        dto.setCvLink(model.getCvLink());
        dto.setVacancyTitle(model
                .getVacancy().getTitle());
        dto.setStatus(model.getStatus());
        dto.setTotalRating(model.getTotalRating());
        dto.setExperienceId(model
                .getExperienceOfWorksList()
                .stream().map(ExpOfWorkModel::getId)
                .collect(Collectors.toList()));
        dto.setFeedbackId(model
                .getFeedbacks()
                .stream()
                .map(FeedbackModel::getId)
                .collect(Collectors.toList()));
        dto.setDelete(model.isDelete());
        return dto;
    }

    @Override
    public CandidateModel toCandidateModel(CandidateRequestDto dto, Long vacancyId) {
        CandidateModel model = new CandidateModel();
        model.setFirstName(dto.getFirstName());
        model.setLastname(dto.getLastname());
        model.setPhoneNumber(dto.getPhoneNumber());
        model.setEmail(dto.getEmail());
        model.setResidence(dto.getResidence());
        model.setCountry(dto.getCountry());
        model.setCity(dto.getCity());
        model.setPosition(dto.getPosition());
        model.setSalary(dto.getSalary());
        model.setBirthdate(dto.getBirthdate());
        model.setCvLink(dto.getCvLink());
        model.setCreationDate(LocalDateTime.now());
        model.setStatus("NEW");
        HRModel hr = hrRepo.findById(1L).orElseThrow(()-> new RuntimeException("Error"));
        model.setHr(hr);
        VacancyModel vacancyModel = vacancyRepo.findById(vacancyId).orElseThrow(() -> new RuntimeException("Vacancy ID not found in candidate mapper"));
        model.setVacancy(vacancyModel);
        model.setExperienceOfWorksList(new LinkedList<>());
        model.setFeedbacks(new LinkedList<>());
        return model;
    }

    @Override
    public List<CandidateResponseDto> toListCandidateResponseDto(List<CandidateModel> list) {
        List<CandidateResponseDto> dtoList = new LinkedList<>();
        for (CandidateModel model : list) {
            dtoList.add(toCandidateResponseDto(model));
        }
        return dtoList;
    }

    @Override
    public CandidateModel toCandidateModelUpdate(CandidateModel source, CandidateRequestUpdateDto dto, HRModel hr, VacancyModel vacancy) {
        source.setFirstName(dto.getFirstName());
        source.setLastname(dto.getLastname());
        source.setPhoneNumber(dto.getPhoneNumber());
        source.setEmail(dto.getEmail());
        source.setResidence(dto.getResidence());
        source.setCountry(dto.getCountry());
        source.setCity(dto.getCity());
        source.setPosition(dto.getPosition());
        source.setSalary(dto.getSalary());
        source.setBirthdate(dto.getBirthdate());
        source.setCreationDate(dto.getCreationDate());
        source.setHr(hr);
        source.setStatus(dto.getStatus());
        source.setTotalRating(dto.getTotalRating());
        source.setCvLink(dto.getCvLink());
        source.setVacancy(vacancy);
        source.setDelete(false);
        return source;
    }
}

