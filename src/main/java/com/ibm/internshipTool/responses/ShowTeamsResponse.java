package com.ibm.internshipTool.responses;
import java.util.List;

public class ShowTeamsResponse {

    private List<TeamDetails> teams;

    // Constructor
    public ShowTeamsResponse() {}

    // Getters and setters
    public List<TeamDetails> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDetails> teams) {
        this.teams = teams;
    }

    // Nested TeamDetails class
    public static class TeamDetails {

        private Long id;
        private String name;
        private String activity;
        private List<ViewStudentInfoResponse> members;

        // Constructor
        public TeamDetails() {}

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public List<ViewStudentInfoResponse> getMembers() {
            return members;
        }

        public void setMembers(List<ViewStudentInfoResponse> members) {
            this.members = members;
        }
    }
}
