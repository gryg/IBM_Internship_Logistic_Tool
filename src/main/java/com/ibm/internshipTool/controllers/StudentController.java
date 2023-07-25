package com.ibm.internshipTool.controllers;

import com.ibm.internshipTool.models.Student;
import com.ibm.internshipTool.responses.ViewStudentInfoResponse;
import com.ibm.internshipTool.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;
    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // define API endpoints for student-related operations
    @GetMapping("/{studentId}")
    public ViewStudentInfoResponse getStudentInfo(@PathVariable long studentId) {
        Student student = studentService.getStudentById(studentId);
        if (student == null) {
            // Return an error response if student not found
            // You can create a separate ErrorResponse class for error responses
            return null;
        }

        // Map the Student object to the ViewStudentInfoResponse object
        return new ViewStudentInfoResponse(
                student.getUsername(),
                student.getId(),
                student.getEmail(),
                student.getJoinDate(),
                student.isLeader()
        );
    }
}
