package com.kartik.placementportal.repository;

import com.kartik.placementportal.entity.Application;
import com.kartik.placementportal.entity.Job;
import com.kartik.placementportal.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    boolean existsByStudentAndJob(Student student, Job job);
}