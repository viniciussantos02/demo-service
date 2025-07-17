package com.example.demo.security.config;

import com.example.demo.security.SecurityFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Configuração de segurança da aplicação utilizando Spring Security.
 *
 * <p>Esta classe define as regras de autenticação e autorização para os endpoints da API,
 * além de configurar o filtro de segurança, gerenciamento de sessões e codificador de senhas.</p>
 *
 * <p>Configurações principais:</p>
 * <ul>
 *   <li>Desabilita CSRF (Cross-Site Request Forgery)</li>
 *   <li>Utiliza autenticação stateless (sem sessões)</li>
 *   <li>Define permissões para rotas públicas e protegidas</li>
 *   <li>Adiciona um filtro JWT personalizado antes do filtro padrão de autenticação</li>
 *   <li>Fornece beans para {@link AuthenticationManager} e {@link PasswordEncoder}</li>
 * </ul>
 *
 * @author Vinicius
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/employee/*").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.GET, "/employee/*").hasRole("MANAGER")
                        .anyRequest().authenticated()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
