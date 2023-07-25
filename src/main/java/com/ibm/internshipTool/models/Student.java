package com.ibm.internshipTool.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "students", schema="public")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @Column(name = "is_leader")
    private boolean isLeader;

    @Column(name = "join_date")
    private LocalDate joinDate;

    public Student() {
    }

    public Student(Long id, String username, String email, Team team, boolean isLeader, LocalDate joinDate) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.team = team;
        this.isLeader = isLeader;
        this.joinDate = joinDate;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
