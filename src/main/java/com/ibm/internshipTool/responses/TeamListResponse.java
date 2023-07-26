package com.ibm.internshipTool.responses;

import java.util.List;

public class TeamListResponse {

    private List<TeamDetailsResponse> teams;

    // Constructor
    public TeamListResponse() {}

    // Getters and setters
    public List<TeamDetailsResponse> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDetailsResponse> teams) {
        this.teams = teams;
    }

    // Nested TeamDetailsResponse class
    public static class TeamDetailsResponse {

        private Long id;
        private String name;

        // Constructor
        public TeamDetailsResponse() {}

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
    }
}
