package com.kartik.placementportal.dto;

public class JobResponseDTO {

    private Long jobId;
    private String title;
    private String companyName;
    private Double minCgpa;
    private String status;

    public JobResponseDTO(Long jobId,String title,String companyName,
                          Double minCgpa,String status) {
        this.jobId = jobId;
        this.title = title;
        this.companyName = companyName;
        this.minCgpa = minCgpa;
        this.status = status;
    }

    public Long getJobId() { return jobId; }
    public String getTitle() { return title; }
    public String getCompanyName() { return companyName; }
    public Double getMinCgpa() { return minCgpa; }
    public String getStatus() { return status; }

}
