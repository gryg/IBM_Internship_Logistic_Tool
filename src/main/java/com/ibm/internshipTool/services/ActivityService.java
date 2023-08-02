package com.ibm.internshipTool.services;

import com.ibm.internshipTool.exceptions.ActivityIdNotFoundException;
import com.ibm.internshipTool.exceptions.AttendanceNotFoundException;
import com.ibm.internshipTool.exceptions.GradeNotFoundException;
import com.ibm.internshipTool.models.*;
import com.ibm.internshipTool.repositories.ActivityRepository;
import com.ibm.internshipTool.repositories.AttendanceRepository;
import com.ibm.internshipTool.repositories.GradeRepository;
import com.ibm.internshipTool.repositories.SessionRepository;
import com.ibm.internshipTool.responses.ActivityResponse;
import com.ibm.internshipTool.responses.TeamListResponse;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ActivityService {

    private final GradeRepository gradeRepository;
    private final AttendanceRepository attendanceRepository;
    private final ActivityRepository activityRepository;
    private final SessionRepository sessionRepository;

    public ActivityService(GradeRepository gradeRepository, AttendanceRepository attendanceRepository, ActivityRepository activityRepository, SessionRepository sessionRepository) {
        this.gradeRepository = gradeRepository;
        this.attendanceRepository = attendanceRepository;
        this.activityRepository =  activityRepository;
        this.sessionRepository = sessionRepository;
    }


    public Long getActivityIdBySessionId(Long sessionId) {

       // return activityRepository.findActivityIdBySessionId(sessionId);
        Long activityId = activityRepository.findActivityIdBySessionId(sessionId);
        if (activityId == null) {
            throw new ActivityIdNotFoundException("Activity ID not found for the given session ID: " + sessionId);
        }
        return activityId;
    }

    public List<Grade> getStudentGradesForActivityAndStudent(Long activityId, Long studentId) {
        //return gradeRepository.findBySessionActivityIdAndStudentId(activityId, studentId);
        List<Grade> grades = gradeRepository.findBySessionActivityIdAndStudentId(activityId, studentId);
        if (grades.isEmpty()) {
            throw new GradeNotFoundException("Grades not found for the given activity and student.");
        }
        return grades;
    }


    public List<Attendance> getStudentAttendancesForActivity(Long activityId, Long studentId) {
       // return attendanceRepository.findBySessionActivityIdAndStudentId(activityId, studentId);
        List<Attendance> attendances = attendanceRepository.findBySessionActivityIdAndStudentId(activityId, studentId);
        if (attendances.isEmpty()) {
            throw new AttendanceNotFoundException("Attendance not found for the given activity and student.");
        }
        return attendances;
    }

    public Grade getStudentGradeForSession(Long activityId, Long sessionId, Long studentId) {
        //return gradeRepository.findBySessionActivityIdAndSessionIdAndStudentId(activityId, sessionId, studentId);
        Grade grade = gradeRepository.findBySessionActivityIdAndSessionIdAndStudentId(activityId, sessionId, studentId);
        if (grade == null) {
            throw new GradeNotFoundException("Grade not found for the given session and student.");
        }
        return grade;
    }

    public Attendance getStudentAttendanceForSession( Long sessionId, Long studentId) {
        //return attendanceRepository.findBySessionActivityIdAndSessionIdAndStudentId(activityId, sessionId, studentId);
        //return attendanceRepository.findBySessionIdAndStudentId(sessionId, studentId);
        Attendance attendance = attendanceRepository.findBySessionIdAndStudentId(sessionId, studentId);
        if (attendance == null) {
            throw new AttendanceNotFoundException("Attendance not found for the given session and student.");
        }
        return attendance;
    }

}
