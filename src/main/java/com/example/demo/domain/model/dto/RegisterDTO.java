package com.example.demo.domain.model.dto;

import com.example.demo.domain.enums.PersonRole;

public record RegisterDTO(String login, String password, PersonRole role) {
}
