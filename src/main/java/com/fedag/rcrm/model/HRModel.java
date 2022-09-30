package com.fedag.rcrm.model;

import com.fedag.rcrm.enums.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "hr",
    uniqueConstraints = {
            @UniqueConstraint(columnNames = "login")
})
public class HRModel extends EmployeeModel {

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private char[] password;

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "hr_to_urm",
//            joinColumns = @JoinColumn(name = "hr_id"),
//            inverseJoinColumns = @JoinColumn(name = "role"))
//    private Set<UserRoleModel> roles = new HashSet<>();

    @Column(name = "role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "hr", fetch = FetchType.LAZY)
    private List<CandidateModel> candidates;

    @ManyToMany()
    @JoinTable(
            name = "hr_to_vacancy",
            joinColumns = @JoinColumn(name = "hr_id"),
            inverseJoinColumns = @JoinColumn(name = "vacancy_id")
    )
    private List<VacancyModel> vacancies;

    @OneToMany(mappedBy = "hr", fetch = FetchType.LAZY)
    private List<FeedbackModel> feedbacks;


    @Column(name = "active")
    private boolean active = true;

    public void addCandidate(CandidateModel candidateModel){
        this.candidates.add(candidateModel);
        candidateModel.setHr(this);
    }

    public void  removeCandidate(CandidateModel candidateModel){
        this.candidates.remove(candidateModel);
    }

    public void addFeedback(FeedbackModel feedbackModel){
        this.feedbacks.add(feedbackModel);
        feedbackModel.setHr(this);
    }

    /*public void  removeFeedback(FeedbackModel feedbackModel){
        this.feedbacks.remove(feedbackModel);
    }*/

    public void addVacancy(VacancyModel vacancyModel){
        this.vacancies.add(vacancyModel);
        vacancyModel.getHrs().add(this);
    }

    public void deleteVacancy(VacancyModel vacancyModel){
        this.vacancies.remove(vacancyModel);
        vacancyModel.getHrs().remove(this);
    }
}