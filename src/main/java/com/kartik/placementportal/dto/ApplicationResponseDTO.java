package com.kartik.placementportal.dto;

public class ApplicationResponseDTO {

    private Long applicationId;
    private Long studentId;
    private Long jobId;
    private String status;

    public ApplicationResponseDTO(Long applicationId,
                                  Long studentId,
                                  Long jobId,
                                  String status){
        this.applicationId = applicationId;
        this.studentId = studentId;
        this.jobId = jobId;
        this.status = status;
    }

    public Long getApplicationId(){
        return applicationId;
    }
    public Long getJobId(){
        return jobId;
    }
    public Long getStudentId(){
        return studentId;
    }
    public String getStatus(){
        return status;
    }
}
