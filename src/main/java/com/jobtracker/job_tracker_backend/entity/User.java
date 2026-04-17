package com.jobtracker.job_tracker_backend.entity;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import lombok.Data;

@Entity
@Table(name="users")
@Data
public class User {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="name", nullable=false)
    private String name;
    
    @Column(name="email", unique=true)
    private String email;
    
    @Column(name="password", nullable=false)
    private String password;
    
    @CreationTimestamp
    @Column(name="created_at", nullable=false)
    private LocalDateTime createdAt;
}