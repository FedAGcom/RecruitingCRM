package com.fedag.rcrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

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

    public ExperienceOfWork() {
    }

    public ExperienceOfWork(long id, String position, String comment, LocalDate startWork, LocalDate endWork) {
        this.id = id;
        this.position = position;
        this.comment = comment;
        this.startWork = startWork;
        this.endWork = endWork;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDate getStartWork() {
        return startWork;
    }

    public void setStartWork(LocalDate startWork) {
        this.startWork = startWork;
    }

    public LocalDate getEndWork() {
        return endWork;
    }

    public void setEndWork(LocalDate endWork) {
        this.endWork = endWork;
    }

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
