package com.jobtracker.job_tracker_backend.service;
import com.jobtracker.job_tracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.jobtracker.job_tracker_backend.config.JwtUtil;
import com.jobtracker.job_tracker_backend.dto.LoginRequest;
import com.jobtracker.job_tracker_backend.entity.User;
 
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwt;

    public User registerUser(User user){
     
        if(emailExists(user))
        throw new IllegalArgumentException("Email already exists!");
      
      String password=user.getPassword();
      
      String hashedPassowrd=passwordEncoder.encode(password);
      user.setPassword(hashedPassowrd);
       return userRepository.save(user);
    }
  
    public String loginUser(LoginRequest loginRequest){

       if(loginRequest.getEmail()==null || loginRequest.getPassword()==null)
        throw new IllegalArgumentException("Email and password must not be null");
     
       Optional<User> user=userRepository.findByEmail(loginRequest.getEmail());

        if( user.isEmpty())
        throw new IllegalArgumentException("Invalid email");

      if (passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword()))
        return jwt.generateToken(loginRequest.getEmail());

        throw new IllegalArgumentException("Invalid password");

        
    }

    public boolean emailExists(User user){
      return  userRepository.findByEmail(user.getEmail()).isPresent();
    }
   
        
}
