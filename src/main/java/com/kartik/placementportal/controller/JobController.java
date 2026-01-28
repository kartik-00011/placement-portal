package com.kartik.placementportal.controller;

import com.kartik.placementportal.dto.ApiResponse;
import com.kartik.placementportal.dto.JobResponseDTO;
import com.kartik.placementportal.entity.Job;
import com.kartik.placementportal.service.JobService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    private JobController(JobService jobService){
        this.jobService=jobService;
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<JobResponseDTO>>> getAllJobs(){
        List<JobResponseDTO> jobs = jobService.getAllJobs();

        ApiResponse<List<JobResponseDTO>> response =
                new ApiResponse<>(true , "Jobs fetched successfully",jobs);

        return ResponseEntity.ok(response);
    }
}
