package com.ibm.internshipTool.models;

import jakarta.persistence.*;
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "team_name")
    private String teamName;

    @ManyToOne
    @JoinColumn(name = "leader_id")
    private Student leader;

    @ManyToOne
    @JoinColumn(name = "activity_id")
    private Activity activity;

    public Team() {
    }

    public Team(Long id, String teamName, Student leader, Activity activity) {
        this.id = id;
        this.teamName = teamName;
        this.leader = leader;
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

    public Student getLeader() {
        return leader;
    }

    public void setLeader(Student leader) {
        this.leader = leader;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }
}
