package com.jobtracker.job_tracker_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jobtracker.job_tracker_backend.service.JobApplicationService;
import com.jobtracker.job_tracker_backend.entity.JobApplication;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/api/jobs")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;
    
    @GetMapping()
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationService.getAllJobApplications();
    }
    
    @PostMapping()
    public void addJobApplication(@RequestBody JobApplication jobApplication) {
       jobApplicationService.addJobApplication(jobApplication);
    }

    @PatchMapping("/{id}")
    public void updateJobApplication(@RequestBody JobApplication jobApplication, @PathVariable Long id) {
       jobApplicationService.updateJobApplication(jobApplication, id);
    }

    @DeleteMapping("/{id}")
    public void deleteJobApplication(@PathVariable Long id) {
       jobApplicationService.deleteJobApplication(id);
    }

    
}
