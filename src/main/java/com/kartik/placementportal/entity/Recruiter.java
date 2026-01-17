package com.kartik.placementportal.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "recruiters")
public class Recruiter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Recruiter login account
    @OneToOne
    @JoinColumn(name = "user_id",nullable = false)
    private User user; // who logs in

    //Recruiter works for one company
    @ManyToOne
    @JoinColumn(name = "company_id",nullable = false)
    private Company company;  // where he works


    private String name;

    public Recruiter(){}

    public Recruiter(User user , Company company,String name){
        this.user=user ;
        this.company=company;
        this.name = name;
    }
}
