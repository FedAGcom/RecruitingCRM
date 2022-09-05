package com.fedag.rcrm.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@NoArgsConstructor
public abstract class Employee extends User {
    public Employee(long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
