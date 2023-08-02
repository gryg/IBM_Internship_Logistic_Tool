package com.ibm.internshipTool.responses;

public class TeamResponse {
    private Long id;
    private String teamName;
    private LeaderResponse leader;
    private ActivityResponse activity;

    // Constructors
    public TeamResponse() {
    }

    public TeamResponse(Long id, String teamName, LeaderResponse leader, ActivityResponse activity) {
        this.id = id;
        this.teamName = teamName;
        this.leader = leader;
        this.activity = activity;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public LeaderResponse getLeader() {
        return leader;
    }

    public void setLeader(LeaderResponse leader) {
        this.leader = leader;
    }

    public ActivityResponse getActivity() {
        return activity;
    }

    public void setActivity(ActivityResponse activity) {
        this.activity = activity;
    }
}
