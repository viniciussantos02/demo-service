package com.example.demo.security;

import com.example.demo.domain.repository.UserRepository;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Filtro de segurança que intercepta todas as requisições HTTP para validar o token JWT.
 *
 * <p>Este filtro é executado uma vez por requisição e tem como responsabilidade:
 * <ul>
 *   <li>Recuperar o token JWT do cabeçalho Authorization.</li>
 *   <li>Validar o token usando {@link TokenService}.</li>
 *   <li>Buscar o usuário no banco de dados usando {@link UserRepository}.</li>
 *   <li>Autenticar o usuário e registrar o contexto de segurança na {@link SecurityContextHolder}.</li>
 * </ul>
 *
 * <p>Se o token não for fornecido ou for inválido, a requisição continuará sem autenticação.
 *
 * @author Vinicius
 * @see TokenService
 * @see UserRepository
 * @see OncePerRequestFilter
 */
@Component
@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {

    private final TokenService tokenService;
    private final UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        var token = this.recoverToken(request);

        if(nonNull(token)) {
            var username = tokenService.validateToken(token);
            UserDetails user = userRepository.findByUsername(username);

            var authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }

        filterChain.doFilter(request, response);
    }

    private String recoverToken(HttpServletRequest request) {
        var authorization = request.getHeader("Authorization");
        if(isNull(authorization)) return null;

        return authorization.replace("Bearer ", "");
    }
}
