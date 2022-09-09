package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.CandidateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends JpaRepository<CandidateModel, Long> {
}
