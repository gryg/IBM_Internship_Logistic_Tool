package com.example.teamManage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ACTIVITIES", schema="public")
public class activities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "activityName")
    private String activityName;

    public activities() {
    }

    public activities(Long id, String activityName) {
        this.id = id;
        this.activityName = activityName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }
}
