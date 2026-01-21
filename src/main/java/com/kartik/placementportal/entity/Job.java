package com.kartik.placementportal.entity;

import com.kartik.placementportal.enums.JobStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "jobs")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private Double minCgpa;
    private Double salary;

    @Enumerated(EnumType.STRING)
    private JobStatus status;

    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
    private Company company;

    public Job(){}

    public Job(String title,
               String description,
               Double minCgpa,
               Double salary,
               Company company){
        this.title = title;
        this.description = description;
        this.minCgpa = minCgpa;
        this.salary = salary;
        this.company = company;
        this.status = JobStatus.OPEN;
    }
    public JobStatus getStatus() {
        return status;
    }


    public double getMinCgpa() {
        return minCgpa;
    }

}
