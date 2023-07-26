package com.ibm.internshipTool.controllers;

import com.ibm.internshipTool.models.Attendance;
import com.ibm.internshipTool.models.Grade;
import com.ibm.internshipTool.responses.AttendanceResponse;
import com.ibm.internshipTool.responses.GradeResponse;
import com.ibm.internshipTool.responses.ListOfAttendancesResponse;
import com.ibm.internshipTool.responses.ListOfGradesResponse;
import com.ibm.internshipTool.services.ActivityService;
import com.ibm.internshipTool.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/v1")
public class ActivityController {

    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @GetMapping("/activity/{activityId}/student/{studentId}/grade/")
    public ResponseEntity<ListOfGradesResponse> getStudentGradesForActivity(
            @PathVariable Long activityId,
            @PathVariable Long studentId
    ) {
        List<Grade> grades = activityService.getStudentGradesForActivity(activityId, studentId);

        // Convert the list of grades to ListOfGradesResponse format
        List<GradeResponse> gradeResponses = new ArrayList<>();
        for (Grade grade : grades) {
            GradeResponse gradeResponse = new GradeResponse();
            gradeResponse.setDate(grade.getSession().getSessionDate().toString());
            gradeResponse.setGrade(grade.getGrade());
            gradeResponses.add(gradeResponse);
        }

        ListOfGradesResponse response = new ListOfGradesResponse();
        response.setGrades(gradeResponses);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/activity/{activityId}/student/{studentId}/attendance/")
    public ResponseEntity<ListOfAttendancesResponse> getStudentAttendancesForActivity(
            @PathVariable Long activityId,
            @PathVariable Long studentId
    ) {
        List<Attendance> attendances = activityService.getStudentAttendancesForActivity(activityId, studentId);

        // Convert the list of attendances to ListOfAttendancesResponse format
        List<AttendanceResponse> attendanceResponses = new ArrayList<>();
        for (Attendance attendance : attendances) {
            AttendanceResponse attendanceResponse = new AttendanceResponse();
            attendanceResponse.setDate(attendance.getSession().getSessionDate().toString());
            attendanceResponse.setStatus(attendance.isAttendance());
            attendanceResponses.add(attendanceResponse);
        }

        ListOfAttendancesResponse response = new ListOfAttendancesResponse();
        response.setAttendances(attendanceResponses);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/activity/{activityId}/session/{sessionId}/student/{studentId}/grade")
    public ResponseEntity<GradeResponse> getStudentGradeForSession(
            @PathVariable Long activityId,
            @PathVariable Long sessionId,
            @PathVariable Long studentId
    ) {
        Grade grade = activityService.getStudentGradeForSession(activityId, sessionId, studentId);

        if (grade == null) {
            return ResponseEntity.notFound().build();
        }

        GradeResponse response = new GradeResponse();
        response.setDate(grade.getSession().getSessionDate().toString());
        response.setGrade(grade.getGrade());

        return ResponseEntity.ok(response);
    }

    @GetMapping("/activity/{activityId}/session/{sessionId}/student/{studentId}/attendance")
    public ResponseEntity<AttendanceResponse> getStudentAttendanceForSession(
            @PathVariable Long activityId,
            @PathVariable Long sessionId,
            @PathVariable Long studentId
    ) {
        Attendance attendance = activityService.getStudentAttendanceForSession(activityId, sessionId, studentId);

        if (attendance == null) {
            return ResponseEntity.notFound().build();
        }

        AttendanceResponse response = new AttendanceResponse();
        response.setDate(attendance.getSession().getSessionDate().toString());
        response.setStatus(attendance.isAttendance());

        return ResponseEntity.ok(response);
    }
}
