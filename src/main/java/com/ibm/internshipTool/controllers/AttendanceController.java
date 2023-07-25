package com.ibm.internshipTool.controllers;

import com.ibm.internshipTool.services.AttendanceService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    public AttendanceController(AttendanceService attendanceService) {
    }

    // define API endpoints for attendance-related operations
}
