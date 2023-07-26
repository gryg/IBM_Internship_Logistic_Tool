package com.ibm.internshipTool.requests;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public class UserProfileRequest {

    private String username;
    private String email;
    private String photo;

    // Constructors
    public UserProfileRequest() {
    }

    public UserProfileRequest(String username, String email, String photo) {
        this.username = username;
        this.email = email;
        this.photo = photo;
    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoto() {
        return photo;
    }

    // Setters
    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
