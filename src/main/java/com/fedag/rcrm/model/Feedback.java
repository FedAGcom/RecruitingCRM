package com.fedag.rcrm.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "feedback_id")
    private Long feedback_id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private Candidate candidate;

    @ManyToOne
    @JoinColumn(name = "hr_id")
    private HR hr;

    @Column(name = "rating")
    private int rating;

    @Column(name = "comment")
    private String comment;
}
