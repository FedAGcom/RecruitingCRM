package com.fedag.rcrm.model;

import com.fedag.rcrm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hr")
public class HRModel extends EmployeeModel {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private char[] password;

    @ElementCollection(targetClass = Role.class)
    @CollectionTable(name = "hr_to_role", joinColumns = @JoinColumn(name = "hr_id"))
    @Enumerated(value = EnumType.STRING)
    @Column(name = "role")
    private Set<Role> roles;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "hr", fetch = FetchType.EAGER)
    private List<CandidateModel> candidates;

    @ManyToMany()
    @JoinTable(
            name = "hr_to_vacancy",
            joinColumns = @JoinColumn(name = "hr_id"),
            inverseJoinColumns = @JoinColumn(name = "vacancy_id")
    )
    private List<VacancyModel> vacancies;


    @Column(name = "active")
    private boolean active = true;

    public void addCandidate(CandidateModel candidateModel){
        this.candidates.add(candidateModel);
        candidateModel.setHr(this);
    }

    public void  removeCandidate(CandidateModel candidateModel){
        this.candidates.remove(candidateModel);
    }

    public void addVacancy(VacancyModel vacancyModel){
        this.vacancies.add(vacancyModel);
        vacancyModel.getHrs().add(this);
    }

    public void deleteVacancy(VacancyModel vacancyModel){
        this.vacancies.remove(vacancyModel);
        vacancyModel.getHrs().remove(this);
    }

}