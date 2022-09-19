package com.fedag.rcrm.mapper.impl;

import com.fedag.rcrm.model.*;
import com.fedag.rcrm.model.dto.response.CandidateResponseDto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class CandidateMapperImplTest {

    CandidateMapperImpl mapper;
    static CandidateModel model;

    @BeforeEach
    void preparedData() {
        model = new CandidateModel();
        model.setFirstName("John");
        model.setLastname("Smith");
        model.setPhoneNumber("123456789");
        model.setEmail("email@mail.ru");
        model.setResidence("Mali");
        model.setCountry("Uganda");
        model.setCity("Bamako");
        model.setPosition("developer");
        model.setSalary(4500);
        model.setBirthdate(LocalDate.ofEpochDay(1990-1-1));
        model.setCreationDate(LocalDateTime.now());
        model.setHr(new HRModel());
        model.setStatus("NEW");
        model.setTotalRating(5.0);
        model.setCvLink("https://www.site.ru");
        model.setExperienceOfWorksList(new ArrayList<>());
        model.setFeedbacks(new ArrayList<>());
        model.setVacancy(new VacancyModel());
        model.setDelete(false);
    }

    @Test
    void toCandidateResponseDto() {
        CandidateResponseDto dto = new CandidateResponseDto();
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
        dto.setStatus(model.getStatus());
        dto.setTotalRating(model.getTotalRating());
        dto.setCvLink(model.getCvLink());
        dto.setExperienceId(model.getExperienceOfWorksList().stream().map(ExpOfWorkModel::getId).collect(Collectors.toList()));
        dto.setFeedbackId(model.getFeedbacks().stream().map(FeedbackModel::getId).collect(Collectors.toList()));
        dto.setVacancyTitle(model.getVacancy().getTitle());
        dto.setDelete(model.isDelete());

        assertEquals(dto, mapper.toCandidateResponseDto(model));
    }

    @Test
    void toCandidateModel() {
    }

    @Test
    void toListCandidateResponseDto() {
    }

    @Test
    void toCandidateModelUpdate() {
    }

    @Test
    void getObjectMapper() {
    }

    @Test
    void getHrRepo() {
    }

    @Test
    void getVacancyRepo() {
    }
}