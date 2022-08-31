package com.fedag.rcrm.model;

public abstract class Employee extends User {

    public Employee() {
        super();
    }

    public Employee(long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
