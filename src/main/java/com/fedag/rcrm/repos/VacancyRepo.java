package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.VacancyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface VacancyRepo extends JpaRepository<VacancyModel, Long> {

    VacancyModel findByTitle(String title);
    VacancyModel findByCandidatesId(Long id);

    VacancyModel findByHrsId(Long id);

}
