package com.ibm.internshipTool.responses;

import java.time.LocalDate;

public class ViewStudentInfoResponse {
    private String userName;
    private Long studentId;
    private String email;
    private LocalDate joinDate;
    private boolean isLeader;

    public ViewStudentInfoResponse(String userName, Long studentId, String email, LocalDate joinDate, boolean isLeader) {
        this.userName = userName;
        this.studentId = studentId;
        this.email = email;
        this.joinDate = joinDate;
        this.isLeader = isLeader;
    }

    // Getters and setters

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public boolean isLeader() {
        return isLeader;
    }

    public void setLeader(boolean leader) {
        isLeader = leader;
    }

    public void setIsLeader(boolean leader) { this.isLeader = isLeader;    }
}