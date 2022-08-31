package com.fedag.rcrm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "candidate")
public class Candidate extends User {
    @Column
    private LocalDate dob;

    @Column
    private long telephone;

    @Column
    private String email;

    @Column
    private String citizenship;

    @Column
    private String residence;

    @Column
    private String position;

    @Column
    private double salary;

    //todo
    //@OneToMany(mappedBy = "")
    //private List<ExperienceOfWork> workList;

    @Column
    private LocalDateTime created;

    @Column
    private String cv;

    /*@Override
    public String toString() {
        return "Candidate{" +
                "dob=" + dob +
                ", telephone=" + telephone +
                ", email='" + email + '\'' +
                ", citizenship='" + citizenship + '\'' +
                ", residence='" + residence + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", workList=" + workList +
                ", created=" + created +
                ", cv='" + cv + '\'' +
                '}';
    }*/
}
