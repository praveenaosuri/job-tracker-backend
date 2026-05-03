package com.jobtracker.job_tracker_backend.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="job_applications")
@Data
public class JobApplication {


     @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name="companyName", nullable=false)
    private String companyName;
    
    @Column(name="role")
    private String role;
    
    @Column(name="status", nullable=false)
    @Enumerated(EnumType.STRING)
    private Status status;
    
     @Column(name="notes")
    private String notes;

    @CreationTimestamp
    @Column(name="applied_at", nullable=false)
    private LocalDateTime appliedAt;


    public enum Status {
    APPLIED,
    INTERVIEW,
    OFFER,
    REJECTED
}

    
}

