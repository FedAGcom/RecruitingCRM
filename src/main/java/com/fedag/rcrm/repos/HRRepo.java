package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.HRModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HRRepo extends JpaRepository<HRModel, Long> {
    Optional<HRModel> findByLogin(String login);

}
