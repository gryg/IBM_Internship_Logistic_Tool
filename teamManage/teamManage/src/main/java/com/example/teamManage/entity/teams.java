package com.example.teamManage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "TEAMS", schema = "public")
public class teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "teamName")
    private String teamName;

    @Column(name = "leaderID")
    private Long leaderID;

    @Column(name = "activity")
    private Long activity;

    public teams() {
    }

    public teams(Long id, String teamName, Long leaderID, Long activity) {
        this.id = id;
        this.teamName = teamName;
        this.leaderID = leaderID;
        this.activity = activity;
    }

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

    public Long getLeaderID() {
        return leaderID;
    }

    public void setLeaderID(Long leaderID) {
        this.leaderID = leaderID;
    }

    public Long getActivity() {
        return activity;
    }

    public void setActivity(Long activity) {
        this.activity = activity;
    }
}
