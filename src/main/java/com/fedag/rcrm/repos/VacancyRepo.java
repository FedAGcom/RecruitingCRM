package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.VacancyModel;
import org.springframework.data.repository.CrudRepository;

public interface VacancyRepo extends CrudRepository<VacancyModel, Long> {

    VacancyModel findByTitle(String title);

}
