package com.jobtracker.job_tracker_backend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import org.springframework.web.filter.OncePerRequestFilter;


@Component
public class JwtFilter extends OncePerRequestFilter{
     @Autowired
         private JwtUtil jwtUtil;
    @Override
    public void doFilterInternal(HttpServletRequest httpRequest,
                                           HttpServletResponse httpResponse,
                                           FilterChain filterChain
    ) throws IOException, ServletException{
        

        String header=httpRequest.getHeader("Authorization");
        if(header!=null && header.startsWith("Bearer ")){
            String token= header.substring(7);
            String email=jwtUtil.extractEmail(token);
        UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(
            email,//principal
              null ,//password
              new ArrayList<>()
        );
        SecurityContextHolder.getContext().setAuthentication(auth);
        }
           filterChain.doFilter( httpRequest,httpResponse);
           
    }
    
}