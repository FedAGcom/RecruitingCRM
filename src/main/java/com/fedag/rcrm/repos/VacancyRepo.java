package com.fedag.rcrm.repos;

import com.fedag.rcrm.model.VacancyModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface VacancyRepo extends JpaRepository<VacancyModel, Long> {

    Optional<VacancyModel> findByTitle(String title);
    @Modifying
    @Query("UPDATE VacancyModel vacancy SET vacancy.status = 'CLOSE' WHERE vacancy.id = :id")
    void deleteById(Long id);

    /*@Modifying
    @Query("SELECT vacancy FROM VacancyModel vacancy WHERE vacancy.status = :status")*/
    Page<VacancyModel> findAllByStatusContains(String status, Pageable pageable);

}
