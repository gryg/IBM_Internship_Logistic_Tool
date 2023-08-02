package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // methods to be added
    List<Attendance> findBySessionActivityIdAndStudentId(Long activityId, Long studentId);
    // review the last 2:
    Optional<Attendance> findByStudentIdAndSessionId(Long studentId, Long sessionId);
    Attendance findBySessionActivityIdAndSessionIdAndStudentId(Long activityId, Long sessionId, Long studentId);
    Attendance findBySessionIdAndStudentId(Long sessionId, Long studentId);

}
