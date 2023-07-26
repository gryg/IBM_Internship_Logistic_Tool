package com.ibm.internshipTool.responses;
import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.STRING)
public class UserProfileResponse {

    private String username;
    private String email;
    private String photo;

    // Constructors, getters, and other methods (omitted for brevity)

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