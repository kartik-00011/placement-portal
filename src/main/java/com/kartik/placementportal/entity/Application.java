package com.kartik.placementportal.entity;

import com.kartik.placementportal.enums.ApplicationStatus;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "applications")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="student_id",nullable = false)
    private Student student;

    @ManyToOne
    @JoinColumn(name="job_id",nullable = false)
    private Job job;

    @OneToMany(mappedBy = "application")
    private List<Interview> interviews;

    @OneToOne(mappedBy = "application")
    private Offer offer;

    @Enumerated(EnumType.STRING)
    private ApplicationStatus status;

    public Application(){}

    public Application(Student student,Job job){
        this.student = student;
        this.job = job;
        this.status = ApplicationStatus.APPLIED;
    }
    public void setStatus(ApplicationStatus status) {
        this.status = status;
    }


}
