package com.kartik.placementportal.controller;

import com.kartik.placementportal.dto.ApiResponse;
import com.kartik.placementportal.dto.JobResponseDTO;
import com.kartik.placementportal.entity.Job;
import com.kartik.placementportal.service.JobService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

//    public ResponseEntity<ApiResponse<List<JobResponseDTO>>> getAllJobs(){
//        List<JobResponseDTO> jobs = jobService.getJobs();
//
//        ApiResponse<List<JobResponseDTO>> response =
//                new ApiResponse<>(true , "Jobs fetched successfully",jobs);

    public ResponseEntity<ApiResponse<Page<JobResponseDTO>>> getJobs(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam(required = false) Double minCgpa
    ) {
        Sort sort = direction.equalsIgnoreCase("desc")
                ? Sort.by(sortBy).descending()
                : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page,size,sort);
        Page<JobResponseDTO> jobs = jobService.getJobs(minCgpa,pageable);


        ApiResponse<Page<JobResponseDTO>> response =
                new ApiResponse<>(true, "Jobs fetched successfully", jobs);

        return ResponseEntity.ok(response);
    }
}
