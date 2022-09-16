package com.fedag.rcrm.model;

import io.swagger.annotations.ApiModelProperty;
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

    @Column(name = "phone_number")
    @ApiModelProperty(notes = "Provided candidate phoneNumber", required =true)
    private String phoneNumber;

    @Column(name = "email")
    @ApiModelProperty(notes = "Provided candidate email", required =true)
    private String email;

    @Column(name = "residence")
    private String residence;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "position")
    @ApiModelProperty(notes = "Provided candidate position objective", required =true)
    private String position;

    @Column(name = "salary")
    private double salary;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "hr_id")
    private HRModel hr;

    @Column(name = "status")
    @ApiModelProperty(notes = "Provided current candidate status", required =true)
    private String status;

    @Column(name = "total_rating")
    @ApiModelProperty(notes = "Provided current candidate rating", required =true)
    private double totalRating;

    @Column(name = "cv_link")
    @ApiModelProperty(notes = "Provided link to candidate CV", required =true)
    private String cvLink;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL)
    @ApiModelProperty(notes = "Provided candidate work experiences ", required =true)
    private List<ExpOfWorkModel> experienceOfWorksList;

    @OneToMany(mappedBy = "candidate")
    @ApiModelProperty(notes = "Provided candidate's feedback ", required =true)
    private List<FeedbackModel> feedbacks;

    @ManyToOne
    @JoinColumn(name = "vacancy_id")
    @ApiModelProperty(notes = "Provided vacancy ", required =true)
    private VacancyModel vacancy;

    @Column(name = "delete")
    @ApiModelProperty(notes = "Provided delete status ", required =true)
    private boolean delete;

    public void addFeedback(FeedbackModel feedbackModel) {
        feedbackModel.setCandidate(this);
        feedbacks.add(feedbackModel);
    }

}
