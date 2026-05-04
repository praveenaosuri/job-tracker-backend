package com.jobtracker.job_tracker_backend.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.jobtracker.job_tracker_backend.entity.JobApplication;
import com.jobtracker.job_tracker_backend.entity.User;
import com.jobtracker.job_tracker_backend.repository.JobApplicationRepository;
import com.jobtracker.job_tracker_backend.repository.UserRepository;

@Service
public class JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private UserRepository userRepository;

    
    public void addJobApplication(JobApplication jobApplication){ 
              Optional<User> userOptional = userRepository.findByEmail(
                (String)  SecurityContextHolder.getContext().getAuthentication().getPrincipal()
              );
              if (userOptional.isEmpty()) {
                throw new IllegalArgumentException("User not found");
              }
              jobApplication.setUser(userOptional.get());
              jobApplicationRepository.save(jobApplication);
    }
    public List<JobApplication> getAllJobApplications(){ 
              Optional<User> userOptional = userRepository.findByEmail(
                (String)  SecurityContextHolder.getContext().getAuthentication().getPrincipal()
              );
              if (userOptional.isEmpty()) {
                throw new IllegalArgumentException("User not found");
              }
              return jobApplicationRepository.findByUser_Email(userOptional.get().getEmail());
                
            }


    
}
