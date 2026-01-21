package com.kartik.placementportal.entity;
import com.kartik.placementportal.enums.InterviewType;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "interviews")
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_id",nullable = false)
    private Application application;

    @Enumerated(EnumType.STRING)
    private InterviewType type;

    private LocalDateTime interviewDate;
    private String feedback;

    public Interview(){}

    public Interview(Application application,
                     InterviewType type,
                     LocalDateTime interviewDate){
        this.application = application;
        this.type = type;
        this.interviewDate = interviewDate;
    }

}
