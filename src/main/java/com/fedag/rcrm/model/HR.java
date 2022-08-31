package com.fedag.rcrm.model;

import com.fedag.rcrm.enums.Role;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Set;

@Entity
@Table
public class HR extends Employee {

    //todo
    private char[] password;

    //todo
    private Set<Role> roles;

    @Column
    private LocalDateTime created;

    public HR() {
        super();
    }

    public HR(long id, String firstName, String lastName, char[] password, Set<Role> roles, LocalDateTime created) {
        super(id, firstName, lastName);
        this.password = password;
        this.roles = roles;
        this.created = created;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "HR{" +
                "password=" + Arrays.toString(password) +
                ", roles=" + roles +
                ", created=" + created +
                '}';
    }
}