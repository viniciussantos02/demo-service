package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum PersonRole {
    EMPLOYEE("Employee", 00),
    MANAGER("Manager", 01),
    VENDOR("Vendor", 02);

    private String role;
    private int roleId;

    PersonRole(String role, int roleId) {
        this.role = role;
        this.roleId = roleId;
    }

    public static PersonRole getRoleFromRoleId(int roleId) {
        for (PersonRole role : PersonRole.values()) {
            if (role.getRoleId() == roleId) return role;
        }

        return PersonRole.EMPLOYEE;
    }
}
