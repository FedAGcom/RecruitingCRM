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
public class Candidate extends User {

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;


    @Column(name = "residence")
    private String residence;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private double salary;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hr_id")
    private HR hr;

    @Column(name = "status")
    private String status;

    @Column(name = "total_rating")
    private double totalRating;

    @Column(name = "cv_link")
    private String cvLink;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    private List<ExperienceOfWork> experienceOfWorksList;

    @OneToMany(mappedBy = "candidate")
    private List<Feedback> feedbacks;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    private Vacancy vacancy;

}
