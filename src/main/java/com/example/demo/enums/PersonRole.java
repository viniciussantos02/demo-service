package com.example.demo.enums;

import lombok.Getter;

@Getter
public enum PersonRole {
    MANAGER("Manager", 01),
    VENDOR("Vendor", 02);

    private String role;
    private int roleId;

    PersonRole(String role, int roleId) {
        this.role = role;
        this.roleId = roleId;
    }
}
