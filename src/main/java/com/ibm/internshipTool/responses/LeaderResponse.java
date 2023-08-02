package com.ibm.internshipTool.responses;

import java.util.Date;

public class LeaderResponse {
    private Long id;
    private String username;

    // Constructors
    public LeaderResponse() {
    }

    public LeaderResponse(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    // Getters and Setters

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
}
