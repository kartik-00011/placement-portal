package com.kartik.placementportal.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String website;
    private Boolean verified = false;

    // One company has many recruiters
    @OneToMany(mappedBy = "company")
    private List<Recruiter> recruiters;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;

    public Company(){}

    public Company(String name , String website){
        this.name = name;
        this.website=website;
        this.verified=false;
    }
}
