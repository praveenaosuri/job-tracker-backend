package com.jobtracker.job_tracker_backend.service;
import com.jobtracker.job_tracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.jobtracker.job_tracker_backend.entity.User;
 
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user){
     
        if(emailExists(user))
        throw new IllegalArgumentException("Email already exists!");
      
      String password=user.getPassword();
      
      String hashedPassowrd=passwordEncoder.encode(password);
      user.setPassword(hashedPassowrd);
       return userRepository.save(user);
    }


    public boolean emailExists(User user){
      return  userRepository.findByEmail(user.getEmail()).isPresent();
    }
   
        
}
