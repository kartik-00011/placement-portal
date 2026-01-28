package com.kartik.placementportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //this linked Student to User
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private String name;
    private Double cgpa;
    private String branch;
    private Integer graduationYear;
    private String resumeUrl;

    public Student() {
    }

    public Student(User user, String name, Double cgpa, String branch, Integer graduationYear) {
        this.user = user;
        this.name = name;
        this.cgpa = cgpa;
        this.branch = branch;
        this.graduationYear = graduationYear;
    }
    public double getCgpa() {
        return cgpa;
    }
    public Long getId(){
        return id;
    }
}
