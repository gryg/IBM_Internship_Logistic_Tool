package com.ibm.internshipTool.models;

import jakarta.persistence.*;

@Entity
@Table(name = "activities")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "activity_name")
    private String activityName;

    //@Column ?
    public void setId(Long id) {
        this.id = id;
    }

    //@Column ?
    public Long getId() {
        return id;
    }

    public Activity() {
    }

    public Activity(Long id, String activityName) {
        this.id = id;
        this.activityName = activityName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
