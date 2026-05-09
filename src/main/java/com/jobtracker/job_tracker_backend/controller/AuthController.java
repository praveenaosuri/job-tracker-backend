package com.jobtracker.job_tracker_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.job_tracker_backend.dto.LoginRequest;
import com.jobtracker.job_tracker_backend.dto.UserResponseDTO;
import com.jobtracker.job_tracker_backend.entity.User;
import com.jobtracker.job_tracker_backend.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private UserService userService;

   
 
    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> registerUser(@RequestBody User user){
        User savedUser = userService.registerUser(user);
        return ResponseEntity.ok(UserResponseDTO.fromUser(savedUser));
    }

    
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequestDto){
        return userService.loginUser(loginRequestDto);
    }
}
