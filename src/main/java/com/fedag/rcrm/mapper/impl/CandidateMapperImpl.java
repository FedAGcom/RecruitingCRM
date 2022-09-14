package com.fedag.rcrm.mapper.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fedag.rcrm.mapper.CandidateMapper;
import com.fedag.rcrm.model.*;
import com.fedag.rcrm.model.dto.request.CandidateRequestDto;
import com.fedag.rcrm.model.dto.request.CandidateRequestUpdateDto;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import com.fedag.rcrm.repos.HRRepo;
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
                .stream().map(ExperienceOfWorkModel::getId)
                .collect(Collectors.toList()));

        dto.setFeedbackId(model
                .getFeedbacks()
                .stream()
                .map(FeedbackModel::getFeedback_id)
                .collect(Collectors.toList()));

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
        model.setVacancy(hr.getVacancies().get(0));

        model.setExperienceOfWorksList(new LinkedList<>());
        model.setFeedbacks(new LinkedList<>());

        return model;
    }

    @Override
    public CandidateRequestUpdateDto toCandidateRequestUpdateDto(CandidateModel model) {
        CandidateRequestUpdateDto dto = new CandidateRequestUpdateDto();

        dto.setHr(model.getHr());
        dto.setStatus(model.getStatus());
        dto.setTotalRating(model.getTotalRating());

        return dto;
    }

    @Override
    public CandidateModel toCandidateModelUpdate(CandidateRequestUpdateDto dto, CandidateModel model) {
        model.setHr(dto.getHr());
        model.setStatus(dto.getStatus());
        model.setTotalRating(dto.getTotalRating());
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
    public CandidateModel candidateModelMerge(CandidateModel source, CandidateRequestUpdateDto dto) {
//        if (dto.getHr() != null) {
//            source.setHr(dto.getHr());
//        }
//        if (dto.getStatus() != null) {
//            source.setStatus(dto.getStatus());
//        }


        return source;
    }
}

