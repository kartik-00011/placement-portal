package com.kartik.placementportal.service;

import com.kartik.placementportal.entity.Application;
import com.kartik.placementportal.entity.Job;
import com.kartik.placementportal.entity.Student;
import com.kartik.placementportal.enums.ApplicationStatus;
import com.kartik.placementportal.enums.JobStatus;
import com.kartik.placementportal.exception.StudentNotFoundException;
import com.kartik.placementportal.repository.ApplicationRepository;
import com.kartik.placementportal.repository.JobRepository;
import com.kartik.placementportal.repository.StudentRepository;
import org.springframework.stereotype.Service;
import com.kartik.placementportal.dto.ApplicationResponseDTO;


@Service
public class ApplicationService {

    private final StudentRepository studentRepository;
    private final JobRepository jobRepository;
    private final ApplicationRepository applicationRepository;

    public ApplicationService(StudentRepository studentRepository,
                              JobRepository jobRepository,
                              ApplicationRepository applicationRepository) {
        this.studentRepository = studentRepository;
        this.jobRepository = jobRepository;
        this.applicationRepository = applicationRepository;
    }

    public ApplicationResponseDTO applyToJob(Long studentId, Long jobId) {

        // 1. Fetch student
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        // 2. Fetch job
        Job job = jobRepository.findById(jobId)
                .orElseThrow(() -> new StudentNotFoundException("Job not found"));

        // 3. Check job status
        if (job.getStatus() == JobStatus.CLOSED) {
            throw new RuntimeException("Job is closed");
        }

        // 4. Prevent duplicate application
        boolean alreadyApplied =
                applicationRepository.existsByStudentAndJob(student, job);

        if (alreadyApplied) {
            throw new RuntimeException("Student already applied to this job");
        }

        // 5. Validate eligibility
        if (student.getCgpa() < job.getMinCgpa()) {
            throw new RuntimeException("CGPA criteria not met");
        }

        // 6. Create application
        Application application = new Application(student, job);
        application.setStatus(ApplicationStatus.APPLIED);

        // 7. Save application
        Application savedApplication = applicationRepository.save(application);


        return new ApplicationResponseDTO(
                savedApplication.getId(),
                student.getId(),
                job.getId(),
                savedApplication.getStatus().toString()

        );
    }
}
