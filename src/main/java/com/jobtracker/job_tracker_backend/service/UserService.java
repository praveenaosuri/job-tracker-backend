package com.jobtracker.job_tracker_backend.service;
import com.jobtracker.job_tracker_backend.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.jobtracker.job_tracker_backend.entity.User;
 
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
       return userRepository.save(user);
    }
    public boolean emailExists(User user){
      return  userRepository.findByEmail(user.getEmail()).isPresent();
    }
   
        
}
