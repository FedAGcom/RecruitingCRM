package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.HRModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CandidateRepo extends JpaRepository<CandidateModel, Long> {
}
