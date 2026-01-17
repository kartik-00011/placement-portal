package com.kartik.placementportal.entity;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "offers")
public class Offer {

    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name="application_id",nullable = false)
    private Application application;

    private Double salary;
    private LocalDate offerDate;
    private LocalDate expiryDate;
    private Boolean accepted;

    public Offer(){}

    public Offer(Application application,
                 Double salary,
                 LocalDate offerDate,
                 LocalDate expiryDate){
        this.application = application;
        this.salary = salary;
        this.offerDate = offerDate;
        this.expiryDate = expiryDate;
        this.accepted = false;
    }


}
