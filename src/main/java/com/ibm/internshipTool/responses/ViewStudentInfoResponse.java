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
}