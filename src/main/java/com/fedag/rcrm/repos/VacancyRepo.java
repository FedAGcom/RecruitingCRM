package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.Vacancy;
import org.springframework.data.repository.CrudRepository;

public interface VacancyRepo extends CrudRepository<Vacancy, Long> {

    Vacancy findByTitle(String title);

}
