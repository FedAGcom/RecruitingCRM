package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.ExperienceOfWorkModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceOfWorkRepo extends JpaRepository<ExperienceOfWorkModel, Long> {
    ExperienceOfWorkModel findByCandidateId(Long id);
}
