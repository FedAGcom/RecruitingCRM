package com.fedag.rcrm.dao.impl;

import com.fedag.rcrm.model.VacancyModel;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@Getter
public class VacancyDao {
    private List<VacancyModel> vacancies;

    public VacancyModel getVacancyById(Long id){
        return vacancies.stream().filter(vacancy -> Objects.equals(vacancy.getId(), id)).findAny().orElse(null);
    }

}
