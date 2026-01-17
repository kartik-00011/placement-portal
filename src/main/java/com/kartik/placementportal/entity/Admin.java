package com.kartik.placementportal.entity;

import jakarta.persistence.*;


public class Admin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //login account
    @OneToOne
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    private String level;  //(SUPER,SUPPORT etc....)

    public Admin(){}

    public Admin(User user,String level){
        this.user = user ;
        this.level = level;
    }
}
