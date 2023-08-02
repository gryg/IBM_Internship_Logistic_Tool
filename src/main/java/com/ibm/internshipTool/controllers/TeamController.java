package com.ibm.internshipTool.controllers;

import com.ibm.internshipTool.models.Team;
import com.ibm.internshipTool.responses.ShowTeamsTableResponse;
import com.ibm.internshipTool.services.TeamService;
import com.ibm.internshipTool.responses.ShowTeamsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/v1/teams")
public class TeamController {

    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public ResponseEntity<List<ShowTeamsTableResponse>> getAllTeams() {
        List<Team> teams = teamService.getAllTeams();
        List<ShowTeamsTableResponse> showTeamsTableResponses = new ArrayList<>();

        for (Team team : teams) {
            ShowTeamsTableResponse showTeamsTableResponse = new ShowTeamsTableResponse(
                    team.getTeamName(),
                    team.getActivityId().getId(),
                    team.getLeader().getId()
            );
            showTeamsTableResponses.add(showTeamsTableResponse);
        }
        return ResponseEntity.ok(showTeamsTableResponses);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowTeamsTableResponse> getTeamById(@PathVariable Long id) {
        Team team = teamService.getTeamById(id);
        if (team != null) {
            ShowTeamsTableResponse showTeamTableResponse = new ShowTeamsTableResponse(
                    team.getTeamName(),
                    team.getActivityId().getId(),
                    team.getLeader().getId()
            );
            return ResponseEntity.ok(showTeamTableResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add other API endpoints as needed
}