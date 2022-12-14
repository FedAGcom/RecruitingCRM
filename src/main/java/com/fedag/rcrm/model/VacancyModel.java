package com.fedag.rcrm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "vacancy")
public class VacancyModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "position")
    private String position;

    @Column(name = "salary")
    private double salary;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @Column(name = "description")
    private String description;

    @Column(name = "status")
    private String status;

    @ManyToMany()
    @JoinTable(
            name = "hr_to_vacancy",
            joinColumns = @JoinColumn(name = "vacancy_id"),
            inverseJoinColumns = @JoinColumn(name = "hr_id")
    )
    private List<HRModel> hrs;

    @OneToMany(mappedBy = "vacancy")
    private List<CandidateModel> candidates;
}
