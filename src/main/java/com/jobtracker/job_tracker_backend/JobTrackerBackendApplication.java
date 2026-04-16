package com.jobtracker.job_tracker_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication(
    exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
    }
)
public class JobTrackerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(JobTrackerBackendApplication.class, args);
	}

}
