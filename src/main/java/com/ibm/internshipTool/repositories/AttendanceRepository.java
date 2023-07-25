package com.ibm.internshipTool.repositories;

import com.ibm.internshipTool.models.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    // methods to be added
}
