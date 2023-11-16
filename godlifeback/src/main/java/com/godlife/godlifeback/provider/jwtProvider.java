package com.godlife.godlifeback.provider;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {

    @Value("${secret-key}")
    private String secretkey;

    public String create(String email){
        Date expiration = Date.from(Instant.now().plus(12, ChronoUnit.HOURS));

        String jwt = Jwts.builder()
                        .signWith(SignatureAlgorithm.HS256, secretkey)
                        .setSubject(email).setIssuedAt(new Date()).setExpiration(expiration)
                        .compact();
        return jwt;
    }

    public String validate(String jwt){
        
        return secretkey;

    }
    
}
