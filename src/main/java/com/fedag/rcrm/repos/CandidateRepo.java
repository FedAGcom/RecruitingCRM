package com.fedag.rcrm.repos;

import com.fedag.rcrm.enums.Role;
import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.HRModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CandidateRepo extends JpaRepository<CandidateModel, Long> {

    @Modifying
    @Query("UPDATE CandidateModel candidate SET candidate.status = 'DENIAL_BY_HR' WHERE candidate.id = :id")
    void deleteCandidate(Long id);

    Page<CandidateModel> findAllByStatus(String status, Pageable pageable);

//    Optional<CandidateModel> findCandidateModelsByFirstNameOrderByFirstName();
}
