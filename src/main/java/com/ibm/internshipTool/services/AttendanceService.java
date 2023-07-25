package com.ibm.internshipTool.services;

import com.ibm.internshipTool.repositories.AttendanceRepository;
import org.springframework.stereotype.Service;

@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    public AttendanceService(AttendanceRepository attendanceRepository) {
        this.attendanceRepository = attendanceRepository;
    }

    // methods for CRUD operations or custom business logic
}
