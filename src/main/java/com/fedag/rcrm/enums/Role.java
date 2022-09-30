package com.fedag.rcrm.enums;

public enum Role {
    USER ("USER"),
    ADMIN ("ADMIN"),
    USER_INACTIVE ("USER_INACTIVE"),
    ADMIN_INACTIVE ("ADMIN_INACTIVE");

    private String name;

    Role(String role) {
        this.name = role;
    }

    public String getName() {
        return name;
    }
}
