package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.FeedbackModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<FeedbackModel, Long> {

    @Modifying
    @Query("UPDATE FeedbackModel feedback SET feedback.deleted = true WHERE feedback.id = :id")
    void deleteById(Long id);

}
