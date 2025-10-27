package com.example.demo.service;

import com.example.demo.domain.model.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<Void> register(RegisterDTO data);
}
