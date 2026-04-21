package com.jobtracker.job_tracker_backend.config;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generateToken(String email){
        return  Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis()+1000*60*60))
        .signWith(getKey())
        .compact();
        
    }
    private SecretKey getKey(){
        byte[] jwtSecretByte=Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(jwtSecretByte);
    }

    public String extractEmail(String token){
      return Jwts.parserBuilder()
                 .setSigningKey(getKey())
                 .build()
                 .parseClaimsJws(token)
                 .getBody()
                 .getSubject();
    }
    public Boolean isTokenValid(String token){
      Date expiry= Jwts.parserBuilder()
                 .setSigningKey(getKey())
                 .build()
                 .parseClaimsJws(token)
                 .getBody()
                 .getExpiration();
        return !expiry.before(new Date());
        //Whether this expired before the current time 
    }
    
}
