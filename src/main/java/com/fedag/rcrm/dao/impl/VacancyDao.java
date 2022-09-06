package com.fedag.rcrm.dao.impl;

import com.fedag.rcrm.model.Vacancy;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@Getter
public class VacancyDao {
    private List<Vacancy> vacancies;

    public Vacancy getVacancyById(Long id){
        return vacancies.stream().filter(vacancy -> Objects.equals(vacancy.getId(), id)).findAny().orElse(null);
    }

}
