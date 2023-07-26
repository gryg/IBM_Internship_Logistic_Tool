package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // methods to be added
    List<Attendance> findBySessionActivityIdAndStudentId(Long activityId, Long studentId);

    Attendance findBySessionActivityIdAndSessionIdAndStudentId(Long activityId, Long sessionId, Long studentId);

}
