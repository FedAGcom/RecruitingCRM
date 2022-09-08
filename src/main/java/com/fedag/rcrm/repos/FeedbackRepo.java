package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.CandidateModel;
import com.fedag.rcrm.model.FeedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepo extends JpaRepository<FeedbackModel, Long> {
    FeedbackModel findByCandidateId(Long id);
    FeedbackModel findByHrModelId(Long id);
}
