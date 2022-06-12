package com.soyeonkim.todolist.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Component
public class JwtTokenProvider {

    public String generateAccessToken(String id) {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 7200000))
                .setSubject(id)
                .signWith(SignatureAlgorithm.HS256, "asdf")
                .compact();
    }

    public String getBearerToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if(bearerToken != null) {
            return bearerToken.substring(7);
        }

        return null;
    }

    public String getUserId(String token) {
        try {
            return Jwts.
        }
    }
}
