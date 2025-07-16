package com.example.demo.service;

import com.example.demo.rest.dto.RegisterDTO;
import org.springframework.http.ResponseEntity;

public interface AuthenticationService {
    ResponseEntity<Void> register(RegisterDTO data);
}
