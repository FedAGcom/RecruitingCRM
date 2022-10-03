package com.fedag.rcrm.model;

import com.fedag.rcrm.enums.Role;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

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

    public UserRoleModel() {
    }

    public UserRoleModel(Role name) {
        this.name = name;
    }
}
