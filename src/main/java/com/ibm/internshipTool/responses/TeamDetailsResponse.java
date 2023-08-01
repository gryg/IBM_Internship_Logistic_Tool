package com.ibm.internshipTool.responses;

import java.util.List;

public class TeamDetailsResponse {
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return name;
    }

    public void setTeamName(String teamName) {
        this.name = name;
    }

    private List<ViewStudentInfoResponse> members; // List of students in the team
    public List<ViewStudentInfoResponse> getMembers() {
        return members;
    }
    public void setMembers(List<ViewStudentInfoResponse> members) {
        this.members = members;
    }

}
