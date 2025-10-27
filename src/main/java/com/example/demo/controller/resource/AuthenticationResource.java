package com.example.demo.controller.resource;

import com.example.demo.domain.model.dto.AuthenticationDTO;
import com.example.demo.domain.model.dto.LoginResponseDTO;
import com.example.demo.domain.model.dto.RegisterDTO;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AuthenticationResource {

    @PostMapping("/login")
    ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data);

    @PostMapping("/register")
    ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data);
}
