package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.repository.UserRepository;
import com.example.demo.rest.dto.RegisterDTO;
import com.example.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<Void> register(RegisterDTO data) {
        if (nonNull(this.userRepository.findByUsername(data.login()))) return ResponseEntity.badRequest().build();

        try {
            userRepository.save(UserMapper.INSTANCE.registerDTOToUser(data));
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            log.error("Erro ao cadastrar usuario: {}", e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}
