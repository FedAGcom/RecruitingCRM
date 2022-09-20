package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.ExpOfWorkModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpOfWorkRepo extends JpaRepository<ExpOfWorkModel, Long> {

    @Modifying
    @Query("UPDATE ExpOfWorkModel experience SET experience.delete = true WHERE experience.id = :id")
    void deleteById(Long id);

    Page<ExpOfWorkModel> findAllByDeleteFalse(Pageable pageable);
}
