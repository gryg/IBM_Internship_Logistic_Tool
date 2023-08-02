package com.ibm.internshipTool.responses;

public class ActivityResponse {
    private Long id;
    private String activityName;

    // Constructors
    public ActivityResponse() {
    }

    public ActivityResponse(Long id, String activityName) {
        this.id = id;
        this.activityName = activityName;
    }

    // Getters and Setters

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
