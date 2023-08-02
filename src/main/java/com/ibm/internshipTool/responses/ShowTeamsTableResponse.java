package com.ibm.internshipTool.responses;

public class ShowTeamsTableResponse {
    private String teamName;
    private Long activityId;
    private Long leaderId;

    public ShowTeamsTableResponse(String teamName, Long activityId, Long leaderId) {
        this.teamName = teamName;
        this.activityId = activityId;
        this.leaderId = leaderId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    public Long getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }
}
