package com.fedag.rcrm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "candidat")
public class Candidate extends User {
    @Column
    private Data dob;

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
//    @OneToMany(mappedBy = "")
    private List<ExperienceOfWork> workList;

    @Column
    private LocalDateTime created;

    @Column
    private String cv;

    public Candidate(long id, String firstName, String lastName,
                     Data dob, long telephone, String email,
                     String citizenship, String residence,
                     String position, double salary,
                     List<ExperienceOfWork> workList, LocalDateTime created,
                     String cv) {
        super(id, firstName, lastName);
        this.dob = dob;
        this.telephone = telephone;
        this.email = email;
        this.citizenship = citizenship;
        this.residence = residence;
        this.position = position;
        this.salary = salary;
        this.workList = workList;
        this.created = created;
        this.cv = cv;
    }

    public Candidate() {
        super();
    }

    public Data getDob() {
        return dob;
    }

    public void setDob(Data dob) {
        this.dob = dob;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<ExperienceOfWork> getWorkList() {
        return workList;
    }

    public void setWorkList(List<ExperienceOfWork> workList) {
        this.workList = workList;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    @Override
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
    }
}
