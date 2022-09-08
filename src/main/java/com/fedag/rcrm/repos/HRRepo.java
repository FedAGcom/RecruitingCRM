package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.HRModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HRRepo extends JpaRepository<HRModel, Long> {
    HRModel findByCandidateId(Long id);
    HRModel findByVacanciesId(Long id);
}
