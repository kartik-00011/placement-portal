package com.kartik.placementportal.controller;


import com.kartik.placementportal.service.ApplicationService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService){
        this.applicationService=applicationService;
    }

    @PostMapping("/students/{studentId}/jobs/{JobId}/apply")
    public ResponseEntity<String> applyToJob(
            @PathVariable Long studentId,
            @PathVariable Long jobId
    ){
        applicationService.applyToJob(studentId,jobId);
        return ResponseEntity.ok("Application Submitted successfully");
    }
}
