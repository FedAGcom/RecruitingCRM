package com.fedag.rcrm.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class ExperienceOfWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String position;

    @Column
    private String comment;

    @Column
    private LocalDate startWork;

    @Column
    private LocalDate endWork;


    @Override
    public String toString() {
        return "ExperienceOfWork{" +
                "id=" + id +
                ", position='" + position + '\'' +
                ", comment='" + comment + '\'' +
                ", startWork=" + startWork +
                ", endWork=" + endWork +
                '}';
    }
}
