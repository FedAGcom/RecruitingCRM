package com.fedag.rcrm.model;

import com.fedag.rcrm.enums.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//@Entity
//@Table(name = "roles")
//@Getter
//@Setter
public class UserRoleModel {

////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;

    @Id
    @Enumerated(EnumType.STRING)
    private Role name;

    public UserRoleModel() {}

    public UserRoleModel(Role name) {
        this.name = name;
    }
}
