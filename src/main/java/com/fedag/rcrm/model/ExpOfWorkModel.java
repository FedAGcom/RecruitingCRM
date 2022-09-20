package com.fedag.rcrm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "candidate_exp")
public class ExpOfWorkModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id")
    private CandidateModel candidate;

    @Column(name = "position")
    private String position;

    @Column(name = "date_start")
    private LocalDate date_start;

    @Column(name = "date_end")
    private LocalDate date_end;

    @Column(name = "comment")
    private String comment;

    @Column(name = "delete")
    boolean delete;
}
