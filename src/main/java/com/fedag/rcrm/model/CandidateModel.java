package com.fedag.rcrm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "candidate")
public class CandidateModel extends UserModel {

    @Column(name = "email")
    private String email;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private double salary;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hr_id")
    private HRModel hr;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private VacancyModel vacancy;

}
