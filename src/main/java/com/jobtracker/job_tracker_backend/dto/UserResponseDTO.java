package com.jobtracker.job_tracker_backend.dto;

import java.time.LocalDateTime;

import com.jobtracker.job_tracker_backend.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDTO {
    private Long id;
    private String name;
     private String email;
     private LocalDateTime createdAt;
 public static UserResponseDTO fromUser(User user) {
        return  new UserResponseDTO(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getCreatedAt()
        );
        }
    
    
    };
       
    
