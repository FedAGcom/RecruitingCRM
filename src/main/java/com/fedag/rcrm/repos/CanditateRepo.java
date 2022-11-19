package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.VacancyModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CanditateRepo extends JpaRepository<CandidateModel, Long> {

    CandidateModel findByLastname(String title);
    CandidateModel findByHrId(Long id);

}
