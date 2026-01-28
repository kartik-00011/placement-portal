package com.kartik.placementportal.service;

import com.kartik.placementportal.dto.JobResponseDTO;
import com.kartik.placementportal.entity.Job;
import com.kartik.placementportal.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {

    private JobRepository jobRepository;

    public JobService(JobRepository jobRepository){
        this.jobRepository=jobRepository;
    }

    public List<JobResponseDTO> getAllJobs() {
        return jobRepository.findAll()
                .stream()
                .map(job -> new JobResponseDTO(
                        job.getId(),
                        job.getTitle(),
                        job.getDescription(),
                        job.getMinCgpa(),
                        job.getStatus().name()
                ))
                .toList();
    }

}
