package com.ibm.internshipTool.services;

import com.ibm.internshipTool.models.Attendance;
import com.ibm.internshipTool.models.Grade;
import com.ibm.internshipTool.repositories.AttendanceRepository;
import com.ibm.internshipTool.repositories.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityService {

    private final GradeRepository gradeRepository;
    private final AttendanceRepository attendanceRepository;

    public ActivityService(GradeRepository gradeRepository, AttendanceRepository attendanceRepository) {
        this.gradeRepository = gradeRepository;
        this.attendanceRepository = attendanceRepository;
    }

    public List<Grade> getStudentGradesForActivity(Long activityId, Long studentId) {
        return gradeRepository.findBySessionActivityIdAndStudentId(activityId, studentId);
    }

    public List<Attendance> getStudentAttendancesForActivity(Long activityId, Long studentId) {
        return attendanceRepository.findBySessionActivityIdAndStudentId(activityId, studentId);
    }

    public Grade getStudentGradeForSession(Long activityId, Long sessionId, Long studentId) {
        return gradeRepository.findBySessionActivityIdAndSessionIdAndStudentId(activityId, sessionId, studentId);
    }

    public Attendance getStudentAttendanceForSession(Long activityId, Long sessionId, Long studentId) {
        return attendanceRepository.findBySessionActivityIdAndSessionIdAndStudentId(activityId, sessionId, studentId);
    }
}
