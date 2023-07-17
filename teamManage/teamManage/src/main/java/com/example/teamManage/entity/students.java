package com.example.teamManage.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "STUDENTS", schema = "public")
public class students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="username")
    private String username;

    @Column(name="email")
    private String email;

    @Column(name="teamID")
    private Long teamID;

    @Column(name="isLeader")
    private Boolean isLeader;

    @Column(name = "joinDate")
    private String joinDate;

    public students() {
    }

    public students(Long id, String username, String email, Long teamID, Boolean isLeader, String joinDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.teamID = teamID;
        this.isLeader = isLeader;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTeamID() {
        return teamID;
    }

    public void setTeamID(Long teamID) {
        this.teamID = teamID;
    }

    public Boolean getLeader() {
        return isLeader;
    }

    public void setLeader(Boolean leader) {
        isLeader = leader;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }
}
