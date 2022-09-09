package com.fedag.rcrm.model;

import com.fedag.rcrm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @CollectionTable(name = "enum_role_type", joinColumns = @JoinColumn(name = "hr_id"))
    @Enumerated(value = EnumType.STRING)
    private Set<Role> roles;

    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    @OneToMany(mappedBy = "hr", fetch = FetchType.EAGER)
    private List<CandidateModel> candidate;

    @ManyToMany()
    @JoinTable(
            name = "hr_to_vacancy",
            joinColumns = @JoinColumn(name = "hr_id"),
            inverseJoinColumns = @JoinColumn(name = "vacancy_id")
    )
    private List<VacancyModel> vacancies;
}