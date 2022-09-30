package com.fedag.rcrm.repos;

import com.fedag.rcrm.enums.Role;
import com.fedag.rcrm.model.HRModel;
import com.fedag.rcrm.model.dto.response.HRResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HRRepo extends JpaRepository<HRModel, Long> {
    Optional<HRModel> findByLogin(String login);

    @Modifying
    @Query("UPDATE HRModel hr SET hr.active = false WHERE hr.id = :id")
    void deleteById(Long id);

    Page<HRModel> findAllByRoleAndActiveTrue(Role role, Pageable pageable);
    Page<HRModel> findAll(Pageable pageable);

//    boolean existByLogin(String login);
}
