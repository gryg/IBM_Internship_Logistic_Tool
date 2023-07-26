package com.ibm.internshipTool.controllers;

import com.ibm.internshipTool.services.TeamLeaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1")
public class TeamLeaderController {

    private final TeamLeaderService teamLeaderService;

    @Autowired
    public TeamLeaderController(TeamLeaderService teamLeaderService) {
        this.teamLeaderService = teamLeaderService;
    }

    @PostMapping("/enroll")
    public ResponseEntity<String> enrollTeamInActivity(
            @RequestParam Long teamId,
            @RequestParam Long activityId
    ) {
        // Call the TeamLeaderService method to enroll the team in the activity
        boolean enrolled = teamLeaderService.enrollTeamInActivity(teamId, activityId);

        if (enrolled) {
            return ResponseEntity.ok("Team enrolled in the activity.");
        } else {
            return ResponseEntity.notFound().build(); // Or return an error response as needed
        }
    }

    @PostMapping("/add")
    public ResponseEntity<String> addStudentToTeam(
            @RequestParam Long teamId,
            @RequestParam Long studentId
    ) {
        // Call the TeamLeaderService method to add the student to the team
        boolean added = teamLeaderService.addStudentToTeam(teamId, studentId);

        if (added) {
            return ResponseEntity.ok("Student added to the team.");
        } else {
            return ResponseEntity.notFound().build(); // Or return an error response as needed
        }
    }

    @DeleteMapping("/student/{studentId}")
    public ResponseEntity<String> deleteStudentFromTeam(@PathVariable Long studentId) {
        // Call the TeamLeaderService method to delete the student from the team
        boolean deleted = teamLeaderService.deleteStudentFromTeam(studentId);

        if (deleted) {
            return ResponseEntity.ok("Student deleted from the team.");
        } else {
            return ResponseEntity.notFound().build(); // Or return an error response as needed
        }
    }
}
