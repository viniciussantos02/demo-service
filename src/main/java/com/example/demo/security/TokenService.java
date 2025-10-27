package com.example.demo.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.example.demo.domain.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Serviço responsável pela geração e validação de tokens JWT.
 *
 * <p>Utiliza a biblioteca Auth0 do JWT para criar e verificar tokens assinado com algoritmo HMAC256.
 * O token é gerado com base no nome de usuário e tem tempo de expiração definido.
 *
 * <p>Principais responsabilidades:
 * <ul>
 *   <li>Gerar tokens JWT válidos usando uma chave secreta definida no arquivo de configuração.</li>
 *   <li>Validar tokens recebidos e extrair o assunto (usuário).</li>
 * </ul>
 *
 * <p>O emissor do token é fixo como {@code "demo-service"} e a expiração é configurada para 7 minutos.
 *
 * @author Vinicius
 * @see com.auth0.jwt.JWT
 * @see com.auth0.jwt.algorithms.Algorithm
 */
@Slf4j
@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secretKey;

    private static final String ISSUER = "demo-service";

    public String generateToken(User user) {
        try {
            log.info("Criando token.");
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            return JWT.create()
                    .withIssuer(ISSUER)
                    .withSubject(user.getUsername())
                    .withExpiresAt(generateExpirationoDate())
                    .sign(algorithm);
        } catch (JWTCreationException ex) {
            throw new RuntimeException("Erro ao gerar token: {}", ex);
        }
    }

    public String validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            return JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (JWTVerificationException ex) {
            log.error("Erro ao validar token: {}", ex.getMessage());
            return "";
        }
    }

    private Instant generateExpirationoDate() {
        return LocalDateTime.now().plusMinutes(7L).toInstant(ZoneOffset.of("-03:00"));
    }
}
