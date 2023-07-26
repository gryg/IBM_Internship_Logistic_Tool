package com.ibm.internshipTool.services;
package com.ibm.internshipTool.services;

import com.ibm.internshipTool.exceptions.SessionNotFoundException;
import com.ibm.internshipTool.exceptions.StudentNotFoundException;
import com.ibm.internshipTool.exceptions.TeamNotFoundException;
import com.ibm.internshipTool.models.*;
import com.ibm.internshipTool.repositories.*;
import com.ibm.internshipTool.requests.AttendanceUpdateRequest;
import com.ibm.internshipTool.requests.GradeRequest;
import com.ibm.internshipTool.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MentorService {

    private final TeamRepository teamRepository;
    private final SessionRepository sessionRepository;
    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;
    private final GradeRepository gradeRepository;

    @Autowired
    public MentorService(
            TeamRepository teamRepository,
            SessionRepository sessionRepository,
            StudentRepository studentRepository,
            AttendanceRepository attendanceRepository,
            GradeRepository gradeRepository
    ) {
        this.teamRepository = teamRepository;
        this.sessionRepository = sessionRepository;
        this.studentRepository = studentRepository;
        this.attendanceRepository = attendanceRepository;
        this.gradeRepository = gradeRepository;
    }

    public ShowTeamsResponse getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        List<ShowTeamsResponse.TeamDetails> teamDetailsList = teams.stream()
                .map(team -> {
                    List<ViewStudentInfoResponse> members = team.getStudents().stream()
                            .map(this::convertToViewStudentInfoResponse)
                            .collect(Collectors.toList());

                    ShowTeamsResponse.TeamDetails teamDetails = new ShowTeamsResponse.TeamDetails();
                    teamDetails.setId(team.getId());
                    teamDetails.setName(team.getTeamName());
                    teamDetails.setActivity(team.getActivity().getActivityName());
                    teamDetails.setMembers(members);
                    return teamDetails;
                })
                .collect(Collectors.toList());

        ShowTeamsResponse response = new ShowTeamsResponse();
        response.setTeams(teamDetailsList);
        return response;
    }

    public TeamListResponse getTeamsByActivity(Long activityId) {
        List<Team> teams = teamRepository.findByActivityId(activityId);
        List<TeamDetailsResponse> teamDetailsList = teams.stream()
                .map(team -> {
                    TeamDetailsResponse teamDetails = new TeamDetailsResponse();
                    teamDetails.setId(team.getId());
                    teamDetails.setName(team.getTeamName());
                    return teamDetails;
                })
                .collect(Collectors.toList());

        TeamListResponse response = new TeamListResponse();
        response.setTeams(teamDetailsList);
        return response;
    }

    public MemberListResponse getTeamMembers(Long teamId) {
        Team team = teamRepository.findById(teamId).orElse(null);
        if (team == null) {
            throw new TeamNotFoundException("Team not found with ID: " + teamId);
        }

        List<ViewStudentInfoResponse> members = team.getStudents().stream()
                .map(this::convertToViewStudentInfoResponse)
                .collect(Collectors.toList());

        MemberListResponse response = new MemberListResponse();
        response.setMembers(members);
        return response;
    }

    public void updateAttendanceRecord(Long activityId, Long sessionId, Long studentId, AttendanceUpdateRequest request) {
        Team team = teamRepository.findByActivityIdAndLeaderId(activityId, studentId).orElse(null);
        if (team == null) {
            throw new TeamNotFoundException("Team not found for the given activity and student.");
        }

        Session session = sessionRepository.findById(sessionId).orElse(null);
        if (session == null || !session.getActivity().getId().equals(activityId)) {
            throw new SessionNotFoundException("Session not found for the given activity and session IDs.");
        }

        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }

        Attendance attendance = attendanceRepository.findByStudentIdAndSessionId(studentId, sessionId).orElse(null);
        if (attendance == null) {
            attendance = new Attendance();
            attendance.setStudent(student);
            attendance.setSession(session);
        }

        attendance.setAttendance(request.isStatus());
        attendanceRepository.save(attendance);
    }

    public void updateGrades(Long activityId, Long sessionId, Long studentId, GradeRequest request) {
        Team team = teamRepository.findByActivityIdAndLeaderId(activityId, studentId).orElse(null);
        if (team == null) {
            throw new TeamNotFoundException("Team not found for the given activity and student.");
        }

        Session session = sessionRepository.findById(sessionId).orElse(null);
        if (session == null || !session.getActivity().getId().equals(activityId)) {
            throw new SessionNotFoundException("Session not found for the given activity and session IDs.");
        }

        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }

        Grade grade = gradeRepository.findByStudentIdAndSessionId(studentId, sessionId).orElse(null);
        if (grade == null) {
            grade = new Grade();
            grade.setStudent(student);
            grade.setSession(session);
        }

        grade.setGrade(request.getGrade());
        gradeRepository.save(grade);
    }

    private ViewStudentInfoResponse convertToViewStudentInfoResponse(Student student) {
        ViewStudentInfoResponse response = new ViewStudentInfoResponse();
        response.setUserName(student.getUsername());
        response.setStudentId(student.getId());
        response.setEmail(student.getEmail());
        response.setJoinDate(student.getJoinDate());
        response.setLeader(student.isLeader());
        return response;
    }
}
