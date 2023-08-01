package com.ibm.internshipTool.responses;

import java.util.List;

public class MemberListResponse {

    private List<ViewStudentInfoResponse> members;

    // Constructor
    public MemberListResponse() {}

    // Getters and setters
    public List<ViewStudentInfoResponse> getMembers() {
        return members;
    }

    public void setMembers(List<ViewStudentInfoResponse> members) {
        this.members = members;
    }
}
