package com.kartik.placementportal.service;

import com.kartik.placementportal.dto.JobResponseDTO;
import com.kartik.placementportal.entity.Job;
import com.kartik.placementportal.repository.JobRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository=jobRepository;
    }

    public Page<JobResponseDTO> getJobs(
            Double minCgpa,
            String title,
            String company,
            Pageable pageable
    ) {
        Page<Job> jobsPage = jobRepository.findJobsWithFilters(
                minCgpa,
                title,
                company,
                pageable
        );

        return jobsPage.map(job -> new JobResponseDTO(
                job.getId(),
                job.getTitle(),
                job.getDescription(),
                job.getMinCgpa(),
                job.getStatus().name()
        ));
    }
}
