package com.ibm.internshipTool.services;

import com.ibm.internshipTool.models.Attendance;
import com.ibm.internshipTool.models.Grade;
import com.ibm.internshipTool.repositories.ActivityRepository;
import com.ibm.internshipTool.repositories.AttendanceRepository;
import com.ibm.internshipTool.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final GradeRepository gradeRepository;
    private final AttendanceRepository attendanceRepository;
    private final ActivityRepository activityRepository;

    public ActivityService(GradeRepository gradeRepository, AttendanceRepository attendanceRepository, ActivityRepository activityRepository) {
        this.gradeRepository = gradeRepository;
        this.attendanceRepository = attendanceRepository;
        this.activityRepository =  activityRepository;
    }

    public Long getActivityIdBySessionId(Long sessionId) {
        return activityRepository.findActivityIdBySessionId(sessionId);
    }

    public List<Grade> getStudentGradesForActivityAndStudent(Long activityId, Long studentId) {
        return gradeRepository.findBySessionActivityIdAndStudentId(activityId, studentId);
    }


    public List<Attendance> getStudentAttendancesForActivity(Long activityId, Long studentId) {
        return attendanceRepository.findBySessionActivityIdAndStudentId(activityId, studentId);
    }

    public Grade getStudentGradeForSession(Long activityId, Long sessionId, Long studentId) {
        return gradeRepository.findBySessionActivityIdAndSessionIdAndStudentId(activityId, sessionId, studentId);
    }

    public Attendance getStudentAttendanceForSession( Long sessionId, Long studentId) {
//        return attendanceRepository.findBySessionActivityIdAndSessionIdAndStudentId(activityId, sessionId, studentId);
        return attendanceRepository.findBySessionIdAndStudentId(sessionId, studentId);

    }
}
