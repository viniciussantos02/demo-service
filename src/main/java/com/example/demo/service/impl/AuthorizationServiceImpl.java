package com.example.demo.service.impl;

import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Serviço responsável pela autenticação de usuários.
 *
 * <p>Essa classe implementa a interface {@link org.springframework.security.core.userdetails.UserDetailsService}
 * e é automaticamente utilizada pelo Spring Security para carregar os dados do usuário durante o processo de login.</p>
 *
 *
 *
 * @author Vinicius Pereira
 * @since 1.0
 * @version 1.0
 */
@Service
@RequiredArgsConstructor
public class AuthorizationServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
