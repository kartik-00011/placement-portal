package com.kartik.placementportal.controller;


import com.kartik.placementportal.dto.ApiResponse;
import com.kartik.placementportal.service.ApplicationService;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.kartik.placementportal.dto.ApplicationResponseDTO;


@RestController
public class ApplicationController {

    private final ApplicationService applicationService;

    public ApplicationController(ApplicationService applicationService) {
        this.applicationService = applicationService;
    }

    @PostMapping("/students/{studentId}/jobs/{jobId}/apply")
    public ResponseEntity<ApiResponse<ApplicationResponseDTO>> applyToJob(
            @PathVariable Long studentId,
            @PathVariable Long jobId
    ) {
        ApplicationResponseDTO result = applicationService.applyToJob(studentId, jobId);

        ApiResponse<ApplicationResponseDTO> response =
                new ApiResponse<>(true,"Application submitted successfully",result);

        return ResponseEntity.ok(response);
    }

}
