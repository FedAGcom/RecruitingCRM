package com.fedag.rcrm.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class EmployeeModel extends UserModel {
    public EmployeeModel(long id, String firstName, String lastName) {
        super(id, firstName, lastName);
    }
}
