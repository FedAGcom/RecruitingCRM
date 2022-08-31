package com.fedag.rcrm.model;

import com.fedag.rcrm.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table
public class HR extends Employee {

    //todo
    private char[] password;

    //todo
    private Set<Role> roles;

    @Column
    private LocalDateTime created;

    @Override
    public String toString() {
        return "HR{" +
                "password=" + Arrays.toString(password) +
                ", roles=" + roles +
                ", created=" + created +
                '}';
    }
}