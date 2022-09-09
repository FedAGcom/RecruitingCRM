package com.fedag.rcrm.repos;

import com.fedag.rcrm.enums.Role;
import com.fedag.rcrm.model.HRModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HRRepo extends JpaRepository<HRModel, Long> {
    Optional<HRModel> findByLogin(String login);
}
