package com.ibm.internshipTool.services;
import com.ibm.internshipTool.exceptions.SessionNotFoundException;
import com.ibm.internshipTool.exceptions.StudentNotFoundException;
import com.ibm.internshipTool.exceptions.TeamNotFoundException;
import com.ibm.internshipTool.models.*;
import com.ibm.internshipTool.repositories.*;
import com.ibm.internshipTool.requests.AttendanceUpdateRequest;
import com.ibm.internshipTool.requests.GradeRequest;
import com.ibm.internshipTool.responses.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MentorService {

    private final TeamRepository teamRepository;
    private final SessionRepository sessionRepository;
    private final StudentRepository studentRepository;
    private final AttendanceRepository attendanceRepository;
    private final GradeRepository gradeRepository;
    private final ActivityRepository activityRepository;

    @Autowired
    public MentorService(
            TeamRepository teamRepository,
            SessionRepository sessionRepository,
            StudentRepository studentRepository,
            AttendanceRepository attendanceRepository,
            GradeRepository gradeRepository,
            ActivityRepository activityRepository
    ) {
        this.teamRepository = teamRepository;
        this.sessionRepository = sessionRepository;
        this.studentRepository = studentRepository;
        this.attendanceRepository = attendanceRepository;
        this.gradeRepository = gradeRepository;
        this.activityRepository = activityRepository;
    }

//    public ShowTeamsResponse getAllTeams() {
//        List<Team> teams = teamRepository.findAll();
//        List<ShowTeamsResponse.TeamDetails> teamDetailsList = teams.stream()
//                .map(team -> {
//                    List<ViewStudentInfoResponse> members = team.getStudents().stream()
//                            .map(this::convertToViewStudentInfoResponse)
//                            .collect(Collectors.toList());
//
//                    ShowTeamsResponse.TeamDetails teamDetails = new ShowTeamsResponse.TeamDetails();
//                    teamDetails.setId(team.getId());
//                    teamDetails.setName(team.getTeamName());
//                    teamDetails.setActivity(team.getActivity().getActivityName());
//                    teamDetails.setMembers(members);
//                    return teamDetails;
//                })
//                .collect(Collectors.toList());
//
//        ShowTeamsResponse response = new ShowTeamsResponse();
//        response.setTeams(teamDetailsList);
//        return response;
//    }
    public ShowTeamsResponse getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        List<ShowTeamsResponse.TeamDetails> teamDetailsList = teams.stream()
                .map(team -> {
                    List<ViewStudentInfoResponse> members = studentRepository.findAllByTeamId(team.getId()).stream()
                            .map(this::convertToViewStudentInfoResponse)
                            .collect(Collectors.toList());

                    ShowTeamsResponse.TeamDetails teamDetails = new ShowTeamsResponse.TeamDetails();
                    teamDetails.setId(team.getId());
                    teamDetails.setName(team.getTeamName());
                    teamDetails.setActivity(team.getActivityId().getActivityName());
                    teamDetails.setMembers(members);
                    return teamDetails;
                })
                .collect(Collectors.toList());

        ShowTeamsResponse response = new ShowTeamsResponse();
        response.setTeams(teamDetailsList);
        return response;
    }

//    public List<TeamDetailsResponse> getAllTeams() {
//        List<Team> teams = teamRepository.findAll();
//        List<TeamDetailsResponse> teamDetailsList = teams.stream()
//                .map(this::convertToTeamDetailsResponse)
//                .collect(Collectors.toList());
//        return teamDetailsList;
//    }
    private TeamDetailsResponse convertToTeamDetailsResponse(Team team) {
        TeamDetailsResponse teamDetails = new TeamDetailsResponse();
        teamDetails.setId(team.getId());
        teamDetails.setTeamName(team.getTeamName());
        return teamDetails;
    }

    public TeamListResponse getTeamsByActivity(Long activityId) {
        List<Team> teams = teamRepository.findByActivityId(activityId);
        List<TeamListResponse.TeamDetailsResponse> teamDetailsList = teams.stream()
                .map(team -> {
                    TeamListResponse.TeamDetailsResponse teamDetails = new TeamListResponse.TeamDetailsResponse();
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
        List<Student> students = studentRepository.findAllByTeamId(teamId);

        List<ViewStudentInfoResponse> members = students.stream()
                .map(this::convertToViewStudentInfoResponse)
                .collect(Collectors.toList());

        MemberListResponse response = new MemberListResponse();
        response.setMembers(members);
        return response;
    }

    @Transactional
    public void updateAttendanceRecord(Long activityId, Long sessionId, Long studentId, AttendanceUpdateRequest request) {
        Session session = sessionRepository.findById(sessionId).orElse(null);
        if (session == null) {
            Activity activity = activityRepository.findById(activityId).orElse(null);
            if (activity == null) {
                throw new EntityNotFoundException("Activity with ID " + activityId + " not found.");
            }

            session = new Session();
            session.setActivity(activity);
            session.setSessionDate(LocalDate.now());

            session = sessionRepository.save(session);
        }

        // Check if the student exists
        Student student = studentRepository.findById(studentId).orElse(null);

        // If the student does not exist, you may choose to handle the error accordingly
        // For now, let's assume that we proceed only if the student exists
        if (student != null) {
            // Check if the attendance entry exists for this student and session
            Optional<Attendance> existingAttendance = attendanceRepository.findByStudentIdAndSessionId(studentId, sessionId);

            Attendance attendance;
            if (existingAttendance.isPresent()) {
                // If the attendance entry exists, update it with the new attendance status
                attendance = existingAttendance.get();
            } else {
                // If the attendance entry does not exist, create a new one
                attendance = new Attendance();
                attendance.setStudent(student);
                attendance.setSession(session);
            }

            // Update the attendance status based on the request
            attendance.setAttendance(request.isAttendance());

            // Save the attendance entry
            attendanceRepository.save(attendance);
        }
    }



    @Transactional
    public void updateGrades(Long activityId, Long sessionId, Long studentId, GradeRequest request) {
        Activity activity = activityRepository.findById(activityId).orElse(null);
        if (activity == null) {
            throw new EntityNotFoundException("Activity with ID " + activityId + " not found.");
        }
        // Check if the session exists for the given session ID
        Session session = sessionRepository.findById(sessionId).orElse(null);

        // If the session does not exist, create a new session
        if (session == null) {
            session = new Session();
            session.setActivity(activity);
            session.setSessionDate(LocalDate.now());

            session = sessionRepository.save(session);
        }

        // Check if the student exists
        Student student = studentRepository.findById(studentId).orElse(null);
        if (student == null) {
            throw new StudentNotFoundException("Student not found with ID: " + studentId);
        }

        // Check if the grade entry exists for this student and session
        Grade grade = gradeRepository.findByStudentIdAndSessionId(studentId, sessionId).orElse(null);
        if (grade == null) {
            grade = new Grade();
            grade.setStudent(student);
            grade.setSession(session);
        }

        grade.setGrade(request.getGrade());

        // Set the comment only if it is provided in the request
        if (request.getComment() != null) {
            grade.setComment(request.getComment());
        }

        gradeRepository.save(grade);
    }


    public List<Grade> getGradesByActivity(Long activityId) {
        return gradeRepository.findBySessionActivityId(activityId);
    }

    private ViewStudentInfoResponse convertToViewStudentInfoResponse(Student student) {
        String userName = student.getUsername();
        Long studentId = student.getId();
        String email = student.getEmail();
        LocalDate joinDate = student.getJoinDate();
        boolean isLeader = student.isLeader();
        ViewStudentInfoResponse response = new ViewStudentInfoResponse(userName, studentId, email, joinDate, isLeader);
        response.setUserName(student.getUsername());
        response.setStudentId(student.getId());
        response.setEmail(student.getEmail());
        response.setJoinDate(student.getJoinDate());
        response.setLeader(student.isLeader());
        return response;
    }
}
