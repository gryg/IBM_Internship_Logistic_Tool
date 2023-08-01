package com.ibm.internshipTool.controllers;
import com.ibm.internshipTool.requests.AttendanceUpdateRequest;
import com.ibm.internshipTool.requests.GradeRequest;
import com.ibm.internshipTool.responses.MemberListResponse;
import com.ibm.internshipTool.responses.ShowTeamsResponse;
import com.ibm.internshipTool.responses.TeamListResponse;
import com.ibm.internshipTool.services.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1")
public class MentorController {

    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping("/mentor/teams")
    public ResponseEntity<ShowTeamsResponse> getAllTeams() {
        ShowTeamsResponse response = mentorService.getAllTeams();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/activity/{activityId}/teams")
    public ResponseEntity<TeamListResponse> getTeamsByActivity(@PathVariable Long activityId) {
        TeamListResponse response = mentorService.getTeamsByActivity(activityId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/mentors/teams/{teamId}/members")
    public ResponseEntity<MemberListResponse> getTeamMembers(@PathVariable Long teamId) {
        MemberListResponse response = mentorService.getTeamMembers(teamId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/activity/{activityId}/session/{sessionId}/student/{studentId}/attendanceRecording")
    public ResponseEntity<Void> updateAttendanceRecord(
            @PathVariable Long activityId,
            @PathVariable Long sessionId,
            @PathVariable Long studentId,
            @RequestBody AttendanceUpdateRequest request
    ) {
        mentorService.updateAttendanceRecord(activityId, sessionId, studentId, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/activity/{activityId}/session/{sessionId}/student/{studentId}/grading")
    public ResponseEntity<Void> updateGrades(
            @PathVariable Long activityId,
            @PathVariable Long sessionId,
            @PathVariable Long studentId,
            @RequestBody GradeRequest request
    ) {
        mentorService.updateGrades(activityId, sessionId, studentId, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
