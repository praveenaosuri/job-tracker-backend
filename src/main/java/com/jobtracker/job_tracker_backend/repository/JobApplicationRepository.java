package com.jobtracker.job_tracker_backend.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobtracker.job_tracker_backend.entity.JobApplication;

@Repository
public interface JobApplicationRepository extends JpaRepository<JobApplication, Long> {

    public List<JobApplication> findByUser_Email(String email);

}
