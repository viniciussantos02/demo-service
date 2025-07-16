package com.example.demo.rest.dto;

import com.example.demo.enums.PersonRole;

public record RegisterDTO(String login, String password, PersonRole role) {
}
