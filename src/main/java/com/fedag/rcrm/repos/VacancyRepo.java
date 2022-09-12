package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.VacancyModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VacancyRepo extends JpaRepository<VacancyModel, Long> {

    Optional<VacancyModel> findByTitle(String title);
}
