package com.kartik.placementportal.repository;

import com.kartik.placementportal.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}