package com.kartik.placementportal.repository;

import com.kartik.placementportal.entity.Job;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface JobRepository extends JpaRepository<Job, Long> {

    @Query("""
    SELECT j FROM Job j
    WHERE (:minCgpa IS NULL OR j.minCgpa <= :minCgpa)
    AND (:title IS NULL OR LOWER(j.title) LIKE LOWER(CONCAT('%', :title, '%')))
    AND (:company IS NULL OR LOWER(j.company.name) LIKE LOWER(CONCAT('%', :company, '%')))
    """)
    Page<Job> findJobsWithFilters(
                @Param("minCgpa") Double minCgpa,
                @Param("title") String title,
                @Param("company") String company,
                Pageable pageable
    );

}