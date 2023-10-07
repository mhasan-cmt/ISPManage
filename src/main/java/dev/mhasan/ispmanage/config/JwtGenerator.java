package dev.mhasan.ispmanage.config;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;

@Component
@Slf4j
public class JwtGenerator {
    public String generateToken(Authentication authentication) {
        String username = authentication.getName();
        LocalDateTime expiryDate = LocalDateTime.now().plusSeconds(SecurityConstraints.JWT_EXPIRATION);

        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Timestamp.valueOf(expiryDate))
                .signWith(SignatureAlgorithm.HS512, SecurityConstraints.JWT_SECRET)
                .compact();

        return token;
    }

    public String getUserNameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(SecurityConstraints.JWT_SECRET)
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SecurityConstraints.JWT_SECRET).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            log.error("Error validating token: {}", e.getMessage());
            throw new AuthenticationCredentialsNotFoundException("JWT was expired or incorrect");
        }
    }
}
