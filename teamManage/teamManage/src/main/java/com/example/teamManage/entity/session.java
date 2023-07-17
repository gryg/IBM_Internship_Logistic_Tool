package com.example.teamManage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "SESSION", schema="public")
public class session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "activityID")
    private Long activityID;

    @Column(name = "date")
    private String date;

    public session() {
    }

    public session(Long id, Long activityID, String date) {
        this.id = id;
        this.activityID = activityID;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityID() {
        return activityID;
    }

    public void setActivityID(Long activityID) {
        this.activityID = activityID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
