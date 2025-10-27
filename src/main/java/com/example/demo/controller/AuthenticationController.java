package com.example.demo.controller;

import com.example.demo.controller.resource.AuthenticationResource;
import com.example.demo.security.TokenService;
import com.example.demo.domain.model.User;
import com.example.demo.domain.model.dto.AuthenticationDTO;
import com.example.demo.domain.model.dto.LoginResponseDTO;
import com.example.demo.domain.model.dto.RegisterDTO;
import com.example.demo.service.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController implements AuthenticationResource {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationService service;
    private final TokenService tokenService;

    @Override
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid AuthenticationDTO data) {
        log.info("Iniciando processo de autenticacao.");
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @Override
    public ResponseEntity<Void> register(@RequestBody @Valid RegisterDTO data) {
        return service.register(data);
    }
}
